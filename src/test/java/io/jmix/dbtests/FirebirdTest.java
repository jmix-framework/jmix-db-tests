package io.jmix.dbtests;

import io.jmix.core.Id;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.dbtests.entity.AbcEntity;
import io.jmix.dbtests.init.FirebirdInitializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(initializers = FirebirdInitializer.class)
public class FirebirdTest {

    @Autowired
    UnconstrainedDataManager dataManager;

    @Test
    void testAbcEntity() {
        AbcEntity entity = dataManager.create(AbcEntity.class);
        entity.setName("e1");
        dataManager.save(entity);

        AbcEntity entity1 = dataManager.load(Id.of(entity)).one();
        assertEquals(entity, entity1);
    }

}
