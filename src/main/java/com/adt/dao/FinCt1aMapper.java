package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCt1a;

@Mapper
public interface FinCt1aMapper {
    public List<FinCt1a> list(FinCt1a finCt1a);
    public FinCt1a select(FinCt1a finCt1a);
    public void insert(FinCt1a finCt1a);
    public void update(FinCt1a finCt1a);
    public void delete(FinCt1a finCt1a);
    public List<FinCt1a> findAll();
    public FinCt1a findById(String id);
    
    public List<FinCt1a> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
