package com.tmx.nari.agm.model.request.create.processdata;

import com.tmx.nari.agm.entity.data.ProcessData;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 17:52
 */
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CreateProcessDataRequest {

    private LocalDateTime timeStamp;
    private String patientsId;
    private String bloodPressure;
    private String heartRate;
    private String deviceNumber;
    private LocalDateTime endTime;

    public ProcessData toEntity(){
        ProcessData processData = new ProcessData();
        processData.setTimeStamp(timeStamp);
        processData.setPatientsId(patientsId);
        processData.setBloodPressure(bloodPressure);
        processData.setHeartRate(heartRate);
        processData.setDeviceNumber(deviceNumber);
        processData.setEndTime(endTime);
        return processData;
    }
}
