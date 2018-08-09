package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutExpProgcategory;

@Mapper
public interface LutExpProgcategoryMapper {
    public List<LutExpProgcategory> list(LutExpProgcategory lutExpProgcategory);
    public LutExpProgcategory select(LutExpProgcategory lutExpProgcategory);
    public void insert(LutExpProgcategory lutExpProgcategory);
    public void update(LutExpProgcategory lutExpProgcategory);
    public void delete(LutExpProgcategory lutExpProgcategory);
    public List<LutExpProgcategory> findAll();
    public LutExpProgcategory findById(String id);
    
    public List<LutExpProgcategory> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
