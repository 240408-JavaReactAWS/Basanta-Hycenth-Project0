package com.revature.Controllers;

import com.revature.Models.Furniture;
import com.revature.Services.FurnitureServices;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/furniture")
@ResponseBody
public class FurnitureController {

    private FurnitureServices fs;
    @Autowired
    public FurnitureController(FurnitureServices fs){
        this.fs = fs;
    }

    // As a user, I can create a new Furniture
    @PostMapping
    public ResponseEntity<Furniture> createFurnitureHandler(@RequestBody Furniture furniture){
        return fs.createFurniture(furniture);
    }

    //As a user, I can view all Furniture
    @GetMapping
    public ResponseEntity<List<Furniture>> getAllFurnitureHandler(){
        return fs.getAllFurniture();
    }

    //As a user, I can view a singular Furniture by its ID
    @GetMapping("{id}")
    public ResponseEntity<Furniture> getFurnitureByIdHandler(@PathVariable int id){
        return fs.findFurnitureById(id);
    }

    //As a user, I can update a Furniture
    @PatchMapping("{id}")
    public ResponseEntity<Furniture>updateFurnitureHandler( @PathVariable int id, @RequestBody Furniture furniture){
        try{
            return fs.updateFurnitureById(id, furniture.getFurnitureType(), furniture.getFurnitureMaterial(), furniture.getQuantityAvailable());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(BAD_REQUEST).body(null);
        }
    }

    // As a user, I can delete a Furniture by its ID
    @DeleteMapping("{id}")
    public ResponseEntity<Furniture> deleteFurnitutreByIdHandler(@PathVariable int id){
        return fs.deleteFurnitureById(id);
    }
}
