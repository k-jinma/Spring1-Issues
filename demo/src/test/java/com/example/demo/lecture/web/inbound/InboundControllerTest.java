package com.example.demo.lecture.web.inbound;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.demo.lecture.entity.InboundHistoryEntity;
import com.example.demo.lecture.entity.ItemEntity;
import com.example.demo.lecture.entity.SupplierEntity;
import com.example.demo.lecture.service.InboundService;
import com.example.demo.lecture.service.ItemService;
import com.example.demo.lecture.service.SupplierService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@ExtendWith(MockitoExtension.class)
public class InboundControllerTest {

    @Mock
    private ItemService itemService;

    @Mock
    private SupplierService supplierService;

    @Mock
    private InboundService inboundService;

    @Mock
    private InboundHistoryEntity inboundForm;

    @Mock
    private Model model;

    @Mock
    private Pageable pageable;

    @Mock
    private BindingResult result;

    @InjectMocks
    private InboundController inboundController;

    @Test
    public void showCreateTest() {
        // モックの設定
        Page<ItemEntity> itemPage = new PageImpl<>(new ArrayList<>(), PageRequest.of(0, 10), 0);
        when(itemService.findAll(pageable)).thenReturn(itemPage);
        
        Page<SupplierEntity> supplierPage = new PageImpl<>(new ArrayList<>(), PageRequest.of(0, 10), 0);
        when(supplierService.findAll(pageable)).thenReturn(supplierPage);

        InboundForm inboundForm = new InboundForm();
        String viewName = inboundController.showCreate(inboundForm, model, pageable);

        // 検証
        assertEquals("pages/inbound/create", viewName);
        verify(model).addAttribute("items", new ArrayList<>());
        verify(model).addAttribute("suppliers", new ArrayList<>());
        verify(model).addAttribute("inboundForm", inboundForm);
    }

    @Test
    public void createTest() {
        // モックの設定
        when(result.hasErrors()).thenReturn(false);
        var inbound = inboundForm.toEntity();
        when(inboundService.save(inbound)).thenReturn(inboundForm);

        InboundForm inboundForm = new InboundForm();
        inboundForm.setItemId(0);; // 必要なセットアップを行う

        String viewName = inboundController.create(inboundForm, result, model, pageable);

        // 検証
        assertEquals("redirect:/inbound/create", viewName);
        // verify(inboundService).save(any(Inbound.class));
    }

    @Test
    public void createTest_withErrors() {
        // モックの設定
        when(result.hasErrors()).thenReturn(true);
        Page<ItemEntity> itemPage = new PageImpl<>(new ArrayList<>(), PageRequest.of(0, 10), 0);
        when(itemService.findAll(pageable)).thenReturn(itemPage);

        Page<SupplierEntity> supplierPage = new PageImpl<>(new ArrayList<>(), PageRequest.of(0, 10), 0);
        when(supplierService.findAll(pageable)).thenReturn(supplierPage);

        InboundForm inboundForm = new InboundForm();
        String viewName = inboundController.create(inboundForm, result, model, pageable);

        // 検証
        assertEquals("pages/inbound/create", viewName);
        verify(model).addAttribute("items", new ArrayList<>());
        verify(model).addAttribute("suppliers", new ArrayList<>());
    }
}