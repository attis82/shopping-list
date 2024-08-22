package com.farkasatesz.shopping_list.models.unitTypes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unit_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_type_id")
    private Integer unitTypeId;

    @Column(name = "unit_type_name")
    private String unitTypeName;


}
