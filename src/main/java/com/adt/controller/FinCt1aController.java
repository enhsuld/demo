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

import com.adt.model.FinCt1a;
import com.adt.service.FinCt1aService;

@RestController
@RequestMapping(value = "/api/finct1a")
public class FinCt1aController {
    @Resource
    private FinCt1aService finCt1aService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCt1aController.class);
     
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
                        .setData(this.finCt1aService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCt1aService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCt1a with id {}", id);
        FinCt1a item = this.finCt1aService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCt1a>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCt1a ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCt1a>> filteredListItem() {
        List<FinCt1a> items = this.finCt1aService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCt1a>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCt1a ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCt1a item) {
     	logger.info("Creating FinCt1a  : {}", item);
        FinCt1a att = this.finCt1aService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCt1aService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCt1a ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCt1a item) {
		logger.info("Updating FinCt1a with id {}", item.getId());
        this.finCt1aService.edit(item);
        return new ResponseEntity< FinCt1a>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCt1a -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCt1a item) throws JSONException {
 		logger.info("Deleting FinCt1a with id {}", item.getId());
        this.finCt1aService.remove(item);
        return new ResponseEntity<FinCt1a>(HttpStatus.NO_CONTENT);
    }

}
