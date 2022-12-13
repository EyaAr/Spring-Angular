package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Restaurant;
import tn.esprit.spring.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurant> retrieveAllRestaurants() {
		// TODO Auto-generated method stub
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	@Override
	public Restaurant addRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		
		return restaurantRepository.save(r);
	}

	@Override
	public Restaurant retrieveRestaurant(Long id) {
		// TODO Auto-generated method stub
		return restaurantRepository.findById(id).orElse(null);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant r) {
		// TODO Auto-generated method stub
		return restaurantRepository.save(r);
	}

	@Override
	public void deleteRestaurant(Long id) {
		// TODO Auto-generated method stub
		restaurantRepository.deleteById(id);
		
	}

}
