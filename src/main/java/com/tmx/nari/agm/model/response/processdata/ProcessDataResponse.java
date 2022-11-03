package com.tmx.nari.agm.model.response.processdata;

import com.tmx.nari.agm.entity.data.ProcessData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 18:18
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProcessDataResponse {
    
    private UUID id;
    private LocalDateTime timeStart;
    private String patientsId;
    private String bloodPressure;
    private String heartRate;
    private String deviceNumber;
    private LocalDateTime endTime;

    public static ProcessDataResponse from(
            final ProcessData processData) {
        ProcessDataResponse response = new ProcessDataResponse();
        response.setId(processData.getId());
        response.setTimeStart(processData.getTimeStart());
        response.setPatientsId(processData.getPatientsId());
        response.setBloodPressure(processData.getBloodPressure());
        response.setHeartRate(processData.getHeartRate());
        response.setDeviceNumber(processData.getDeviceNumber());
        response.setEndTime(processData.getEndTime());
        return response;
    }

}
