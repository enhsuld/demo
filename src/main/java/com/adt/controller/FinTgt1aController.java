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

import com.adt.model.FinTgt1a;
import com.adt.service.FinTgt1aService;

@RestController
@RequestMapping(value = "/api/fintgt1a")
public class FinTgt1aController {
    @Resource
    private FinTgt1aService finTgt1aService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinTgt1aController.class);
     
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
                        .setData(this.finTgt1aService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finTgt1aService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinTgt1a with id {}", id);
        FinTgt1a item = this.finTgt1aService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinTgt1a>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinTgt1a ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinTgt1a>> filteredListItem() {
        List<FinTgt1a> items = this.finTgt1aService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinTgt1a>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinTgt1a ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinTgt1a item) {
     	logger.info("Creating FinTgt1a  : {}", item);
        FinTgt1a att = this.finTgt1aService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finTgt1aService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinTgt1a ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinTgt1a item) {
		logger.info("Updating FinTgt1a with id {}", item.getId());
        this.finTgt1aService.edit(item);
        return new ResponseEntity< FinTgt1a>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinTgt1a -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinTgt1a item) throws JSONException {
 		logger.info("Deleting FinTgt1a with id {}", item.getId());
        this.finTgt1aService.remove(item);
        return new ResponseEntity<FinTgt1a>(HttpStatus.NO_CONTENT);
    }

}
