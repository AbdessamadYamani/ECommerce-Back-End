package org.sid.inventoryservice.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import org.sid.inventoryservice.entites.Cart;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer_Order {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCo;
    @Getter
    @Setter
private long id;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    private Cart  cart;
    @Getter
    @Setter
    private Date orderDate;

}
