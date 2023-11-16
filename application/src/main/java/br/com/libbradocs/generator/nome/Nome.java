package br.com.libbradocs.generator.nome;

import br.com.libbradocs.generator.cpf.CPF;
import br.com.libbradocs.generator.uf.UF;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Nome {

    private Nome() {
    }

    public static class Builder {

        private static final List<String> NOMES_MASCULINOS = Collections.unmodifiableList(Arrays.asList(
                "João", "Pedro", "Lucas", "Gabriel", "Matheus", "Felipe", "Guilherme", "Enzo", "Vinícius", "Carlos",
                "André", "Luiz", "Marcelo", "Thiago", "Davi", "Bruno", "Eduardo", "Ricardo", "Victor", "Hugo"
        ));

        private static final List<String> NOMES_FEMININOS = Collections.unmodifiableList(Arrays.asList(
                "Maria", "Ana", "Julia", "Laura", "Sophia", "Alice", "Isabella", "Luiza", "Valentina", "Clara",
                "Heloísa", "Manuela", "Letícia", "Melissa", "Nicole", "Yasmin", "Gabriela", "Isadora", "Lavínia", "Lívia"
        ));

        private static final List<String> NOMES_COMPOSTOS_MASCULINOS = Collections.unmodifiableList(Arrays.asList(
                "João Pedro", "Lucas Gabriel", "Matheus Henrique", "Pedro Henrique", "Gabriel Oliveira",
                "Felipe André", "Guilherme Augusto", "Enzo Miguel", "Vinícius Rafael", "Carlos Eduardo",
                "André Luiz", "Luiz Felipe", "Marcelo Antônio", "Thiago Alves", "Davi Lucca", "Lucas Mateus",
                "Bruno César", "Eduardo Santos", "Ricardo Leonardo", "Victor Hugo"
        ));

        private static final List<String> NOMES_COMPOSTOS_FEMININOS = Collections.unmodifiableList(Arrays.asList(
                "Maria Eduarda", "Ana Luíza", "Laura Beatriz", "Giovanna Maria", "Clara Sofia", "Lara Vitória",
                "Sophia Gabriela", "Isabella Valentina", "Luiza Fernanda", "Helena Carolina", "Beatriz Oliveira",
                "Amanda Gabrielle", "Gabriela Aparecida", "Letícia Cristina", "Manuela Vitória", "Marcela Eduarda",
                "Juliana Beatriz", "Yasmin Isabela", "Camila Eduarda", "Larissa Beatriz"
        ));

        private static final List<String> SOBRENOMES = Collections.unmodifiableList(Arrays.asList(
                "Silva", "Santos", "Oliveira", "Souza", "Pereira", "Lima", "Almeida", "Costa", "Ferreira", "Martins",
                "Rodrigues", "Rocha", "Barbosa", "Ribeiro", "Cardoso", "Nunes", "Cunha", "Castro", "Fernandes", "Carvalho",
                "Gomes", "Araújo", "Mendes", "Carvalho", "Martins", "Melo", "Dantas", "Rocha", "Batista", "Campos"
        ));

        private String nome = null;
        private String sobrenome = null;
        private Boolean isNomeMasculino = null;
        private Boolean isNomeComposto = null;
        private int quantidadeSobrenomes = 1;
        private static final Random RANDOM = new Random();

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Builder nomeMasculino(boolean isNomeMasculino) {
            this.isNomeMasculino = isNomeMasculino;
            return this;
        }

        public Builder nomeComposto(boolean isNomeComposto) {
            this.isNomeComposto = isNomeComposto;
            return this;
        }

        public Builder quantidadeSobrenomes(int quantidadeSobrenomes) {
            this.quantidadeSobrenomes = quantidadeSobrenomes;
            return this;
        }

        public String get() {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(getNome()).append(" ");
            stringBuilder.append(getSobrenome());

            return stringBuilder.toString();
        }

        private String getNome() {
            if (isNomeComposto == null) {
                isNomeComposto = RANDOM.nextInt(NOMES_FEMININOS.size()) % 2 == 0;
            }
            if (isNomeMasculino == null) {
                isNomeMasculino = RANDOM.nextInt(NOMES_MASCULINOS.size()) % 2 == 0;
            }

            return (nome == null || nome == "")
                    ? isNomeComposto ? getNomeComposto(isNomeMasculino) : getNomeSimples(isNomeMasculino)
                    : nome;
        }

        private String getSobrenome() {

            StringBuilder sb = new StringBuilder();
            if (sobrenome == null || sobrenome == "") {
                for (int i = 0; i < quantidadeSobrenomes; i++) {
                    sb.append(SOBRENOMES.get(RANDOM.nextInt(SOBRENOMES.size()))).append(" ");
                }
            } else {
                sb.append(sobrenome);
            }

            return sb.toString();
        }

        private String getNomeComposto(Boolean isNomeMasculino) {
            return isNomeMasculino
                    ? NOMES_COMPOSTOS_MASCULINOS.get(RANDOM.nextInt(NOMES_COMPOSTOS_MASCULINOS.size()))
                    : NOMES_COMPOSTOS_FEMININOS.get(RANDOM.nextInt(NOMES_COMPOSTOS_FEMININOS.size()));
        }

        private String getNomeSimples(Boolean isNomeMasculino) {
            return isNomeMasculino
                    ? NOMES_MASCULINOS.get(RANDOM.nextInt(NOMES_MASCULINOS.size()))
                    : NOMES_FEMININOS.get(RANDOM.nextInt(NOMES_FEMININOS.size()));
        }
    }
}
