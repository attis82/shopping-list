package com.farkasatesz.shopping_list.models.unitTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/shopping-list/unit-types")
public class UnitTypeController {

    private final UnitTypeService unitTypeService;

    @Autowired
    public UnitTypeController(UnitTypeService unitTypeService) {
        this.unitTypeService = unitTypeService;
    }

    @GetMapping(path = "/search")
    public List<UnitType> searchByName(@RequestParam String query) {
        return unitTypeService.getUnitTypesByQuery(query);
    }

    @PostMapping
    public UnitType createUnitType(@RequestBody UnitType unitType) {
        return unitTypeService.createUnitType(unitType);
    }

    @PutMapping(path = "/{unitTypeId}")
    public UnitType updateUnitType(@PathVariable Integer unitTypeId, @RequestBody UnitType unitType) {
        return unitTypeService.updateUnitType(unitTypeId, unitType);
    }

    @DeleteMapping(path = "/{unitTypeId}")
    public void deleteUnitType(@PathVariable Integer unitTypeId) {
        unitTypeService.deleteUnitType(unitTypeId);
    }
}
