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

import com.adt.model.FinCbws;
import com.adt.service.FinCbwsService;

@RestController
@RequestMapping(value = "/api/fincbws")
public class FinCbwsController {
    @Resource
    private FinCbwsService finCbwsService;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCbwsController.class);
     
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
                        .setData(this.finCbwsService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCbwsService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCbws with id {}", id);
        FinCbws item = this.finCbwsService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCbws>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCbws ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCbws>> filteredListItem() {
        List<FinCbws> items = this.finCbwsService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCbws>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCbws ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCbws item) {
     	logger.info("Creating FinCbws  : {}", item);
        FinCbws att = this.finCbwsService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCbwsService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCbws ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCbws item) {
		logger.info("Updating FinCbws with id {}", item.getId());
        this.finCbwsService.edit(item);
        return new ResponseEntity< FinCbws>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCbws -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCbws item) throws JSONException {
 		logger.info("Deleting FinCbws with id {}", item.getId());
        this.finCbwsService.remove(item);
        return new ResponseEntity<FinCbws>(HttpStatus.NO_CONTENT);
    }

}
