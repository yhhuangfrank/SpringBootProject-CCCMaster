package com.ispan.CCCMaster.service;

import org.springframework.data.domain.Page;

import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;

public interface ServiceFromService {

	public void createform(ReportForm2Model rfm);
	
	ReportForm2Model findReportFormById(Integer id);
	
	void deleteReportFormById(Integer id);
	
	Page<ReportForm2Model> findByPage(Integer pageNumber);
	
}
