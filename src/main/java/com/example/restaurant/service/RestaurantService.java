package com.example.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant.data.RestaurantData;
import com.example.restaurant.repository.RestaurantRepository;
@Service
public class RestaurantService {
@Autowired 
RestaurantRepository restaurantRepository;
	public void saveData(RestaurantData restaurantData) {
		// TODO Auto-generated method stub
		restaurantRepository.save(restaurantData);
	}
	public void UpdatePriceById(RestaurantData restaurantData) {
		// TODO Auto-generated method stub
		restaurantRepository.updatePrice(restaurantData.getId(), restaurantData.getPrice());
	}
	public List<RestaurantData> fetchAllData() {
		// TODO Auto-generated method stub
		return restaurantRepository.findAll();
	}
	public void deleteId(Long id) {
		// TODO Auto-generated method stub
		restaurantRepository.deleteById(id);
	}
	public boolean existById(Long id) {
		// TODO Auto-generated method stub
		return restaurantRepository.existsById(id);
	}

}
