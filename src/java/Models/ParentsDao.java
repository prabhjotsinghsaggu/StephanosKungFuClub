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

public interface ParentsDao {
    
    Parents getParents(long parent_id);
    List<Parents> listParents();
    void updateParent(Parents parent);
    void addParent(Parents parent);
    
}
