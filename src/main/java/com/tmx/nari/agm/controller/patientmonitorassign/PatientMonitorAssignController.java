package com.tmx.nari.agm.controller.patientmonitorassign;

import com.tmx.nari.agm.entity.patientmonitorassign.PatientMonitorAssign;
import com.tmx.nari.agm.model.request.create.patientmonitorassign.CreatePatientMonitorAssignRequest;
import com.tmx.nari.agm.model.request.update.patientmonitorassign.UpdatePatientMonitorAssignRequest;
import com.tmx.nari.agm.model.response.patientmonitorassign.PatientMonitorAssignResponse;
import com.tmx.nari.agm.service.patienassigntmonitorassign.PatientAssignMonitorService;
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
 * Time: 23:06
 */
@RestController
@RequestMapping("api/patient-monitor-assign")
@Api("patient monitor assign")
public class PatientMonitorAssignController {
    
    private final PatientAssignMonitorService service;

    public PatientMonitorAssignController(final PatientAssignMonitorService service) {
        this.service = service;
    }
    @PostMapping("/create")
    @ApiOperation(
            value = "create patient monitor assign",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PatientMonitorAssignResponse> create(
            @Valid @RequestBody CreatePatientMonitorAssignRequest request) {
        PatientMonitorAssign item = service.create(request);
        PatientMonitorAssignResponse response = PatientMonitorAssignResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(
            value = "find patient monitor assign ",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PatientMonitorAssignResponse> findById(
            @Valid @PathVariable("id") UUID id) {
        PatientMonitorAssign item = service.getById(id);
        PatientMonitorAssignResponse response = PatientMonitorAssignResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(
            value = "update patient monitor assign",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PatientMonitorAssignResponse> update(
            @Valid @RequestBody UpdatePatientMonitorAssignRequest request,
            @Valid @PathVariable("id") UUID id) {
        PatientMonitorAssign item = service.update(id, request);
        PatientMonitorAssignResponse response = PatientMonitorAssignResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(
            value = "delete patient monitor assign",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void delete(
           @Valid @PathVariable("id") UUID id) {
        this.service.delete(id);
    }

    @DeleteMapping("/unassign/{id}")
    @ApiOperation(
            value = "monitor un assign ",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PatientMonitorAssignResponse> unAssign(
            @Valid @PathVariable("id") UUID id) {
        PatientMonitorAssign item = service.unAssign(id);
        PatientMonitorAssignResponse response = PatientMonitorAssignResponse.from(item);
        return ResponseEntity.ok(response);
    }
}
