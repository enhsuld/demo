package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutReason;


public interface LutReasonService {
    public List<LutReason> find(LutReason lutReason);
    public LutReason view(LutReason lutReason);
    public void add(LutReason lutReason);
    public void edit(LutReason lutReason);
    public void remove(LutReason lutReason);
    public List<LutReason> findAll();
    public LutReason findById(String id);
    
    public List<LutReason> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
