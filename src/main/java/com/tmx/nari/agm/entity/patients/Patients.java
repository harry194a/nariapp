package com.tmx.nari.agm.entity.patients;

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
public class Patients extends AuditableBaseEntity {

    @Column(unique = true)
    private String patientId;

    @Enumerated(EnumType.STRING)
    private Status status;
}
