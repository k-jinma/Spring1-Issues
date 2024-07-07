package com.example.demo.lecture.web.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/error")
public class ErrorController {

  @RequestMapping(path = "/{status}")
  public String error(@PathVariable("status") String status, Model model) {
    model.addAttribute("error_status", status);
    return "error";
  }
}
