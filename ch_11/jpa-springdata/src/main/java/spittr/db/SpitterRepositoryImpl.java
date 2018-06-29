package spittr.db;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 14:22
 * Description: 当所需要的 Repository 所提供的功能是无法用 Spring Data 的方法
 * 命名约定来描述，甚至无法用 @Query 注解设置查询来实现时，需要按照传统的方式来编写
 * Repository 方法，也就是直接使用 EntityManager。 我们可以继续使用 Spring Data
 * 来实现，其方式是自定义一个与 Repository 接口名字相同且加了Impl后缀的类。
 * Spring Data 会把它的方法与 Spring Data JPA 所生成的方法合并在一起。
 */
public class SpitterRepositoryImpl implements SpitterSweeper {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int eliteSweep() {
        String update =
                "update Spitter spitter " +
                        "set spitter.status = 'Elite' " +
                        "where spitter.status = 'Newbie' " +
                        "and spitter.id in (" +
                        "select s from Spitter s where (" +
                        " select count(spittles) from s.spittles spittles) > 10000" +
                        ")";
        return entityManager.createQuery(update).executeUpdate();
    }
}
