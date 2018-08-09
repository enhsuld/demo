package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt4;


public interface FinCtt4Service {
    public List<FinCtt4> find(FinCtt4 finCtt4);
    public FinCtt4 view(FinCtt4 finCtt4);
    public void add(FinCtt4 finCtt4);
    public void edit(FinCtt4 finCtt4);
    public void remove(FinCtt4 finCtt4);
    public List<FinCtt4> findAll();
    public FinCtt4 findById(String id);
    
    public List<FinCtt4> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
