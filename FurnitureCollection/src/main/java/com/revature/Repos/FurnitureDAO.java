package com.revature.Repos;

import com.revature.Models.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureDAO extends JpaRepository<Furniture, Integer> {

}
