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
public interface MeetingDao {
    
    Meeting getMeeting(long meet_id);
    List<Meeting> listMeeting();
    void updateMeeting(Meeting meeting);
    void addMeeting(Meeting meeting);
    long getStuNum(long meet_id);
    
}
