package com.drp.dto;

import java.io.Serializable;
import java.util.Date;

public class FlowCardDto implements Serializable {
    private Integer id;
    private String flowCardNum;
    private String clientCode;
    private String clientName;
    private String recoederName;
    private String recoedDate;

    public FlowCardDto() {
    }

    public FlowCardDto(Integer id, String flowCardNum, String clientCode, String clientName, String recoederName, String recoedDate) {
        this.id = id;
        this.flowCardNum = flowCardNum;
        this.clientCode = clientCode;
        this.clientName = clientName;
        this.recoederName = recoederName;
        this.recoedDate = recoedDate;
    }

    public String getRecoederName() {
        return recoederName;
    }

    public void setRecoederName(String recoederName) {
        this.recoederName = recoederName;
    }

    public String getRecoedDate() {
        return recoedDate;
    }

    public void setRecoedDate(String recoedDate) {
        this.recoedDate = recoedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlowCardNum() {
        return flowCardNum;
    }

    public void setFlowCardNum(String flowCardNum) {
        this.flowCardNum = flowCardNum;
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
}
