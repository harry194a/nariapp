package com.tmx.nari.agm.service.processdata;

import com.tmx.nari.agm.entity.data.ProcessData;
import com.tmx.nari.agm.model.request.create.processdata.CreateProcessDataRequest;
import com.tmx.nari.agm.model.request.update.processdata.UpdateProcessDataRequest;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:20
 */
public interface ProcessDataService {

    ProcessData create(final CreateProcessDataRequest request);

    ProcessData update(final UUID id, final UpdateProcessDataRequest model);

    ProcessData getById(final UUID id);

    void delete(final UUID id);
}
