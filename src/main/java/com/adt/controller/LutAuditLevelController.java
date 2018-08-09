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

import com.adt.model.LutAuditLevel;
import com.adt.service.LutAuditLevelService;

@RestController
@RequestMapping(value = "/api/lutauditlevel")
public class LutAuditLevelController {
    @Resource
    private LutAuditLevelService lutAuditLevelService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutAuditLevelController.class);
     
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
                        .setData(this.lutAuditLevelService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutAuditLevelService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutAuditLevel with id {}", id);
        LutAuditLevel item = this.lutAuditLevelService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutAuditLevel>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutAuditLevel ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutAuditLevel>> filteredListItem() {
        List<LutAuditLevel> items = this.lutAuditLevelService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutAuditLevel>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutAuditLevel ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutAuditLevel item) {
     	logger.info("Creating LutAuditLevel  : {}", item);
        LutAuditLevel att = this.lutAuditLevelService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutAuditLevelService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutAuditLevel ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutAuditLevel item) {
		logger.info("Updating LutAuditLevel with id {}", item.getId());
        this.lutAuditLevelService.edit(item);
        return new ResponseEntity< LutAuditLevel>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutAuditLevel -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutAuditLevel item) throws JSONException {
 		logger.info("Deleting LutAuditLevel with id {}", item.getId());
        this.lutAuditLevelService.remove(item);
        return new ResponseEntity<LutAuditLevel>(HttpStatus.NO_CONTENT);
    }

}
