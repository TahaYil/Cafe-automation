package com.taa.cafeautomation.repository;

import com.taa.cafeautomation.entitiy.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    public Order findById(int id);
    public List<Order> findByTableId(int tabelId);

    @Query(value = "select o from orders o where o.table_id=:tableId and o.isActive=true",nativeQuery = true)
    public Optional<Order> findActiveOrderByTableId(@Param("tableId") int tableId);

}
