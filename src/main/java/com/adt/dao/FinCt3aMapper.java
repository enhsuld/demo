package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCt3a;

@Mapper
public interface FinCt3aMapper {
    public List<FinCt3a> list(FinCt3a finCt3a);
    public FinCt3a select(FinCt3a finCt3a);
    public void insert(FinCt3a finCt3a);
    public void update(FinCt3a finCt3a);
    public void delete(FinCt3a finCt3a);
    public List<FinCt3a> findAll();
    public FinCt3a findById(String id);
    
    public List<FinCt3a> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
