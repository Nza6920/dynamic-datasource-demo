package com.niu.datasource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    private String userName;

    private String userPhone;

    private String address;

    private Integer weight;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
