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
public class MeetingDaoImpl extends HibernateDaoSupport implements MeetingDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Meeting getMeeting(long meet_id) {
        return (Meeting)this.sessionFactory.getCurrentSession().get(Meeting.class,meet_id);
    }

    @Override
    @Transactional
    public List<Meeting> listMeeting() {
        Criteria criteria= this.sessionFactory.getCurrentSession().createCriteria(Meeting.class);
        return (List<Meeting>)criteria.list();
    }

    @Override
    @Transactional
    public void updateMeeting(Meeting meeting) {
        this.sessionFactory.getCurrentSession().update(meeting);
    }

    @Override
    @Transactional
    public void addMeeting(Meeting meeting) {
        this.sessionFactory.getCurrentSession().save(meeting);
    }
    
    @Override
    @Transactional
    public long getStuNum(long meet_id)
    {
        Query q=this.sessionFactory.getCurrentSession().createQuery("select stu_num from Meeting where id="+meet_id);
        long classnum=q.getFirstResult();
        return classnum;
    }
    
    
    
}
