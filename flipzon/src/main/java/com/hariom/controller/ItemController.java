package com.hariom.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hariom.entity.Item;
import com.hariom.service.ItemService;

/**
 * 
 * @author Hariom Yadav | 01-Apr-2020
 *
 */

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemServiceObj;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Item> getAllItems(){
        return this.itemServiceObj.getAllItems();
    }
	
	@RequestMapping(value = "/{item_id}", 
					method = RequestMethod.GET)
	public Item getItemById(@PathVariable("item_id") int id){
        return this.itemServiceObj.getItemById(id); 
    }
	
	@RequestMapping(value = "/{item_id}",
					method = RequestMethod.DELETE)
	public void removeItemById(@PathVariable("item_id") int id) {
        this.itemServiceObj.removeItemById(id);
    }
	
	//update old Item
	@RequestMapping(method = RequestMethod.PUT, 
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateItem(@RequestBody Item item){
    	this.itemServiceObj.updateItem(item);
    }
	
	//adding new Item
    @RequestMapping(method = RequestMethod.POST, 
    				consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertItem(@RequestBody Item item){
        this.itemServiceObj.insertItem(item);
    }
	
	
}