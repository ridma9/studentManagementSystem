package com.myapp.studentmanagementsystem;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Subject {

    private String subjectName;
    private int subjectCode;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Subject() {
    }

    public Subject(String subjectName, int subjectCode) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", subjectCode=" + subjectCode +
                '}';
    }
}
