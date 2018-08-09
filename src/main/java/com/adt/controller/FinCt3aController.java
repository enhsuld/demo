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

import com.adt.model.FinCt3a;
import com.adt.service.FinCt3aService;

@RestController
@RequestMapping(value = "/api/finct3a")
public class FinCt3aController {
    @Resource
    private FinCt3aService finCt3aService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCt3aController.class);
     
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
                        .setData(this.finCt3aService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCt3aService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCt3a with id {}", id);
        FinCt3a item = this.finCt3aService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCt3a>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCt3a ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCt3a>> filteredListItem() {
        List<FinCt3a> items = this.finCt3aService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCt3a>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCt3a ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCt3a item) {
     	logger.info("Creating FinCt3a  : {}", item);
        FinCt3a att = this.finCt3aService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCt3aService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCt3a ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCt3a item) {
		logger.info("Updating FinCt3a with id {}", item.getId());
        this.finCt3aService.edit(item);
        return new ResponseEntity< FinCt3a>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCt3a -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCt3a item) throws JSONException {
 		logger.info("Deleting FinCt3a with id {}", item.getId());
        this.finCt3aService.remove(item);
        return new ResponseEntity<FinCt3a>(HttpStatus.NO_CONTENT);
    }

}
