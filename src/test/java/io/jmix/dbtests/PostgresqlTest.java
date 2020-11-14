package io.jmix.dbtests;

import io.jmix.dbtests.init.PostgresqlInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = PostgresqlInitializer.class)
public class PostgresqlTest extends MainDataStoreTest {
}
