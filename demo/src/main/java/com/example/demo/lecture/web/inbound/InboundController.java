package com.example.demo.lecture.web.inbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.lecture.service.ItemService;
import com.example.demo.lecture.service.SupplierService;

import jakarta.validation.Valid;

@Controller
public class InboundController {

    @Autowired
    ItemService itemService;

    @Autowired
    SupplierService supplierService;

    @RequestMapping(path = "/inbound/create", method = RequestMethod.GET)
    public String showCreate(
        InboundForm inboundForm,
        Model model,
        Pageable pageable
        ) {
        
        // 商品一覧情報を取得する
        var items = itemService.findAll(pageable);

        // 入荷先一覧情報を取得する
        var supplieres = supplierService.findAll(pageable);

        model.addAttribute("items", items);
        model.addAttribute("suppliers", supplieres);

        model.addAttribute("inboundForm", inboundForm);
        return "pages/inbound/create";
    }

    @RequestMapping(path = "/inbound/create", method = RequestMethod.POST)
    public String create(
        @Valid @ModelAttribute InboundForm inboundForm,
        final BindingResult result,
        Model model,
        Pageable pageable
    ) {
        if (result.hasErrors()) {
            var items = itemService.findAll(pageable);
            var suppliers = supplierService.findAll(pageable);

            model.addAttribute("items", items);
            model.addAttribute("suppliers", suppliers);
            return "pages/inbound/create";
        }
        var inbound = inboundForm.toEntity();

        // 保存処理
        // user = userService.save(user);
        
        // return "redirect:/user/" + user.getId();
        return "redirect:/inbound/create";
    }
}
