package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FinAssets;

@Mapper
public interface FinAssetsMapper {
    public List<FinAssets> list(FinAssets finAssets);
    public FinAssets select(FinAssets finAssets);
    public void insert(FinAssets finAssets);
    public void update(FinAssets finAssets);
    public void delete(FinAssets finAssets);
    public List<FinAssets> findAll();
    public FinAssets findById(String id);
    
    public List<FinAssets> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
