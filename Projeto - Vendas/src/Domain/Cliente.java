package Domain;

import Anotacao.TipoChave;

/**
 * Created by Kadson Lima on 28/01/2025
 *
 * @author Kadson Lima
 */

public class Cliente implements Persistente {

    @TipoChave("getCPF")  // Anote o campo CPF
    private Long CPF;

    private String nome;

    private Long tel;

    private String end;

    private Integer numero;

    private String cidade;

    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }
}
