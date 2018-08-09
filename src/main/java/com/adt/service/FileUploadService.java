package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FileUpload;


public interface FileUploadService {
    public List<FileUpload> find(FileUpload fileUpload);
    public FileUpload view(FileUpload fileUpload);
    public void add(FileUpload fileUpload);
    public void edit(FileUpload fileUpload);
    public void remove(FileUpload fileUpload);
    public List<FileUpload> findAll();
    public FileUpload findById(String id);
    
    public List<FileUpload> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
