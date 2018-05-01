package com.drp.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 刘江涛
 * @ClassName: Inventory
 * @Description: 实体：库存
 * @date 2017年11月7日 上午11:46:43
 */
@Entity
@Table(name = "t_inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;            //库存主键id

    @Column(length = 10)
    private Integer initialNum;    //初始化数量

    private Integer inNum;        //进库数量

    private Integer outNum;        //出库数量

    private String isVerify;    //是否确认

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "item_id")
    private Integer itemId;

    @ManyToOne()
    @JoinColumn(name = "fiscalPeriodId")
    private Fiscal fiscal;

    public Inventory() {
    }

    public Inventory(Integer id, Integer initialNum, Integer inNum, Integer outNum, String isVerify, Fiscal fiscal) {
        super();
        this.id = id;
        this.initialNum = initialNum;
        this.inNum = inNum;
        this.outNum = outNum;
        this.isVerify = isVerify;
        this.fiscal = fiscal;
    }

    public Inventory(Integer id, Integer initialNum, Integer inNum, Integer outNum, String isVerify) {
        super();
        this.id = id;
        this.initialNum = initialNum;
        this.inNum = inNum;
        this.outNum = outNum;
        this.isVerify = isVerify;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInitialNum() {
        return initialNum;
    }

    public void setInitialNum(Integer initialNum) {
        this.initialNum = initialNum;
    }

    public Integer getInNum() {
        return inNum;
    }

    public void setInNum(Integer inNum) {
        this.inNum = inNum;
    }

    public Integer getOutNum() {
        return outNum;
    }

    public void setOutNum(Integer outNum) {
        this.outNum = outNum;
    }


    public Fiscal getFiscal() {
        return fiscal;
    }

    public void setFiscal(Fiscal fiscal) {
        this.fiscal = fiscal;
    }

    public String getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(String isVerify) {
        this.isVerify = isVerify;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", initialNum=" + initialNum +
                ", inNum=" + inNum +
                ", outNum=" + outNum +
                ", isVerify='" + isVerify + '\'' +
                ", clientId=" + clientId +
                ", itemId=" + itemId +
                ", fiscal=" + fiscal +
                '}';
    }
}
