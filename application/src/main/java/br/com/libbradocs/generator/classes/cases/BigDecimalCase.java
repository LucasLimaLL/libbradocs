package br.com.libbradocs.generator.classes.cases;

import br.com.libbradocs.generator.classes.cases.AbstractCase;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class BigDecimalCase extends AbstractCase {
    @Override
    protected <T> void populate(T object, Field field) throws Exception {
        field.set(object, BigDecimal.valueOf(RANDOM.nextDouble()));
    }

    @Override
    protected boolean apply(Field field)  {
        return field.getType().equals(BigDecimal.class);
    }
}
