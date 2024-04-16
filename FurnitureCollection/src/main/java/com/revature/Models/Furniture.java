package com.revature.Models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity // Entity makes this database table
@Table(name = "furniture") // allow us to name the Table in database
@Component // makes the class as Spring bean
public class Furniture {
    /*
    Unique id for each furniture
     */
    @Id // create the primary key in the database
    @Column(name = "furnitureId") //allow us to provide config detail about the column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // will auto increment the id in database
    private int furnitureId;

    /*
    furniture Type examples: chair, table, bed
     */
    @Column(nullable = false)
    private String furnitureType;

    /*
    Material type examples: Metal, Wood, Plastic
     */
    private String furnitureMaterial;

    /*
    Quantity available
     */
    private int quantityAvailable;

    // no-arg constructor
    public Furniture() {
    }

    // all-arg constructor
    public Furniture(int furnitureId, String furnitureType, String furnitureMaterial, int quantityAvailable) {
        this.furnitureId = furnitureId;
        this.furnitureType = furnitureType;
        this.furnitureMaterial = furnitureMaterial;
        this.quantityAvailable = quantityAvailable;
    }

    // args without furniture id
    public Furniture(String furnitureType, String furnitureMaterial, int quantityAvailable) {
        this.furnitureType = furnitureType;
        this.furnitureMaterial = furnitureMaterial;
        this.quantityAvailable = quantityAvailable;
    }

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
