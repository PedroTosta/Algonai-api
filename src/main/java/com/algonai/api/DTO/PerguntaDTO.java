package com.algonai.api.DTO;

import com.algonai.api.Entities.Pergunta;

public class PerguntaDTO {
    private Long id;
    private String pergunta;
    private String resposta;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String dificuldade;

    public PerguntaDTO(){
    }

    public PerguntaDTO(Long id, String pergunta, String resposta, String alternativa1, String alternativa2, String alternativa3, String dificuldade) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.dificuldade = dificuldade;
    }

    public PerguntaDTO(Pergunta entity) {
        this.id = entity.getId();
        this.pergunta = entity.getPergunta();
        this.resposta = entity.getResposta();
        this.alternativa1 = entity.getAlternativa1();
        this.alternativa2 = entity.getAlternativa2();
        this.alternativa3 = entity.getAlternativa3();
        this.dificuldade = entity.getDificuldade();
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
}
