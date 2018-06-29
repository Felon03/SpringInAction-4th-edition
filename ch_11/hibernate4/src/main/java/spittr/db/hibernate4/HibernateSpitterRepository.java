package spittr.db.hibernate4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-28 15:21
 * Description: 借助Hibernate Session 实现不依赖于 Spring 的 Repository
 */
// @Repository注解的两个用途
// 1. @Repository是Spring的另一种构造性注解，可以被Spring组件扫描所扫描到
// 2. 捕获任何平台相关的异常并以Spring非检查型数据访问异常的形式重新抛出
// （需要添加 bean 后置处理器 PersistenceExceptionTranslationPostProcessor）
@Repository
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
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
    public Spitter save(Spitter spitter) {
        Serializable id = currentSession().save(spitter);
        return new Spitter((Long) id,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
    }

    @Override
    public Spitter findOne(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession()
                .createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) currentSession()
                .createCriteria(Spitter.class).list();
    }
}
