package com.taa.cafeautomation.controller;

import com.taa.cafeautomation.entitiy.Order;
import com.taa.cafeautomation.entitiy.Product;
import com.taa.cafeautomation.entitiy.Tables;
import com.taa.cafeautomation.service.OrderService;
import com.taa.cafeautomation.service.ProductService;
import com.taa.cafeautomation.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cashier")
public class CashierController {
    private final OrderService orderService;
    private final ProductService productService;
    private final TableService tableService;

    public CashierController(OrderService orderService, ProductService productService, TableService tableService) {
        this.orderService = orderService;
        this.productService = productService;
        this.tableService = tableService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping("/order/add")
    public ResponseEntity<Order> addProductOrder(@RequestParam int tableId,
                                                 @RequestParam int productId,
                                                 @RequestParam int quantity) {
        return ResponseEntity.ok(orderService.addProductOrder(tableId,productId,quantity));
    }
    @PostMapping("/checkout")
    public ResponseEntity<Double> checkout(@RequestParam int tableId){
        return ResponseEntity.ok(tableService.doCheckOut(tableId));
    }
    @GetMapping("/tables")
    public ResponseEntity<List<Tables>> getNonActiveTables() {
        return ResponseEntity.ok(tableService.findNonActiveTables());
    }


}
