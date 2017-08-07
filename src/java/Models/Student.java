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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
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
@Table(name="Student")
public class Student {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="stu_num")
    private long stu_num;
    
    @Column(name="dob")
    private String dob;
    
    @Column(name="stu_name")
    private String stu_name;
    
    @Column(name="join_date")
    private String join_date;
    
    @Column(name="mob_no")
    private String mob_no;
    
    @OneToMany(mappedBy="student")
    private List<Fees> fees;
    
//    @ManyToMany
//    @JoinTable(name="Attendence", joinColumns={@JoinColumn(name="stu_num")}
//            , inverseJoinColumns={@JoinColumn(name="meet_id")})
//    private List<Meeting> meeting;
   
    
//    @ManyToMany
//    @JoinTable(name="Attains", joinColumns={@JoinColumn(name="stu_num")} 
//           , inverseJoinColumns={@JoinColumn(name="rank_id")})
//    private List<Rank> rank;
    
    @OneToMany(mappedBy="student")
    private List<Parents> parents;
    
    
    
    @ManyToOne
    @JoinColumn(name="rank_id")
    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
    
    

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }
    
    
//
//    public List<Rank> getRank() {
//        return rank;
//    }
//
//    public void setRank(List<Rank> rank) {
//        this.rank = rank;
//    }

    
    
//    public List<Meeting> getMeeting() {
//        return meeting;
//    }
//    
//
//    public void setMeeting(List<Meeting> meeting) {
//        this.meeting = meeting;
//    }

    public List<Fees> getFees() {
        return fees;
    }

    public void setFees(List<Fees> fees) {
        this.fees = fees;
    }
    
     

    public long getStu_num() {
        return stu_num;
    }

    public void setStu_num(long stu_num) {
        this.stu_num = stu_num;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="email")
    private String email;
    
    @Column(name="address")
    private String address;
    
   
    
}
