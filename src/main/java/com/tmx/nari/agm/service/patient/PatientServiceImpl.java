package com.tmx.nari.agm.service.patient;

import com.tmx.nari.agm.entity.patients.Patients;
import com.tmx.nari.agm.model.request.create.patients.CreatePatientRequest;
import com.tmx.nari.agm.model.request.update.patient.UpdatePatientRequest;
import com.tmx.nari.agm.repositoy.PatientsRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:21
 */
@Service
public class PatientServiceImpl implements PatientService {
    private final PatientsRepository repository;

    public PatientServiceImpl(final PatientsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patients create(final CreatePatientRequest request) {
        Assert.notNull(request, "Request must not be null");
        Patients patients = request.toEntity();
        patients = repository.save(patients);
        return patients;
    }

    @Override
    public Patients update(final UUID id, final UpdatePatientRequest request) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(request, "Request must not be null");
        Patients patients = getById(id);
        patients = request.toEntity(patients);
        return repository.save(patients);
    }

    @Override
    public Patients getById(final UUID id) {
        return repository.findById(id).orElseThrow(SecurityException::new);
    }

    @Override
    public void delete(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        getById(id);
        repository.deleteById(id);
    }
}
