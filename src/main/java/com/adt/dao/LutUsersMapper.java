package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutUsers;

@Mapper
public interface LutUsersMapper {
    public List<LutUsers> list(LutUsers lutUsers);
    public LutUsers select(LutUsers lutUsers);
    public void insert(LutUsers lutUsers);
    public void update(LutUsers lutUsers);
    public void delete(LutUsers lutUsers);
    public List<LutUsers> findAll();
    public LutUsers findById(String id);
    
    public List<LutUsers> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
