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

import com.adt.model.LnkAuditFormFile;
import com.adt.service.LnkAuditFormFileService;

@RestController
@RequestMapping(value = "/api/lnkauditformfile")
public class LnkAuditFormFileController {
    @Resource
    private LnkAuditFormFileService lnkAuditFormFileService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkAuditFormFileController.class);
     
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
                        .setData(this.lnkAuditFormFileService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkAuditFormFileService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkAuditFormFile with id {}", id);
        LnkAuditFormFile item = this.lnkAuditFormFileService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkAuditFormFile>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkAuditFormFile ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkAuditFormFile>> filteredListItem() {
        List<LnkAuditFormFile> items = this.lnkAuditFormFileService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkAuditFormFile>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkAuditFormFile ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkAuditFormFile item) {
     	logger.info("Creating LnkAuditFormFile  : {}", item);
        LnkAuditFormFile att = this.lnkAuditFormFileService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkAuditFormFileService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkAuditFormFile ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkAuditFormFile item) {
		logger.info("Updating LnkAuditFormFile with id {}", item.getId());
        this.lnkAuditFormFileService.edit(item);
        return new ResponseEntity< LnkAuditFormFile>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkAuditFormFile -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkAuditFormFile item) throws JSONException {
 		logger.info("Deleting LnkAuditFormFile with id {}", item.getId());
        this.lnkAuditFormFileService.remove(item);
        return new ResponseEntity<LnkAuditFormFile>(HttpStatus.NO_CONTENT);
    }

}
