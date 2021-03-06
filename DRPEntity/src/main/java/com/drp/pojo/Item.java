package com.drp.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author 刘江涛
 * @ClassName: Item
 * @Description: 实体：物料
 * @date 2017年11月7日 上午11:47:01
 */
@Entity
@Table(name = "t_item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;                //主键id

    @Column(length = 10, nullable = false)
    private String code;            //物料代码

    @Column(length = 10, nullable = false)
    private String name;            //物料名称

    private String specification;    //物料规格

    private String modelNum;        //物料型号

    private String simplePhoto;        //样品图片

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "itemType_id")
    private Category itemType;

    @ManyToOne()
    @JoinColumn(name = "unitType_id")
    private Category unitType;

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSimplePhoto() {
        return simplePhoto;
    }

    public void setSimplePhoto(String simplePhoto) {
        this.simplePhoto = simplePhoto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Category getItemType() {
        return itemType;
    }

    public void setItemType(Category itemType) {
        this.itemType = itemType;
    }

    public Category getUnitType() {
        return unitType;
    }

    public void setUnitType(Category unitType) {
        this.unitType = unitType;
    }
}
