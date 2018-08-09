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

import com.adt.model.LnkMainUsers;
import com.adt.service.LnkMainUsersService;

@RestController
@RequestMapping(value = "/api/lnkmainusers")
public class LnkMainUsersController {
    @Resource
    private LnkMainUsersService lnkMainUsersService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkMainUsersController.class);
     
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
                        .setData(this.lnkMainUsersService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkMainUsersService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkMainUsers with id {}", id);
        LnkMainUsers item = this.lnkMainUsersService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkMainUsers>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkMainUsers ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkMainUsers>> filteredListItem() {
        List<LnkMainUsers> items = this.lnkMainUsersService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkMainUsers>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkMainUsers ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkMainUsers item) {
     	logger.info("Creating LnkMainUsers  : {}", item);
        LnkMainUsers att = this.lnkMainUsersService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkMainUsersService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkMainUsers ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkMainUsers item) {
		logger.info("Updating LnkMainUsers with id {}", item.getId());
        this.lnkMainUsersService.edit(item);
        return new ResponseEntity< LnkMainUsers>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkMainUsers -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkMainUsers item) throws JSONException {
 		logger.info("Deleting LnkMainUsers with id {}", item.getId());
        this.lnkMainUsersService.remove(item);
        return new ResponseEntity<LnkMainUsers>(HttpStatus.NO_CONTENT);
    }

}
