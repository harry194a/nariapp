package com.tmx.nari.agm.repositoy;

import com.tmx.nari.agm.entity.data.ProcessData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 03.11.22
 * Time: 22:30
 */
public interface ProcessDataRepository extends JpaRepository<ProcessData, UUID> {
}
