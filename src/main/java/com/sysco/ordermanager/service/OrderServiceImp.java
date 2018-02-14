package com.sysco.ordermanager.service;
import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import com.sysco.ordermanager.service.converter.OrderConverter;
import com.sysco.ordermanager.web.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by vibodhab on 2/8/18.
 */
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public Order getOrder(String id) {
        return orderConverter.convertOrderDataToOrder(orderRepository.getOne(id));
    }

    @Override
    public Order setOrder(Order order) {
        OrderData orderData = orderConverter.convertOrderToOrderData(order);
        return orderConverter.convertOrderDataToOrder(orderRepository.save(orderData));
    }

    @Override
    public ArrayList<Order> getUserOrders(String id) {
        ArrayList<OrderData> userOrderData = orderRepository.findByUserData(id);
        ArrayList<Order> userOrders = new ArrayList<>();
        for (int i = 0; i < userOrderData.size(); i++){
            Order tempOrder = orderConverter.convertOrderDataToOrder(userOrderData.get(i));
            userOrders.add(tempOrder);
        }
        return userOrders;
    }
}
