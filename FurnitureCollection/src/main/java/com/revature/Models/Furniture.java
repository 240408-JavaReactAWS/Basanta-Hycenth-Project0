package com.revature.Models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity // Indicates that this class is an entity mapped to a database table
@Table(name = "furniture") // Specifies the name of the database table
@Component // Indicates that this class is a Spring bean
public class Furniture {

    @Id // Indicates the primary key of the entity
    @Column(name = "furnitureId") // Specifies the column name in the database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies how the ID is generated (auto-increment)
    private int furnitureId;

    @Column(nullable = false) // Specifies that this column cannot be null in the database
    private String furnitureType; // Represents the type of furniture

    private String furnitureMaterial; // Represents the material of the furniture

    private int quantityAvailable; // Represents the quantity of this furniture available

    // No-argument constructor
    public Furniture() {
    }

    // Constructor with all arguments
    public Furniture(int furnitureId, String furnitureType, String furnitureMaterial, int quantityAvailable) {
        this.furnitureId = furnitureId;
        this.furnitureType = furnitureType;
        this.furnitureMaterial = furnitureMaterial;
        this.quantityAvailable = quantityAvailable;
    }

    // Constructor without the furniture ID
    public Furniture(String furnitureType, String furnitureMaterial, int quantityAvailable) {
        this.furnitureType = furnitureType;
        this.furnitureMaterial = furnitureMaterial;
        this.quantityAvailable = quantityAvailable;
    }

    // Getter and setter methods
    public int getFurnitureId() {
        return furnitureId;
    }

    public void setFurnitureId(int furnitureId) {
        this.furnitureId = furnitureId;
    }

    public String getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(String furnitureType) {
        this.furnitureType = furnitureType;
    }

    public String getFurnitureMaterial() {
        return furnitureMaterial;
    }

    public void setFurnitureMaterial(String furnitureMaterial) {
        this.furnitureMaterial = furnitureMaterial;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    // toString method for printing the object
    @Override
    public String toString() {
        return "Furniture{" +
                "furnitureId=" + furnitureId +
                ", furnitureType='" + furnitureType + '\'' +
                ", furnitureMaterial='" + furnitureMaterial + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}
