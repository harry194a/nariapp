package com.tmx.nari.agm.service.patient;

import com.tmx.nari.agm.entity.patients.Patients;
import com.tmx.nari.agm.model.request.create.patients.CreatePatientRequest;
import com.tmx.nari.agm.model.request.update.patient.UpdatePatientRequest;

import java.util.List;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:19
 */
public interface PatientService {
    Patients create(final CreatePatientRequest request);

    Patients update(final UUID id, final UpdatePatientRequest model);

    Patients getById(final UUID id);
    
    Boolean existByPatientsId(final String patientsId);
    
    Patients getByPatientsId(final String patientsId);
    
    List<Patients> findAll();

    void delete(final UUID id);
}
