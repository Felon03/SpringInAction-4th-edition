package spittr.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-12 21:13
 * Description:
 */
@Configuration
public class DefaultSpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return createSpittleList(count);
    }

    @Override
    public Spittle findOne(long id) {
        return new Spittle("Hello", new Date());
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle" + i, new Date()));
        }
        return spittles;
    }
}
