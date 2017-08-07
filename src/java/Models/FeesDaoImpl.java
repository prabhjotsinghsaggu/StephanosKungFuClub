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
public class FeesDaoImpl extends HibernateDaoSupport implements FeesDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public Fees getFees(long fee_id) {
        return (Fees)this.sessionFactory.getCurrentSession().get(Fees.class,fee_id);
        
    }

    @Override
    @Transactional
    public List<Fees> listFees() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Fees.class);
        return (List<Fees>) criteria.list();
    }

    @Override
    @Transactional
    public void changeStatus(Fees fees) {
        this.sessionFactory.getCurrentSession().update(fees);
    }

    @Override
    @Transactional
    public void updateFees(Fees fees) {
        this.sessionFactory.getCurrentSession().update(fees);
    }

    @Override
    @Transactional
    public void addFees(Fees fees) {
        this.sessionFactory.getCurrentSession().save(fees);
    }
    
    @Override
    @Transactional
    public long getStudentNum(long feeid) {
        Query q=this.sessionFactory.getCurrentSession().createSQLQuery("select stu_num from Fees where id="+feeid);
//        q.setLong("s", subid);
        long stu=q.getFirstResult();
        return stu;
                        
    }

   
    
    
    
    
    
    
}