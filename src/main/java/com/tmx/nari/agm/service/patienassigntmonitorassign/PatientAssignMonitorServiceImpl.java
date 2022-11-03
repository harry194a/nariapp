package com.tmx.nari.agm.service.patienassigntmonitorassign;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import com.tmx.nari.agm.model.request.create.patientmonitorassign.CreatePatientMonitorAssignRequest;
import com.tmx.nari.agm.model.request.update.patientmonitorassign.UpdatePatientMonitorAssignRequest;
import com.tmx.nari.agm.repositoy.PatientMonitorAssignRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:21
 */
@Service
public class PatientAssignMonitorServiceImpl implements PatientAssignMonitorService {
   private final PatientMonitorAssignRepository repository;

    public PatientAssignMonitorServiceImpl(final PatientMonitorAssignRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientMonitorAssign create(final CreatePatientMonitorAssignRequest request) {
        Assert.notNull(request, "Request must not be null");
        PatientMonitorAssign patientMonitorAssign = request.toEntity();
        patientMonitorAssign = repository.save(patientMonitorAssign);
        return patientMonitorAssign;    }

    @Override
    public PatientMonitorAssign update(final UUID id, final UpdatePatientMonitorAssignRequest request) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(request, "Request must not be null");
        PatientMonitorAssign patientMonitorAssign = getById(id);
        patientMonitorAssign = request.toEntity(patientMonitorAssign);
        return repository.save(patientMonitorAssign);    }

    @Override
    public PatientMonitorAssign getById(final UUID id) {
        return repository.findById(id).orElseThrow(SecurityException::new);
    }

    @Override
    public void delete(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        getById(id);
        repository.deleteById(id);
    }
}
