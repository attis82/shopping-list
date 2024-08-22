package com.farkasatesz.shopping_list.models.supermarkets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket, Integer> {

    List<Supermarket> findBySupermarketNameLikeIgnoreCase(String query);

}
