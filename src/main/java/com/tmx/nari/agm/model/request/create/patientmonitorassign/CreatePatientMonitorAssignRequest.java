package com.tmx.nari.agm.model.request.create.patientmonitorassign;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 18:06
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CreatePatientMonitorAssignRequest {
    
    private String patientId;
    private String monitorId;
    
    public PatientMonitorAssign toEntity(){
        PatientMonitorAssign patientMonitorAssign = new PatientMonitorAssign();
        patientMonitorAssign.setPatientId(patientId);
        patientMonitorAssign.setMonitorId(monitorId);
        patientMonitorAssign.setSignInDate(LocalDateTime.now());
        
        return patientMonitorAssign;
    }
}
