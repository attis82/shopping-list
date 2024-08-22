package com.farkasatesz.shopping_list.models.priceTracker;

import com.farkasatesz.shopping_list.exceptions.priceTrackerExceptions.PriceTrackerException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PriceTrackerService {
    private final PriceTrackerRepository priceTrackerRepository;

    @Autowired
    public PriceTrackerService(PriceTrackerRepository priceTrackerRepository) {
        this.priceTrackerRepository = priceTrackerRepository;
    }

    public Double getMostRecentPrice(Integer shoppingItemId){
        try {
            return priceTrackerRepository.getMostRecentPrice(shoppingItemId);
        }catch (RuntimeException e){
            throw new PriceTrackerException("Unable to get last price", e);
        }
    }

    public List<Double> getPriceHistory(Integer shoppingItemId){
        try {
            return priceTrackerRepository.getPriceHistoryOfShoppingItem(shoppingItemId);
        }catch (RuntimeException e){
            throw new PriceTrackerException("Unable to get history", e);
        }
    }

    @Transactional
    public PriceTracker createPriceTracker(PriceTracker priceTracker) {
        try {
            priceTracker.setPriceTrackerId(null);
            priceTracker.setPriceAddedAt(LocalDate.now());
            return priceTrackerRepository.save(priceTracker);
        }catch (RuntimeException e){
            throw new PriceTrackerException("Unable to save new price", e);
        }
    }

    @Transactional
    public void deletePriceTracker(Integer priceTrackerId) {
        try {
            priceTrackerRepository.deleteById(priceTrackerId);
        } catch (RuntimeException e) {
            throw new PriceTrackerException("Unable to delete price", e);
        }
    }
}
