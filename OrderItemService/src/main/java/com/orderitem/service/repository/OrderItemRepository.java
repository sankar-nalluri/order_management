package com.orderitem.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderitem.service.model.Item;

@Repository
public interface OrderItemRepository extends JpaRepository<Item, Long> {

}
