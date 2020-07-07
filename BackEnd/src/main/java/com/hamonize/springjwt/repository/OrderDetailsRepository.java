package com.hamonize.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamonize.springjwt.models.Order_Details;

@Repository
public interface OrderDetailsRepository extends JpaRepository<Order_Details, Long>{

}
