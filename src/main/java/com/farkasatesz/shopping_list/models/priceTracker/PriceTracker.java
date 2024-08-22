package com.farkasatesz.shopping_list.models.priceTracker;

import com.farkasatesz.shopping_list.models.shoppingItems.ShoppingItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "price_tracker")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_tracker_id")
    private Integer priceTrackerId;

    @ManyToOne
    @JoinColumn(name = "shopping_item_id", referencedColumnName = "shopping_item_id")
    private ShoppingItem shoppingItem;

    @Column(name = "price_added_at")
    private LocalDate priceAddedAt;

    @Column(name = "unit_price")
    private Double unitPrice;
}
