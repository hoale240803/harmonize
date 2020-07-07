package com.hamonize.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamonize.springjwt.models.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}
