package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinTgt1a;


public interface FinTgt1aService {
    public List<FinTgt1a> find(FinTgt1a finTgt1a);
    public FinTgt1a view(FinTgt1a finTgt1a);
    public void add(FinTgt1a finTgt1a);
    public void edit(FinTgt1a finTgt1a);
    public void remove(FinTgt1a finTgt1a);
    public List<FinTgt1a> findAll();
    public FinTgt1a findById(String id);
    
    public List<FinTgt1a> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
