/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author chonzom_rapgay
 */
@Entity
@Table(name="Rank_req")
public class Rank_req {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="req_num")
    private long req_num;
    
    @Column(name="req_desc")
    private String req_desc;
    
    @ManyToOne
    @JoinColumn(name="rank_id")
    private Rank rank;

    public long getReq_num() {
        return req_num;
    }

    public void setReq_num(long req_num) {
        this.req_num = req_num;
    }

    public String getReq_desc() {
        return req_desc;
    }

    public void setReq_desc(String req_desc) {
        this.req_desc = req_desc;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
    
}
