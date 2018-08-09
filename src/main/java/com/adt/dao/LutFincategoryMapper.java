package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutFincategory;

@Mapper
public interface LutFincategoryMapper {
    public List<LutFincategory> list(LutFincategory lutFincategory);
    public LutFincategory select(LutFincategory lutFincategory);
    public void insert(LutFincategory lutFincategory);
    public void update(LutFincategory lutFincategory);
    public void delete(LutFincategory lutFincategory);
    public List<LutFincategory> findAll();
    public LutFincategory findById(String id);
    
    public List<LutFincategory> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
