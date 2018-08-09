package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LnkMainUsers;

@Mapper
public interface LnkMainUsersMapper {
    public List<LnkMainUsers> list(LnkMainUsers lnkMainUsers);
    public LnkMainUsers select(LnkMainUsers lnkMainUsers);
    public void insert(LnkMainUsers lnkMainUsers);
    public void update(LnkMainUsers lnkMainUsers);
    public void delete(LnkMainUsers lnkMainUsers);
    public List<LnkMainUsers> findAll();
    public LnkMainUsers findById(String id);
    
    public List<LnkMainUsers> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
