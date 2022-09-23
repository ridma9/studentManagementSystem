package com.myapp.studentmanagementsystem;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private int id;
    private String name;
    private String grade;
    Map<String,Integer> subjects = new HashMap<String,Integer>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student() {
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjectMarks(String subname, Integer marks) throws IOException {
        subjects.put(subname,marks);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(this.getName()+".txt"),this);
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getGrade() {
        return grade;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", subjects=" + subjects.toString() +
                '}';
    }
}
