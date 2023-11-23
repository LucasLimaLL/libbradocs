package br.com.libbradocs.generator.classes.cases;

import java.lang.reflect.Field;
import java.util.Random;

public abstract class AbstractCase {

    static final Random RANDOM = new Random();

    public <T> void set(T object, Field field) throws Exception {
        if (apply(field)) {
            populate(object, field);
        }
    }

    protected abstract <T> void populate(T object, Field field) throws Exception;

    protected abstract boolean apply(Field field);

}
