package co.develhope.CRUD_esercizio.entities;

import javax.persistence.*;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private Long id;
    private String modelName;
    private String type;

    public Car() {
    }

    public Car(Long id, String modelName, String type) {
        this.id = id;
        this.modelName = modelName;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
