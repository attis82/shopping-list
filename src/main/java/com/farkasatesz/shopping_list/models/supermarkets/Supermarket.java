package com.farkasatesz.shopping_list.models.supermarkets;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supermarkets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supermarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supermarket_id")
    private Integer supermarketId;

    @Column(name = "supermarket_name")
    private String supermarketName;
}
