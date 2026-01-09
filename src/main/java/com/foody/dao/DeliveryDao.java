package com.foody.dao;

import com.foody.model.Delivery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class DeliveryDao {
    private JdbcTemplate jdbcTemplate;

    public DeliveryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createDelivery(Delivery delivery){
        jdbcTemplate.update("INSERT INTO delivery VALUES(?,?,?,?)",
                delivery.getDelId(),
                delivery.getOrderId(),
                delivery.getDelPartnerId(),
                delivery.getStatus());
    }

    public void updateDeliveryStatus(int delId, String status){
        jdbcTemplate.update("UPDATE delivery SET status=? WHERE del_id=?",
                status,
                delId);
    }

    RowMapper<Delivery> deliveryRowMapper = (rs, rowNum) -> {
        Delivery d = new Delivery();
        d.setDelId(rs.getString("del_id"));
        d.setOrderId(rs.getString("order_id"));
        d.setDelPartnerId(rs.getString("del_partner_id"));
        d.setStatus(rs.getString("status"));
        return d;
    };

    public Delivery findDeliveryById(int delId){
        return jdbcTemplate.queryForObject("SELECT * FROM delivery WHERE del_id=?",
                new Object[]{delId},
                deliveryRowMapper);
    }

    public List<Delivery> findDeliveriesByOrderId(int orderId){
        return jdbcTemplate.query("SELECT * FROM delivery WHERE order_id=?",
                new Object[]{orderId},
                deliveryRowMapper);
    }

    public List<Delivery> findDeliveriesByPartner(int delPartnerId){
        return jdbcTemplate.query("SELECT * FROM delivery WHERE del_partner_id=?",
                new Object[]{delPartnerId},
                deliveryRowMapper);
    }

    public List<Delivery> findDeliveriesByStatus(String status){
        return jdbcTemplate.query("SELECT * FROM delivery WHERE status=?",
                new Object[]{status},
                deliveryRowMapper);
    }
}
