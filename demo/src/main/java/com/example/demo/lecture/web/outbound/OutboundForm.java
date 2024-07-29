package com.example.demo.lecture.web.outbound;

import com.example.demo.lecture.entity.OutboundHistoryEntity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OutboundForm {

    /** 商品ID */
    @NotNull(message = "{validation.field.required}")
    private int itemId;

    /** 数量 */
    @NotNull(message = "{validation.field.required}")
    @Min(value = 1)
    private int quantity;

    /** 顧客ID */
    @NotNull(message = "{validation.field.required}")
    private int customerId;

    /** 顧客配送先ID */
    @NotNull(message = "{validation.field.required}")
    private int customerDestinationId;

    /** 出荷予定日 */
    // TODO: すでに実績があれば(inbound_historyテーブルにデータがある)エラーを表示？
    private String expectedDate;

    /** 出荷ステータス */
    private int status;

    /** FormデータをOutboundHistoryEntityに変換する */
    public OutboundHistoryEntity toEntity() {
        OutboundHistoryEntity outboundHistoryEntity = new OutboundHistoryEntity();
        // inboundHistoryEntity.setItem_id(itemId);
        // inboundHistoryEntity.setSupplier_id(supplierId);
        // inboundHistoryEntity.setQuantity(quantity);
        // inboundHistoryEntity.setStatus(status);
        // inboundHistoryEntity.setExpectedDate(scheduledDate);
        
        // // TODO: ユーザー名を設定
        // inboundHistoryEntity.setCreatedBy("ダミーユーザー1");
        // inboundHistoryEntity.setCreatedAt(LocalDateTime.now());
        // // TODO: ユーザー名を設定
        // inboundHistoryEntity.setUpdatedBy("ダミーユーザー1");
        // inboundHistoryEntity.setUpdatedAt(LocalDateTime.now());

        return outboundHistoryEntity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerDestinationId() {
        return customerDestinationId;
    }

    public void setCustomerDestinationId(int customerDestinationId) {
        this.customerDestinationId = customerDestinationId;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

}
