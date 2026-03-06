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

                    System.out.print("Digite os IDs dos cursos separados por vírgula (ex: 1,2): ");
                    String idsInput = teclado.nextLine();
                    String[] ids = idsInput.split(",");

                    Student newStudent = new Student(nameS, emailS);
                    boolean vinculouAlgum = false;

                    for (String idStr : ids) {
                        try {
                            int idBusca = Integer.parseInt(idStr.trim());
                            Course courseFound = courseService.findById(idBusca);
                            if (courseFound != null) {
                                newStudent.getCourses().add(courseFound);
                                vinculouAlgum = true;
                            } else {
                                System.out.println("Aviso: Curso ID " + idBusca + " não encontrado.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: '" + idStr + "' não é um ID válido.");
                        }
                    }

                    if (vinculouAlgum) {
                        studentService.studentRegistration(newStudent);
                        System.out.println("\n Aluno matriculado com sucesso!");
                        System.out.println("Cursos vinculados:");
                        newStudent.getCourses().forEach(c -> System.out.println("- " + c.getNameCourse()));
                    } else {
                        System.out.println(" Erro: Nenhum curso válido foi selecionado. Aluno não cadastrado.");
                    }
                    break;



                case 6:
                    System.out.println("\n--- LISTA DE ALUNOS NO BANCO ---");
                    studentService.findAll().forEach(System.out::println);
                    break;


                case 7:
                    System.out.print("ID do aluno para atualizar: ");
                    int idS = teclado.nextInt();
                    teclado.nextLine();

                    Student sAlA = studentService.findById(idS);
                    if (sAlA != null) {
                        System.out.println("Aluno encontrado: " + sAlA.getNameStudent());

                        System.out.print("Novo Nome: ");
                        sAlA.setNameStudent(teclado.nextLine());

                        System.out.print("Novo Email: ");
                        sAlA.setEmail(teclado.nextLine());

                        System.out.print("Digite os novos IDs dos cursos (ex: 1,2): ");
                        String idaInput = teclado.nextLine();
                        String[] ida = idaInput.split(",");

                        sAlA.getCourses().clear();

                        for (String idStr : ida) {
                            try {
                                int idBusca = Integer.parseInt(idStr.trim());
                                Course courseFound = courseService.findById(idBusca);
                                if (courseFound != null) {
                                    sAlA.getCourses().add(courseFound);
                                } else {
                                    System.out.println("Aviso: Curso ID " + idBusca + " não encontrado.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Erro: '" + idStr + "' não é um ID válido.");
                            }
                        }

                        studentService.update(sAlA);
                        System.out.println("\n Aluno atualizado com sucesso!");
                        System.out.println("Novos cursos vinculados:");
                        sAlA.getCourses().forEach(c -> System.out.println("- " + c.getNameCourse()));

                    } else {
                        System.out.println("Aluno não encontrado.");
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
