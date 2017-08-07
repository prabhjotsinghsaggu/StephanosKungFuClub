/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Fees;
import Models.FeesDao;
import Models.Meeting;
import Models.MeetingDao;
import Models.Parents;
import Models.ParentsDao;
import Models.Rank;
import Models.RankDao;
import Models.Rank_req;
import Models.Rank_reqDao;
import Models.Student;
import Models.StudentDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author chonzom_rapgay
 */
public class TestAdd {
        public static void main(String args[]){
        
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("file:web/WEB-INF/applicationContext.xml");

           Rank_reqDao odao=(Rank_reqDao)ctx.getBean("rank_reqDaoImpl");
           Rank_req ord=new Rank_req();
//           StudentDao sdao=(StudentDao)ctx.getBean("studentDaoImpl");
//           Student student=new Student();
//           student=sdao.getStudent(2);
           Rank r= new Rank();
           r.setRank_id(2);
           ord.setReq_desc("Beginner level-II");
           ord.setReq_num(1112);
//           ord.setStudent(student);

            ord.setRank(r);
            odao.addRankreq(ord);
           


    
}
}
