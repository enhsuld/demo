package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCt2a;


public interface FinCt2aService {
    public List<FinCt2a> find(FinCt2a finCt2a);
    public FinCt2a view(FinCt2a finCt2a);
    public void add(FinCt2a finCt2a);
    public void edit(FinCt2a finCt2a);
    public void remove(FinCt2a finCt2a);
    public List<FinCt2a> findAll();
    public FinCt2a findById(String id);
    
    public List<FinCt2a> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
