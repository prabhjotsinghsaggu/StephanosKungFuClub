/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author chonzom_rapgay
 */
public interface StudentDao {
    
    Student getStudent(long stu_num);
    List<Student> listStudent();
    void updateStudent(Student student);
    void addStudent(Student student);
    long getMeetNum(long stu_num);
    long getRankNum(long stu_num);
    long getParentNum(long stu_num);
    
}
