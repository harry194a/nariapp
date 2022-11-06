package com.tmx.nari.agm.model.request.update.monitor;

import com.tmx.nari.agm.entity.monitors.MonitorStatus;
import com.tmx.nari.agm.entity.monitors.Monitors;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 19:15
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class UpdateMonitorRequest {
    
    private String name;
    private String model;
    private String monitorId;
    private MonitorStatus status;

    public Monitors toEntity(final Monitors monitors) {
        monitors.setName(name);
        monitors.setModel(model);
        monitors.setMonitorId(monitorId);
        monitors.setMonitorStatus(status);
        return monitors;
    }
}
