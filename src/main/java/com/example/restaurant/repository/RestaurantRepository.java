package com.example.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.restaurant.data.ResponseData;
import com.example.restaurant.data.RestaurantData;

public interface RestaurantRepository extends JpaRepository <RestaurantData, Long> {
@Transactional
@Modifying
@Query(value = "update food_details set price=:price where id=:id", nativeQuery = true)
void updatePrice(@Param("id") Long id, @Param("price") Long price);
}
