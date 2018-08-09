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

import com.adt.model.LnkAuditForms;
import com.adt.service.LnkAuditFormsService;

@RestController
@RequestMapping(value = "/api/lnkauditforms")
public class LnkAuditFormsController {
    @Resource
    private LnkAuditFormsService lnkAuditFormsService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkAuditFormsController.class);
     
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
                        .setData(this.lnkAuditFormsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkAuditFormsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkAuditForms with id {}", id);
        LnkAuditForms item = this.lnkAuditFormsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkAuditForms>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkAuditForms ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkAuditForms>> filteredListItem() {
        List<LnkAuditForms> items = this.lnkAuditFormsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkAuditForms>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkAuditForms ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkAuditForms item) {
     	logger.info("Creating LnkAuditForms  : {}", item);
        LnkAuditForms att = this.lnkAuditFormsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkAuditFormsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkAuditForms ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkAuditForms item) {
		logger.info("Updating LnkAuditForms with id {}", item.getId());
        this.lnkAuditFormsService.edit(item);
        return new ResponseEntity< LnkAuditForms>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkAuditForms -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkAuditForms item) throws JSONException {
 		logger.info("Deleting LnkAuditForms with id {}", item.getId());
        this.lnkAuditFormsService.remove(item);
        return new ResponseEntity<LnkAuditForms>(HttpStatus.NO_CONTENT);
    }

}
