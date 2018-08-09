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

import com.adt.model.LutRole;
import com.adt.service.LutRoleService;

@RestController
@RequestMapping(value = "/api/lutrole")
public class LutRoleController {
    @Resource
    private LutRoleService lutRoleService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutRoleController.class);
     
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
                        .setData(this.lutRoleService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutRoleService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutRole with id {}", id);
        LutRole item = this.lutRoleService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutRole>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutRole ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutRole>> filteredListItem() {
        List<LutRole> items = this.lutRoleService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutRole>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutRole ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutRole item) {
     	logger.info("Creating LutRole  : {}", item);
        LutRole att = this.lutRoleService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutRoleService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutRole ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutRole item) {
		logger.info("Updating LutRole with id {}", item.getId());
        this.lutRoleService.edit(item);
        return new ResponseEntity< LutRole>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutRole -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutRole item) throws JSONException {
 		logger.info("Deleting LutRole with id {}", item.getId());
        this.lutRoleService.remove(item);
        return new ResponseEntity<LutRole>(HttpStatus.NO_CONTENT);
    }

}
