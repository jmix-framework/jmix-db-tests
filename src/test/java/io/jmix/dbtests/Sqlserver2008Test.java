package io.jmix.dbtests;

import io.jmix.dbtests.init.Sqlserver2008Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(initializers = Sqlserver2008Initializer.class)
public class Sqlserver2008Test extends MainDataStoreTest {

    @Autowired
    DataSource dataSource;

    @Override
    protected void checkSequence() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long count = jdbcTemplate.queryForObject(
                "select count(*) from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'seq_id_dbt_longidentity'", Long.class);
        assertEquals(1, count);
    }
}
