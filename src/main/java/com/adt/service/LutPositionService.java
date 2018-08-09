package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutPosition;


public interface LutPositionService {
    public List<LutPosition> find(LutPosition lutPosition);
    public LutPosition view(LutPosition lutPosition);
    public void add(LutPosition lutPosition);
    public void edit(LutPosition lutPosition);
    public void remove(LutPosition lutPosition);
    public List<LutPosition> findAll();
    public LutPosition findById(String id);
    
    public List<LutPosition> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
