package com.tmx.nari.agm.entity.patientmonitorassign;

import com.tmx.nari.agm.entity.common.AuditableBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 16:51
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
public class PatientMonitorAssign extends AuditableBaseEntity {
    
    private String PatientId;
    private String MonitorId;
    private LocalDateTime SignInDate;
    
}
