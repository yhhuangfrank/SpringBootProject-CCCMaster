package com.ispan.CCCMaster.service;

import java.util.List;

import com.ispan.CCCMaster.model.bean.Positions;

public interface PositionService {

	void createPosition(Positions pst);

	List<Positions> findAll();

}