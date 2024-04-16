package com.revature.Repos;

import com.revature.Models.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository, which provides basic CRUD operations for the Furniture entity
public interface FurnitureDAO extends JpaRepository<Furniture, Integer> {

}
