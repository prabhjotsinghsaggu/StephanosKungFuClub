/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chonzom_rapgay
 */
@Repository
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public Student getStudent(long stu_num) {
        
        return (Student)this.sessionFactory.getCurrentSession().get(Student.class,stu_num);
    }

    @Override
    @Transactional
    public List<Student> listStudent() {
        Criteria criteria=this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        return (List<Student>)criteria.list();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        this.sessionFactory.getCurrentSession().update(student);
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        this.sessionFactory.getCurrentSession().save(student);
    }
    
    @Override
    @Transactional
    public long getMeetNum(long stu_num)
    {
        Query q=this.sessionFactory.getCurrentSession().createSQLQuery("Select meet_id from Students where id="+stu_num);
        long meetnum=q.getFirstResult();
        return meetnum;
    }
    
    @Override
    @Transactional
    public long getRankNum(long stu_num)
    {
        Query q=this.sessionFactory.getCurrentSession().createSQLQuery("Select rank_id from Student where id="+stu_num);
        long ranknum=q.getFirstResult();
        return ranknum;
    }
    
    @Override
    @Transactional
    public long getParentNum(long stu_num)
    {
       Query q=this.sessionFactory.getCurrentSession().createSQLQuery("Select parent_id from Student where id="+stu_num);
        long pnum=q.getFirstResult();
        return pnum; 
    }
    
    
}
