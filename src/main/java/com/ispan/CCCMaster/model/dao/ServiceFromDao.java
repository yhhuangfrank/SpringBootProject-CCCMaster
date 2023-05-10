package com.ispan.CCCMaster.model.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;

public interface ServiceFromDao extends JpaRepository<ReportForm2Model, Integer> {

    public ReportForm2Model findFirstByOrderByCreatetimeDesc();
    
    public Page<ReportForm2Model> findAllByCustomerid(Integer customerid, org.springframework.data.domain.Pageable pgb);

}
