package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entity.Restaurant;

public interface RestaurantService {
	
	List<Restaurant> retrieveAllRestaurants();

	Restaurant addRestaurant(Restaurant r);

	Restaurant retrieveRestaurant(Long id);

	Restaurant updateRestaurant(Restaurant r);

	void deleteRestaurant(Long id);


}
