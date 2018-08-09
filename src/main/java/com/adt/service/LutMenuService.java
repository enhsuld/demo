package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutMenu;


public interface LutMenuService {
    public List<LutMenu> find(LutMenu lutMenu);
    public LutMenu view(LutMenu lutMenu);
    public void add(LutMenu lutMenu);
    public void edit(LutMenu lutMenu);
    public void remove(LutMenu lutMenu);
    public List<LutMenu> findAll();
    public LutMenu findById(String id);
    
    public List<LutMenu> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
