package com.algonai.api.Service;

import java.util.Optional;

import com.algonai.api.Entities.Pergunta;
import com.algonai.api.Service.Exceptions.DatabaseException;
import com.algonai.api.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.algonai.api.Repositories.PerguntaRepository;
import com.algonai.api.DTO.PerguntaDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PerguntaService {

    @Autowired
    private PerguntaRepository repository;

    @Transactional(readOnly = true)
    public Page<PerguntaDTO> findAllPaged(Pageable pageable) {
        Page<Pergunta> list = repository.findAll(pageable);
        return list.map(x -> new PerguntaDTO(x));
    }

    @Transactional(readOnly = true)
    public PerguntaDTO findById(Long id) {
        Optional<Pergunta> obj = repository.findById(id);
        Pergunta entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PerguntaDTO(entity);
    }

    @Transactional
    public PerguntaDTO insert(PerguntaDTO dto) {
        Pergunta entity = new Pergunta();
        entity.setPergunta(dto.getPergunta());
        entity.setResposta(dto.getResposta());
        entity.setAlternativa1(dto.getAlternativa1());
        entity.setAlternativa2(dto.getAlternativa2());
        entity.setAlternativa3(dto.getAlternativa3());
        entity.setDificuldade(dto.getDificuldade());
        entity = repository.save(entity);
        return new PerguntaDTO(entity);
    }

    @Transactional
    public PerguntaDTO update(Long id, PerguntaDTO dto) {
        try {
            Pergunta entity = repository.getReferenceById(id);
            entity.setPergunta(dto.getPergunta());
            entity.setResposta(dto.getResposta());
            entity.setAlternativa1(dto.getAlternativa1());
            entity.setAlternativa2(dto.getAlternativa2());
            entity.setAlternativa3(dto.getAlternativa3());
            entity.setDificuldade(dto.getDificuldade());
            entity = repository.save(entity);
            return new PerguntaDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

}
