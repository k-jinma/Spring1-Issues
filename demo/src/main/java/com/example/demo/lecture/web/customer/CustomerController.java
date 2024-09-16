package com.example.demo.lecture.web.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.demo.lecture.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(path = "customer/create", method = RequestMethod.GET)
    public String showCreate(CustomerForm customerForm, Model model) {
        model.addAttribute("customerForm", customerForm);
        return "pages/customer/create";
    }

    @RequestMapping(path = "customer/create", method = RequestMethod.POST)
    public String create(
        @Valid @ModelAttribute CustomerForm form,
        final BindingResult result) {
        if(result.hasErrors()) {
            return "pages/customer/create";
        }
        var customer = form.toEntity();
        customer = customerService.save(customer);

        // 作成したCustomerのIDをパスパラメータにセットしてリダイレクト
        // PRGパターンを実装
        // PRGパターンとは、POSTリクエストでデータを送信した後にリダイレクトすることで、ブラウザのリロードによる二重送信を防ぐためのパターン
        return "redirect:/customer/" + customer.getId();
    }


}
