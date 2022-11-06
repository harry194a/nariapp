package com.tmx.nari.agm.service.processdata;

import com.tmx.nari.agm.entity.data.ProcessData;
import com.tmx.nari.agm.model.request.create.processdata.CreateProcessDataRequest;
import com.tmx.nari.agm.model.request.update.processdata.UpdateProcessDataRequest;
import com.tmx.nari.agm.repositoy.ProcessDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:22
 */
@Service
public class ProcessDataServiceImpl implements ProcessDataService {
    private final ProcessDataRepository repository;

    public ProcessDataServiceImpl(final ProcessDataRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ProcessData create(final CreateProcessDataRequest request) {
        Assert.notNull(request, "Request must not be null");
        ProcessData processData = request.toEntity();
        processData = repository.save(processData);
        return processData;    }

    @Override
    @Transactional
    public ProcessData update(final UUID id, final UpdateProcessDataRequest request) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(request, "Request must not be null");
        ProcessData processData = getById(id);
        processData = request.toEntity(processData);
        return repository.save(processData);    }

    @Override
    @Transactional
    public ProcessData getById(final UUID id) {
        return repository.findById(id).orElseThrow(SecurityException::new);
    }

    @Override
    @Transactional
    public void delete(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        getById(id);
        repository.deleteById(id);
    }
}
