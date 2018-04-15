package com.yummyrecipe.Yummy.Recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="yummy-recipes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Recipes implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Long id;

    @NotBlank
    private  String recipeName;
    @Column(nullable = false)

    @NotBlank
    private  String recipeDetails;
    @Column(nullable = false)
    @CreatedDate

    private Date createdAt;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)

    @LastModifiedDate
    private Date updatedAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDetails() {
        return recipeDetails;
    }

    public void setRecipeDetails(String recipeDetails) {
        this.recipeDetails = recipeDetails;
    }
}
