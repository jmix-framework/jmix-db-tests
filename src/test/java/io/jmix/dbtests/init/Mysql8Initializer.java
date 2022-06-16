package io.jmix.dbtests.init;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MySQLContainer;

public class Mysql8Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0.29")
            .withDatabaseName("test-db")
            .withUsername("root");

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        container.start();
        TestPropertyValues.of(
                "main.datasource.jdbcUrl=" + container.getJdbcUrl(),
                "main.datasource.username=" + container.getUsername(),
                "main.datasource.password=" + container.getPassword()
        ).applyTo(applicationContext.getEnvironment());
    }
}
