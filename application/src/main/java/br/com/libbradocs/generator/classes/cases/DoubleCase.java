package br.com.libbradocs.generator.classes.cases;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class DoubleCase extends AbstractCase {
    @Override
    protected <T> void populate(T object, Field field) throws Exception {
        field.set(object, RANDOM.nextDouble());
    }

    @Override
    protected boolean apply(Field field)  {
        return field.getType().equals(Double.class) || field.getType().equals(double.class);
    }
}
