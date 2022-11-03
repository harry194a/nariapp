package com.tmx.nari.agm.model.response.patients;

import com.tmx.nari.agm.entity.patients.Patients;
import com.tmx.nari.agm.entity.patients.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class PatientResponse {
    
    private UUID id;
    private String patientId;
    private Status status;
    
    public static PatientResponse from(
            final Patients patients) {
        PatientResponse response = new PatientResponse();
        response.setId(patients.getId());
        response.setPatientId(patients.getPatientId());
        response.setStatus(patients.getStatus());
        return response;
    }
}
