package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.model.Student;
import org.example.model.utils.EntityManagerFactorySingleton;

import java.util.List;

public class StudentService {

        EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        public Student studentRegistration (Student student){
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            return student;
        }

        public Student findById(int id){
            return entityManager.find(Student.class, id);
        }

        public List<Student> findAll(){
            Query query = entityManager.createQuery("from Student");
            return query.getResultList();
        }

        public  Student update (Student student){
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            return student;
        }

        public void deleteById (Student student){
            entityManager.getTransaction().begin();
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        }

        public  void closeEntityManager(){
            entityManager.close();
        }
    }

