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

import com.adt.model.LutUsers;
import com.adt.service.LutUsersService;

@RestController
@RequestMapping(value = "/api/lutusers")
public class LutUsersController {
    @Resource
    private LutUsersService lutUsersService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutUsersController.class);
     
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
                        .setData(this.lutUsersService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutUsersService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutUsers with id {}", id);
        LutUsers item = this.lutUsersService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutUsers>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutUsers ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutUsers>> filteredListItem() {
        List<LutUsers> items = this.lutUsersService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutUsers>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutUsers ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutUsers item) {
     	logger.info("Creating LutUsers  : {}", item);
        LutUsers att = this.lutUsersService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutUsersService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutUsers ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutUsers item) {
		logger.info("Updating LutUsers with id {}", item.getId());
        this.lutUsersService.edit(item);
        return new ResponseEntity< LutUsers>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutUsers -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutUsers item) throws JSONException {
 		logger.info("Deleting LutUsers with id {}", item.getId());
        this.lutUsersService.remove(item);
        return new ResponseEntity<LutUsers>(HttpStatus.NO_CONTENT);
    }

}
