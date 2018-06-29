package spittr.db.hibernate4;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import spittr.db.SpittleRepository;
import spittr.domain.Spittle;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-28 15:45
 * Description: 借助Hibernate Session 实现不依赖于 Spring 的 Repository
 */

@Repository
public class HibernateSpittleRepository implements SpittleRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpittleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Spittle> findRecent(int count) {
        return (List<Spittle>) spittleCriteria()
                .setMaxResults(count)
                .list();
    }

    @Override
    public Spittle findOne(long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }

    @Override
    public Spittle save(Spittle spittle) {
        Serializable id = currentSession().save(spittle);
        return new Spittle((Long) id,
                spittle.getSpitter(),
                spittle.getMessage(),
                spittle.getPostedTime());
    }

    @Override
    public List<Spittle> findBySpitterId(long spitterId) {
        return spittleCriteria()
                .add(Restrictions.eq("spitter.id", spitterId))
                .list();
    }

    @Override
    public void delete(long id) {
        currentSession().delete(findOne(id));
    }

    public List<Spittle> findAll() {
        return (List<Spittle>) spittleCriteria().list();
    }

    private Criteria spittleCriteria() {
        return currentSession()
                .createCriteria(Spittle.class)
                .addOrder(Order.desc("postedTime"));
    }
}
