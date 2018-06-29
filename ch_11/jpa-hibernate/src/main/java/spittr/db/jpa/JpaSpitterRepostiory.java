package spittr.db.jpa;

import org.springframework.stereotype.Repository;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 10:18
 * Description: 不使用 Spring 模板的纯 JPA Repository
 */

@Repository
public class JpaSpitterRepostiory implements SpitterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        if (spitter.getId() == null) {
            entityManager.persist(spitter);
        } else {
            entityManager.merge(spitter);
        }
        return spitter;
    }

    @Override
    public Spitter findOne(long id) {
        return entityManager.find(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) entityManager.createQuery("select s from Spitter s where s.username=?")
                .setParameter(1, username).getSingleResult();
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) entityManager.createQuery("select s from Spitter s").getResultList();
    }
}
