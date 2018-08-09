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

import com.adt.model.LnkAuditProblems;
import com.adt.service.LnkAuditProblemsService;

@RestController
@RequestMapping(value = "/api/lnkauditproblems")
public class LnkAuditProblemsController {
    @Resource
    private LnkAuditProblemsService lnkAuditProblemsService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkAuditProblemsController.class);
     
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
                        .setData(this.lnkAuditProblemsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkAuditProblemsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkAuditProblems with id {}", id);
        LnkAuditProblems item = this.lnkAuditProblemsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkAuditProblems>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkAuditProblems ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkAuditProblems>> filteredListItem() {
        List<LnkAuditProblems> items = this.lnkAuditProblemsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkAuditProblems>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkAuditProblems ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkAuditProblems item) {
     	logger.info("Creating LnkAuditProblems  : {}", item);
        LnkAuditProblems att = this.lnkAuditProblemsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkAuditProblemsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkAuditProblems ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkAuditProblems item) {
		logger.info("Updating LnkAuditProblems with id {}", item.getId());
        this.lnkAuditProblemsService.edit(item);
        return new ResponseEntity< LnkAuditProblems>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkAuditProblems -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkAuditProblems item) throws JSONException {
 		logger.info("Deleting LnkAuditProblems with id {}", item.getId());
        this.lnkAuditProblemsService.remove(item);
        return new ResponseEntity<LnkAuditProblems>(HttpStatus.NO_CONTENT);
    }

}
