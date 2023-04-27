package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.Positions;

public interface PositionRepository extends JpaRepository<Positions, Integer> {

}
