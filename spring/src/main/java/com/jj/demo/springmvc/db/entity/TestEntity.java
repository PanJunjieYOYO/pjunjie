package com.jj.demo.springmvc.db.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by panjunjie on 2016/07/30.
 */
@Entity
@Table(name = "jj")
public class TestEntity {
    private String jj;
    private int b;

    public String getJj() {
        return jj;
    }

    public void setJj(String jj) {
        this.jj = jj;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
