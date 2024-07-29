package com.example.demo.lecture.web.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.lecture.service.CustomerDestinationService;
import com.example.demo.lecture.service.CustomerService;
import com.example.demo.lecture.service.ItemService;
import com.example.demo.lecture.service.OutboundService;


@Controller
public class OutboundController {

    @Autowired
    OutboundService outboundService;

    @Autowired
    ItemService itemService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerDestinationService customerDestinationService;

    @RequestMapping(path = "/outbound/create", method=RequestMethod.GET)
    public String showCreate(
        OutboundForm outboundForm,
        Model model,
        Pageable pageable
        ) {

        // 商品一覧情報を取得する
        var items = itemService.findAll(pageable);
        model.addAttribute("items", items);

        // 顧客一覧を取得する
        var customers = customerService.findAll(pageable);
        model.addAttribute("customers", customers);

        // 顧客配送先一覧を取得する
        var customerDestinations = customerDestinationService.findAll(pageable);
        model.addAttribute("customerDestinations", customerDestinations);

        model.addAttribute("outboundForm", outboundForm);


        return "pages/outbound/create";
    }
    
}
