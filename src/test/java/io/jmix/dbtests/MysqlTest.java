package io.jmix.dbtests;

import io.jmix.dbtests.init.MysqlInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = MysqlInitializer.class)
public class MysqlTest extends MainDataStoreTest {
}
