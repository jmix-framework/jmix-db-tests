package io.jmix.dbtests;

import io.jmix.dbtests.init.Mysql8Initializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = Mysql8Initializer.class)
public class Mysql8Test extends MainDataStoreTest {
}
