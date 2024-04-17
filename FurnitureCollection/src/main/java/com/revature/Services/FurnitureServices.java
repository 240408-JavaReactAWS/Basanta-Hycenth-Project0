package com.revature.Services;

import com.revature.Models.Furniture;
import com.revature.Repos.FurnitureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public class FurnitureServices {
    private FurnitureDAO fdao;

    @Autowired // Autowired annotation tells Spring to inject FurnitureDAO bean into this class
    public FurnitureServices(FurnitureDAO fdao){
        this.fdao = fdao;
    }

    // Method to create a new Furniture
    public ResponseEntity<Furniture> createFurniture(Furniture furniture){
        // Save the furniture using FurnitureDAO's save method
        Furniture savedFurniture = fdao.save(furniture);
        // Return ResponseEntity with saved furniture and status OK
        return ResponseEntity.status(201).body(savedFurniture);
    }

    // Method to get all Furniture
    public ResponseEntity<List<Furniture>> getAllFurniture(){
        // Retrieve all furniture using FurnitureDAO's findAll method
        List<Furniture> furnitureList = fdao.findAll();
        // Return ResponseEntity with list of furniture and status OK
        return ResponseEntity.status(OK).body(furnitureList);
    }

    // Method to find a furniture by its ID
    public ResponseEntity<Furniture> findFurnitureById(int id){
        // Find furniture by its ID using FurnitureDAO's findById method
        Optional<Furniture> furniture = fdao.findById(id);
        // If furniture is present, return it with status OK; otherwise, return status NOT_FOUND
        return furniture.map(value -> ResponseEntity.status(OK).body(value))
                .orElseGet(() -> ResponseEntity.status(NOT_FOUND).body(null));
    }

    // Method to update a furniture by its ID
    public ResponseEntity<Furniture> updateFurnitureById(Integer furnitureId, String newFurnitureType, String newFurnitureMaterial, int newQuantityAvailable) {
        // Find furniture by its ID using FurnitureDAO's findById method
        Optional<Furniture> furniture = fdao.findById(furnitureId);
        // If furniture is present, update its properties and save it
        if (furniture.isPresent()) {
            Furniture updatedFurniture = furniture.get();
            updatedFurniture.setFurnitureType(newFurnitureType);
            updatedFurniture.setFurnitureMaterial(newFurnitureMaterial);
            updatedFurniture.setQuantityAvailable(newQuantityAvailable);
            fdao.save(updatedFurniture);
            // Return updated furniture with status OK
            return ResponseEntity.status(OK).body(updatedFurniture);
        }
        // If furniture is not found, return status NOT_FOUND
        return ResponseEntity.status(NOT_FOUND).body(null);
    }

    // Method to delete a furniture by its ID
    public ResponseEntity<Furniture> deleteFurnitureById(int id){
        // Find furniture by its ID using FurnitureDAO's findById method
        Optional<Furniture> furniture = fdao.findById(id);
        // If furniture is present, delete it and return it with status OK; otherwise, return status NOT_FOUND
        return furniture.map(value -> {
            fdao.deleteById(id);
            return ResponseEntity.status(OK).body(value);
        }).orElseGet(() -> ResponseEntity.status(NOT_FOUND).body(null));
    }
}
