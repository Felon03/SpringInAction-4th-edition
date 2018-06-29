package spittr.db;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.domain.Spittle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 14:34
 * Description: Repository interface with operations for {@link spittr.domain.Spittle} persistence
 */
public interface SpittleRepository extends JpaRepository<Spittle, Long>, SpittleRepositoryCustom {

    List<Spittle> findBySpitterId(long spitterId);
}
