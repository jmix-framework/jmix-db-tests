package io.jmix.dbtests.init;

import org.firebirdsql.testcontainers.FirebirdContainer;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

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
    }
}
