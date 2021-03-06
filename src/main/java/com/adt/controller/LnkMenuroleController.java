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

import com.adt.model.LnkMenurole;
import com.adt.service.LnkMenuroleService;

@RestController
@RequestMapping(value = "/api/lnkmenurole")
public class LnkMenuroleController {
    @Resource
    private LnkMenuroleService lnkMenuroleService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkMenuroleController.class);
     
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
                        .setData(this.lnkMenuroleService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkMenuroleService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkMenurole with id {}", id);
        LnkMenurole item = this.lnkMenuroleService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkMenurole>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkMenurole ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkMenurole>> filteredListItem() {
        List<LnkMenurole> items = this.lnkMenuroleService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkMenurole>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkMenurole ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkMenurole item) {
     	logger.info("Creating LnkMenurole  : {}", item);
        LnkMenurole att = this.lnkMenuroleService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkMenuroleService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkMenurole ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkMenurole item) {
		logger.info("Updating LnkMenurole with id {}", item.getId());
        this.lnkMenuroleService.edit(item);
        return new ResponseEntity< LnkMenurole>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkMenurole -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkMenurole item) throws JSONException {
 		logger.info("Deleting LnkMenurole with id {}", item.getId());
        this.lnkMenuroleService.remove(item);
        return new ResponseEntity<LnkMenurole>(HttpStatus.NO_CONTENT);
    }

}
