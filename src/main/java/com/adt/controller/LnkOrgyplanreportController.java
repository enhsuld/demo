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

import com.adt.model.LnkOrgyplanreport;
import com.adt.service.LnkOrgyplanreportService;

@RestController
@RequestMapping(value = "/api/lnkorgyplanreport")
public class LnkOrgyplanreportController {
    @Resource
    private LnkOrgyplanreportService lnkOrgyplanreportService;
    
    public static final Logger logger = LoggerFactory.getLogger(LnkOrgyplanreportController.class);
     
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
                        .setData(this.lnkOrgyplanreportService.getListByPage(obj.getInt("page"), obj.getInt("take"),query,order))
                        .setCurrentPage(obj.getInt("page"))
                        .setTotal(this.lnkOrgyplanreportService.getTotalPage(obj.getInt("take"),query)));
    }
    
    
    // -------------------FindOne by Id ---------------------------------------------------------

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
    	logger.info("Fetching LnkOrgyplanreport with id {}", id);
        LnkOrgyplanreport item = this.lnkOrgyplanreportService.findById(id);
        if (item == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LnkOrgyplanreport>(item, HttpStatus.OK);
    }
    
    // -------------------Retrieve All LnkOrgyplanreport ----------------------------------------------

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<LnkOrgyplanreport>> filteredListItem() {
        List<LnkOrgyplanreport> items = this.lnkOrgyplanreportService.findAll();
        if (items.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<LnkOrgyplanreport>>(items, HttpStatus.OK);
    }
    
    
    // ------------------- Create a  LnkOrgyplanreport ------------------------------------------------
        
    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody LnkOrgyplanreport item) {
     	logger.info("Creating LnkOrgyplanreport  : {}", item);
        LnkOrgyplanreport att = this.lnkOrgyplanreportService.view(item);
        if(att!=null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        this.lnkOrgyplanreportService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
    // ------------------- Update a  LnkOrgyplanreport ------------------------------------------------

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody LnkOrgyplanreport item) {
		logger.info("Updating LnkOrgyplanreport with id {}", item.getId());
        this.lnkOrgyplanreportService.edit(item);
        return new ResponseEntity< LnkOrgyplanreport>(item, HttpStatus.OK);
    }
    
    // ------------------- Delete a LnkOrgyplanreport -------------------------------------------------

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LnkOrgyplanreport item) throws JSONException {
 		logger.info("Deleting LnkOrgyplanreport with id {}", item.getId());
        this.lnkOrgyplanreportService.remove(item);
        return new ResponseEntity<LnkOrgyplanreport>(HttpStatus.NO_CONTENT);
    }

}
