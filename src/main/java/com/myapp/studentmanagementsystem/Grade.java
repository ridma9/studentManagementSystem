package com.myapp.studentmanagementsystem;

import java.io.IOException;
import java.util.*;

public class Grade implements Comparator<Student> {

    FileHandler fileHandler=new FileHandler();


    public  void findMarksAll() throws IOException {
        List<Student> studentList=fileHandler.readFromFile();
        int i=0;
        for (Student student:studentList) {
            Integer total = findTotal(student);
            String name =student.getName();
            System.out.println(student.getName()+" - Total marks = " +total);
        }
    }
    public int findTotal(Student student){
        int total=0;
        //System.out.println(student.getSubjects().values());
        for (int value: student.getSubjects().values()){
            total +=value;
        }
        return total;
    }
    public void findGrades() throws IOException {
        List<Student> studentList=fileHandler.readFromFile();
        int i = 1;

        Collections.sort(studentList,new Grade());

        for (Student student:studentList) {
            Integer total = findTotal(student);
            String name =student.getName();
            System.out.println(i+" "+name+"  Total marks = " +total);
            i ++;
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        Integer total_1 = this.findTotal(o1);
        Integer total_2 = this.findTotal(o2);
        return total_2.compareTo(total_1);
    }


}
