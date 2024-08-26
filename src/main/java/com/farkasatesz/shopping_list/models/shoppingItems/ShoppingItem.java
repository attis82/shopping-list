package com.farkasatesz.shopping_list.models.shoppingItems;

import com.farkasatesz.shopping_list.models.categories.Category;
import com.farkasatesz.shopping_list.models.supermarkets.Supermarket;
import com.farkasatesz.shopping_list.models.unitTypes.UnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopping_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_item_id")
    private Integer shoppingItemId;

    @Column(name = "shopping_item_name")
    private String shoppingItemName;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supermarket_id", referencedColumnName = "supermarket_id")
    private Supermarket supermarket;

    @ManyToOne
    @JoinColumn(name = "unit_type_id", referencedColumnName = "unit_type_id")
    private UnitType unitType;

}
