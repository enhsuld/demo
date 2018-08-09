package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt2;

@Mapper
public interface FinCtt2Mapper {
    public List<FinCtt2> list(FinCtt2 finCtt2);
    public FinCtt2 select(FinCtt2 finCtt2);
    public void insert(FinCtt2 finCtt2);
    public void update(FinCtt2 finCtt2);
    public void delete(FinCtt2 finCtt2);
    public List<FinCtt2> findAll();
    public FinCtt2 findById(String id);
    
    public List<FinCtt2> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
