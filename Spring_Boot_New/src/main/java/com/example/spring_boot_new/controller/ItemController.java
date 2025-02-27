package com.example.spring_boot_new.controller;

import com.example.spring_boot_new.dto.ItemDTO;
import com.example.spring_boot_new.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("item")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("save")
    public boolean saveItem(@RequestBody ItemDTO ItemDTO) {
        boolean isSaved = itemService.saveItem(ItemDTO);
        return isSaved;
    }

    @GetMapping("getAll")
    public ArrayList<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping("delete/{id}")
    public String deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return "Item Deleted with id " + id;
    }

    @PutMapping("update")
    public String updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
        return itemDTO.toString();
    }


}
