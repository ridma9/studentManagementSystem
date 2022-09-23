package com.myapp.studentmanagementsystem;

import Exceptions.StudentNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {


    public void writeToFile(Student student) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(student.getName()+".txt"),student);
    }

    
    public List<Student> readFromFile() throws IOException {
        List<Student> studentList = new ArrayList<>();
        File folder = new File("E:\\Coding\\StudentManagementSystem\\");

        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".txt")){
                ObjectMapper mapper = new ObjectMapper();
                Student s = mapper.readValue(new File(file.getAbsolutePath()),Student.class);

                studentList.add(s);
            }
        }
        return studentList;
    }

    public void deleteFile(Student student) throws IOException {
        Path newFile = Paths.get("E:\\Coding\\StudentManagementSystem\\"+student.getName()+".txt");
        newFile.toFile().delete();
    }

    public List<Student> searchStudent(String name) throws IOException {
        boolean found=false;
        List<Student> resultStudentList = new ArrayList<>();
        File folder = new File("E:\\Coding\\StudentManagementSystem\\");
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".txt")){
                ObjectMapper mapper = new ObjectMapper();
                Student s = mapper.readValue(new File(file.getAbsolutePath()),Student.class);
                if (s.getName().equals(name)){
                    resultStudentList.add(s);
                    found=true;
                }
            }
        }
        if (found==false){
            throw new StudentNotFoundException("Student Not Found");
        }
        return resultStudentList;
    }

    public void writeSubjectToFile(Subject subject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("E:\\Coding\\StudentManagementSystem\\Subjects\\"+subject.getSubjectName()+".txt"),subject);
    }

    public List<Subject> readSubjectFromFile() throws IOException {
        List<Subject> subjectList = new ArrayList<>();
        File folder = new File("E:\\Coding\\StudentManagementSystem\\Subjects\\");

        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".txt")){
                ObjectMapper mapper = new ObjectMapper();
                Subject sub = mapper.readValue(new File(file.getAbsolutePath()),Subject.class);
                //System.out.println(s);
                subjectList.add(sub);
            }
        }
        return subjectList;
    }

    public void deleteSubjectFile(Subject subject) throws IOException {
        Path newFile = Paths.get("E:\\Coding\\StudentManagementSystem\\"+subject.getSubjectName());
        newFile.toFile().delete();
    }


}
