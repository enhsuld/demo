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

import com.adt.model.FinNt2;
import com.adt.service.FinNt2Service;

@RestController
@RequestMapping(value = "/api/finnt2")
public class FinNt2Controller {
    @Resource
    private FinNt2Service finNt2Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinNt2Controller.class);
     
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
                        .setData(this.finNt2Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finNt2Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinNt2 with id {}", id);
        FinNt2 item = this.finNt2Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinNt2>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinNt2 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinNt2>> filteredListItem() {
        List<FinNt2> items = this.finNt2Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinNt2>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinNt2 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinNt2 item) {
     	logger.info("Creating FinNt2  : {}", item);
        FinNt2 att = this.finNt2Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finNt2Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinNt2 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinNt2 item) {
		logger.info("Updating FinNt2 with id {}", item.getId());
        this.finNt2Service.edit(item);
        return new ResponseEntity< FinNt2>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinNt2 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinNt2 item) throws JSONException {
 		logger.info("Deleting FinNt2 with id {}", item.getId());
        this.finNt2Service.remove(item);
        return new ResponseEntity<FinNt2>(HttpStatus.NO_CONTENT);
    }

}
