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

import com.adt.model.LutMenu;
import com.adt.service.LutMenuService;

@RestController
@RequestMapping(value = "/api/lutmenu")
public class LutMenuController {
    @Resource
    private LutMenuService lutMenuService;
    
    public static final Logger logger = LoggerFactory.getLogger(LutMenuController.class);
     
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
                        .setData(this.lutMenuService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lutMenuService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LutMenu with id {}", id);
        LutMenu item = this.lutMenuService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LutMenu>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LutMenu ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LutMenu>> filteredListItem() {
        List<LutMenu> items = this.lutMenuService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LutMenu>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LutMenu ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LutMenu item) {
     	logger.info("Creating LutMenu  : {}", item);
        LutMenu att = this.lutMenuService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lutMenuService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LutMenu ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LutMenu item) {
		logger.info("Updating LutMenu with id {}", item.getId());
        this.lutMenuService.edit(item);
        return new ResponseEntity< LutMenu>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LutMenu -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LutMenu item) throws JSONException {
 		logger.info("Deleting LutMenu with id {}", item.getId());
        this.lutMenuService.remove(item);
        return new ResponseEntity<LutMenu>(HttpStatus.NO_CONTENT);
    }

}
