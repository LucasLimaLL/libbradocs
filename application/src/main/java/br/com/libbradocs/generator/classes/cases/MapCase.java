package br.com.libbradocs.generator.classes.cases;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.libbradocs.generator.classes.Mock.createObject;

public class MapCase extends AbstractCase {

    @Override
    protected <T> void populate(T object, Field field) throws Exception {
        ParameterizedType mapType = (ParameterizedType) field.getGenericType();
        Class<?> keyType = (Class<?>) mapType.getActualTypeArguments()[0];
        Class<?> valueType = (Class<?>) mapType.getActualTypeArguments()[1];
        Map<Object, Object> mapa = new HashMap<>();
        mapa.put(createObject(keyType), createObject(valueType));
        field.set(object, mapa);
    }

    @Override
    protected boolean apply(Field field) {
        return field.getType().equals(Map.class);
    }
}
