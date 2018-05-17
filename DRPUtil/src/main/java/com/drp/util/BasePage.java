package com.drp.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页Util
 * @param <T>
 */
public class BasePage<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    public List<T> list;
    public int size;
    public int totalPage;

    public BasePage(List<T> list, int size, int totalPage) {
        super();
        this.list = list;
        this.size = size;
        this.totalPage = totalPage;
    }

    public BasePage() {
        super();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

}
