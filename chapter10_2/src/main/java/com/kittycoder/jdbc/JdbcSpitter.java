package com.kittycoder.jdbc;

import com.kittycoder.po.Spitter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shucheng on 2020/7/16 11:27
 */
public class JdbcSpitter {

    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname) values (?, ?, ?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username=?, password=?, fullname=? where id = ?";
    private static final String SQL_SELECT_SPITTER = "select id, username, password, fullname from spitter where id = ?";
    @Autowired
    private DataSource dataSource;

    // 新增
    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_SPITTER);
            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 修改
    public void saveSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_SPITTER);
            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.setLong(4, spitter.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 查询单个
    public Spitter findOne(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_SPITTER);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            Spitter spitter = null;
            if (rs.next()) {
                spitter = new Spitter();
                spitter.setId(rs.getLong("id"));
                spitter.setUsername(rs.getString("username"));
                spitter.setPassword(rs.getString("password"));
                spitter.setFullName(rs.getString("fullname"));
            }
            return spitter;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
