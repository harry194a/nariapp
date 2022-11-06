package com.tmx.nari.agm.repositoy;

import com.tmx.nari.agm.entity.monitors.MonitorStatus;
import com.tmx.nari.agm.entity.monitors.Monitors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 22:22
 */
public interface MonitorRepository extends JpaRepository<Monitors, UUID> {
    Optional<Monitors> findByMonitorId(String monitorId);
    boolean existsByMonitorId(String monitorId);
    List<Monitors> findAllByMonitorStatus(MonitorStatus status);
}
