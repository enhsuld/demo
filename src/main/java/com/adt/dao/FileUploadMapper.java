package com.adt.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.adt.model.FileUpload;

@Mapper
public interface FileUploadMapper {
    public List<FileUpload> list(FileUpload fileUpload);
    public FileUpload select(FileUpload fileUpload);
    public void insert(FileUpload fileUpload);
    public void update(FileUpload fileUpload);
    public void delete(FileUpload fileUpload);
    public List<FileUpload> findAll();
    public FileUpload findById(String id);
    
    public List<FileUpload> selectByPage(Integer offset, Integer perPage, String searchQuery, String orderQuery);
    public Integer selectCount(String searchQuery);
}
