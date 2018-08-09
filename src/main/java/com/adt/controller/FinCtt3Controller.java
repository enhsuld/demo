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

import com.adt.model.FinCtt3;
import com.adt.service.FinCtt3Service;

@RestController
@RequestMapping(value = "/api/finctt3")
public class FinCtt3Controller {
    @Resource
    private FinCtt3Service finCtt3Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt3Controller.class);
     
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
                        .setData(this.finCtt3Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt3Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt3 with id {}", id);
        FinCtt3 item = this.finCtt3Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt3>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt3 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt3>> filteredListItem() {
        List<FinCtt3> items = this.finCtt3Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt3>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt3 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt3 item) {
     	logger.info("Creating FinCtt3  : {}", item);
        FinCtt3 att = this.finCtt3Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt3Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt3 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt3 item) {
		logger.info("Updating FinCtt3 with id {}", item.getId());
        this.finCtt3Service.edit(item);
        return new ResponseEntity< FinCtt3>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt3 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt3 item) throws JSONException {
 		logger.info("Deleting FinCtt3 with id {}", item.getId());
        this.finCtt3Service.remove(item);
        return new ResponseEntity<FinCtt3>(HttpStatus.NO_CONTENT);
    }

}
