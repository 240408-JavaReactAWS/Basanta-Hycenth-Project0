package com.revature.Controllers;

import com.revature.Models.Furniture;
import com.revature.Services.FurnitureServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Furniture createFurnitureHandler(@RequestBody Furniture furniture){
        return fs.createFurniture(furniture);
    }

    //As a user, I can view all Furniture
    @GetMapping
    public List<Furniture> getAllFurnitureHandler(){
        return fs.getAllFurniture();
    }

    //As a user, I can view a singular Furniture by its ID
    @GetMapping("{id}")
    public Furniture getFurnitureByIdHandler(@PathVariable int id){
        return fs.findFurnitureById(id);
    }

    //As a user, I can update a Furniture
    @PatchMapping("{id}")
    public Furniture updateFurnitureHandler( @PathVariable int id, @RequestBody Furniture furniture){
        return fs.updateFurnitureById(id, furniture.getFurnitureType(), furniture.getFurnitureMaterial());
    }

    // As a user, I can delete a Furniture by its ID
    @DeleteMapping("{id}")
    public Furniture deleteFurnitutreByIdHandler(@PathVariable int id){
        return fs.deleteFurnitureById(id);
    }
}
