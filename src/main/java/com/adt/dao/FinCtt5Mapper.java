package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinCtt5;

@Mapper
public interface FinCtt5Mapper {
    public List<FinCtt5> list(FinCtt5 finCtt5);
    public FinCtt5 select(FinCtt5 finCtt5);
    public void insert(FinCtt5 finCtt5);
    public void update(FinCtt5 finCtt5);
    public void delete(FinCtt5 finCtt5);
    public List<FinCtt5> findAll();
    public FinCtt5 findById(String id);
    
    public List<FinCtt5> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
