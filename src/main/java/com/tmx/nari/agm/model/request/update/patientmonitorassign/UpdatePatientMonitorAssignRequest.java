package com.tmx.nari.agm.model.request.update.patientmonitorassign;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 19:18
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class UpdatePatientMonitorAssignRequest {

    private String patientId;
    private String monitorId;
    private LocalDateTime signInDate;

    public PatientMonitorAssign toEntity(final PatientMonitorAssign patientMonitorAssign) {
        patientMonitorAssign.setPatientId(patientId);
        patientMonitorAssign.setMonitorId(monitorId);
        patientMonitorAssign.setSignInDate(signInDate);
        return patientMonitorAssign;
    }
}
