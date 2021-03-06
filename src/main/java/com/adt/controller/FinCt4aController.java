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

import com.adt.model.FinCt4a;
import com.adt.service.FinCt4aService;

@RestController
@RequestMapping(value = "/api/finct4a")
public class FinCt4aController {
    @Resource
    private FinCt4aService finCt4aService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCt4aController.class);
     
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
                        .setData(this.finCt4aService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCt4aService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCt4a with id {}", id);
        FinCt4a item = this.finCt4aService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCt4a>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCt4a ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCt4a>> filteredListItem() {
        List<FinCt4a> items = this.finCt4aService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCt4a>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCt4a ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCt4a item) {
     	logger.info("Creating FinCt4a  : {}", item);
        FinCt4a att = this.finCt4aService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCt4aService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCt4a ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCt4a item) {
		logger.info("Updating FinCt4a with id {}", item.getId());
        this.finCt4aService.edit(item);
        return new ResponseEntity< FinCt4a>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCt4a -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCt4a item) throws JSONException {
 		logger.info("Deleting FinCt4a with id {}", item.getId());
        this.finCt4aService.remove(item);
        return new ResponseEntity<FinCt4a>(HttpStatus.NO_CONTENT);
    }

}
