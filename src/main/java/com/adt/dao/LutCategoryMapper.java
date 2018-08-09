package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutCategory;

@Mapper
public interface LutCategoryMapper {
    public List<LutCategory> list(LutCategory lutCategory);
    public LutCategory select(LutCategory lutCategory);
    public void insert(LutCategory lutCategory);
    public void update(LutCategory lutCategory);
    public void delete(LutCategory lutCategory);
    public List<LutCategory> findAll();
    public LutCategory findById(String id);
    
    public List<LutCategory> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
