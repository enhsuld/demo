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

import com.adt.model.FinCtt5;
import com.adt.service.FinCtt5Service;

@RestController
@RequestMapping(value = "/api/finctt5")
public class FinCtt5Controller {
    @Resource
    private FinCtt5Service finCtt5Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt5Controller.class);
     
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
                        .setData(this.finCtt5Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt5Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt5 with id {}", id);
        FinCtt5 item = this.finCtt5Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt5>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt5 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt5>> filteredListItem() {
        List<FinCtt5> items = this.finCtt5Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt5>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt5 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt5 item) {
     	logger.info("Creating FinCtt5  : {}", item);
        FinCtt5 att = this.finCtt5Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt5Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt5 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt5 item) {
		logger.info("Updating FinCtt5 with id {}", item.getId());
        this.finCtt5Service.edit(item);
        return new ResponseEntity< FinCtt5>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt5 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt5 item) throws JSONException {
 		logger.info("Deleting FinCtt5 with id {}", item.getId());
        this.finCtt5Service.remove(item);
        return new ResponseEntity<FinCtt5>(HttpStatus.NO_CONTENT);
    }

}
