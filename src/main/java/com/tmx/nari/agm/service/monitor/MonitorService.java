package com.tmx.nari.agm.service.monitor;

import com.tmx.nari.agm.entity.monitors.MonitorStatus;
import com.tmx.nari.agm.entity.monitors.Monitors;
import com.tmx.nari.agm.model.request.create.monitor.CreateMonitorRequest;
import com.tmx.nari.agm.model.request.update.monitor.UpdateMonitorRequest;

import java.util.List;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:19
 */
public interface MonitorService {
    Monitors create(final CreateMonitorRequest request);

    Monitors update(final UUID id, final UpdateMonitorRequest model);

    Monitors getById(final UUID id);
    
    Monitors getByMonitorId(final String monitorId);
    
    boolean checkAndChangeAvailabilityStatus(final String monitorId);
    boolean changeStatus(final String monitorId);
    List<Monitors> findAllByMonitorStatus(final MonitorStatus status);


    List<Monitors> findAll();

    void delete(final UUID id);
}
