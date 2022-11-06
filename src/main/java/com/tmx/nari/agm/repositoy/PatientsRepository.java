package com.tmx.nari.agm.repositoy;

import com.tmx.nari.agm.entity.patients.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 22:27
 */
public interface PatientsRepository extends JpaRepository<Patients, UUID> {
    Optional<Patients> findByPatientId(String patientId);
    Boolean existsByPatientId(String patientId);
}
