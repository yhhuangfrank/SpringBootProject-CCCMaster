package com.ispan.CCCMaster.service;

import java.util.List;

import com.ispan.CCCMaster.model.bean.Position;

public interface PositionService {

	void createPosition(Position pst);

	List<Position> findAll();

}