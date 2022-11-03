package com.tmx.nari.agm.model.request.create.patients;

import com.tmx.nari.agm.entity.patients.Patients;
import com.tmx.nari.agm.entity.patients.Status;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 17:46
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CreatePatientRequest {
    
    private String patientId;
    private Status status;
    
    public Patients toEntity(){
        Patients patients = new Patients();
        patients.setPatientId(patientId);
        patients.setStatus(status);
        return patients;
    }
}
