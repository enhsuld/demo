package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.LnkOrgyplanreportService;
import com.adt.model.LnkOrgyplanreport;
import com.adt.dao.LnkOrgyplanreportMapper;

@Service
public class LnkOrgyplanreportServiceImpl implements LnkOrgyplanreportService {
    @Resource
    private LnkOrgyplanreportMapper LnkOrgyplanreportMapper;

    @Override
    public List<LnkOrgyplanreport> find(LnkOrgyplanreport lnkOrgyplanreport) {
        return this.LnkOrgyplanreportMapper.list(lnkOrgyplanreport);
    }

    @Override
    public LnkOrgyplanreport view(LnkOrgyplanreport lnkOrgyplanreport) {
        return this.LnkOrgyplanreportMapper.select(lnkOrgyplanreport);
    }
    
    @Override
    public List<LnkOrgyplanreport> findAll() {
        return this.LnkOrgyplanreportMapper.findAll();
    }

    @Override
    public LnkOrgyplanreport findById(String id) {
        return this.LnkOrgyplanreportMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(LnkOrgyplanreport lnkOrgyplanreport) {
        this.LnkOrgyplanreportMapper.insert(lnkOrgyplanreport);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(LnkOrgyplanreport lnkOrgyplanreport) {
        this.LnkOrgyplanreportMapper.update(lnkOrgyplanreport);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(LnkOrgyplanreport lnkOrgyplanreport) {
        this.LnkOrgyplanreportMapper.delete(lnkOrgyplanreport);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<LnkOrgyplanreport> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<LnkOrgyplanreport>) this.LnkOrgyplanreportMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.LnkOrgyplanreportMapper.selectCount(query);
    }

}
