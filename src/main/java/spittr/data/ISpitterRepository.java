package spittr.data;

import spittr.Spitter;

public interface ISpitterRepository {

    Spitter save(Spitter spittle);

    Spitter findByUsername(String username);
}
