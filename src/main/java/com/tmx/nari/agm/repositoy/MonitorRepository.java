package com.tmx.nari.agm.repositoy;

import com.tmx.nari.agm.entity.monitors.Monitors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 22:22
 */
public interface MonitorRepository extends JpaRepository<Monitors, UUID> {
}
