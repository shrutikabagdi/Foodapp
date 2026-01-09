package com.foody.dao;

import com.foody.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class RestaurantDao {
    private JdbcTemplate jdbcTemplate;

    public RestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //public void saveRestaurant(Restaurant restaurant);
    public void saveRestaurant(Restaurant restaurant) {
        jdbcTemplate.update("INSERT INTO restaurant VALUES(?,?,?,?,?)",
                restaurant.getResTd(),
                restaurant.getName(),
                restaurant.getRatings(),
                restaurant.getLatitude(),
                restaurant.getLongitude());
    }
    //public void updateRestaurant(Restaurant restaurant);
    public void updateRestaurant(Restaurant restaurant){
        jdbcTemplate.update("UPDATE restaurant SET name=?, rating=?, latitude=?, longitude=? WHERE res_id=?",
                restaurant.getName(),
                restaurant.getRatings(),
                restaurant.getLatitude(),
                restaurant.getLongitude(),
                restaurant.getResTd());
    }
    //public void deleteRestaurantById(int resId);
    public void deleteRestaurantById(int resId){
        jdbcTemplate.update("DELETE FROM restaurant WHERE res_id=?", resId);
    }

    RowMapper<Restaurant> restaurantRowMapper = (rs, rowNum) -> {
        Restaurant r = new Restaurant();
        r.setResTd(String.valueOf(rs.getInt("res_id")));
        r.setName(rs.getString("name"));
        r.setRatings(rs.getDouble("rating"));
        r.setLatitude(rs.getDouble("latitude"));
        r.setLongitude(rs.getDouble("longitude"));
        return r;
    };
    //public Restaurant findRestaurantById(int resId);
    public Restaurant findRestaurantById(int resId){
        return jdbcTemplate.queryForObject("SELECT * FROM restaurant WHERE res_id=?",
                new Object[]{resId},
                restaurantRowMapper);
    }

//public List<Restaurant> findRestaurantsByRating(double rating);
public List<Restaurant> findRestaurantsByRating(double rating){
    return jdbcTemplate.query("SELECT * FROM restaurant WHERE rating>=?",
            new Object[]{rating},
            restaurantRowMapper);
}
//
//public List<Restaurant> findRestaurantsWithinRadius(
//        double latitude, double longitude, double radius);
public List<Restaurant> findRestaurantsWithinRadius(double latitude, double longitude, double radius){
    String sql = "SELECT * FROM restaurant";
    return jdbcTemplate.query(sql, restaurantRowMapper);
}

//
//public List<Restaurant> findAllRestaurants();

    public List<Restaurant> findAllRestaurants(){
        return jdbcTemplate.query("SELECT * FROM restaurant", restaurantRowMapper);
    }

}



