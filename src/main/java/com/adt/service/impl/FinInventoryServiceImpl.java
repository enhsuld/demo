package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.FinInventoryService;
import com.adt.model.FinInventory;
import com.adt.dao.FinInventoryMapper;

@Service
public class FinInventoryServiceImpl implements FinInventoryService {
    @Resource
    private FinInventoryMapper FinInventoryMapper;

    @Override
    public List<FinInventory> find(FinInventory finInventory) {
        return this.FinInventoryMapper.list(finInventory);
    }

    @Override
    public FinInventory view(FinInventory finInventory) {
        return this.FinInventoryMapper.select(finInventory);
    }
    
    @Override
    public List<FinInventory> findAll() {
        return this.FinInventoryMapper.findAll();
    }

    @Override
    public FinInventory findById(String id) {
        return this.FinInventoryMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(FinInventory finInventory) {
        this.FinInventoryMapper.insert(finInventory);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(FinInventory finInventory) {
        this.FinInventoryMapper.update(finInventory);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(FinInventory finInventory) {
        this.FinInventoryMapper.delete(finInventory);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<FinInventory> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<FinInventory>) this.FinInventoryMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.FinInventoryMapper.selectCount(query);
    }

}
