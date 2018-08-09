package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LutMenuService;
import com.adt.model.LutMenu;
import com.adt.dao.LutMenuMapper;

@Service
public class LutMenuServiceImpl implements LutMenuService {
    @Resource
    private LutMenuMapper LutMenuMapper;

    @Override
    public List<LutMenu> find(LutMenu lutMenu) {
        return this.LutMenuMapper.list(lutMenu);
    }

    @Override
    public LutMenu view(LutMenu lutMenu) {
        return this.LutMenuMapper.select(lutMenu);
    }
    
    @Override
    public List<LutMenu> findAll() {
        return this.LutMenuMapper.findAll();
    }

    @Override
    public LutMenu findById(String id) {
        return this.LutMenuMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LutMenu lutMenu) {
        this.LutMenuMapper.insert(lutMenu);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LutMenu lutMenu) {
        this.LutMenuMapper.update(lutMenu);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LutMenu lutMenu) {
        this.LutMenuMapper.delete(lutMenu);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LutMenu> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LutMenu>) this.LutMenuMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LutMenuMapper.selectCount(query);
    }

}
