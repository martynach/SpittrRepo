package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class MockedSpittleRepository implements ISpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long SpittleId) {
        return new Spittle("new Spittle from findOne method", new Date());
    }
}
