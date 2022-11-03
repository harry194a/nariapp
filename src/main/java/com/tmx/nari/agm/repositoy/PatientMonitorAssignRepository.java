package com.tmx.nari.agm.repositoy;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 22:35
 */
public interface PatientMonitorAssignRepository extends JpaRepository<PatientMonitorAssign, UUID> {
}
