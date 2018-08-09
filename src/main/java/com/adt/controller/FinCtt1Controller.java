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

import com.adt.model.FinCtt1;
import com.adt.service.FinCtt1Service;

@RestController
@RequestMapping(value = "/api/finctt1")
public class FinCtt1Controller {
    @Resource
    private FinCtt1Service finCtt1Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt1Controller.class);
     
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
                        .setData(this.finCtt1Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt1Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt1 with id {}", id);
        FinCtt1 item = this.finCtt1Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt1>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt1 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt1>> filteredListItem() {
        List<FinCtt1> items = this.finCtt1Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt1>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt1 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt1 item) {
     	logger.info("Creating FinCtt1  : {}", item);
        FinCtt1 att = this.finCtt1Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt1Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt1 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt1 item) {
		logger.info("Updating FinCtt1 with id {}", item.getId());
        this.finCtt1Service.edit(item);
        return new ResponseEntity< FinCtt1>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt1 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt1 item) throws JSONException {
 		logger.info("Deleting FinCtt1 with id {}", item.getId());
        this.finCtt1Service.remove(item);
        return new ResponseEntity<FinCtt1>(HttpStatus.NO_CONTENT);
    }

}
