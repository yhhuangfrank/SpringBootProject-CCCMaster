package com.ispan.CCCMaster.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.employee.Position;
import com.ispan.CCCMaster.model.dao.PositionDao;
import com.ispan.CCCMaster.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	private PositionDao pstDao;
	
	@Override
	public void createPosition(Position pst) {
		pstDao.save(pst);
	}
	
	@Override
	public List<Position> findAll(){
		List<Position> positions = pstDao.findAll();
		return positions;
	}
	
	@Override
	public void deleteById(Integer id) {
		pstDao.deleteById(id);
	}
	
	@Override
	public Position findById(Integer id) {
		Optional<Position> option = pstDao.findById(id);
		if(option.isEmpty()) {
			return null;
		} else {
			return option.get();
		}
	}
	
	@Override
	@Transactional
	public void editById(Position position) {
		Optional<Position> option = pstDao.findById(position.getPositionId());
		if(option.isPresent()) {
			Position old = option.get();
			old.setPositionName(position.getPositionName());
		}
	}

}
