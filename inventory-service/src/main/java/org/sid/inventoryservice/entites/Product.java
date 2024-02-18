package org.sid.inventoryservice.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Getter
        public Long id;
        @Getter
        @Setter
        public String Name;
    @Getter
    @Setter
        public String Discription;
    @Getter
    @Setter
        public int Price;
    @Getter @Setter
    public String Pic;


    }

