package io.jmix.dbtests.init;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MariaDBContainer;

public class MariadblInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static MariaDBContainer<?> container = new MariaDBContainer<>("mariadb:10.5.8")
            .withDatabaseName("test-db")
            .withUsername("test")
            .withPassword("pass");

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
