package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        try (PreparedStatement statement = cn.prepareStatement(
                "insert into items(name) values (?);", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        boolean rsl;
        try (PreparedStatement statement = cn.prepareStatement(
                "update items set name = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            rsl = statement.executeUpdate() > 0;
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rsl;
        try (PreparedStatement statement = cn.prepareStatement(
                "delete from items where id = ?")) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate() > 0;
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(
                "select * from items")) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item (resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                    items.add(item);
                }
            }
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement(
                "select * from items where name = ?")) {
            statement.setString(1, key);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item (resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                    items.add(item);
                }
            }
        }
        return items;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item item = null;
        try (PreparedStatement statement = cn.prepareStatement(
                "select * from items where id = ?")) {
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item (resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                }
            }
        }
        return item;
    }
}
