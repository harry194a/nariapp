package com.tmx.nari.agm.controller.processdata;

import com.tmx.nari.agm.entity.data.ProcessData;
import com.tmx.nari.agm.model.request.create.processdata.CreateProcessDataRequest;
import com.tmx.nari.agm.model.request.update.processdata.UpdateProcessDataRequest;
import com.tmx.nari.agm.model.response.processdata.ProcessDataResponse;
import com.tmx.nari.agm.service.processdata.ProcessDataService;
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
 * Time: 23:07
 */
@RestController
@RequestMapping("api/Data")
@Api("Data")
public class ProcessDataController {
    
    private final ProcessDataService service;

    public ProcessDataController(final ProcessDataService service) {
        this.service = service;
    }
    @PostMapping("/create")
    @ApiOperation(
            value = "create Data",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProcessDataResponse> create(
           @Valid @RequestBody CreateProcessDataRequest request) {
        ProcessData item = service.create(request);
        ProcessDataResponse response = ProcessDataResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(
            value = "find Data ",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProcessDataResponse> findById(
            @PathVariable("id") UUID id) {
        ProcessData item = service.getById(id);
        ProcessDataResponse response = ProcessDataResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(
            value = "update Monitor",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProcessDataResponse> update(
            @RequestBody UpdateProcessDataRequest request,
            @PathVariable("id") UUID id) {
        ProcessData item = service.update(id, request);
        ProcessDataResponse response = ProcessDataResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(
            value = "delete monitor",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void delete(
            @PathVariable("id") UUID id) {
        this.service.delete(id);
    }
}

