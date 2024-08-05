package com.rahul.movieapibackend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;

    @Column(nullable=false,length=500)
    @NotBlank(message="Please Enter refresh TOken value")
    private String refreshToken;

    @Column(nullable=false)
    private Instant expirationDate;

    @OneToOne
    private User user;

}
