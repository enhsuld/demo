package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCtt6;


public interface FinCtt6Service {
    public List<FinCtt6> find(FinCtt6 finCtt6);
    public FinCtt6 view(FinCtt6 finCtt6);
    public void add(FinCtt6 finCtt6);
    public void edit(FinCtt6 finCtt6);
    public void remove(FinCtt6 finCtt6);
    public List<FinCtt6> findAll();
    public FinCtt6 findById(String id);
    
    public List<FinCtt6> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
