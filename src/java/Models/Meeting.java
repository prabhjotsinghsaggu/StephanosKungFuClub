/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author chonzom_rapgay
 */
@Entity
@Table(name="Meeting")
public class Meeting {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="meet_id")
    private long meet_id;
    
    @Column(name="meet_date")
    private String meet_date;
   
    @Column(name="class_id")
    private String class_id;
    
    @Column(name="class_level")
    private String class_level;
    
    
    @OneToOne
    @JoinColumn(name="stu_num")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_level() {
        return class_level;
    }

    public void setClass_level(String class_level) {
        this.class_level = class_level;
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
    
    
    
   
    
    
    

    public long getMeet_id() {
        return meet_id;
    }

    public void setMeet_id(long meet_id) {
        this.meet_id = meet_id;
    }

    public String getMeet_date() {
        return meet_date;
    }

    public void setMeet_date(String meet_date) {
        this.meet_date = meet_date;
    }

//    public List<Student> getStudent() {
//        return student;
//    }
//
//    public void setStudent(List<Student> student) {
//        this.student = student;
//    }
    
    
    
    
}
