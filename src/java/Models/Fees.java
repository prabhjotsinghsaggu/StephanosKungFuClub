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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author chonzom_rapgay
 */
@Entity
@Table(name="Fees")
public class Fees {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="fee_id")
    private long fee_id;
    
    @Column(name="fee_type")
    private String fee_type;
    
    @Column(name="fee_amount")
    private String fee_amount;
    
    @Column(name="pay_date")
    private String pay_date;
    
    @ManyToOne
    @JoinColumn(name="stu_num")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    

    public long getFee_id() {
        return fee_id;
    }

    public void setFee_id(long fee_id) {
        this.fee_id = fee_id;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getFee_amount() {
        return fee_amount;
    }

    public void setFee_amount(String fee_amount) {
        this.fee_amount = fee_amount;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }
     
   
    
}
