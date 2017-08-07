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
import javax.persistence.Table;

/**
 *
 * @author chonzom_rapgay
 */
@Entity
@Table(name="Rank")
public class Rank {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="rank_id")
    private long rank_id;
    
    @Column(name="rank_name")
    private String rank_name;
    
    @Column(name="rank_belt")
    private String rank_belt;
    
    @OneToMany(mappedBy="rank")
    private List<Rank_req> req; 
    
    @OneToMany(mappedBy="rank")
    private  List<Student> student;
    
    
    
//    @ManyToMany(mappedBy="rank")
//    private List<Student> student;

//    public List<Student> getStudent() {
//        return student;
//    }
//
//    public void setStudent(List<Student> student) {
//        this.student = student;
//    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
    

    
    
    
    public long getRank_id() {
        return rank_id;
    }

    public void setRank_id(long rank_id) {
        this.rank_id = rank_id;
    }

    public String getRank_name() {
        return rank_name;
    }

    public void setRank_name(String rank_name) {
        this.rank_name = rank_name;
    }

    public String getRank_belt() {
        return rank_belt;
    }

    public void setRank_belt(String rank_belt) {
        this.rank_belt = rank_belt;
    }

    public List<Rank_req> getReq() {
        return req;
    }

    public void setReq(List<Rank_req> req) {
        this.req = req;
    }
    
    
    
}
