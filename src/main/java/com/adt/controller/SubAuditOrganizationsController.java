package com.adt.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.adt.constant.PaginatedResult;
import com.adt.constant.QueryBuilder;

import com.adt.model.SubAuditOrganizations;
import com.adt.service.SubAuditOrganizationsService;

@RestController
@RequestMapping(value = "/api/subauditorganizations")
public class SubAuditOrganizationsController {
    @Resource
    private SubAuditOrganizationsService subAuditOrganizationsService;
    
    public static final Logger logger = LoggerFactory.getLogger(SubAuditOrganizationsController.class);
     
    @Resource
    private QueryBuilder builder;

    // -------------------List by page ----------------------------------------------------------
     
    @PostMapping("/list")
    public ResponseEntity<?> getList(@RequestBody String data) throws JSONException {
        String query="";


        JSONObject obj= new JSONObject(data);
        String order="";
        if(obj.has("sort")){
            order=builder.getSort(data);
        }
        if(obj.has("filter")){
            query=builder.getFilter(data);
        }

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(this.subAuditOrganizationsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.subAuditOrganizationsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching SubAuditOrganizations with id {}", id);
        SubAuditOrganizations item = this.subAuditOrganizationsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SubAuditOrganizations>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All SubAuditOrganizations ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<SubAuditOrganizations>> filteredListItem() {
        List<SubAuditOrganizations> items = this.subAuditOrganizationsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<SubAuditOrganizations>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  SubAuditOrganizations ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody SubAuditOrganizations item) {
     	logger.info("Creating SubAuditOrganizations  : {}", item);
        SubAuditOrganizations att = this.subAuditOrganizationsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.subAuditOrganizationsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  SubAuditOrganizations ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody SubAuditOrganizations item) {
		logger.info("Updating SubAuditOrganizations with id {}", item.getId());
        this.subAuditOrganizationsService.edit(item);
        return new ResponseEntity< SubAuditOrganizations>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a SubAuditOrganizations -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody SubAuditOrganizations item) throws JSONException {
 		logger.info("Deleting SubAuditOrganizations with id {}", item.getId());
        this.subAuditOrganizationsService.remove(item);
        return new ResponseEntity<SubAuditOrganizations>(HttpStatus.NO_CONTENT);
    }

}
