package com.tmx.nari.agm.model.models;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 06.11.22
 * Time: 16:54
 */
@Value
public class PatientAssignMonitorModel {
    UUID id;
    String PatientId;
    String MonitorId;
    LocalDateTime SignInDate;
    LocalDateTime SignOutDate;

    public static PatientAssignMonitorModel from(PatientMonitorAssign patientMonitorAssign) {
        return new PatientAssignMonitorModel(
                patientMonitorAssign.getId(),
                patientMonitorAssign.getPatientId(),
                patientMonitorAssign.getMonitorId(),
                patientMonitorAssign.getSignInDate(),
                patientMonitorAssign.getSignOutDate()
        );
    }
}
