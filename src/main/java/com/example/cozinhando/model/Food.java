package com.example.cozinhando.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Table(name = "foods")
@Entity(name = "foods")
@Getter //Criação getters
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private String category;
    private String recipe;
    private Integer likes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date(); // Inicializa com a data atual

    public Food(FoodRequestDTO data){
        this.image = data.image();
        this.likes = data.likes();
        this.title = data.title();
        this.category = data.category();
        this.recipe = data.recipe();
    }
}
