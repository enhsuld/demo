package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FileConvertedService;
import com.adt.model.FileConverted;
import com.adt.dao.FileConvertedMapper;

@Service
public class FileConvertedServiceImpl implements FileConvertedService {
    @Resource
    private FileConvertedMapper FileConvertedMapper;

    @Override
    public List<FileConverted> find(FileConverted fileConverted) {
        return this.FileConvertedMapper.list(fileConverted);
    }

    @Override
    public FileConverted view(FileConverted fileConverted) {
        return this.FileConvertedMapper.select(fileConverted);
    }
    
    @Override
    public List<FileConverted> findAll() {
        return this.FileConvertedMapper.findAll();
    }

    @Override
    public FileConverted findById(String id) {
        return this.FileConvertedMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FileConverted fileConverted) {
        this.FileConvertedMapper.insert(fileConverted);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FileConverted fileConverted) {
        this.FileConvertedMapper.update(fileConverted);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FileConverted fileConverted) {
        this.FileConvertedMapper.delete(fileConverted);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FileConverted> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FileConverted>) this.FileConvertedMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FileConvertedMapper.selectCount(query);
    }

}
