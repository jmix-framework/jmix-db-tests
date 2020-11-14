package io.jmix.dbtests.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.Store;

import javax.persistence.*;
import java.util.UUID;

@Store(name = "abc")
@JmixEntity
@Table(name = "DBT_ABC_ENTITY")
@Entity(name = "dbt_AbcEntity")
public class AbcEntity {

    @JmixGeneratedValue
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @JmixGeneratedValue
    @Column(name = "UUID")
    private UUID uuid;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}