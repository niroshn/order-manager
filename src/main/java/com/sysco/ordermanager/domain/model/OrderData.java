package com.sysco.ordermanager.domain.model;


import javax.persistence.*;

/**
 * Created by vibodhab on 2/8/18.
 */
@Entity
@Table
public class OrderData {

    @Id
    @Column
    private String id;

    @Column
    private String type;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserData userData;

    public OrderData() {
    }

    public OrderData(String id, String type,int quantity ) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
