package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.model.OrderItemData;
import com.sysco.ordermanager.web.api.Order;
import com.sysco.ordermanager.web.api.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by vibodhab on 2/9/18.
 */
@Service
public class OrderConverter {

    @Autowired
    OrderItemConverter orderItemConverter;

    @Autowired
    private UserConverter userConverter;

    public Order convertOrderDataToOrder(OrderData orderData) {

        final Order order = new Order(
                orderData.getId(),
                orderData.getType(),
                userConverter.convertUserDataToUser(orderData.getUserData()),
                orderData.getOrderStatus()
        );
        final Set<OrderItem> orderItemSet = orderItemConverter.convertOrderItemDataListToOrderItemList(orderData.getItems(), order);
        order.setOrderItems(orderItemSet);
        return order;
    }

    public OrderData convertOrderToOrderData(Order order) {

        final OrderData orderData = new OrderData(
                order.getType(),
                userConverter.convertUserToUserData(order.getUser()),
                order.getOrderStatus()
        );

        final Set<OrderItemData>
                orderItemDataSet = orderItemConverter.convertOrderItemListToOrderItemDataList(order.getOrderItems(), orderData);

        orderData.setItems(orderItemDataSet);
        return orderData;
    }
}
