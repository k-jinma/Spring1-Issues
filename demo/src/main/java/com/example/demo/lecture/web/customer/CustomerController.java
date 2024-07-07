package com.example.demo.lecture.web.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.lecture.service.CustomerService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @RequestMapping( path = "/customers", method=RequestMethod.GET)
    public String list( @PageableDefault(size = 10) Pageable pageable, Model model) {

        var customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);
        return "pages/customer/list";
    }

    @RequestMapping(path = "customer/{id}")
    public String detail(
        Model model,
        @PathVariable("id") Integer id,
        @RequestParam(name = "page", required = false, defaultValue = "1") int page,
        @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {
        try {
            var customer = customerService.findOne(id);
            model.addAttribute("customer", customer);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
        } catch (NotFoundException e) {
            return "redirect:/error/404";
        }
        return "redirect:/customers";
    }
    

}
