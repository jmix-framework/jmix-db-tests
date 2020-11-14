package io.jmix.dbtests.init;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MSSQLServerContainer;

public class Sqlserver2008Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static MSSQLServerContainer<?> container = new MSSQLServerContainer<>()
            .acceptLicense();

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        container.start();
        TestPropertyValues.of(
                "main.datasource.jdbcUrl=" + container.getJdbcUrl(),
                "main.datasource.username=" + container.getUsername(),
                "main.datasource.password=" + container.getPassword(),
                "jmix.data.dbmsVersion=2008"
        ).applyTo(applicationContext.getEnvironment());
    }
}
