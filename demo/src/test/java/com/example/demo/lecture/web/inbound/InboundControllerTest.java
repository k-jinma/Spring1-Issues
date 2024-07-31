package com.example.demo.lecture.web.inbound;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.example.demo.lecture.service.InboundService;
import com.example.demo.lecture.service.ItemService;
import com.example.demo.lecture.service.SupplierService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@ExtendWith(MockitoExtension.class)
public class InboundControllerTest {

    @Autowired
    private MockMvc mockMvc;

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

    /**
     * 入荷情報登録処理のバリデーションを実行するテストメソッド
     * createメソッドのテストケース
     * テスト項目 1_3_1
     */
    @Test
    public void testCreate_1_3_1(){

        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.afterPropertiesSet(); // バリデータを初期化
        
        InboundForm form = new InboundForm();
        form.setItemId(1);
        form.setSupplierId(1);
        form.setQuantity(-1); // 数量が不正
        form.setScheduledDate("2024-07-31");
        form.setStatus(1);

        BindingResult result = new BeanPropertyBindingResult(form, "inboundForm");

        // バリデーションの実行
        validator.validate(form, result);

        // バリデーションエラーがあることを検証
        assertTrue(result.hasErrors());
        assertTrue(result.hasFieldErrors("quantity"));

    }

    /**
     * 入荷情報登録処理のバリデーションを実行するテストメソッド
     * createメソッドのテストケース
     * テスト項目 1_3_2
     */
    @Test
    public void testCreate_1_3_2(){

        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.afterPropertiesSet(); // バリデータを初期化
        
        InboundForm form = new InboundForm();

        DataBinder binder = new DataBinder(form, "inboundForm");
        binder.setValidator(validator);
        
        binder.bind( new MutablePropertyValues(Map.of(
            "itemId", 1,
            "supplierId", 1,
            "quantity", "0",
            "scheduledDate", "2024-07-31",
            "status", 1
        )));

        // バリデーションの実行
        binder.validate();

        BindingResult result = binder.getBindingResult();

        // バリデーションエラーがあることを検証
        assertTrue(result.hasErrors());
        assertTrue(result.hasFieldErrors("quantity"));

    }

    
    /**
     * 入荷情報登録処理のバリデーションを実行するテストメソッド
     * createメソッドのテストケース
     * テスト項目 1_3_4
     */
    @Test
    public void testCreate_1_3_4(){

        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.afterPropertiesSet(); // バリデータを初期化
        
        InboundForm form = new InboundForm();

        DataBinder binder = new DataBinder(form, "inboundForm");
        binder.setValidator(validator);
        
        binder.bind( new MutablePropertyValues(Map.of(
            "itemId", 1,
            "supplierId", 1,
            "quantity", "e",
            "scheduledDate", "2024-07-31",
            "status", 1
        )));

        // バリデーションの実行
        binder.validate();

        BindingResult result = binder.getBindingResult();

        // バリデーションエラーがあることを検証
        assertTrue(result.hasErrors());
        assertTrue(result.hasFieldErrors("quantity"));

    }

}
