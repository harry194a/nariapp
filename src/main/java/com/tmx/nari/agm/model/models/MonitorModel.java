package com.tmx.nari.agm.model.models;

import com.tmx.nari.agm.entity.monitors.MonitorStatus;
import com.tmx.nari.agm.entity.monitors.Monitors;
import lombok.Value;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 06.11.22
 * Time: 16:44
 */
@Value
public class MonitorModel {
    UUID id;
    String name;
    String model;
    String monitorId;
    MonitorStatus monitorStatus;

    public static MonitorModel from(Monitors monitors) {
        return new MonitorModel(
                monitors.getId(),
                monitors.getName(),
                monitors.getModel(),
                monitors.getMonitorId(),
                monitors.getMonitorStatus()
                );
    }
}
