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
public class Rank_reqDaoImpl extends HibernateDaoSupport implements Rank_reqDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public Rank_req getRankreq(long req_num) {
       return (Rank_req)this.sessionFactory.getCurrentSession().get(Rank_req.class,req_num);
        
    }

    @Override
    @Transactional
    public List<Rank_req> listRankreq() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Rank_req.class);
        return (List<Rank_req>) criteria.list();
    }

    @Override
    @Transactional
    public void changeStatus(Rank_req req) {
        this.sessionFactory.getCurrentSession().update(req);
    }

    @Override
    @Transactional
    public void updateReq(Rank_req req) {
        this.sessionFactory.getCurrentSession().update(req);
    }

    @Override
    @Transactional
    public void addRankreq(Rank_req req) {
        this.sessionFactory.getCurrentSession().save(req);
    }
    
    @Override
    @Transactional
    public long getRankNum(long reqid) {
        Query q=this.sessionFactory.getCurrentSession().createSQLQuery("select rank_id from Rank_req where id="+reqid);
//        q.setLong("s", subid);
        long rankreq=q.getFirstResult();
        return rankreq;
                        
    }

   
    
    
    
    
    
    
}
