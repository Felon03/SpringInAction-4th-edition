package concert;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-06 9:41
 * Description: Audience类： 观看演出的切面
 */

@Aspect
public class Audience {

    @Before("execution(* concert.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("execution(* concert.Performance.perform(..)))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @After("execution(* concert.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(* concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
