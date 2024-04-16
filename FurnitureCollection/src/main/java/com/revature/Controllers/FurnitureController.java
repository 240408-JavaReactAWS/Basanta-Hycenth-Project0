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

    // Constructor injection of FurnitureServices
    @Autowired
    public FurnitureController(FurnitureServices fs){
        this.fs = fs;
    }

    // Handler method to create a new Furniture
    @PostMapping
    public ResponseEntity<Furniture> createFurnitureHandler(@RequestBody Furniture furniture){
        return fs.createFurniture(furniture);
    }

    // Handler method to get all Furniture
    @GetMapping
    public ResponseEntity<List<Furniture>> getAllFurnitureHandler(){
        return fs.getAllFurniture();
    }

    // Handler method to get a Furniture by its ID
    @GetMapping("{id}")
    public ResponseEntity<Furniture> getFurnitureByIdHandler(@PathVariable int id){
        return fs.findFurnitureById(id);
    }

    // Handler method to update a Furniture
    @PatchMapping("{id}")
    public ResponseEntity<Furniture> updateFurnitureHandler( @PathVariable int id, @RequestBody Furniture furniture){
        try{
            // Update the furniture based on ID, type, material, and quantity available
            return fs.updateFurnitureById(id, furniture.getFurnitureType(), furniture.getFurnitureMaterial(), furniture.getQuantityAvailable());
        } catch (Exception e){
            // Print exception message if an error occurs during update
            System.out.println(e.getMessage());
            // Return bad request status with null body
            return ResponseEntity.status(BAD_REQUEST).body(null);
        }
    }

    // Handler method to delete a Furniture by its ID
    @DeleteMapping("{id}")
    public ResponseEntity<Furniture> deleteFurnitureByIdHandler(@PathVariable int id){
        return fs.deleteFurnitureById(id);
    }
}
