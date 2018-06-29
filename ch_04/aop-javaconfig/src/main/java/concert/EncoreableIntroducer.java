package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-06 16:25
 * Description:
 */

@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "concert.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
