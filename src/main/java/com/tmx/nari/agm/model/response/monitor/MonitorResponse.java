package com.tmx.nari.agm.model.response.monitor;

import com.tmx.nari.agm.entity.monitors.MonitorStatus;
import com.tmx.nari.agm.entity.monitors.Monitors;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 18:17
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MonitorResponse {

    private UUID id;
    private String name;
    private String model;
    private String monitorId;
    private MonitorStatus status;

    public static MonitorResponse from(
            final Monitors monitors) {
        MonitorResponse response = new MonitorResponse();
        response.setId(monitors.getId());
        response.setName(monitors.getName());
        response.setModel(monitors.getModel());
        response.setMonitorId(monitors.getMonitorId());
        response.setStatus(monitors.getMonitorStatus());
        return response;
    }
}
