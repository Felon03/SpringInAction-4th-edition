package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-12 20:23
 * Description: 定义一个数据访问的Repository，为了实现解耦以及避免陷入数据库
 * 访问细节中，将其定义为一个接口
 */
public interface SpittleRepository {

    /**
     * 获得Spittle对象
     * @param max 表示所返回的Spittle中，SpittleID属性的最大值
     * @param count 表示要返回的Spittle对象的个数
     * @return 返回包含Spittle对象的列表
     */
    List<Spittle> findSpittles(long max, int count);

    /**
     * 获取id所对应的Spittle对象
     * @param id 对象id
     * @return 返回id所对应的Spittle对象
     */
    Spittle findOne(long id);
}
