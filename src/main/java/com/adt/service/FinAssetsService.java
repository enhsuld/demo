package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinAssets;


public interface FinAssetsService {
    public List<FinAssets> find(FinAssets finAssets);
    public FinAssets view(FinAssets finAssets);
    public void add(FinAssets finAssets);
    public void edit(FinAssets finAssets);
    public void remove(FinAssets finAssets);
    public List<FinAssets> findAll();
    public FinAssets findById(String id);
    
    public List<FinAssets> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
