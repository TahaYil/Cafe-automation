package com.taa.cafeautomation.service;

import com.taa.cafeautomation.entitiy.Order;
import com.taa.cafeautomation.entitiy.Tables;
import com.taa.cafeautomation.repository.OrderRepository;
import com.taa.cafeautomation.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    private final TableRepository tableRepository;
    private final OrderRepository orderRepository;

    public TableService(TableRepository tableRepository, OrderRepository orderRepository) {
        this.tableRepository = tableRepository;
        this.orderRepository = orderRepository;
    }
    public Tables turnNonActive(Tables table) {
        Order order=orderRepository.findActiveOrderByTableId(table.getId()).orElse(new Order());
        order.setActive(false);

        return tableRepository.save(table);
    }
    public double getPrice(Tables table) {
        Order order=orderRepository.findActiveOrderByTableId(table.getId()).orElse(new Order());
        return order.getOriginalAmount();
    }
    public double doCheckOut(int tableId){
        Tables table = tableRepository.findById(tableId);
        table=turnNonActive(table);

        return getPrice(table);


    }
    public List<Tables> findNonActiveTables() {
        List tableLlist=tableRepository.findNonActiveTables().orElse(new ArrayList<>());
        return tableLlist;
    }
}
