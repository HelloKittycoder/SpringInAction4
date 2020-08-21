package com.kittycoder.dao.jdbc;

import com.kittycoder.dao.SpitterRepository;
import com.kittycoder.po.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shucheng on 2020/7/16 12:55
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String SQL_INSERT_SPITTER = "insert into Spitter (username, password, fullname) values (?, ?, ?)";
    private static final String SQL_INSERT_SPITTER2 = "insert into Spitter (username, password, fullname) values (:username, :password, :fullname)";
    private static final String SQL_UPDATE_SPITTER = "update Spitter set username=?, password=?, fullname=? where id=?";
    private static final String SELECT_SPITTER = "select id, username, password, fullname, email, updateByEmail from Spitter";

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public void addSpitter(Spitter spitter) {
        jdbcOperations.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName());
    }

    // 使用命名参数功能
    @Override
    public void addSpitter2(Spitter spitter) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", spitter.getUsername());
        paramMap.put("password", spitter.getPassword());
        paramMap.put("fullname", spitter.getFullName());
        namedJdbcTemplate.update(SQL_INSERT_SPITTER2, paramMap);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        Long id = spitter.getId();
        jdbcOperations.update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                id);
    }

    @Override
    public Spitter findOne(long id) {
        return jdbcOperations.queryForObject(SELECT_SPITTER + " where id = ?", new SpitterRowMapper(), id);
    }

    @Override
    public List<Spitter> findAll() {
        return jdbcOperations.query(SELECT_SPITTER, new SpitterRowMapper());
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {
        @Override
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fullname = rs.getString("fullname");
            String email = rs.getString("email");
            boolean updateByEmail = rs.getBoolean("updateByEmail");
            return new Spitter(id, username, password, fullname, email, updateByEmail);
        }
    }
}
