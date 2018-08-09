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

import com.adt.model.LutAuditresults;
import com.adt.service.LutAuditresultsService;

@RestController
@RequestMapping(value = "/api/lutauditresults")
public class LutAuditresultsController {
    @Resource
    private LutAuditresultsService lutAuditresultsService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutAuditresultsController.class);
     
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
                        .setData(this.lutAuditresultsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutAuditresultsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutAuditresults with id {}", id);
        LutAuditresults item = this.lutAuditresultsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutAuditresults>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutAuditresults ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutAuditresults>> filteredListItem() {
        List<LutAuditresults> items = this.lutAuditresultsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutAuditresults>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutAuditresults ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutAuditresults item) {
     	logger.info("Creating LutAuditresults  : {}", item);
        LutAuditresults att = this.lutAuditresultsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutAuditresultsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutAuditresults ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutAuditresults item) {
		logger.info("Updating LutAuditresults with id {}", item.getId());
        this.lutAuditresultsService.edit(item);
        return new ResponseEntity< LutAuditresults>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutAuditresults -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutAuditresults item) throws JSONException {
 		logger.info("Deleting LutAuditresults with id {}", item.getId());
        this.lutAuditresultsService.remove(item);
        return new ResponseEntity<LutAuditresults>(HttpStatus.NO_CONTENT);
    }

}
