package com.algonai.api.Repositories;

import com.algonai.api.Entities.Pergunta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

}
