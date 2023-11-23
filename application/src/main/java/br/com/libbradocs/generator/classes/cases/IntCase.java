package br.com.libbradocs.generator.classes.cases;

import java.lang.reflect.Field;

public class IntCase extends AbstractCase {

    @Override
    protected <T> void populate(T object, Field field) throws IllegalAccessException {
        field.set(object, RANDOM.nextInt(800));
    }

    @Override
    protected boolean apply(Field field) {
        return field.getType().equals(int.class);
    }
}
