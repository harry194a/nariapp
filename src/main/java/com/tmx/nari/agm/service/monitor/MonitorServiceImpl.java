package com.tmx.nari.agm.service.monitor;

import com.tmx.nari.agm.entity.monitors.MonitorStatus;
import com.tmx.nari.agm.entity.monitors.Monitors;
import com.tmx.nari.agm.model.request.create.monitor.CreateMonitorRequest;
import com.tmx.nari.agm.model.request.update.monitor.UpdateMonitorRequest;
import com.tmx.nari.agm.repositoy.MonitorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
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
    @Transactional
    public Monitors create(final CreateMonitorRequest request) {
        Assert.notNull(request, "Request must not be null");
        Monitors monitors = request.toEntity();
        monitors = repository.save(monitors);
        return monitors;
    }

    @Override
    @Transactional
    public Monitors update(final UUID id, final UpdateMonitorRequest request) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(request, "Request must not be null");
        Monitors monitors = getById(id);
        monitors = request.toEntity(monitors);
        return repository.save(monitors);
    }

    @Override
    @Transactional
    public Monitors getById(final UUID id) {
        return repository.findById(id).orElseThrow(SecurityException::new);
    }

    @Override
    @Transactional
    public Monitors getByMonitorId(final String monitorId) {
        return repository.findByMonitorId(monitorId).orElseThrow(SecurityException::new);
    }

    @Override
    @Transactional
    public boolean checkAndChangeAvailabilityStatus(final String monitorId) {
        if (!repository.existsByMonitorId(monitorId)) {
            return false;
        }
        Monitors monitors = getByMonitorId(monitorId);
        if (monitors.getMonitorStatus().equals(MonitorStatus.UNAVAILABLE) ||
                monitors.getMonitorStatus().equals(MonitorStatus.IN_CHARGE)) {
            return false;
        }
        if (monitors.getMonitorStatus().equals(MonitorStatus.AVAILABLE)) {
            monitors.setMonitorStatus(MonitorStatus.IN_CHARGE);
            repository.save(monitors);
        }

        return true;
    }

    @Override
    @Transactional
    public boolean changeStatus(final String monitorId) {
        if (!repository.existsByMonitorId(monitorId)) {
            return false;
        }
        Monitors monitors = getByMonitorId(monitorId);
        if (monitors.getMonitorStatus().equals(MonitorStatus.AVAILABLE) ||
                monitors.getMonitorStatus().equals(MonitorStatus.UNAVAILABLE)) {
            return false;
        }
        if (monitors.getMonitorStatus().equals(MonitorStatus.IN_CHARGE)) {
            monitors.setMonitorStatus(MonitorStatus.AVAILABLE);
            repository.save(monitors);
        }

        return true;
    }

    @Override
    @Transactional
    public List<Monitors> findAllByMonitorStatus(final MonitorStatus status) {
        Assert.notNull(status, "Status cannot be null");
        return repository.findAllByMonitorStatus(status);
    }

    @Override
    @Transactional
    public List<Monitors> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        getById(id);
        repository.deleteById(id);
    }
}
