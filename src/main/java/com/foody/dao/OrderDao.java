package com.foody.dao;

import com.foody.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;
import java.util.List;

public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void placeOrder(Order order){
        jdbcTemplate.update("INSERT INTO orders VALUES(?,?,?,?,?,?)",
                order.getOrderId(),
                order.getUserId(),
                order.getRestaurantId(),
                order.getAmount(),
                order.getStatus(),
                order.getDate()
        );
    }

    public void updateOrderAmount(int orderId, double amount){
        jdbcTemplate.update("UPDATE orders SET amount=? WHERE order_id=?",
                amount,
                orderId);
    }

    public void updateOrderStatus(int orderId, String status){
        jdbcTemplate.update("UPDATE orders SET status=? WHERE order_id=?",
                status,
                orderId);
    }

    RowMapper<Order> orderRowMapper = (rs, rowNum) -> {
        Order o = new Order();
        o.setOrderId(rs.getString("order_id"));
        o.setUserId(rs.getString("user_id"));
        o.setRestaurantId(rs.getString("restaurant_id"));
        o.setAmount(rs.getDouble("amount"));
        o.setStatus(rs.getString("status"));
        o.setDate(rs.getString("order_date").tolocal
        return o;
    };

    public Order findOrderById(int orderId){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM orders WHERE order_id=?",
                new Object[]{orderId},
                orderRowMapper
        );
    }

    public List<Order> findOrdersByUserId(int userId){
        return jdbcTemplate.query(
                "SELECT * FROM orders WHERE user_id=?",
                new Object[]{userId},
                orderRowMapper
        );
    }

    public List<Order> findOrdersByRestaurantId(int restId){
        return jdbcTemplate.query(
                "SELECT * FROM orders WHERE restaurant_id=?",
                new Object[]{restId},
                orderRowMapper
        );
    }

    public List<Order> findOrdersByDate(LocalDate date){
        return jdbcTemplate.query(
                "SELECT * FROM orders WHERE order_date=?",
                new Object[]{date},
                orderRowMapper
        );
    }
}
