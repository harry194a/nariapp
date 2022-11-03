package com.tmx.nari.agm.model.request.update.monitor;

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

    private String model;
    private String monitorId;

    public Monitors toEntity(final Monitors monitors) {
        monitors.setModel(model);
        monitors.setMonitorId(monitorId);
        return monitors;
    }
}
