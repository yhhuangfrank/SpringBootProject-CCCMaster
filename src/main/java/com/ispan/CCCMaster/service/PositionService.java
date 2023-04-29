package com.ispan.CCCMaster.service;

import java.util.List;

import com.ispan.CCCMaster.model.bean.employee.Position;

public interface PositionService {

	void createPosition(Position pst);

	List<Position> findAll();

	void deleteById(Integer id);

	Position findById(Integer id);

	void editById(Position position);

}