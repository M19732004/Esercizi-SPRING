package co.develhope.hybernate.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name ="student_id",nullable = false,insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    @JoinColumn(name ="school_class_id",nullable = false,insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private SchoolClass schoolClass;

}