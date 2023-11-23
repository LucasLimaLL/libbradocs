package br.com.libbradocs.generator.contato;

public class Contato {

    private final TipoContato tipoContato;
    private final String contato;

    public Contato(TipoContato tipoContato, String contato) {
        this.tipoContato = tipoContato;
        this.contato = contato;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public String getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "tipoContato=" + tipoContato +
                ", contato='" + contato + '\'' +
                '}';
    }
}
