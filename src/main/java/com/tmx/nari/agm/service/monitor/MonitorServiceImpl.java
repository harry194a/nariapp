package com.tmx.nari.agm.service.monitor;

import com.tmx.nari.agm.entity.monitors.Monitors;
import com.tmx.nari.agm.model.request.create.monitor.CreateMonitorRequest;
import com.tmx.nari.agm.model.request.update.monitor.UpdateMonitorRequest;
import com.tmx.nari.agm.repositoy.MonitorRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 20:21
 */
@Service
public class MonitorServiceImpl implements MonitorService {
    
    private final MonitorRepository repository;

    public MonitorServiceImpl(final MonitorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Monitors create(final CreateMonitorRequest request) {
        Assert.notNull(request, "Request must not be null");
        Monitors monitors = request.toEntity();
        monitors = repository.save(monitors);
        return monitors;
    }

    @Override
    public Monitors update(final UUID id, final UpdateMonitorRequest request) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(request, "Request must not be null");
        Monitors monitors = getById(id);
        monitors = request.toEntity(monitors);
        return repository.save(monitors);
    }

    @Override
    public Monitors getById(final UUID id) {
        return repository.findById(id).orElseThrow(SecurityException::new);
    }

    @Override
    public void delete(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        getById(id);
        repository.deleteById(id);
    }
}
