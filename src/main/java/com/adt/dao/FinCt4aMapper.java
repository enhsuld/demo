package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCt4a;

@Mapper
public interface FinCt4aMapper {
    public List<FinCt4a> list(FinCt4a finCt4a);
    public FinCt4a select(FinCt4a finCt4a);
    public void insert(FinCt4a finCt4a);
    public void update(FinCt4a finCt4a);
    public void delete(FinCt4a finCt4a);
    public List<FinCt4a> findAll();
    public FinCt4a findById(String id);
    
    public List<FinCt4a> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
