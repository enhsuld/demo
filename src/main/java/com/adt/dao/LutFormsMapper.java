package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutForms;

@Mapper
public interface LutFormsMapper {
    public List<LutForms> list(LutForms lutForms);
    public LutForms select(LutForms lutForms);
    public void insert(LutForms lutForms);
    public void update(LutForms lutForms);
    public void delete(LutForms lutForms);
    public List<LutForms> findAll();
    public LutForms findById(String id);
    
    public List<LutForms> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
