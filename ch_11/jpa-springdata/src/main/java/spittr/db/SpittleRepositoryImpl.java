package spittr.db;

import spittr.domain.Spittle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 14:36
 * Description: 混合自定义的功能
 */
public class SpittleRepositoryImpl implements SpittleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Spittle> findRecent(int count) {
        return (List<Spittle>) entityManager.createQuery("select s from Spittle s order by s.postedTime desc")
                .setMaxResults(count)
                .getResultList();
    }
}
