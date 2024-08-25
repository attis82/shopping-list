package com.farkasatesz.shopping_list.models.priceTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/shopping-list/price-trackers")
public class PriceTrackerController {
    private final PriceTrackerService priceTrackerService;

    @Autowired
    public PriceTrackerController(PriceTrackerService priceTrackerService) {
        this.priceTrackerService = priceTrackerService;
    }

    @GetMapping(path = "/recent-price")
    public Double getRecentPrice(@RequestParam Integer shoppingItemId) {
        return priceTrackerService.getMostRecentPrice(shoppingItemId);
    }

    @GetMapping(path = "/history")
    public List<PriceTracker> getHistory(@RequestParam Integer shoppingItemId) {
        return priceTrackerService.getPriceHistory(shoppingItemId);
    }

    @PostMapping
    public PriceTracker createPriceTracker(@RequestBody PriceTracker priceTracker) {
        return priceTrackerService.createPriceTracker(priceTracker);
    }

}
