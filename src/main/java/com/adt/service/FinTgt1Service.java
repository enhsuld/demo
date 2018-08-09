package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinTgt1;


public interface FinTgt1Service {
    public List<FinTgt1> find(FinTgt1 finTgt1);
    public FinTgt1 view(FinTgt1 finTgt1);
    public void add(FinTgt1 finTgt1);
    public void edit(FinTgt1 finTgt1);
    public void remove(FinTgt1 finTgt1);
    public List<FinTgt1> findAll();
    public FinTgt1 findById(String id);
    
    public List<FinTgt1> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
