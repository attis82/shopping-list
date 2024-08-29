package com.farkasatesz.shopping_list.models.shoppingDetails;

import com.farkasatesz.shopping_list.models.shoppingItems.ShoppingItem;
import com.farkasatesz.shopping_list.models.shoppingLists.ShoppingList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopping_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_detail_id")
    private Integer shoppingDetailId;

    @ManyToOne
    @JoinColumn(name = "shopping_list_id", referencedColumnName = "shopping_list_id")
    private ShoppingList shoppingList;

    @ManyToOne
    @JoinColumn(name = "shopping_item_id", referencedColumnName = "shopping_item_id")
    private ShoppingItem shoppingItem;

    @Column(name = "latest_unit_price")
    private Double latestUnitPrice;

    @Column(name = "quantity")
    private Double quantity;
}
