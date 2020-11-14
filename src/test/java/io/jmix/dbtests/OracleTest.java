package io.jmix.dbtests;

import io.jmix.dbtests.init.OracleInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = OracleInitializer.class)
public class OracleTest extends MainDataStoreTest {
}
