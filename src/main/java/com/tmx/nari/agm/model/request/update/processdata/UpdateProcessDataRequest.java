package com.tmx.nari.agm.model.request.update.processdata;

import com.tmx.nari.agm.entity.data.ProcessData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 19:19
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class UpdateProcessDataRequest {
    private LocalDateTime timeStart;
    private String patientsId;
    private String bloodPressure;
    private String heartRate;
    private String deviceNumber;
    private LocalDateTime endTime;

    public ProcessData toEntity(final ProcessData processData) {
        processData.setTimeStart(timeStart);
        processData.setPatientsId(patientsId);
        processData.setBloodPressure(bloodPressure);
        processData.setHeartRate(heartRate);
        processData.setDeviceNumber(deviceNumber);
        processData.setEndTime(endTime);
        return processData;
    }
}
