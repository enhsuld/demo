package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutReason;

@Mapper
public interface LutReasonMapper {
    public List<LutReason> list(LutReason lutReason);
    public LutReason select(LutReason lutReason);
    public void insert(LutReason lutReason);
    public void update(LutReason lutReason);
    public void delete(LutReason lutReason);
    public List<LutReason> findAll();
    public LutReason findById(String id);
    
    public List<LutReason> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
