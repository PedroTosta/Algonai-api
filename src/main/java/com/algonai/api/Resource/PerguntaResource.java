package com.algonai.api.Resource;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algonai.api.Entities.Pergunta;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaResource {
    @GetMapping
    public ResponseEntity<List<Pergunta>> findAll(){
        List<Pergunta> list = new ArrayList<>();
        //list.add(new Pergunta(1l,"Books"));
        //list.add(new Pergunta(2l,"Electronics"));
        return ResponseEntity.ok().body(list);
    }
}
