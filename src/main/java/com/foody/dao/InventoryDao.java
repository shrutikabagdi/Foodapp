package com.foody.dao;

import com.foody.model.Inventory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class InventoryDao {
    private JdbcTemplate jdbcTemplate;

    public InventoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void save(Inventory inventory){
        jdbcTemplate.update("INSERT INTO " +
                        "inventory Values(?,?)",
                inventory.getItemId(),
                inventory.getItemName());
    }
    public void update(Inventory inventory) {
        jdbcTemplate.update("UPDATE inventory SET"
                        + "Name = ? WHERE id = ? ",
                inventory.getItemId(),
                inventory.getItemName()
        );
    }
    RowMapper<Inventory> inventoryRowMapper =(rs, rowNum) -> {
        Inventory i =new Inventory();
        i.setItemId(rs.getInt("id"));
        i.setItemName(rs.getString("name"));
        return i;
    };
    public List<Inventory> findAll(int limit, int pageNo){
        return jdbcTemplate.query("SELECT * FROM inventory",inventoryRowMapper);
    }
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE From inventory WHERE id=? ",id);
    }
    // NamedParameterJdbcTemplate for delete if ? marks nhi dena hy to use kr sakte hy

    public Inventory findbyId(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM inventory WHERE id=?",
                new Object[]{id},
                (rs, rowNum) -> {
                    Inventory inv = new Inventory();
                    inv.setItemId(id);
                    inv.setItemName(rs.getString("name"));
                    return inv;
                });
    }

}
