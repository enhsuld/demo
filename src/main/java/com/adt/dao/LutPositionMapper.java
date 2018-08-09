package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.LutPosition;

@Mapper
public interface LutPositionMapper {
    public List<LutPosition> list(LutPosition lutPosition);
    public LutPosition select(LutPosition lutPosition);
    public void insert(LutPosition lutPosition);
    public void update(LutPosition lutPosition);
    public void delete(LutPosition lutPosition);
    public List<LutPosition> findAll();
    public LutPosition findById(String id);
    
    public List<LutPosition> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
