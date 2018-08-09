package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinCbws;


public interface FinCbwsService {
    public List<FinCbws> find(FinCbws finCbws);
    public FinCbws view(FinCbws finCbws);
    public void add(FinCbws finCbws);
    public void edit(FinCbws finCbws);
    public void remove(FinCbws finCbws);
    public List<FinCbws> findAll();
    public FinCbws findById(String id);
    
    public List<FinCbws> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
