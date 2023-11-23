package br.com.libbradocs.generator;

import br.com.libbradocs.generator.classes.Mock;
import br.com.libbradocs.generator.nome.Nome;
import br.com.libbradocs.generator.pessoa.PessoaFisica;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        var pessoa1 = Mock.mock(PessoaFisica.class, null);
        System.out.println(pessoa1);

        var pessoa2 = Mock.mock(PessoaFisica.class, Map.of("nome", new Nome.Builder().get()));
        System.out.println(pessoa2);

    }

}
