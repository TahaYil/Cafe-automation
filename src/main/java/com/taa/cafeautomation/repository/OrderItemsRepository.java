package com.taa.cafeautomation.repository;

import com.taa.cafeautomation.entitiy.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {
    //public OrderItems create(OrderItems orderItems);
    @Query(value = "insert into order_items (order_id,product_id,quantitiy) values (:orderId,:productId,:quantitiy) ",nativeQuery = true)
    public OrderItems create(@Param("orderId") int orderId,
                             @Param("productId") int productId,
                             @Param("quantitiy") int quantity);
    public OrderItems findById(int id);
}
