package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCt1a;


public interface FinCt1aService {
    public List<FinCt1a> find(FinCt1a finCt1a);
    public FinCt1a view(FinCt1a finCt1a);
    public void add(FinCt1a finCt1a);
    public void edit(FinCt1a finCt1a);
    public void remove(FinCt1a finCt1a);
    public List<FinCt1a> findAll();
    public FinCt1a findById(String id);
    
    public List<FinCt1a> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
