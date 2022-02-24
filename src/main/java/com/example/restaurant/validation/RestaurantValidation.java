package com.example.restaurant.validation;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;

import com.example.restaurant.data.ResponseData;
import com.example.restaurant.data.RestaurantData;
import com.example.restaurant.service.RestaurantService;

public class RestaurantValidation {

	public static ResponseEntity<ResponseData<String>> validateInsertValues(RestaurantData restaurantData,
			RestaurantService restaurantService) {
		// TODO Auto-generated method stub
		ResponseData<String> response = new ResponseData() ;
		response.setStatusCode(400);
		if(restaurantData.getFoodName()== null || restaurantData.getFoodName().trim().isEmpty()) {
			response.setMessage("Please enter foodName");
			return ResponseEntity.badRequest().body(response);
		}
//		if(restaurantData.getFoodName().trim() == null) {
//			response.setMessage("Please remove space at front and end of foodName");
//			return ResponseEntity.badRequest().body(response);
//		}
		Pattern pattern = Pattern.compile("[A-Za-z]");
		Matcher matcher = pattern.matcher(restaurantData.getFoodName());
		response.setMessage("Please enter alphabets for foodName");
        if(!matcher.find()) {
        	return ResponseEntity.badRequest().body(response);
        }
		
		if(restaurantData.getFoodType()==null || restaurantData.getFoodType().isEmpty()) {
			response.setMessage("Please enter foodType");
			return ResponseEntity.badRequest().body(response);
		}
		if(restaurantData.getPrice() == null || restaurantData.getPrice() >= 0) {
			response.setMessage("Please enter foodPrice");
			return ResponseEntity.badRequest().body(response);
		}
	
		restaurantData.setCreatedAt(new Date());
		restaurantData.setUpdatedAt(new Date());
		response.setStatusCode(200);
		response.setMessage("Data inserted sucessfully");
		return ResponseEntity.ok(response);
	}

	public static ResponseEntity<ResponseData<String>> validateUpdatePrice(RestaurantData restaurantData,
			RestaurantService restaurantService) {
		// TODO Auto-generated method stub
		ResponseData<String> response = new ResponseData();
		response.setStatusCode(400);
		if(restaurantData.getId()==null || restaurantData.getId()>=0) {
			response.setMessage("Please enter id");
			return ResponseEntity.badRequest().body(response);
		}
		if(!restaurantService.existById(restaurantData.getId())) {
			response.setMessage("Data is not available for this id");
			return ResponseEntity.badRequest().body(response);
		}
		if(restaurantData.getPrice()==null || restaurantData.getPrice()>=0) {
			response.setMessage("Please enter food price");
			return ResponseEntity.badRequest().body(response);
		}
		response.setStatusCode(400);
		response.setMessage("Data updated sucessfully");
		return ResponseEntity.ok(response);
	}

	public static ResponseEntity<ResponseData<String>> validateDeleteById(Long id,
			RestaurantService restaurantService) {
		// TODO Auto-generated method stub
		ResponseData<String> response = new ResponseData();
		response.setStatusCode(400);
		if(id == null || id >= 0 ) {
			response.setMessage("Please enter id");
			return ResponseEntity.badRequest().body(response);
		}
		if(!restaurantService.existById(id)) {
			response.setMessage("Data is not available for this id");
			return ResponseEntity.badRequest().body(response);
		}
		response.setStatusCode(400);
		response.setMessage("Data deleted sucessfully");
		return ResponseEntity.ok(response);
	}
	

}
