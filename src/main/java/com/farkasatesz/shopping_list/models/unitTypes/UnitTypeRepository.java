package com.farkasatesz.shopping_list.models.unitTypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Integer> {

    List<UnitType> findByUnitTypeNameLikeIgnoreCase(String query);
    Boolean existsByUnitTypeNameLikeIgnoreCase(String unitTypeName);

}
