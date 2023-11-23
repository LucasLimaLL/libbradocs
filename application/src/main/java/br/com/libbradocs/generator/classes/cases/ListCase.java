package br.com.libbradocs.generator.classes.cases;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import static br.com.libbradocs.generator.classes.Mock.createObject;

public class ListCase extends AbstractCase {

    @Override
    protected <T> void populate(T object, Field field) throws Exception {
        ParameterizedType listType = (ParameterizedType) field.getGenericType();
        Class<?> elementType = (Class<?>) listType.getActualTypeArguments()[0];
        List<Object> list = new ArrayList<>();
        list.add(createObject(elementType));
        field.set(object, list);
    }

    @Override
    protected boolean apply(Field field) {
        return field.getType().equals(List.class);
    }
}
