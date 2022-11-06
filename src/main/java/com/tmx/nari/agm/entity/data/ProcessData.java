package com.tmx.nari.agm.entity.data;

import com.tmx.nari.agm.entity.common.AuditableBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 16:28
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
public class ProcessData extends AuditableBaseEntity {
    
    private LocalDateTime timeStamp;
    private String patientsId;
    private String bloodPressure;
    private String heartRate;
    private String deviceNumber;
    private LocalDateTime endTime;
}
