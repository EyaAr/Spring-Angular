package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Restaurant;
import tn.esprit.spring.service.RestaurantService;

@RestController
@Api(tags = "restaurant management")
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
RequestMethod.PUT })
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@ApiOperation(value = "Récupérer la liste des restaurants")
	// http://localhost:8089/SpringMVC/restaurant/retrieve-all-restaurants
	@GetMapping("/retrieve-all-restaurants")
	@ResponseBody
	public List<Restaurant> listRestaurant() {
		return restaurantService.retrieveAllRestaurants();
	}
	
	// http://localhost:8089/SpringMVC/restaurant/retrieve-restaurant/
		@GetMapping("/retrieve-restaurant/{restaurant-id}")
		@ApiOperation(value = "Récupérer restaurant par id")
		@ResponseBody
		public Restaurant retrieveRestaurant(@PathVariable("restaurant-id") Long idRestaurant) {
			return restaurantService.retrieveRestaurant(idRestaurant);
		}
		
		// http://localhost:8089/SpringMVC/restaurant/add-restaurant
		@PostMapping("/add-restaurant")
		@ApiOperation(value = "ajouter restaurant")
		@ResponseBody
		public Restaurant addRestaurant(@RequestBody Restaurant r) {
			Restaurant restaurant = restaurantService.addRestaurant(r);
			return restaurant;
		}
	
		// http://localhost:8089/SpringMVC/restaurant/remove-restaurant/{restaurant-id}
		@DeleteMapping("/remove-restaurant/{restaurant-id}")
		@ApiOperation(value = "supprimer restaurant")
		@ResponseBody
		public void removeRestaurant(@PathVariable("restaurant-id") Long idRestaurant) {
			restaurantService.deleteRestaurant(idRestaurant);
		}
	
		// http://localhost:8089/SpringMVC/restaurant/modify-restaurant
		@PutMapping("/modify-restaurant")
		@ApiOperation(value = "modifier restaurant")
		@ResponseBody
		public Restaurant modifyRestaurant(@RequestBody Restaurant restaurant) {
			return restaurantService.updateRestaurant(restaurant);
		}
}
