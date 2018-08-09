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

import com.adt.model.FinCtt7;
import com.adt.service.FinCtt7Service;

@RestController
@RequestMapping(value = "/api/finctt7")
public class FinCtt7Controller {
    @Resource
    private FinCtt7Service finCtt7Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt7Controller.class);
     
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
                        .setData(this.finCtt7Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt7Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt7 with id {}", id);
        FinCtt7 item = this.finCtt7Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt7>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt7 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt7>> filteredListItem() {
        List<FinCtt7> items = this.finCtt7Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt7>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt7 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt7 item) {
     	logger.info("Creating FinCtt7  : {}", item);
        FinCtt7 att = this.finCtt7Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt7Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt7 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt7 item) {
		logger.info("Updating FinCtt7 with id {}", item.getId());
        this.finCtt7Service.edit(item);
        return new ResponseEntity< FinCtt7>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt7 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt7 item) throws JSONException {
 		logger.info("Deleting FinCtt7 with id {}", item.getId());
        this.finCtt7Service.remove(item);
        return new ResponseEntity<FinCtt7>(HttpStatus.NO_CONTENT);
    }

}
