package com.epam.authserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "permission")
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
}
