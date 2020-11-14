package io.jmix.dbtests;

import io.jmix.dbtests.init.MariadblInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = MariadblInitializer.class)
public class MariadbTest extends MainDataStoreTest {
}
