package com.sysco.ordermanager.domain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by vibodhab on 2/8/18.
 */
@Entity
@Table
public class OrderData implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String type;

    @Column
    private int quantity;


    @OneToMany(mappedBy = "orderItemId.order",cascade ={ CascadeType.ALL })
    private Set<OrderItemData> orderItems=new HashSet<>();

    public Set<OrderItemData> getItems() {
        return orderItems;
    }

    public void setItems(Set<OrderItemData> orderItems) {
        this.orderItems = orderItems;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private UserData userData;


    public OrderData() {
    }

    public OrderData(Long id, String type, int quantity, Set<OrderItemData> orderItems) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.orderItems = orderItems;
        this.userData = userData;
    }

    public OrderData(Long id, String type, int quantity) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
