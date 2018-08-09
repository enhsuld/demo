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

import com.adt.model.FinTgt1;
import com.adt.service.FinTgt1Service;

@RestController
@RequestMapping(value = "/api/fintgt1")
public class FinTgt1Controller {
    @Resource
    private FinTgt1Service finTgt1Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinTgt1Controller.class);
     
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
                        .setData(this.finTgt1Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finTgt1Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinTgt1 with id {}", id);
        FinTgt1 item = this.finTgt1Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinTgt1>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinTgt1 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinTgt1>> filteredListItem() {
        List<FinTgt1> items = this.finTgt1Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinTgt1>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinTgt1 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinTgt1 item) {
     	logger.info("Creating FinTgt1  : {}", item);
        FinTgt1 att = this.finTgt1Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finTgt1Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinTgt1 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinTgt1 item) {
		logger.info("Updating FinTgt1 with id {}", item.getId());
        this.finTgt1Service.edit(item);
        return new ResponseEntity< FinTgt1>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinTgt1 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinTgt1 item) throws JSONException {
 		logger.info("Deleting FinTgt1 with id {}", item.getId());
        this.finTgt1Service.remove(item);
        return new ResponseEntity<FinTgt1>(HttpStatus.NO_CONTENT);
    }

}
