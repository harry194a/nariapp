package com.tmx.nari.agm.entity.monitors;

import com.tmx.nari.agm.entity.common.AuditableBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;

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
    
    private String model;
    private String monitorId;
}
