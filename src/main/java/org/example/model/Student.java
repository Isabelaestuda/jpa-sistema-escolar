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

        @ManyToOne
        @JoinColumn (name = "idCource")
        private Course course;


        public Student() {
        }

        public Student(String nameStudent, String email, Course course) {
            this.nameStudent = nameStudent;
            this.email = email;
            this.course = course;
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

        public Course getTurma() {
            return course;
        }

        public void setTurma(Course course) {
            this.course = course;
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
            return "Aluno{" +
                    "id=" + id +
                    ", nameStudent='" + nameStudent + '\'' +
                    ", email='" + email + '\'' +
                    ", course=" + course +
                    '}';
        }
    }

