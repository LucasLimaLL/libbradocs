package br.com.libbradocs.generator.classes;

import br.com.libbradocs.generator.classes.cases.AbstractCase;
import br.com.libbradocs.generator.classes.cases.BigDecimalCase;
import br.com.libbradocs.generator.classes.cases.DoubleCase;
import br.com.libbradocs.generator.classes.cases.EnumCase;
import br.com.libbradocs.generator.classes.cases.IntCase;
import br.com.libbradocs.generator.classes.cases.ListCase;
import br.com.libbradocs.generator.classes.cases.MapCase;
import br.com.libbradocs.generator.classes.cases.StringCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mock {
    private static final List<AbstractCase> CASES = List.of(
            new StringCase(),
            new IntCase(),
            new BigDecimalCase(),
            new ListCase(),
            new MapCase(),
            new EnumCase(),
            new DoubleCase()
    );

    public static <T> T mock(Class<T> classe, Map<String, Object> fields) throws Exception {
        return createObject(classe);
    }

    public static <T> T createObject(Class<T> classe) throws Exception {
        var constructor = getConstructor(classe);
        var instance = createInstance(constructor);
        populate(instance);

        return instance;
    }

    private static <T> Constructor<T> getConstructor(Class<T> classe) {
        List<Constructor<T>> constructors = Arrays.asList((Constructor<T>[]) classe.getConstructors());

        // Encontra o construtor com o maior número de parâmetros
        return constructors.stream()
                .min(Comparator.comparingInt(Constructor::getParameterCount))
                .orElse(null);
    }

    private static <T> T createInstance(Constructor<T> constructor) {
        try {
            // Obtém os tipos dos parâmetros do construtor
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            // Gera dados aleatórios para cada tipo de parâmetro
            Object[] randomData = Arrays.stream(parameterTypes)
                    .map(Mock::generateRandomDataForType)
                    .toArray();

            // Cria uma nova instância usando o construtor e os dados aleatórios
            return constructor.newInstance(randomData);
        } catch (Exception e) {
            // Lida com exceções de reflexão, se necessário
            e.printStackTrace();
            return null;
        }
    }

    private static Object generateRandomDataForType(Class<?> type) {
        Random random = new Random();

        if (type.equals(int.class) || type.equals(Integer.class)) {
            return random.nextInt(100);
        } else if (type.equals(String.class)) {
            return generateRandomString();
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            return random.nextDouble();
        }

        return null;
    }

    private static String generateRandomString() {
        // Lógica para gerar uma string aleatória
        return "RandomString" + new Random().nextInt(100);
    }

    public static <T> void populate(T objeto) throws Exception {
        Class<?> classe = objeto.getClass();
        Field[] campos = classe.getDeclaredFields();

        for (Field campo : campos) {
            campo.setAccessible(true);

            for (AbstractCase applycase : CASES) {
                applycase.set(objeto, campo);
            }
        }
    }

    public static <T> void imprimirValores(T objeto) throws Exception {
        Class<?> classe = objeto.getClass();
        Field[] campos = classe.getDeclaredFields();

        for (Field campo : campos) {
            campo.setAccessible(true);
            System.out.println(campo.getName() + ": " + campo.get(objeto));
        }
        System.out.println();
    }
}
