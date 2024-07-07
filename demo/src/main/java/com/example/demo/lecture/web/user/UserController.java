package com.example.demo.lecture.web.user;

import com.example.demo.lecture.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

  @Autowired
  UserService userService;

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @RequestMapping(path = "/users", method = RequestMethod.GET)
  public String list(
    @PageableDefault(size = 10) Pageable pageable,
    Model model
  ) {
    var users = userService.findAll(pageable);
    model.addAttribute("users", users);
    return "pages/user/list";
  }

  @RequestMapping(path = "user/{id}")
  public String detail(
    Model model,
    @PathVariable("id") Long id,
    @RequestParam(name = "page", required = false, defaultValue = "1") int page,
    @RequestParam(name = "size", required = false, defaultValue = "10") int size
  ) {
    try {
      var user = userService.findOne(id);
      model.addAttribute("user", user);
      model.addAttribute("page", page);
      model.addAttribute("size", size);
    } catch (NotFoundException e) {
      logger.error("NotFound", e);
      return "redirect:/error/404";
    }
    return "pages/user/detail";
  }

  @RequestMapping(path = "user/create", method = RequestMethod.GET)
  public String showCreate(UserForm userForm, Model model) {
    model.addAttribute("userForm", userForm);
    return "pages/user/create";
  }

  @RequestMapping(path = "user/create", method = RequestMethod.POST)
  public String create(
    @Valid @ModelAttribute UserForm userForm,
    final BindingResult result
  ) {
    if (result.hasErrors()) {
      return "pages/user/create";
    }
    var user = userForm.toEntity();
    user = userService.save(user);
    return "redirect:/user/" + user.getId();
  }

  @RequestMapping(path = "user/{userId}/edit", method = RequestMethod.GET)
  public String showEdit(
    UserEditForm userEditForm,
    Model model,
    @PathVariable("userId") Long userId,
    @RequestParam("page") int page,
    @RequestParam("size") int size
  ) {
    try {
      var user = userService.findOne(userId);
      userEditForm.setEntity(user);
      model.addAttribute("userEditForm", userEditForm);
      model.addAttribute("page", page);
      model.addAttribute("size", size);
    } catch (Exception e) {
      return "redirect:/error/404";
    }
    return "pages/user/edit";
  }

  @RequestMapping(path = "user/{userId}/edit", method = RequestMethod.POST)
  public String edit(
    @Valid @ModelAttribute UserEditForm userEditForm,
    BindingResult result,
    Model model,
    @PathVariable("userId") Long userId,
    @RequestParam(name = "page") int page,
    @RequestParam(name = "size") int size,
    RedirectAttributes redirectAttributes
  ) {
    try {
      var user = userService.findOne(userId);
      if (user.getUpdatedAt().equals(userEditForm.getUpdatedAtDateTime())) {
        logger.info("楽観ロック成功");
        userEditForm.updateEntityAttributes(user);
        userService.save(user);
      } else {
        logger.info("楽観ロック失敗");
        redirectAttributes.addFlashAttribute("error", "error.edit.lock_error");
        return "redirect:/user/" + userId;
      }
    } catch (NotFoundException e) {
      return "redirect:/error/404";
    }
    return "redirect:/user/" + userId + "?page=" + page + "&size=" + size;
  }

  @RequestMapping(path = "/user/{id}/delete", method = RequestMethod.POST)
  public String delete(
    @PathVariable("id") Long id,
    RedirectAttributes redirectAttributes
  ) {
    try {
      var user = userService.findOne(id);
      userService.delete(user);
      redirectAttributes.addFlashAttribute("info", "info.delete.success");
    } catch (NotFoundException e) {
      return "redirect:/error/404";
    }
    return "redirect:/users";
  }
}
