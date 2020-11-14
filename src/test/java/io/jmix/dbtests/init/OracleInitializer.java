package io.jmix.dbtests.init;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.containers.PostgreSQLContainer;

public class OracleInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static OracleContainer container = new OracleContainer(System.getProperty("oracleImage"));

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
