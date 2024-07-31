package com.example.demo.lecture.web.inbound;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.example.demo.lecture.service.InboundService;
import com.example.demo.lecture.service.ItemService;
import com.example.demo.lecture.service.SupplierService;

@ExtendWith(MockitoExtension.class)
public class InboundControllerTest {

    @Mock
    private ItemService itemService;

    @Mock
    private SupplierService supplierService;

    @Mock
    private InboundService inboundService;

    @Mock
    private Model model;

    @InjectMocks
    private InboundController inboundController;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

    /**
     * 入荷情報登録画面を表示するテストメソッド
     * showCreateメソッドのテストケース
     */
    @Test
    public void testShowCreate() {

        String viewName = inboundController.showCreate(null, model, null);

        // ビューネームの返却が適切か確認
        assertEquals("pages/inbound/create", viewName);
    }
}
