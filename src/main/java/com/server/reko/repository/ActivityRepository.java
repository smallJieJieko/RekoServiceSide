package com.server.reko.repository;

import com.server.reko.model.RekoActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<RekoActivity,Long> {
    RekoActivity findActivitiesByaNumber(Long aNumber);
    List<RekoActivity> findActivitiesByCreaterNumber(Long createrNumber);
}
