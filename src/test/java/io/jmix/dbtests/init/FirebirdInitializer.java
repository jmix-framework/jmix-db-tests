package io.jmix.dbtests.init;

import org.firebirdsql.testcontainers.FirebirdContainer;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirebirdInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static FirebirdContainer<?> container = new FirebirdContainer<>()
            .withDatabaseName("test-db")
            .withUsername("test")
            .withPassword("pass");

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        container.start();
        TestPropertyValues.of(
                "abc.datasource.jdbcUrl=" + container.getJdbcUrl(),
                "abc.datasource.username=" + container.getUsername(),
                "abc.datasource.password=" + container.getPassword(),
                "jmix.data.dbmsType_abc = firebird"
        ).applyTo(applicationContext.getEnvironment());

        // todo remove after https://github.com/liquibase/liquibase/issues/1303 is fixed
        try (Connection connection = DriverManager.getConnection(container.getJdbcUrl(), container.getUsername(), container.getPassword());
             Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE DATABASECHANGELOGLOCK (ID VARCHAR(255) NOT NULL, LOCKED SMALLINT NOT NULL, LOCKGRANTED TIMESTAMP, LOCKEDBY VARCHAR(255))");
        } catch (SQLException e) {
            //noinspection JmixRuntimeException
            throw new RuntimeException(e);
        }
    }
}
