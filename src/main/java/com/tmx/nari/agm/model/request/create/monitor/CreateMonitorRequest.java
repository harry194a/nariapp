package com.tmx.nari.agm.model.request.create.monitor;

import com.tmx.nari.agm.entity.monitors.Monitors;
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
    
    private String model;
    private String monitorId;
    
    public Monitors toEntity(){
        Monitors monitor = new Monitors();
        monitor.setMonitorId(monitorId);
        monitor.setModel(model);
        return monitor;
    }
}
