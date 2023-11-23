package br.com.libbradocs.generator.classes.cases;

import br.com.libbradocs.generator.cpf.CPF;

import java.lang.reflect.Field;

public class StringCase extends AbstractCase {


    @Override
    protected <T> void populate(T object, Field field) throws IllegalAccessException {
        field.set(object, generateString(field));
    }

    private String generateString(Field field) {
        if (field.getName().equalsIgnoreCase("cpf")) {
            return new CPF.Builder().get();
        } else if (field.getName().equalsIgnoreCase("cep")) {
            StringBuilder word = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                word.append(RANDOM.nextInt(10));
            }

            return word.toString();
        }

        StringBuilder word = new StringBuilder();

        for (int i = 3; i < (RANDOM.nextInt(18) + 6); i++) {
            char letra = (char) ('a' + RANDOM.nextInt(26));
            word.append(letra);
        }

        return word.toString().toUpperCase();
    }

    @Override
    protected boolean apply(Field field) {
        return field.getType().equals(String.class);
    }
}
