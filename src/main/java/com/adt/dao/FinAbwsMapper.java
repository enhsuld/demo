package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinAbws;

@Mapper
public interface FinAbwsMapper {
    public List<FinAbws> list(FinAbws finAbws);
    public FinAbws select(FinAbws finAbws);
    public void insert(FinAbws finAbws);
    public void update(FinAbws finAbws);
    public void delete(FinAbws finAbws);
    public List<FinAbws> findAll();
    public FinAbws findById(String id);
    
    public List<FinAbws> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
