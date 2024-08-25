package com.farkasatesz.shopping_list.models.priceTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceTrackerRepository extends JpaRepository<PriceTracker, Integer> {

    @Query("SELECT unitPrice FROM PriceTracker WHERE shoppingItem.shoppingItemId=:id ORDER BY priceAddedAt DESC limit 1")
    Double getMostRecentPrice(Integer id);

    @Query("SELECT PriceTracker FROM PriceTracker WHERE shoppingItem.shoppingItemId=:id  ORDER BY priceAddedAt ASC")
    List<PriceTracker> getPriceHistoryOfShoppingItem(Integer id);
}
