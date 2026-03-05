package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.model.Course;
import org.example.model.utils.EntityManagerFactorySingleton;

import java.util.List;

public class CourseService {
        EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Course courseRegistration (Course course){
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        return course;
    }

        public Course findById (int id){
            return  entityManager.find(Course.class,id);
        }

        public List<Course> findAll(){
            Query query = entityManager.createQuery("from Course");
            return query.getResultList();
        }

        public Course update (Course course){
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            return course;
        }

        public  void  deleteById(Course course){
            entityManager.getTransaction().begin();
            entityManager.remove(course);
            entityManager.getTransaction().commit();
        }

        public void closeEntityManager(){
            entityManager.close();
        }


    }

