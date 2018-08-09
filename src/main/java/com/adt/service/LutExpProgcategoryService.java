package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.LutExpProgcategory;


public interface LutExpProgcategoryService {
    public List<LutExpProgcategory> find(LutExpProgcategory lutExpProgcategory);
    public LutExpProgcategory view(LutExpProgcategory lutExpProgcategory);
    public void add(LutExpProgcategory lutExpProgcategory);
    public void edit(LutExpProgcategory lutExpProgcategory);
    public void remove(LutExpProgcategory lutExpProgcategory);
    public List<LutExpProgcategory> findAll();
    public LutExpProgcategory findById(String id);
    
    public List<LutExpProgcategory> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
