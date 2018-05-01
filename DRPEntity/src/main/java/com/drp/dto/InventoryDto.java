package com.drp.dto;

import java.io.Serializable;

public class InventoryDto implements Serializable {
    private Integer id;
    private Integer clientId;
    private Integer itemId;
    private String clientCode;
    private String clientName;
    private String itemCode;
    private String itemName;
    private String specification;
    private String modelNum;
    private String isVerify;
    private Integer initialNum;

    public InventoryDto() {
    }

    public InventoryDto(Integer id, String clientCode, String itemCode,Integer initialNum) {
        this.id = id;
        this.clientCode = clientCode;
        this.itemCode = itemCode;
        this.initialNum = initialNum;
    }

    public InventoryDto(Integer id, Integer clientId, Integer itemId, String clientCode, String clientName, String itemCode, String itemName, String specification, String modelNum, String isVerify, Integer initialNum) {
        this.id = id;
        this.clientId = clientId;
        this.itemId = itemId;
        this.clientCode = clientCode;
        this.clientName = clientName;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.specification = specification;
        this.modelNum = modelNum;
        this.isVerify = isVerify;
        this.initialNum = initialNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(String isVerify) {
        this.isVerify = isVerify;
    }

    public Integer getInitialNum() {
        return initialNum;
    }

    public void setInitialNum(Integer initialNum) {
        this.initialNum = initialNum;
    }

    @Override
    public String toString() {
        return "InventoryDto{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", itemId=" + itemId +
                ", clientCode='" + clientCode + '\'' +
                ", clientName='" + clientName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", specification='" + specification + '\'' +
                ", modelNum='" + modelNum + '\'' +
                ", isVerify='" + isVerify + '\'' +
                ", initialNum='" + initialNum + '\'' +
                '}';
    }
}
