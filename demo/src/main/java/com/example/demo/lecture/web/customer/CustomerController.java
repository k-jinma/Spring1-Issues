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


@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @RequestMapping( path = "/customers", method=RequestMethod.GET)
    public String list(
        Model model,
        @PageableDefault(size = 10) Pageable pageable
    ) {

        // CustomerServiceのfindAllメソッドを呼び出す
        var customers = customerService.findAll(pageable);
        // 取得したCustomerのリストをModelにセット
        model.addAttribute("customers", customers);
        return "pages/customer/list";
    }

    @RequestMapping(path = "customer/{id}")
    public String detail(
        Model model,
        @PathVariable("id") Integer id
    ) {
        try {
            // CustomerServiceのfindOneメソッドを呼び出す
            var customer = customerService.findOne(id);
            // 取得したCustomerをModelにセット
            model.addAttribute("customer", customer);

        // NotFoundExceptionが発生した場合はエラーページにリダイレクト
        } catch (NotFoundException e) {
            return "redirect:/error/404";
        }
        return "pages/customer/detail";
    }
    

}
