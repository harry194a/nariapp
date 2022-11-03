package com.tmx.nari.agm.entity.common;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;
/**
 * Created by Arshavir Hunanyan
 * Date: 9/11/21
 * Time: 4:30 PM
 */
@MappedSuperclass
public class AbstractDomainEntity {

    @Column( name = "id", updatable = false, nullable = false, unique = true)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @GeneratedValue
    @Id
    protected UUID id;

    protected AbstractDomainEntity(final UUID id) {
        this.id = id;
    }

    protected AbstractDomainEntity() {
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof AbstractDomainEntity)) return false;

        final AbstractDomainEntity that = (AbstractDomainEntity) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}
