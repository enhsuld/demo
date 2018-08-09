package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FileUploadService;
import com.adt.model.FileUpload;
import com.adt.dao.FileUploadMapper;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Resource
    private FileUploadMapper FileUploadMapper;

    @Override
    public List<FileUpload> find(FileUpload fileUpload) {
        return this.FileUploadMapper.list(fileUpload);
    }

    @Override
    public FileUpload view(FileUpload fileUpload) {
        return this.FileUploadMapper.select(fileUpload);
    }
    
    @Override
    public List<FileUpload> findAll() {
        return this.FileUploadMapper.findAll();
    }

    @Override
    public FileUpload findById(String id) {
        return this.FileUploadMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FileUpload fileUpload) {
        this.FileUploadMapper.insert(fileUpload);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FileUpload fileUpload) {
        this.FileUploadMapper.update(fileUpload);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FileUpload fileUpload) {
        this.FileUploadMapper.delete(fileUpload);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FileUpload> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FileUpload>) this.FileUploadMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FileUploadMapper.selectCount(query);
    }

}
