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

import com.adt.model.FinCtt2;
import com.adt.service.FinCtt2Service;

@RestController
@RequestMapping(value = "/api/finctt2")
public class FinCtt2Controller {
    @Resource
    private FinCtt2Service finCtt2Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt2Controller.class);
     
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
                        .setData(this.finCtt2Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt2Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt2 with id {}", id);
        FinCtt2 item = this.finCtt2Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt2>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt2 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt2>> filteredListItem() {
        List<FinCtt2> items = this.finCtt2Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt2>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt2 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt2 item) {
     	logger.info("Creating FinCtt2  : {}", item);
        FinCtt2 att = this.finCtt2Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt2Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt2 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt2 item) {
		logger.info("Updating FinCtt2 with id {}", item.getId());
        this.finCtt2Service.edit(item);
        return new ResponseEntity< FinCtt2>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt2 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt2 item) throws JSONException {
 		logger.info("Deleting FinCtt2 with id {}", item.getId());
        this.finCtt2Service.remove(item);
        return new ResponseEntity<FinCtt2>(HttpStatus.NO_CONTENT);
    }

}
