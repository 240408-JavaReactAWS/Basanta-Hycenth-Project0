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

    @Autowired // This tells spring to wire the UserDAO bean into this class so we can use it
    public FurnitureServices(FurnitureDAO fdao){
        this.fdao = fdao;
    }

    //As a user, I can create a new Furniture by calling save DAO function
    public ResponseEntity<Furniture> createFurniture(Furniture furniture){
        Furniture furniture1 = fdao.save(furniture);
        return ResponseEntity.status(OK).body(furniture1);
    }

    //As a user, I can view all Furniture by calling findALL DAO function
    public ResponseEntity<List<Furniture>> getAllFurniture(){
        List<Furniture> lists=  fdao.findAll();
        return ResponseEntity.status(OK).body(lists);
    }

    //As a user, I can view a singular Furniture by its ID
    public ResponseEntity<Furniture> findFurnitureById(int id){
        Optional<Furniture> furniture = fdao.findById(id);
        if(furniture.isEmpty()){
            return ResponseEntity.status(NOT_FOUND).body(null);
        }
        return ResponseEntity.status(OK).body(furniture.get());
    }

    // As a user, I can update a Furniture (Change the name or other properties)
    public ResponseEntity<Furniture> updateFurnitureById(Integer furnitureId, String newFurniType, String newFurniMaterial) {
        Optional<Furniture> furniture = fdao.findById(furnitureId);
        if (furniture.isPresent()) {
            Furniture updatedFurniture = furniture.get();

            updatedFurniture.setFurnitureType(newFurniType);
            updatedFurniture.setFurnitureMaterial(newFurniMaterial);
            fdao.save(updatedFurniture);
            return ResponseEntity.status(OK).body(updatedFurniture);
        }
        return ResponseEntity.status(NOT_FOUND).body(null);
    }

    //As a user, I can delete a Furniture by its ID (HINT: Use Path Params to select a Item by its ID)
    public ResponseEntity<Furniture> deleteFurnitureById(int id){
        Optional<Furniture> furniture = fdao.findById(id);
        if(furniture.isEmpty()){
            return ResponseEntity.status(NOT_FOUND).body(null);
        }
        fdao.deleteById(id);
        return ResponseEntity.status(OK).body(furniture.get());
    }
}
