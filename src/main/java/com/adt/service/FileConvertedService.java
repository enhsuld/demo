package com.adt.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.adt.model.FileConverted;


public interface FileConvertedService {
    public List<FileConverted> find(FileConverted fileConverted);
    public FileConverted view(FileConverted fileConverted);
    public void add(FileConverted fileConverted);
    public void edit(FileConverted fileConverted);
    public void remove(FileConverted fileConverted);
    public List<FileConverted> findAll();
    public FileConverted findById(String id);
    
    public List<FileConverted> getListByPage(Integer page, Integer perPage, String query, String order);
    Integer getTotalPage(Integer perPage, String query);
}
