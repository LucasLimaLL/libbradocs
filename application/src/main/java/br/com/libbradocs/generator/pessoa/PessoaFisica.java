package br.com.libbradocs.generator.pessoa;

import br.com.libbradocs.generator.contato.Contato;
import br.com.libbradocs.generator.endereco.Endereco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PessoaFisica {

    private String nome;
    private String cpf;
    private List<Endereco> enderecos;
    private Map<String, Contato> contatos;
    private BigDecimal salario;

    private double porcentagem;

    public PessoaFisica(String nome, String cpf, List<Endereco> enderecos, Map<String, Contato> contatos) {
        this.nome = nome;
        this.cpf = cpf;
        this.enderecos = enderecos == null ? new ArrayList<>() : enderecos;
        this.contatos = contatos == null ? new HashMap<>() : contatos;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Map<String, Contato> getContatos() {
        return contatos;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", porcentagem=" + porcentagem +
                ", cpf='" + cpf + '\'' +
                ", enderecos=" + enderecos +
                ", contatos=" + contatos +
                ", salario=" + salario +
                '}';
    }
}
