package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt1;

@Mapper
public interface FinCtt1Mapper {
    public List<FinCtt1> list(FinCtt1 finCtt1);
    public FinCtt1 select(FinCtt1 finCtt1);
    public void insert(FinCtt1 finCtt1);
    public void update(FinCtt1 finCtt1);
    public void delete(FinCtt1 finCtt1);
    public List<FinCtt1> findAll();
    public FinCtt1 findById(String id);
    
    public List<FinCtt1> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
