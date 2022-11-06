package com.tmx.nari.agm.service.patienassigntmonitorassign;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import com.tmx.nari.agm.model.request.create.patientmonitorassign.CreatePatientMonitorAssignRequest;
import com.tmx.nari.agm.model.request.update.patientmonitorassign.UpdatePatientMonitorAssignRequest;
import com.tmx.nari.agm.repositoy.PatientMonitorAssignRepository;
import com.tmx.nari.agm.service.monitor.MonitorService;
import com.tmx.nari.agm.service.patient.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:21
 */
@Service
public class PatientAssignMonitorServiceImpl implements PatientAssignMonitorService {
   private final PatientMonitorAssignRepository repository;
   private final PatientService patientService;
   private final MonitorService monitorService;

    public PatientAssignMonitorServiceImpl(final PatientMonitorAssignRepository repository, 
                                           final PatientService patientService, 
                                           final MonitorService monitorService) {
        this.repository = repository;
        this.patientService = patientService;
        this.monitorService = monitorService;
    }

    @Override
    @Transactional
    public PatientMonitorAssign create(final CreatePatientMonitorAssignRequest request) {
        Assert.notNull(request, "Request must not be null");
        PatientMonitorAssign patientMonitorAssign = request.toEntity();
        if(monitorService.checkAndChangeAvailabilityStatus(request.getMonitorId())){
        patientMonitorAssign = repository.save(patientMonitorAssign);}
        return patientMonitorAssign;    }

    @Override
    @Transactional
    public PatientMonitorAssign update(final UUID id, final UpdatePatientMonitorAssignRequest request) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(request, "Request must not be null");
        PatientMonitorAssign patientMonitorAssign = getById(id);
        patientMonitorAssign = request.toEntity(patientMonitorAssign);
        return repository.save(patientMonitorAssign);    }

    @Override
    @Transactional
    public PatientMonitorAssign getById(final UUID id) {
        return repository.findById(id).orElseThrow(SecurityException::new);
    }
    @Transactional
    @Override
    public PatientMonitorAssign unAssign(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        PatientMonitorAssign patientMonitorAssign = getById(id);
        if(monitorService.changeStatus(patientMonitorAssign.getMonitorId())){
            patientMonitorAssign.setSignOutDate(LocalDateTime.now());
            patientMonitorAssign = repository.save(patientMonitorAssign);}
        return patientMonitorAssign;
    }

    @Override
    @Transactional
    public void delete(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        getById(id);
        repository.deleteById(id);
    }
}
