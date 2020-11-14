package io.jmix.dbtests;

import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.dbtests.entity.LongIdEntity;
import io.jmix.dbtests.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class MainDataStoreTest {

    @Autowired
    DataManager dataManager;

    @Test
    void testUser() {
        User user = dataManager.create(User.class);
        user.setUsername(RandomStringUtils.randomAlphanumeric(8));
        dataManager.save(user);

        User user1 = dataManager.load(Id.of(user)).one();
        assertEquals(user, user1);
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
