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

import com.adt.model.FinCtt4;
import com.adt.service.FinCtt4Service;

@RestController
@RequestMapping(value = "/api/finctt4")
public class FinCtt4Controller {
    @Resource
    private FinCtt4Service finCtt4Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt4Controller.class);
     
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
                        .setData(this.finCtt4Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt4Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt4 with id {}", id);
        FinCtt4 item = this.finCtt4Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt4>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt4 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt4>> filteredListItem() {
        List<FinCtt4> items = this.finCtt4Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt4>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt4 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt4 item) {
     	logger.info("Creating FinCtt4  : {}", item);
        FinCtt4 att = this.finCtt4Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt4Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt4 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt4 item) {
		logger.info("Updating FinCtt4 with id {}", item.getId());
        this.finCtt4Service.edit(item);
        return new ResponseEntity< FinCtt4>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt4 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt4 item) throws JSONException {
 		logger.info("Deleting FinCtt4 with id {}", item.getId());
        this.finCtt4Service.remove(item);
        return new ResponseEntity<FinCtt4>(HttpStatus.NO_CONTENT);
    }

}
