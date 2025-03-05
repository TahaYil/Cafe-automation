package com.taa.cafeautomation.service;

import com.taa.cafeautomation.entitiy.Order;
import com.taa.cafeautomation.entitiy.OrderItems;
import com.taa.cafeautomation.entitiy.Product;
import com.taa.cafeautomation.repository.OrderItemsRepository;
import com.taa.cafeautomation.repository.OrderRepository;
import com.taa.cafeautomation.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemsService(OrderItemsRepository orderItemsRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderItemsRepository = orderItemsRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderItems create(int tableId, int productId,int quantity) {
        OrderItems orderItems = new OrderItems();
        Order order=orderRepository.findActiveOrderByTableId(tableId).orElse(new Order());
        Product product=productRepository.findById(productId);

        orderItems.setOrder(order);
        orderItems.setProduct(product);
        orderItems.setQuantity(quantity);
        return orderItemsRepository.create(order.getId(), productId,quantity);
    }
}
