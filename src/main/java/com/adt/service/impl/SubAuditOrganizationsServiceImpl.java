package com.adt.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.adt.service.SubAuditOrganizationsService;
import com.adt.model.SubAuditOrganizations;
import com.adt.dao.SubAuditOrganizationsMapper;

@Service
public class SubAuditOrganizationsServiceImpl implements SubAuditOrganizationsService {
    @Resource
    private SubAuditOrganizationsMapper SubAuditOrganizationsMapper;

    @Override
    public List<SubAuditOrganizations> find(SubAuditOrganizations subAuditOrganizations) {
        return this.SubAuditOrganizationsMapper.list(subAuditOrganizations);
    }

    @Override
    public SubAuditOrganizations view(SubAuditOrganizations subAuditOrganizations) {
        return this.SubAuditOrganizationsMapper.select(subAuditOrganizations);
    }
    
    @Override
    public List<SubAuditOrganizations> findAll() {
        return this.SubAuditOrganizationsMapper.findAll();
    }

    @Override
    public SubAuditOrganizations findById(String id) {
        return this.SubAuditOrganizationsMapper.findById(id);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void add(SubAuditOrganizations subAuditOrganizations) {
        this.SubAuditOrganizationsMapper.insert(subAuditOrganizations);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void edit(SubAuditOrganizations subAuditOrganizations) {
        this.SubAuditOrganizationsMapper.update(subAuditOrganizations);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public void remove(SubAuditOrganizations subAuditOrganizations) {
        this.SubAuditOrganizationsMapper.delete(subAuditOrganizations);
    }
    
	@Override
 	@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public List<SubAuditOrganizations> getListByPage(Integer firstIndex, Integer lastIndex, String query, String order) {
        return (List<SubAuditOrganizations>) this.SubAuditOrganizationsMapper.selectByPage(firstIndex, lastIndex, query, order);
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED)
    public Integer getTotalPage(Integer perPage, String query) {
        return this.SubAuditOrganizationsMapper.selectCount(query);
    }

}
