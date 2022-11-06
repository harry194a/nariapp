package com.tmx.nari.agm.service.patienassigntmonitorassign;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import com.tmx.nari.agm.model.request.create.patientmonitorassign.CreatePatientMonitorAssignRequest;
import com.tmx.nari.agm.model.request.update.patientmonitorassign.UpdatePatientMonitorAssignRequest;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:20
 */
public interface PatientAssignMonitorService {

    PatientMonitorAssign create(final CreatePatientMonitorAssignRequest request);

    PatientMonitorAssign update(final UUID id, final UpdatePatientMonitorAssignRequest request);

    PatientMonitorAssign getById(final UUID id);
    
    PatientMonitorAssign unAssign(final UUID id);

    void delete(final UUID id);
}
