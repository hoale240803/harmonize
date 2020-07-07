package com.hamonize.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamonize.springjwt.models.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
