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

import com.adt.model.FinCtt8;
import com.adt.service.FinCtt8Service;

@RestController
@RequestMapping(value = "/api/finctt8")
public class FinCtt8Controller {
    @Resource
    private FinCtt8Service finCtt8Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt8Controller.class);
     
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
                        .setData(this.finCtt8Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt8Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt8 with id {}", id);
        FinCtt8 item = this.finCtt8Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt8>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt8 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt8>> filteredListItem() {
        List<FinCtt8> items = this.finCtt8Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt8>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt8 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt8 item) {
     	logger.info("Creating FinCtt8  : {}", item);
        FinCtt8 att = this.finCtt8Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt8Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt8 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt8 item) {
		logger.info("Updating FinCtt8 with id {}", item.getId());
        this.finCtt8Service.edit(item);
        return new ResponseEntity< FinCtt8>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt8 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt8 item) throws JSONException {
 		logger.info("Deleting FinCtt8 with id {}", item.getId());
        this.finCtt8Service.remove(item);
        return new ResponseEntity<FinCtt8>(HttpStatus.NO_CONTENT);
    }

}
