package com.ispan.CCCMaster.service;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;

import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;

public interface ServiceFromService {

	public void createform(ReportForm2Model rfm);
	
	ReportForm2Model findReportFormById(Integer id);
	
	void deleteReportFormById(Integer id);
	
	public Page<ReportForm2Model> findByPage(Integer pageNumber,Integer customerid);
	ReportForm2Model getLatest();



	
}
