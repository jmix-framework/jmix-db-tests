package io.jmix.dbtests;

import io.jmix.core.Id;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.dbtests.entity.LongIdEntity;
import io.jmix.dbtests.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class MainDataStoreTest {

    @Autowired
    UnconstrainedDataManager dataManager;

    @Test
    void testUser() {
        User user = dataManager.create(User.class);
        user.setUsername(RandomStringUtils.randomAlphanumeric(8));
        dataManager.save(user);

        User user1 = dataManager.load(Id.of(user)).one();
        assertEquals(user, user1);
    }

    @Test
    void testLoadUserById() {
        User user = dataManager.load(Id.of(UUID.fromString("60885987-1b61-4247-94c7-dff348347f93"), User.class)).one();
        assertNotNull(user);
        assertEquals("admin", user.getUsername());
    }

    @Test
    void testLongIdEntity() {
        LongIdEntity entity = dataManager.create(LongIdEntity.class);
        entity.setName("e1");
        dataManager.save(entity);

        LongIdEntity entity1 = dataManager.load(Id.of(entity)).one();
        assertEquals(entity, entity1);

        checkSequence();
    }

    protected void checkSequence() {
    }
}
