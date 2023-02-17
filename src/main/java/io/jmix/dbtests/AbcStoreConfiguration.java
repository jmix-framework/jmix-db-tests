package io.jmix.dbtests;

import io.jmix.autoconfigure.data.JmixLiquibaseCreator;
import io.jmix.core.JmixModules;
import io.jmix.core.Resources;
import io.jmix.data.impl.JmixEntityManagerFactoryBean;
import io.jmix.data.impl.JmixTransactionManager;
import io.jmix.data.persistence.DbmsSpecifics;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class AbcStoreConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "abc.datasource")
    DataSource abcDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    LocalContainerEntityManagerFactoryBean abcEntityManagerFactory(JpaVendorAdapter jpaVendorAdapter,
                                                                   DbmsSpecifics dbmsSpecifics,
                                                                   JmixModules jmixModules,
                                                                   Resources resources) {
        return new JmixEntityManagerFactoryBean("abc", abcDataSource(), jpaVendorAdapter, dbmsSpecifics, jmixModules, resources);
    }

    @Bean
    JpaTransactionManager abcTransactionManager(@Qualifier("abcEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JmixTransactionManager("abc", entityManagerFactory);
    }

    @Bean("abcLiquibaseProperties")
    @ConfigurationProperties(prefix = "abc.liquibase")
    public LiquibaseProperties abcLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean("abcLiquibase")
    public SpringLiquibase abcLiquibase(@Qualifier("abcDataSource") DataSource dataSource,
                                        @Qualifier("abcLiquibaseProperties") LiquibaseProperties liquibaseProperties) {
        return JmixLiquibaseCreator.create(dataSource, liquibaseProperties);
    }
}
