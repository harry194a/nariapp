package com.tmx.nari.agm.service.patient;

import com.tmx.nari.agm.entity.patients.Patients;
import com.tmx.nari.agm.model.request.create.patients.CreatePatientRequest;
import com.tmx.nari.agm.model.request.update.patient.UpdatePatientRequest;
import com.tmx.nari.agm.repositoy.PatientsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
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
    @Transactional
    public Patients create(final CreatePatientRequest request) {
        Assert.notNull(request, "Request must not be null");
        Patients patients = request.toEntity();
        patients = repository.save(patients);
        return patients;
    }

    @Override
    @Transactional
    public Patients update(final UUID id, final UpdatePatientRequest request) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(request, "Request must not be null");
        Patients patients = getById(id);
        patients = request.toEntity(patients);
        return repository.save(patients);
    }

    @Override
    @Transactional
    public Patients getById(final UUID id) {
        return repository.findById(id).orElseThrow(SecurityException::new);
    }

    @Override
    @Transactional
    public Boolean existByPatientsId(final String patientsId) {
        return repository.existsByPatientId(patientsId);
    }

    @Override
    @Transactional
    public Patients getByPatientsId(final String patientsId) {
        return repository.findByPatientId(patientsId).orElseThrow(SecurityException::new);
    }

    @Override
    @Transactional
    public List<Patients> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        getById(id);
        repository.deleteById(id);
    }
}
