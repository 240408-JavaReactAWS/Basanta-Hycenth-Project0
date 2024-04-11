package com.revature.Services;

import com.revature.Models.Furniture;
import com.revature.Repos.FurnitureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurnitureServices {
    private FurnitureDAO fdao;

    @Autowired // This tells spring to wire the UserDAO bean into this class so we can use it
    public FurnitureServices(FurnitureDAO fdao){
        this.fdao = fdao;
    }

    //As a user, I can create a new Furniture
    public Furniture createFurniture(Furniture furniture){
        return fdao.save(furniture);
    }

    //As a user, I can view all Furniture
    public List<Furniture> getAllFurniture(){
        return fdao.findAll();
    }

    //As a user, I can view a singular Furniture by its ID
    public Furniture findFurnitureById(int id){
        return fdao.findById(id).orElse(null);
    }

    // As a user, I can update a Furniture (Change the name or other properties)
    public Furniture updateFurnitureById(Integer furnitureId, String newFurniType, String newFurniMaterial) {
        Furniture furniture = fdao.findById(furnitureId).orElse(null);
        if (furniture != null) {
            furniture.setFurnitureType(newFurniType);
            furniture.setFurnitureMaterial(newFurniMaterial);
            fdao.save(furniture);
            return furniture;
        }
        return null;
    }

    //As a user, I can delete a Furniture by its ID (HINT: Use Path Params to select a Item by its ID)
    public Furniture deleteFurnitureById(int id){
        Furniture furniture = fdao.findById(id).orElse(null);
        fdao.deleteById(id);
        return furniture;
    }
}
