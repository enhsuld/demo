package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FinInventory;


public interface FinInventoryService {
    public List<FinInventory> find(FinInventory finInventory);
    public FinInventory view(FinInventory finInventory);
    public void add(FinInventory finInventory);
    public void edit(FinInventory finInventory);
    public void remove(FinInventory finInventory);
    public List<FinInventory> findAll();
    public FinInventory findById(String id);
    
    public List<FinInventory> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
