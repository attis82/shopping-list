package com.farkasatesz.shopping_list.models.supermarkets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/shopping-list/supermarkets")
public class SupermarketController {

    private final SupermarketService supermarketService;

    @Autowired
    public SupermarketController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    @GetMapping(path = "/search")
    public List<Supermarket> search(@RequestParam String supermarketName) {
        return supermarketService.findSupermarketsByQuery(supermarketName);
    }

    @GetMapping(path = "/check-existence")
    public Boolean checkExistence(@RequestParam String supermarketName) {
        return supermarketService.checkIfSupermarketExists(supermarketName);
    }

    @PostMapping
    public Supermarket createSupermarket(@RequestBody Supermarket supermarket) {
        return supermarketService.createSupermarket(supermarket);
    }

    @PutMapping(path = "/{supermarketId}")
    public Supermarket updateSupermarket(@PathVariable Integer supermarketId, @RequestBody Supermarket supermarket) {
        return supermarketService.updateSupermarket(supermarketId, supermarket);
    }

    @DeleteMapping(path = "/{supermarketId}")
    public void deleteSupermarket(@PathVariable Integer supermarketId) {
        supermarketService.deleteSupermarket(supermarketId);
    }
}
