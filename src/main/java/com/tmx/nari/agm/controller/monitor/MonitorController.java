package com.tmx.nari.agm.controller.monitor;

import com.tmx.nari.agm.entity.monitors.MonitorStatus;
import com.tmx.nari.agm.entity.monitors.Monitors;
import com.tmx.nari.agm.model.request.create.monitor.CreateMonitorRequest;
import com.tmx.nari.agm.model.request.update.monitor.UpdateMonitorRequest;
import com.tmx.nari.agm.model.response.monitor.MonitorResponse;
import com.tmx.nari.agm.service.monitor.MonitorService;
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
import java.util.List;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 23:04
 */
@RestController
@RequestMapping("api/monitor")
@Api("monitor")
public class MonitorController {

    private final MonitorService service;

    public MonitorController(final MonitorService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ApiOperation(
            value = "create Monitor",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MonitorResponse> create(
           @Valid @RequestBody CreateMonitorRequest request) {
        Monitors item = service.create(request);
        MonitorResponse response = MonitorResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(
            value = "find Monitors ",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MonitorResponse> findById(
            @Valid @PathVariable("id") UUID id) {
        Monitors item = service.getById(id);
        MonitorResponse response = MonitorResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(
            value = "update Monitor",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MonitorResponse> update(
            @RequestBody UpdateMonitorRequest request,
            @Valid @PathVariable("id") UUID id) {
        Monitors item = service.update(id, request);
        MonitorResponse response = MonitorResponse.from(item);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(
            value = "delete monitor",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void delete(
            @Valid @PathVariable("id") UUID id) {
        this.service.delete(id);
    }

    @GetMapping("/find-status")
    @ApiOperation(
            value = "find Monitors by status ",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<Monitors>> findByStatus(MonitorStatus status) {
        List<Monitors> item = service.findAllByMonitorStatus(status);
        return ResponseEntity.ok(item);
    }
}
