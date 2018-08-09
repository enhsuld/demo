package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCt2a;

@Mapper
public interface FinCt2aMapper {
    public List<FinCt2a> list(FinCt2a finCt2a);
    public FinCt2a select(FinCt2a finCt2a);
    public void insert(FinCt2a finCt2a);
    public void update(FinCt2a finCt2a);
    public void delete(FinCt2a finCt2a);
    public List<FinCt2a> findAll();
    public FinCt2a findById(String id);
    
    public List<FinCt2a> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
