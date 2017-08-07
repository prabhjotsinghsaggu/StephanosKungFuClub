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
import Models.MemberDAO;
import Models.Members;
import Models.Parents;
import Models.ParentsDao;
import Models.Rank;
import Models.RankDao;
import Models.Rank_req;
import Models.Rank_reqDao;
import Models.Student;
import Models.StudentDao;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author chonzom_rapgay
 */
public class ControllerWithAnnotation {
   
    @RequestMapping(value="/admin", method=RequestMethod.GET) 
    public String admin(HttpServletRequest request){
    String uri = request.getRequestURI();
    return "admin";  
            }
    
    @RequestMapping(value="/myhome", method=RequestMethod.GET)
    public String loghome(HttpServletRequest req)
    {
        String uri=req.getRequestURI();
        int flag=0;
        String aname=req.getParameter("name");
        String apassword=req.getParameter("password");

        int uid = 0;
        ServletContext context = req.getServletContext();
         System.out.println("------------------ context : "+context+" -----------"); 
         //if(context != null){
          ApplicationContext ctx =  
                    WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            MemberDAO mdao=(MemberDAO)ctx.getBean("memberDAOImpl");  
            
              
        List<Members> members=null;        
        try
        {
            members=(List<Members>)mdao.listMembers();
        
        }catch(org.hibernate.HibernateException e)
        {
            System.out.println(e);
        }
        
        for(Members m : members)
        {
              uid=m.getId();
        if(aname.equals(m.getUsername()) & apassword.equals(m.getPassword()) )
        {
        flag=1;
       break;
        }
        }
        if(flag==1)
        {
            HttpSession session=req.getSession();
            session.setAttribute("aname", aname);
            session.setAttribute("uid", uid);
            System.out.println("the user id is in login page "+uid);
            return "myhome";
        }
        else
        {
            System.out.println("invalid login ......");
            return "error";
        }   
    }
        @RequestMapping(value="/viewStudents" ,method=RequestMethod.GET)
         public String viewStudents(HttpServletRequest req){
    
         ServletContext context = req.getServletContext();
        if(context != null){
          ApplicationContext ctx =  
                    WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao dao=(StudentDao)ctx.getBean("studentDaoImpl");
//            FeesDao fdao=(FeesDao)ctx.getBean("feesDaoImpl");
            
            
            System.out.println("this is the dao bean!!");
            List<Student> stuli=null;
            try{
            stuli=dao.listStudent();
            System.out.println("we have function listStudent()");
            
                
                req.setAttribute("li", stuli);
                System.out.println("student is viewed!!!");
            }catch(org.hibernate.HibernateException e){
                System.out.println(e);
            }
            
            System.out.println("view a student");
            String uri=req.getRequestURI();
        }
        return "viewStudents";
    }
         
         @RequestMapping(value="/view_stu",method=RequestMethod.GET)
        public String view_stu(HttpServletRequest req){
        ServletContext context=req.getServletContext();
        if(context!=null){
              ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao sdao=(StudentDao)ctx.getBean("studentDaoImpl");
            long stu_id=0;
            stu_id=Long.parseLong(req.getParameter("sid"));
            Student s=new Student();
            s=sdao.getStudent(stu_id);
//          RankDao rdao=(RankDao)ctx.getBean("rankDaoImpl");
          
            
            try{
                req.setAttribute("ob",s);
            }catch(org.hibernate.HibernateException e){
                System.out.println(e);
            }
            String uri=req.getRequestURI();
        }
        return "view_stu";
    }
    
    @RequestMapping(value = "/add_stu", method = RequestMethod.GET)
     public String add_stu(HttpServletRequest req) {
     
        
         ServletContext context =req.getServletContext();
        if(context!=null){
            ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        StudentDao dao=(StudentDao)ctx.getBean("studentDaoImpl");
        Student c=new Student();
        
         try{
              List<Student> cat=null;
              cat=dao.listStudent();
              req.setAttribute("li",cat);
             }catch(org.hibernate.HibernateException e){
                System.out.println(e);
            }
        
        }
     return "add_stu";
   }
     
     @RequestMapping(value="/addstu" ,method=RequestMethod.GET)
     public String addstu(HttpServletRequest req)
     {
         ServletContext context = req.getServletContext();
        if(context != null){
          ApplicationContext ctx =  
                    WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao dao=(StudentDao)ctx.getBean("studentDaoImpl");  
            
            ApplicationContext ctx1 =  
                    WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao sdao=(StudentDao)ctx1.getBean("studentDaoImpl");  
            String stu_name=req.getParameter("stu_name");
            String stu_num=req.getParameter("stu_num");
            String dob=req.getParameter("dob");
            String mob_no=req.getParameter("mob_no");
            String join_date=req.getParameter("join_date");
            String email=req.getParameter("email");
            String address=req.getParameter("address");
            String rank=req.getParameter("rank");
//            Long stu_num=Long.parseLong(req.getParameter("stu_num"));
            Long id=Long.parseLong(stu_num);
            Student s = new Student();
            s.setStu_num(id);
            s.setAddress(address);
            s.setDob(dob);
            s.setEmail(email);
            s.setJoin_date(join_date);
            s.setMob_no(mob_no);
            s.setStu_name(stu_name);
            
          
          
//            s.setStudent();

            dao.addStudent(s);
            
            System.out.println("Added a student");
//            List<Student> list = dao.listStudent();
//            req.setAttribute("stuList", stuli);
        }
        
      return "added_student";   
     
     }
     
     @RequestMapping(value="/editStudent", method=RequestMethod.GET)
    public String editStudent(HttpServletRequest req){
       
        //long id=0;
        ServletContext context =req.getServletContext();
        if(context!=null){
            ApplicationContext ctx= WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao odao=(StudentDao)ctx.getBean("studentDaoImpl");
            Student stu=new Student();
            long stu_num=0;
            stu_num=Long.parseLong(req.getParameter("sid"));
            stu=odao.getStudent(stu_num);
            req.setAttribute("stu",stu);
            
        }  
        return "edit_student";
    }
    
     
     @RequestMapping(value="/editStu" ,method=RequestMethod.GET)
    public String editStu(HttpServletRequest request, HttpServletResponse response)
    {
         ServletContext context = request.getServletContext();
ApplicationContext ctx =  
                    WebApplicationContextUtils.getRequiredWebApplicationContext(context);
         StudentDao sdao=(StudentDao)ctx.getBean("studentDaoImpl");  
         Student s=new Student();
         long stu_num=Long.parseLong(request.getParameter("stu_num"));
         Student stu=sdao.getStudent(stu_num);
//         System.out.println("inside update mem controller....");
//         System.out.println(request.getParameter("address"));
//         System.out.println(request.getParameter("stu_name"));
         s.setAddress(request.getParameter("address"));
         s.setDob(request.getParameter("dob"));
         s.setEmail(request.getParameter("email"));
         s.setJoin_date(request.getParameter("join_date"));
         s.setMob_no(request.getParameter("mob_no"));
         s.setStu_name(request.getParameter("stu_name"));
         s.setStu_num(stu_num);
        
         sdao.updateStudent(s);
         List<Student> list = sdao.listStudent();
         request.setAttribute("stuList", list);
         return "updated_stu";
    
    }
    
    
    @RequestMapping(value="/fees", method=RequestMethod.GET)
    public String fees(HttpServletRequest req)
    {
       ServletContext context=req.getServletContext();
        if(context!=null){
              ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao sdao=(StudentDao)ctx.getBean("studentDaoImpl");
            FeesDao fdao=(FeesDao)ctx.getBean("feesDaoImpl");
            
//            Student s=new Student();
            Fees f=new Fees();
            
            List<Fees> feeli=null;
//            long stu_num=fdao.getStudentNum(0);
            
            
            
            try{
                feeli=fdao.listFees();
                req.setAttribute("ob",feeli);
            }catch(org.hibernate.HibernateException e){
                System.out.println(e);
            }
            String uri=req.getRequestURI();
        }
        return "fee_list";
    }
    
    
    @RequestMapping(value="/parents", method=RequestMethod.GET)
    public String parents(HttpServletRequest req)
    {
       ServletContext context=req.getServletContext();
        if(context!=null){
              ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao sdao=(StudentDao)ctx.getBean("studentDaoImpl");
            ParentsDao fdao=(ParentsDao)ctx.getBean("parentsDaoImpl");
            
//            Student s=new Student();
            Parents f=new Parents();
            
            List<Parents> par=null;
//            long stu_num=fdao.getStudentNum(0);
            
            
            
            try{
                par=fdao.listParents();
                req.setAttribute("ob",par);
            }catch(org.hibernate.HibernateException e){
                System.out.println(e);
            }
            String uri=req.getRequestURI();
        }
        return "parents";
    }
    
    @RequestMapping(value="/attendance",method=RequestMethod.GET)
    public String attendance(HttpServletRequest req)
    {
         ServletContext context=req.getServletContext();
        if(context!=null){
              ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao sdao=(StudentDao)ctx.getBean("studentDaoImpl");
            MeetingDao fdao=(MeetingDao)ctx.getBean("meetingDaoImpl");
            
//            Student s=new Student();
            Meeting f=new Meeting();
            
            List<Meeting> meet=null;
//            long stu_num=fdao.getStudentNum(0);
            
            
            
            try{
                meet=fdao.listMeeting();
                req.setAttribute("ob",meet);
            }catch(org.hibernate.HibernateException e){
                System.out.println(e);
            }
            String uri=req.getRequestURI();
        }
        return "attendance";
        
    }
    
    @RequestMapping(value="/rank",method=RequestMethod.GET)
    public String rank(HttpServletRequest req)
    {
         ServletContext context=req.getServletContext();
        if(context!=null){
              ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao sdao=(StudentDao)ctx.getBean("studentDaoImpl");
            RankDao fdao=(RankDao)ctx.getBean("rankDaoImpl");
            
//            Student s=new Student();
            Rank f=new Rank();
            
            List<Rank> rank=null;
//            long stu_num=fdao.getStudentNum(0);
            
            
            
            try{
                rank=fdao.listRank();
                req.setAttribute("ob",rank);
            }catch(org.hibernate.HibernateException e){
                System.out.println(e);
            }
            String uri=req.getRequestURI();
        }
        return "rank";
        
    }
    
    
    
    @RequestMapping(value="/req", method=RequestMethod.GET)
    public String req(HttpServletRequest req)
    {
       ServletContext context=req.getServletContext();
        if(context!=null){
              ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            RankDao sdao=(RankDao)ctx.getBean("rankDaoImpl");
            Rank_reqDao fdao=(Rank_reqDao)ctx.getBean("rank_reqDaoImpl");
            
//            Student s=new Student();
            Rank_req f=new Rank_req();
            long rid=Long.parseLong(req.getParameter("rid"));
             Rank r=new Rank();
             f=fdao.getRankreq(rid);
            
                    
            
            
            try{
                
                req.setAttribute("ob",f);
            }catch(org.hibernate.HibernateException e){
                System.out.println(e);
            }
            String uri=req.getRequestURI();
        }
        return "req";
    }
    
    @RequestMapping(value="/add_parents",method=RequestMethod.GET)
    public String add_parents(HttpServletRequest req)
    {
        ServletContext context=req.getServletContext();
        if(context!=null){
              ApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(context);
              StudentDao sdao=(StudentDao)ctx.getBean("studentDaoImpl");
//              RankDao rdao=(RankDao)ctx.getBean("rankDaoImpl");
              ParentsDao pdao=(ParentsDao)ctx.getBean("parentsDaoImpl");
              Parents p=new Parents();
              Student stu=new Student();
              StudentDao odao=(StudentDao)ctx.getBean("studentDaoImpl");
            long stu_num=0;
            stu_num=Long.parseLong(req.getParameter("sid"));
            stu=odao.getStudent(stu_num);
            req.setAttribute("stu",stu);
              try{
              List<Parents> par=null;
              par=pdao.listParents();
//              req.setAttribute("par",par);
        }catch(org.hibernate.HibernateException e){
            e.printStackTrace();
        }
        }
        return "add_parents";
                       
        
    }
    
    @RequestMapping(value="/addpar",method=RequestMethod.GET)
    public String addpar(HttpServletRequest req)
    {
         ServletContext context = req.getServletContext();
        if(context != null){
          ApplicationContext ctx =  
                    WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            StudentDao dao=(StudentDao)ctx.getBean("studentDaoImpl");  
            
            ApplicationContext ctx1 =  
                    WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            ParentsDao pdao=(ParentsDao)ctx.getBean("parentsDaoImpl");
            Parents p=new Parents();
    
            Long parent_id=Long.getLong(req.getParameter("parent_id"));
            String address=req.getParameter("address");
            String email=req.getParameter("email");
            Long stu_num=Long.getLong(req.getParameter("stu_num"));
            p.setAddress(address);
            p.setEmail(email);
            Student student=new Student();
            
            p.setParent_id(parent_id);
            p.setStudent(student);
            pdao.addParent(p);
            System.out.println("Add parents");
        }
        return "added_stu";
    }
          
    
   
    

    
}
    

