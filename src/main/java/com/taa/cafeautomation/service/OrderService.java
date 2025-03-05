package com.taa.cafeautomation.service;

import com.taa.cafeautomation.entitiy.Order;
import com.taa.cafeautomation.entitiy.OrderItems;
import com.taa.cafeautomation.entitiy.Product;
import com.taa.cafeautomation.repository.OrderItemsRepository;
import com.taa.cafeautomation.repository.OrderRepository;
import com.taa.cafeautomation.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final ProductRepository productRepository;
    public OrderService(OrderRepository orderRepository, OrderRepository orderRepository1, OrderItemsRepository orderItemsRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository1;
        this.orderItemsRepository = orderItemsRepository;
        this.productRepository = productRepository;
    }
    public List<Order> findByTableId(int tableId) {
        return orderRepository.findByTableId(tableId);
    }
    public Order addProductOrder(int tableId, int productId, int quantity) {
        Order order = orderRepository.findActiveOrderByTableId(tableId).orElse(new Order());
        OrderItems orderItems = orderItemsRepository.create(tableId,productId,quantity);
        Product product = productRepository.findById(productId);
        double price = product.getPrice()*quantity;
        order.setOriginalAmount(order.getOriginalAmount()+price);

        List<OrderItems> newList=order.getOrderItems();
        newList.add(orderItems);
        order.setOrderItems(newList);

        return orderRepository.save(order);


    }
}
