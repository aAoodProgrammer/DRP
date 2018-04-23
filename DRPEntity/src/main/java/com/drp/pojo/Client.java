package com.drp.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 刘江涛
 * @ClassName: Client
 * @Description: 实体：分销商
 * @date 2017年11月7日 上午11:43:42
 */
@Entity
@Table(name = "t_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;            //分销商主键id

    @Column(length = 40)            //,nullable=false
    private String name;        //分销商名字

    @Column(length = 10)
    private String code;        //分销商代码

    @Column(length = 30)
    private String bankCardNum;    //银行卡号

    @Column(length = 50)
    private String address;        //地址

    @Column(length = 15)
    private String zipCode;        //邮编

    @Column(length = 15)
    private String contactTel;        //联系电话

    @Column(length = 1, nullable = false)
    private String isLeaf;    //是否是叶子节点

    @Column(length = 1, nullable = false)
    private String isClient;    //是否是分销商

    @ManyToOne()
    @JoinColumn(name = "level_id")
    private Category level;    //分销商界别

    @ManyToOne()
    @JoinColumn(name = "upperId")
    private Client client;        //上级区域id

    @OneToMany(mappedBy = "client", cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    private Set<Client> clients;//分销商集合

    @OneToMany(mappedBy = "client")
    private Set<FlowCardMain> flowCardMains;    //流向单主信息 一对多

    @OneToMany(mappedBy = "client")
    private Set<Inventory> inventories;            //库存信息  一对多

    public Client() {
    }

    public Client(Integer id, String name, String code, String bankCardNum, String address, String zipCode,
                  String isLeaf, String isClient, Client client, Set<Client> clients, Set<FlowCardMain> flowCardMains,
                  Set<Inventory> inventories) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.bankCardNum = bankCardNum;
        this.address = address;
        this.zipCode = zipCode;
        this.isLeaf = isLeaf;
        this.isClient = isClient;
        this.client = client;
        this.clients = clients;
        this.flowCardMains = flowCardMains;
        this.inventories = inventories;
    }

    public Client(Integer id, String name, String code, String isLeaf, String isClient, Client client) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
        this.isLeaf = isLeaf;
        this.isClient = isClient;
        this.client = client;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankCardNum() {
        return bankCardNum;
    }

    public void setBankCardNum(String bankCardNum) {
        this.bankCardNum = bankCardNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getIsClient() {
        return isClient;
    }

    public void setIsClient(String isClient) {
        this.isClient = isClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<FlowCardMain> getFlowCardMains() {
        return flowCardMains;
    }

    public void setFlowCardMains(Set<FlowCardMain> flowCardMains) {
        this.flowCardMains = flowCardMains;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Category getLevel() {
        return level;
    }

    public void setLevel(Category level) {
        this.level = level;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", code=" + code + ", bankCardNum=" + bankCardNum + ", address="
                + address + ", zipCode=" + zipCode + ", isLeaf=" + isLeaf + ", isClient=" + isClient + ", clients="
                + clients + "]";
    }


}
