package io.jmix.dbtests;

import io.jmix.dbtests.init.SqlserverInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(initializers = SqlserverInitializer.class)
public class SqlserverTest extends MainDataStoreTest {

    @Autowired
    DataSource dataSource;

    @Override
    protected void checkSequence() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long count = jdbcTemplate.queryForObject(
                "select count(*) from INFORMATION_SCHEMA.TABLES where TABLE_NAME = 'seq_id_dbt_longidentity'", Long.class);
        assertEquals(0, count); // no table is created for the sequence
    }
}
