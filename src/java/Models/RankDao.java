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
public interface RankDao {
    
    Rank getRank(long rank_id);
    List<Rank> listRank();
    void updateRank(Rank rank);
    void addRank(Rank rank);
//    long getRankreq(long rank_id);
   
    
}