package com.ispan.CCCMaster.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.Positions;
import com.ispan.CCCMaster.model.dao.PositionRepository;
import com.ispan.CCCMaster.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	private PositionRepository pstRepository;
	
	@Override
	public void createPosition(Positions pst) {
		pstRepository.save(pst);
	}
	
	@Override
	public List<Positions> findAll(){
		List<Positions> positions = pstRepository.findAll();
		return positions;
	}

}
