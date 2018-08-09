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

import com.adt.model.LnkAuditFiles;
import com.adt.service.LnkAuditFilesService;

@RestController
@RequestMapping(value = "/api/lnkauditfiles")
public class LnkAuditFilesController {
    @Resource
    private LnkAuditFilesService lnkAuditFilesService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkAuditFilesController.class);
     
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
                        .setData(this.lnkAuditFilesService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkAuditFilesService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkAuditFiles with id {}", id);
        LnkAuditFiles item = this.lnkAuditFilesService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkAuditFiles>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkAuditFiles ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkAuditFiles>> filteredListItem() {
        List<LnkAuditFiles> items = this.lnkAuditFilesService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkAuditFiles>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkAuditFiles ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkAuditFiles item) {
     	logger.info("Creating LnkAuditFiles  : {}", item);
        LnkAuditFiles att = this.lnkAuditFilesService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkAuditFilesService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkAuditFiles ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkAuditFiles item) {
		logger.info("Updating LnkAuditFiles with id {}", item.getId());
        this.lnkAuditFilesService.edit(item);
        return new ResponseEntity< LnkAuditFiles>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkAuditFiles -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkAuditFiles item) throws JSONException {
 		logger.info("Deleting LnkAuditFiles with id {}", item.getId());
        this.lnkAuditFilesService.remove(item);
        return new ResponseEntity<LnkAuditFiles>(HttpStatus.NO_CONTENT);
    }

}
