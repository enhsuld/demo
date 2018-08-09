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

import com.adt.model.FinCtt9;
import com.adt.service.FinCtt9Service;

@RestController
@RequestMapping(value = "/api/finctt9")
public class FinCtt9Controller {
    @Resource
    private FinCtt9Service finCtt9Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt9Controller.class);
     
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
                        .setData(this.finCtt9Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt9Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt9 with id {}", id);
        FinCtt9 item = this.finCtt9Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt9>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt9 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt9>> filteredListItem() {
        List<FinCtt9> items = this.finCtt9Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt9>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt9 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt9 item) {
     	logger.info("Creating FinCtt9  : {}", item);
        FinCtt9 att = this.finCtt9Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt9Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt9 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt9 item) {
		logger.info("Updating FinCtt9 with id {}", item.getId());
        this.finCtt9Service.edit(item);
        return new ResponseEntity< FinCtt9>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt9 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt9 item) throws JSONException {
 		logger.info("Deleting FinCtt9 with id {}", item.getId());
        this.finCtt9Service.remove(item);
        return new ResponseEntity<FinCtt9>(HttpStatus.NO_CONTENT);
    }

}
