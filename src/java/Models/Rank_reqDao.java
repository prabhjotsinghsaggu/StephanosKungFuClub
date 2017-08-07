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

    public interface Rank_reqDao {
    
    Rank_req getRankreq(long req_num);
    List<Rank_req> listRankreq();
    void changeStatus(Rank_req req);
    void updateReq(Rank_req req);
    void addRankreq(Rank_req req);
    long getRankNum(long req_num);
}


