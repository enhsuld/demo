package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCbws;

@Mapper
public interface FinCbwsMapper {
    public List<FinCbws> list(FinCbws finCbws);
    public FinCbws select(FinCbws finCbws);
    public void insert(FinCbws finCbws);
    public void update(FinCbws finCbws);
    public void delete(FinCbws finCbws);
    public List<FinCbws> findAll();
    public FinCbws findById(String id);
    
    public List<FinCbws> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
