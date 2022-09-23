package com.myapp.studentmanagementsystem;

import Exceptions.StudentNotFoundException;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();
        Display display = new Display();
        Scanner input = new Scanner(System.in);
        Grade grade = new Grade();

        while (true){
            display.message("Choose option : ");
            display.message("Enter 1 for Add Student ");
            display.message("Enter 2 for Delete Student ");
            display.message("Enter 3 for View All Students ");
            display.message("Enter 4 for Search Student ");
            display.message("Enter 5 for Add Subject ");
            display.message("Enter 6 for Add Marks ");
            display.message("Enter 7 for Final Grades ");
            display.message("Enter 8 for Exit ");


            String opt;
            opt=input.next();
            try {
                Integer.parseInt(opt);
                try {
                    int option= Integer.parseInt(String.valueOf(opt));
                    if (option == 1) {
                        display.message("Enter name : ");
                        int id = 1;
                        String name = input.next();
                        display.message("Enter id : ");
                        id = input.nextInt();
                        Student student = new Student(id, name);
                        System.out.println(student.toString());
                        fileHandler.writeToFile(student);
                        continue;
                    } else if (option == 2) {
                        List<Student> studentList=new ArrayList<>();
                        System.out.println("Delete Student");
                        display.message("Enter student Name : ");
                        String name = input.next();
                        studentList = fileHandler.searchStudent(name);
                        for (Student student:studentList) {
                            fileHandler.deleteFile(student);
                        }
                    } else if (option==3) {
                        List<Student> studentList=fileHandler.readFromFile();
                        for (Student s:studentList) {
                            System.out.println(s);
                        }
                    } else if (option == 4) {
                        List<Student> studentList=fileHandler.readFromFile();
                        display.message("Enter student Name : ");
                        String name = input.next();
                        studentList=fileHandler.searchStudent(name);
                        for (Student student:studentList) {
                            System.out.println(student);
                        }
                    } else if (option == 5) {
                        display.message("Enter Subject Name : ");
                        String name = input.next();
                        display.message("Enter id : ");
                        int code = input.nextInt();
                        Subject subject = new Subject(name,code);
                        fileHandler.writeSubjectToFile(subject);

                    } else if (option==6) {
                        List<Student> studentList=fileHandler.readFromFile();
                        display.message("Enter student Name : ");
                        String name = input.next();
                        display.message("Enter Subject Name : ");
                        String subjectName = input.next();
                        display.message("Enter Marks : ");
                        int marks = input.nextInt();
                        studentList=fileHandler.searchStudent(name);
                        for (Student student:studentList) {
                            student.setSubjectMarks(name,marks);
                        }
                    } else if (option == 7) {
                        grade.findGrades();
                    } else if (option == 8) {
                        System.out.println("Ended");
                        break;
                    }
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }catch (InputMismatchException e){
                    System.out.println("Invalid Input, Try Again...");
                }catch (StudentNotFoundException e){
                    System.out.println(e.getMessage());
                }

            }catch (NumberFormatException e){
                System.out.println("Invalid Input, Try Again...");
            }





        }









































/*
        Student st1 = new Student(1,"carl");
        Student st2 = new Student(2,"john");
        Student st3 = new Student(3,"peter");


        FileHandler fileHandler = new FileHandler();

        try {
            System.out.println("=============Add=============");
            fileHandler.writeToFile(st1);
            fileHandler.writeToFile(st2);
            fileHandler.writeToFile(st3);

            System.out.println("=============ListAll=============");
            List<Student> studentList=fileHandler.readFromFile();
            for (Student s:studentList) {
                System.out.println(s);
            }
            /*
            System.out.println("=============Search=============");
            studentList=fileHandler.searchStudent("carl");
            for (Student student:studentList) {
                System.out.println(student);
            }



            System.out.println("=============Delete=============");
            //fileHandler.deleteFile(st1);

            System.out.println("=============AddSubject=============");

            Subject maths = new Subject("Maths",101);
            Subject english = new Subject("English",102);
            fileHandler.writeSubjectToFile(maths);
            fileHandler.writeSubjectToFile(english);

            System.out.println("=============ListSubject=============");
            List<Subject> subjectList =fileHandler.readSubjectFromFile();
            for (Subject sub:subjectList) {
                System.out.println(sub);
            }


            st1.setSubjectMarks("Maths",80);
            st1.setSubjectMarks("English",60);
            st1.setSubjectMarks("History",90);
            st2.setSubjectMarks("Maths",50);
            st2.setSubjectMarks("English",10);
            st3.setSubjectMarks("History",100);




            grade.findMarksAll();
            grade.findGrades();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

*/



    }
}