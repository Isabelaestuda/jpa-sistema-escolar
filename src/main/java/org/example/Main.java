package org.example;




import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CourseService;
import org.example.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService();

        int option = -1;

        while (option != 0){
            System.out.println("\n--- SISTEMA ESCOLAR ---");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Listar Turmas");
            System.out.println("3 - Atualizar Turmas");
            System.out.println("4 - Excluir Turmas");
            System.out.println("5 - Cadastrar Aluno");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Atualizar Aluno");
            System.out.println("8 - Excluir Aluno");


            option = teclado.nextInt();
            teclado.nextLine();

            switch (option){
                case 1:
                    System.out.print("Nome da Turma: ");
                    String nameC = teclado.nextLine();

                    System.out.print("Período: ");
                    String shiftC = teclado.nextLine();

                    courseService.courseRegistration (new Course (nameC, shiftC));
                    System.out.println("Turma cadastrada!");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE TURMAS NO BANCO ---");
                    courseService.findAll().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("ID da turma para atualizar: ");
                    int idC = teclado.nextInt();
                    teclado.nextLine();
                    Course cAlt = courseService.findById(idC);
                    if (cAlt != null) {
                        System.out.print("Novo Nome: ");
                        cAlt.setNameCourse(teclado.nextLine());

                        System.out.print("Período: ");
                        cAlt.setShift(teclado.nextLine());

                        courseService.update(cAlt);
                        System.out.println("Turma atualizada!");
                    } else {
                        System.out.println("Turma não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("ID da turma para excluir: ");
                    int idCDel = teclado.nextInt();
                    Course cDel = courseService.findById(idCDel);
                    if (cDel != null) {
                        courseService.deleteById(cDel);
                        System.out.println("Turma excluída!");
                    }
                    break;

                case 5:
                    System.out.print("Nome do Aluno: ");
                    String nameS = teclado.nextLine();
                    System.out.print("Email: ");
                    String emailS = teclado.nextLine();
                    System.out.print("ID da Turma deste aluno: ");
                    int idcourseSearch = teclado.nextInt();

                    Course courseFound = courseService.findById(idcourseSearch);
                    if (courseFound != null) {
                        Student newStudent = new Student(nameS, emailS, courseFound);
                        studentService.studentRegistration(newStudent);
                        System.out.println("Aluno matriculado com sucesso!");
                    } else {
                        System.out.println("Erro: Turma não existe. Cadastre a turma primeiro!");
                    }
                    break;

                case 6:
                    System.out.println("\n--- LISTA DE ALUNOS NO BANCO ---");
                    studentService.findAll().forEach(System.out::println);
                    break;

                case 7:

                    System.out.print("ID da aluno para atualizar: ");
                    int idS = teclado.nextInt();
                    teclado.nextLine();
                    Student sAlA = studentService.findById(idS);
                    if (sAlA != null) {
                        System.out.print("Novo Nome: ");
                        sAlA.setNameStudent(teclado.nextLine()
                        );

                        System.out.print("Email: ");
                        sAlA.setEmail(teclado.nextLine());

                        studentService.update(sAlA);
                        System.out.println("Aluno atualizada!");
                    } else {
                        System.out.println("Aluno não encontrada.");
                    }
                    break;



                case 8:
                    System.out.print("ID da aluno para excluir: ");
                    int idSDel = teclado.nextInt();
                    Student sDel = studentService.findById(idSDel);
                    if (sDel != null) {
                        studentService.deleteById(sDel);
                        System.out.println("Aluno excluída!");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    courseService.closeEntityManager();
                    studentService.closeEntityManager();
                    break;
            }
        }
        teclado.close();

    }
}