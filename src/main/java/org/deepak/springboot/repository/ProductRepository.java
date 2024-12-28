package org.deepak.springboot.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.deepak.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByNameContainsIgnoreCase(String name);

    // Custom JPQL query for matching multiple fields
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :input, '%')) " +
            "OR LOWER(p.category) LIKE LOWER(CONCAT('%', :input, '%'))")
    List<Product> searchByInput(@Param("input") String input);
}
