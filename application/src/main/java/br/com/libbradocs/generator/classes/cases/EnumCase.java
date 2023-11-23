package br.com.libbradocs.generator.classes.cases;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static br.com.libbradocs.generator.classes.Mock.createObject;

public class EnumCase extends AbstractCase {

    @Override
    protected <T> void populate(T object, Field field) throws Exception {
        Object[] enumConstants = field.getType().getEnumConstants();
        if (enumConstants.length > 0) {
            field.set(object, enumConstants[RANDOM.nextInt(enumConstants.length)]);
        }
    }

    @Override
    protected boolean apply(Field field) {
        return field.getType().isEnum();
    }
}
