package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FileConverted;

@Mapper
public interface FileConvertedMapper {
    public List<FileConverted> list(FileConverted fileConverted);
    public FileConverted select(FileConverted fileConverted);
    public void insert(FileConverted fileConverted);
    public void update(FileConverted fileConverted);
    public void delete(FileConverted fileConverted);
    public List<FileConverted> findAll();
    public FileConverted findById(String id);
    
    public List<FileConverted> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
