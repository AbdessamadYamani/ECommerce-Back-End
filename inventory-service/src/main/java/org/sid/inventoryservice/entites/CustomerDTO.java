package org.sid.inventoryservice.entites;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CustomerDTO {

    private Long id;
    private String username;

    private String password;

    private String role;
}
