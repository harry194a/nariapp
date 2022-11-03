package com.tmx.nari.agm.entity.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

/**
 * Created by Arshavir Hunanyan
 * Date: 9/11/21
 * Time: 5:13 PM
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditableBaseEntity extends AbstractDomainEntity {

    @CreatedDate
    protected Instant createdAt;

    @LastModifiedDate
    protected Instant lastModifiedAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(final Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("createdAt", createdAt)
                .append("lastModifiedAt", lastModifiedAt)
                .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof AuditableBaseEntity)) return false;

        final AuditableBaseEntity that = (AuditableBaseEntity) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(createdAt, that.createdAt)
                .append(lastModifiedAt, that.lastModifiedAt)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(createdAt)
                .append(lastModifiedAt)
                .toHashCode();
    }
}
