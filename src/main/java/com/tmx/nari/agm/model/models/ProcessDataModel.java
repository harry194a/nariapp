package com.tmx.nari.agm.model.models;

import com.tmx.nari.agm.entity.data.ProcessData;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 06.11.22
 * Time: 16:51
 */
@Value
public class ProcessDataModel {
    UUID id;
    LocalDateTime timeStamp;
    String patientsId;
    String bloodPressure;
    String heartRate;
    String deviceNumber;
    LocalDateTime endTime;

    public static ProcessDataModel from(ProcessData processData) {
        return new ProcessDataModel(
                processData.getId(),
                processData.getTimeStamp(),
                processData.getPatientsId(),
                processData.getBloodPressure(),
                processData.getHeartRate(),
                processData.getDeviceNumber(),
                processData.getEndTime()

        );
    }
}
