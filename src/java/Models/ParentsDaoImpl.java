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
public class ParentsDaoImpl extends HibernateDaoSupport implements ParentsDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public Parents getParents(long parent_id) {
        return (Parents)this.sessionFactory.getCurrentSession().get(Parents.class, parent_id);
    }

    @Override
    @Transactional
    public List<Parents> listParents() {
        Criteria criteria=this.sessionFactory.getCurrentSession().createCriteria(Parents.class);
        return (List<Parents>)criteria.list();
    }

    
    @Override
    @Transactional
    public void updateParent(Parents parent) {
        this.sessionFactory.getCurrentSession().update(parent);
    }

    @Override
    @Transactional
    public void addParent(Parents parent) {
        this.sessionFactory.getCurrentSession().save(parent);
    }
    
    
    
    
}
