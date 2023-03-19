package com.example.demo.domain.persistenceClasses;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "addition")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionPersistence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "game_id")
    @NotNull
    @EqualsAndHashCode.Exclude
    private int game_id;
    @NotBlank
    @Length(min = 2 ,max = 100)
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
    @NotBlank
    @Length(min = 2 ,max = 200)
    @Column(name = "image")
    private String image;
}
