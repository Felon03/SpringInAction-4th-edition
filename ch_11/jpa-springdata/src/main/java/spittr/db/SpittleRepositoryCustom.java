package spittr.db;

import spittr.domain.Spittle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 14:33
 * Description:
 */
public interface SpittleRepositoryCustom {

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);
}
