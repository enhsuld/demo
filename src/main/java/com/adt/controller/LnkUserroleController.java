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

import com.adt.model.LnkUserrole;
import com.adt.service.LnkUserroleService;

@RestController
@RequestMapping(value = "/api/lnkuserrole")
public class LnkUserroleController {
    @Resource
    private LnkUserroleService lnkUserroleService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkUserroleController.class);
     
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
                        .setData(this.lnkUserroleService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkUserroleService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkUserrole with id {}", id);
        LnkUserrole item = this.lnkUserroleService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkUserrole>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkUserrole ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkUserrole>> filteredListItem() {
        List<LnkUserrole> items = this.lnkUserroleService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkUserrole>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkUserrole ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkUserrole item) {
     	logger.info("Creating LnkUserrole  : {}", item);
        LnkUserrole att = this.lnkUserroleService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkUserroleService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkUserrole ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkUserrole item) {
		logger.info("Updating LnkUserrole with id {}", item.getId());
        this.lnkUserroleService.edit(item);
        return new ResponseEntity< LnkUserrole>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkUserrole -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkUserrole item) throws JSONException {
 		logger.info("Deleting LnkUserrole with id {}", item.getId());
        this.lnkUserroleService.remove(item);
        return new ResponseEntity<LnkUserrole>(HttpStatus.NO_CONTENT);
    }

}
