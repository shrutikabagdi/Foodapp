package com.foody;

import com.foody.config.AppConfig;
import com.foody.controller.OrderController;
import com.foody.dao.InventoryDao;
import com.foody.model.Inventory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class FoodyApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderController controller = ctx.getBean(OrderController.class);
        controller.placeOrder();

        AnnotationConfigApplicationContext ctx1 = new AnnotationConfigApplicationContext(AppConfig.class);
        JdbcTemplate jdbcTemplate = ctx1.getBean(JdbcTemplate.class);
        InventoryDao idao = new InventoryDao(jdbcTemplate);
        Inventory inv = new Inventory();
        inv.setItemId(1);
        inv.setItemName("product");
        idao.save(inv);

//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp","root","12345");
//
//        PreparedStatement ps1 = con.prepareStatement("CREATE TABLE orders(oid varchar(32))");
//        ps1.executeUpdate();
//
//        PreparedStatement ps2 = con.prepareStatement("INSERT INTO orders (oid,oname) VALUES (?, ?)"
//        );
//        ps2.setInt(1,1);
//        ps2.setString(2,"Product Name");
////        ps2.setString(3,"12345");
//        ps2.executeUpdate();
//        ps2.close();
//        con.close();

    }

}







//package com.foody;
//
//import com.foody.config.AppConfig;
//import com.foody.controller.OrderController;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//@SpringBootApplication
//public class FoodyApplication {
//
//    public static void main(String[] args) throws SQLException {
//
//        // Spring
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderController controller = ctx.getBean(OrderController.class);
//        controller.placeOrder();
//
//        // DB Connection
//        Connection con = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/foodapp",
//                "root",
//                "12345"
//        );
//
//        // 1️⃣ Create orders table (proper)
//        PreparedStatement ps1 = con.prepareStatement(
//                "CREATE TABLE IF NOT EXISTS orders (" +
//                        "oid VARCHAR(32)," +
//                        "oname VARCHAR(50)" +
//                        ")"
//        );
//        ps1.executeUpdate();
//        ps1.close();
//
//        // 2️⃣ Insert data into orders
//        PreparedStatement ps2 = con.prepareStatement(
//                "INSERT INTO orders (oid, oname) VALUES (?, ?)"
//        );
//        ps2.setString(1, "101");
//        ps2.setString(2, "First Order");
//        ps2.executeUpdate();
//        ps2.close();
//
//        con.close();
//
//        System.out.println("✔ Table created + ✔ Order inserted successfully!");
//    }
//}
