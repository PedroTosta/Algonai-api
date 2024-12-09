package com.algonai.api.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pergunta")
public class Pergunta implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static final long serialVersionUID = 1L;
    private Long id;
    private String pergunta;
    private String resposta;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String dificuldade;

    public Pergunta() {
    }

    public Pergunta(Long id, String pergunta, String resposta, String alternativa1, String alternativa2, String alternativa3, String dificuldade) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pergunta other = (Pergunta) obj;
        return Objects.equals(id, other.id);
    }


}
