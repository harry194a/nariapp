package com.tmx.nari.agm.controller.patient;

import com.tmx.nari.agm.entity.patients.Patients;
import com.tmx.nari.agm.model.request.create.patients.CreatePatientRequest;
import com.tmx.nari.agm.model.request.update.patient.UpdatePatientRequest;
import com.tmx.nari.agm.model.response.patients.PatientResponse;
import com.tmx.nari.agm.service.patient.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 23:05
 */
@RestController
@RequestMapping("api/patient")
@Api("patient")
public class PatientController {
    
    private final PatientService service;

    public PatientController(final PatientService service) {
        this.service = service;
    }
    @PostMapping("/create")
    @ApiOperation(
            value = "create Patient",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PatientResponse> create(
           @Valid @RequestBody CreatePatientRequest request) {
        Patients item = service.create(request);
        PatientResponse response = PatientResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(
            value = "find Patient ",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PatientResponse> findById(
            @Valid @PathVariable("id") UUID id) {
        Patients item = service.getById(id);
        PatientResponse response = PatientResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(
            value = "update Patient",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PatientResponse> update(
          @Valid  @RequestBody UpdatePatientRequest request,
          @Valid  @PathVariable("id") UUID id) {
        Patients item = service.update(id, request);
        PatientResponse response = PatientResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(
            value = "delete patient",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void delete(
            @Valid @PathVariable("id") UUID id) {
        this.service.delete(id);
    }
}
