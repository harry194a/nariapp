package com.tmx.nari.agm.model.models;

import com.tmx.nari.agm.entity.patients.Patients;
import com.tmx.nari.agm.entity.patients.Status;
import lombok.Value;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 06.11.22
 * Time: 16:49
 */
@Value
public class PatientModel {
    
    UUID id;
    String patientId;
    Status status;

    public static PatientModel from(Patients patients) {
        return new PatientModel(
                patients.getId(),
                patients.getPatientId(),
                patients.getStatus()
        );
    }
}
