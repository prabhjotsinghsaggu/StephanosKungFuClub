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
public interface FeesDao {
    
    Fees getFees(long fee_id);
    List<Fees> listFees();
    void changeStatus(Fees fees);
    void updateFees(Fees fees);
    void addFees(Fees fees);
    long getStudentNum(long fee_id);
}
