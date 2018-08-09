package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LnkOrgyplanreport;


public interface LnkOrgyplanreportService {
    public List<LnkOrgyplanreport> find(LnkOrgyplanreport lnkOrgyplanreport);
    public LnkOrgyplanreport view(LnkOrgyplanreport lnkOrgyplanreport);
    public void add(LnkOrgyplanreport lnkOrgyplanreport);
    public void edit(LnkOrgyplanreport lnkOrgyplanreport);
    public void remove(LnkOrgyplanreport lnkOrgyplanreport);
    public List<LnkOrgyplanreport> findAll();
    public LnkOrgyplanreport findById(String id);
    
    public List<LnkOrgyplanreport> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
