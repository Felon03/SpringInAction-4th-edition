package spittr.db;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.domain.Spitter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 14:16
 * Description: Repository interface with operations for {@link spittr.domain.Spitter} persistence
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {

    Spitter findByUsername(String username);

    List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);
}
