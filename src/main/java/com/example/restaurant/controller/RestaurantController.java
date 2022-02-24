package com.example.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.data.ResponseData;
import com.example.restaurant.data.RestaurantData;
import com.example.restaurant.repository.RestaurantRepository;
import com.example.restaurant.service.RestaurantService;
import com.example.restaurant.validation.RestaurantValidation;

@RestController
@RequestMapping("/api/v1/restaurant")

public class RestaurantController {
@Autowired
RestaurantService restaurantService;
	

@PostMapping("/insertValues")
public ResponseEntity<ResponseData<String>> insertValues(@RequestBody RestaurantData restaurantData){
	ResponseEntity<ResponseData<String>>validation = RestaurantValidation.validateInsertValues(restaurantData, restaurantService);
	if(validation.getStatusCode().value() == 200) {
		restaurantService.saveData(restaurantData);
		return validation;
	}
	return validation;
}
@PutMapping("/updatePrice")
public ResponseEntity<ResponseData<String>> updatePrice(@RequestBody RestaurantData restaurantData){
	ResponseEntity<ResponseData<String>> validation = RestaurantValidation.validateUpdatePrice(restaurantData, restaurantService);
	if(validation.getStatusCode().value() == 200) {
		restaurantService.UpdatePriceById(restaurantData);
		return validation;
	}
	return validation;
}
@GetMapping("/getAllData")
public ResponseEntity<ResponseData<List<RestaurantData>>> getAllData(){
	ResponseData<List<RestaurantData>> response = new ResponseData();
	response.setStatusCode(200);
	response.setMessage("Data fethched sucessfully");
	response.setData(restaurantService.fetchAllData());
	return ResponseEntity.ok(response);
}
@DeleteMapping("/deleteById/{id}")
public ResponseEntity<ResponseData<String>> deleteById(@PathVariable ("id") Long id){
	ResponseEntity<ResponseData<String>> validation = RestaurantValidation.validateDeleteById(id, restaurantService);
	if(validation.getStatusCode().value() == 200) {
		restaurantService.deleteId(id);
		return validation;
	}
	return validation;
}
}
