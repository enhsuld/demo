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

import com.adt.model.FinCtt6;
import com.adt.service.FinCtt6Service;

@RestController
@RequestMapping(value = "/api/finctt6")
public class FinCtt6Controller {
    @Resource
    private FinCtt6Service finCtt6Service;
    
    public static final Logger logger = LoggerFactory.getLogger(FinCtt6Controller.class);
     
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
                        .setData(this.finCtt6Service.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.finCtt6Service.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching FinCtt6 with id {}", id);
        FinCtt6 item = this.finCtt6Service.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FinCtt6>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All FinCtt6 ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<FinCtt6>> filteredListItem() {
        List<FinCtt6> items = this.finCtt6Service.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<FinCtt6>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  FinCtt6 ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody FinCtt6 item) {
     	logger.info("Creating FinCtt6  : {}", item);
        FinCtt6 att = this.finCtt6Service.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.finCtt6Service.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  FinCtt6 ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody FinCtt6 item) {
		logger.info("Updating FinCtt6 with id {}", item.getId());
        this.finCtt6Service.edit(item);
        return new ResponseEntity< FinCtt6>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a FinCtt6 -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FinCtt6 item) throws JSONException {
 		logger.info("Deleting FinCtt6 with id {}", item.getId());
        this.finCtt6Service.remove(item);
        return new ResponseEntity<FinCtt6>(HttpStatus.NO_CONTENT);
    }

}
