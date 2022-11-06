package com.tmx.nari.agm.entity.monitors;

import com.tmx.nari.agm.entity.common.AuditableBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 16:28
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
public class Monitors extends AuditableBaseEntity {

    private String name;
    private String model;
    @Column(unique = true)
    private String monitorId;

    @Enumerated(EnumType.STRING)
    private MonitorStatus monitorStatus;
}
