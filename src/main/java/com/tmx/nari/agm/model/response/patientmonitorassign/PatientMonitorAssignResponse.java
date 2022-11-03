package com.tmx.nari.agm.model.response.patientmonitorassign;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 18:17
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PatientMonitorAssignResponse {
    private UUID id;
    private String patientId;
    private String monitorId;
    private LocalDateTime signInDate;

    public static PatientMonitorAssignResponse from(
            final PatientMonitorAssign patientMonitorAssign) {
        PatientMonitorAssignResponse response = new PatientMonitorAssignResponse();
        response.setId(patientMonitorAssign.getId());
        response.setPatientId(patientMonitorAssign.getPatientId());
        response.setMonitorId(patientMonitorAssign.getMonitorId());
        response.setSignInDate(patientMonitorAssign.getSignInDate());
        return response;
    }

}
