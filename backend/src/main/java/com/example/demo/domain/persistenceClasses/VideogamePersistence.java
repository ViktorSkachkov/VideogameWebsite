package com.example.demo.domain.persistenceClasses;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "videogame")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideogamePersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Length(min = 2 ,max = 200)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    @NotNull
    @EqualsAndHashCode.Exclude
    private double price;
    @NotBlank
    @Length(min = 2 ,max = 1000)
    @Column(name = "description")
    private String description;
    @Column(name = "featured")
    @NotNull
    @EqualsAndHashCode.Exclude
    private Boolean featured;
    @NotBlank
    @Length(min = 2 ,max = 200)
    @Column(name = "image")
    private String image;
}
