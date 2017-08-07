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
public class RankDaoImpl extends HibernateDaoSupport implements RankDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public Rank getRank(long rank_id) {
       return (Rank)this.sessionFactory.getCurrentSession().get(Rank.class,rank_id);
        
    }

    @Override
    @Transactional
    public List<Rank> listRank() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Rank.class);
        return (List<Rank>) criteria.list();
    }


    @Override
    @Transactional
    public void updateRank(Rank rank) {
        this.sessionFactory.getCurrentSession().update(rank);
    }

    @Override
    @Transactional
    public void addRank(Rank rank) {
        this.sessionFactory.getCurrentSession().save(rank);
    }
    
//    @Override
//    @Transactional
//    public long getStudent(long rank_id){
//        
//       Query q= this.sessionFactory.getCurrentSession().createQuery("select ");
//    }
    
    
    
}
