package com.farkasatesz.shopping_list.models.unitTypes;

import com.farkasatesz.shopping_list.exceptions.unitTypeExceptions.UnitTypeException;
import com.farkasatesz.shopping_list.exceptions.unitTypeExceptions.UnitTypeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitTypeService {

    private final UnitTypeRepository unitTypeRepository;

    public UnitTypeService(UnitTypeRepository unitTypeRepository) {
        this.unitTypeRepository = unitTypeRepository;
    }

    public List<UnitType> getUnitTypesByQuery(String query) {
        try {
            return unitTypeRepository.findByUnitTypeNameLikeIgnoreCase("%" + query +"%");
        } catch (Exception e) {
            throw new UnitTypeException("Failed to find unitTypes by query: " + query, e);
        }
    }

    @Transactional
    public UnitType createUnitType(UnitType unitType) {
        try {
            unitType.setUnitTypeId(null);
            return unitTypeRepository.save(unitType);
        } catch (Exception e) {
            throw new UnitTypeException("Failed to save unitType: " + unitType, e);
        }
    }

    @Transactional
    public UnitType updateUnitType(Integer unitTypeId, UnitType unitType) {
        UnitType oldUnitType = unitTypeRepository.findById(unitTypeId).orElseThrow(() -> new UnitTypeNotFoundException("Unit type was not found"));
        try {
            oldUnitType.setUnitTypeName(unitType.getUnitTypeName());
            return unitTypeRepository.save(oldUnitType);
        } catch (Exception e) {
            throw new UnitTypeException("Failed to update unitType: " + oldUnitType, e);
        }
    }

    @Transactional
    public void deleteUnitType(Integer unitTypeId) {
        unitTypeRepository.deleteById(unitTypeId);
    }
}
