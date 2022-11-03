package com.tmx.nari.agm.model.request.update.patient;

import com.tmx.nari.agm.entity.patients.Patients;
import com.tmx.nari.agm.entity.patients.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 19:18
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class UpdatePatientRequest {

    private String patientId;
    private Status status;

    public Patients toEntity(final Patients patients) {
        patients.setPatientId(patientId);
        patients.setStatus(status);
        return patients;
    }
}
