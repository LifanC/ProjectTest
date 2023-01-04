package com.project.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<ProductNumber, Integer> {
	@Query(value = "select * from product_object where product_object.productnumber=?", nativeQuery = true)
    List<ProductNumber> queryByProductnumber(String productnumber);
	@Query(value = "select * from product_object where product_object.id=?", nativeQuery = true)
    Integer setByProductnumber(Integer id);
}
