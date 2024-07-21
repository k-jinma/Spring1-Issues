package com.example.demo.lecture.web.inbound;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InboundForm {

    /** 商品ID */
    @NotNull(message = "{validation.field.required}")
    private int itemId;

    /** 入荷ID */
    @NotNull(message = "{validation.field.required}")
    private int supplierId;

    /** 数量 */
    @NotNull(message = "{validation.field.required}")
    @Min(value = 1)
    private int quantity;
    
    /** 入荷予定日 */
    private String scheduledDate;

    /** 入荷ステータス */
    private int status;


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    

}
