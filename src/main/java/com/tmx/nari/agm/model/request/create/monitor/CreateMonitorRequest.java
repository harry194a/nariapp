package com.tmx.nari.agm.model.request.create.monitor;

import com.tmx.nari.agm.entity.monitors.MonitorStatus;
import com.tmx.nari.agm.entity.monitors.Monitors;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 17:38
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CreateMonitorRequest {
    
    private String name;
    private String model;
    private String monitorId;
    @Enumerated(EnumType.STRING)
    private MonitorStatus status;
    
    public Monitors toEntity(){
        Monitors monitor = new Monitors();
        monitor.setName(name);
        monitor.setMonitorId(monitorId);
        monitor.setModel(model);
        monitor.setMonitorStatus(status);
        return monitor;
    }
}
