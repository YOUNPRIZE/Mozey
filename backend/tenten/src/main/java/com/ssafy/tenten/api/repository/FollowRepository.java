package com.ssafy.tenten.api.repository;

import com.ssafy.tenten.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long>{
}