package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt1;


public interface FinCtt1Service {
    public List<FinCtt1> find(FinCtt1 finCtt1);
    public FinCtt1 view(FinCtt1 finCtt1);
    public void add(FinCtt1 finCtt1);
    public void edit(FinCtt1 finCtt1);
    public void remove(FinCtt1 finCtt1);
    public List<FinCtt1> findAll();
    public FinCtt1 findById(String id);
    
    public List<FinCtt1> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
