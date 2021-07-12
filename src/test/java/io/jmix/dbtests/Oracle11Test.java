package io.jmix.dbtests;

import io.jmix.dbtests.init.Oracle11Initializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = Oracle11Initializer.class)
public class Oracle11Test extends MainDataStoreTest {
}
