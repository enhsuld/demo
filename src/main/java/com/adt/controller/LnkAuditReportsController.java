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

import com.adt.model.LnkAuditReports;
import com.adt.service.LnkAuditReportsService;

@RestController
@RequestMapping(value = "/api/lnkauditreports")
public class LnkAuditReportsController {
    @Resource
    private LnkAuditReportsService lnkAuditReportsService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkAuditReportsController.class);
     
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
                        .setData(this.lnkAuditReportsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkAuditReportsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkAuditReports with id {}", id);
        LnkAuditReports item = this.lnkAuditReportsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkAuditReports>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkAuditReports ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkAuditReports>> filteredListItem() {
        List<LnkAuditReports> items = this.lnkAuditReportsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkAuditReports>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkAuditReports ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkAuditReports item) {
     	logger.info("Creating LnkAuditReports  : {}", item);
        LnkAuditReports att = this.lnkAuditReportsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkAuditReportsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkAuditReports ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkAuditReports item) {
		logger.info("Updating LnkAuditReports with id {}", item.getId());
        this.lnkAuditReportsService.edit(item);
        return new ResponseEntity< LnkAuditReports>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkAuditReports -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkAuditReports item) throws JSONException {
 		logger.info("Deleting LnkAuditReports with id {}", item.getId());
        this.lnkAuditReportsService.remove(item);
        return new ResponseEntity<LnkAuditReports>(HttpStatus.NO_CONTENT);
    }

}
