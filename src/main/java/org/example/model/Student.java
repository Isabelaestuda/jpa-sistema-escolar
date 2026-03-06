package org.example.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

    @Entity
    @Table(name = "tb_student")

    public class Student implements Serializable{
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column (name = "nameStudent")
        private String nameStudent;

        @Column (name = "email")
        private String email;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "student_courses",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id")
        )
        private java.util.List<Course> courses = new java.util.ArrayList<>();

        public Student(String nameStudent, String email) {
            this.nameStudent = nameStudent;
            this.email = email;
        }

        public java.util.List<Course> getCourses() {
            return courses;
        }

        public void setCourses(java.util.List<Course> courses) {
            this.courses = courses;
        }



        public Student() {
        }




        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNameStudent() {
            return nameStudent;
        }

        public void setNameStudent(String nameStudent) {
            this.nameStudent = nameStudent;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }



        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Student aluno = (Student) o;
            return id != null && id.equals(aluno.id);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }

        @Override
        public String toString() {
            String nomesCursos = courses.stream()
                    .map(Course::getNameCourse)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("Nenhum curso");

            return "Aluno{" +
                    "id=" + id +
                    ", nome='" + nameStudent + '\'' +
                    ", email='" + email + '\'' +
                    ", cursos=[" + nomesCursos + "]" +
                    '}';
        }
    }

