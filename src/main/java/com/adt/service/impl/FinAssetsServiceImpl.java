package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinAssetsService;
import com.adt.model.FinAssets;
import com.adt.dao.FinAssetsMapper;

@Service
public class FinAssetsServiceImpl implements FinAssetsService {
    @Resource
    private FinAssetsMapper FinAssetsMapper;

    @Override
    public List<FinAssets> find(FinAssets finAssets) {
        return this.FinAssetsMapper.list(finAssets);
    }

    @Override
    public FinAssets view(FinAssets finAssets) {
        return this.FinAssetsMapper.select(finAssets);
    }
    
    @Override
    public List<FinAssets> findAll() {
        return this.FinAssetsMapper.findAll();
    }

    @Override
    public FinAssets findById(String id) {
        return this.FinAssetsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinAssets finAssets) {
        this.FinAssetsMapper.insert(finAssets);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinAssets finAssets) {
        this.FinAssetsMapper.update(finAssets);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinAssets finAssets) {
        this.FinAssetsMapper.delete(finAssets);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinAssets> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinAssets>) this.FinAssetsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinAssetsMapper.selectCount(query);
    }

}
