package com.BrainyByte.road_ai_system.repository;

import com.BrainyByte.road_ai_system.model.RoadIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadIssueRepository extends JpaRepository<RoadIssue, Long> {
}
