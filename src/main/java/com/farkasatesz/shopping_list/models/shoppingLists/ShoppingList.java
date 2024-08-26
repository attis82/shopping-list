package com.farkasatesz.shopping_list.models.shoppingLists;


import com.farkasatesz.shopping_list.models.supermarkets.Supermarket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopping_lists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_list_id")
    private Integer shoppingListId;

    @Column(name = "shopping_list_name")
    private String shoppingListName;

}
