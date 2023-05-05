package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.employee.Position;

public interface PositionDao extends JpaRepository<Position, Integer> {

}
