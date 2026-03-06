package org.example.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_course")

public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column (name = "nameCourse ")
        private String nameCourse ;

        @Column (name = "shift")
        private String shift;


    @ManyToMany(mappedBy = "courses")
    private java.util.List<Student> students = new java.util.ArrayList<>();



    public Course(){

        }
        public Course(String nameCourse, String shift) {
            this.nameCourse = nameCourse;
            this.shift = shift;
        }

        public int getId() {
            return id;
        }


        public void setId(int id) {
            this.id = id;
        }


        public String getNameCourse() {
            return nameCourse;
        }


        public void setNameCourse(String nameCourse) {
            this.nameCourse = nameCourse;
        }


        public String getShift() {
            return shift;
        }


        public void setShift(String shift) {
            this.shift = shift;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Course course = (Course) o;
            return id == course.id;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }

        @Override
        public String toString() {
            return "Course{" +
                    "id=" + id +
                    ", nameCourse='" + nameCourse + '\'' +
                    ", shift='" + shift + '\'' +
                    '}';
        }
    }

