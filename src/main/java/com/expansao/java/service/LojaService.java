package com.expansao.java.service;

import com.expansao.java.dto.LojaDto;
import com.expansao.java.model.Loja;
import com.expansao.java.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LojaService {

    @Autowired(required=true)
    private LojaRepository lojaRepository;


    public List<LojaDto> buscaLojas() throws Exception {
        List<Loja> lojas = lojaRepository.findAll();


        if(lojas.isEmpty()){
            throw new Exception();

        }

        return mapLojaDto(lojas);

    }

    public void adicionaLoja(LojaDto loja){
        Loja lojaEntity = new Loja();
        lojaEntity.setNome(loja.getNome());
        lojaEntity.setEndereco(loja.getEndereco());
        lojaEntity.setTelefone(loja.getTelefone());

        lojaRepository.save(lojaEntity);
    }



    private List<LojaDto> mapLojaDto(List<Loja> lojas) {
        List<LojaDto> lojaDtos = new ArrayList<>();

        lojas.forEach(item->{
            LojaDto dto = new LojaDto(item.getNome(), item.getEndereco(), item.getTelefone());
            lojaDtos.add(dto);
        });

        return lojaDtos;

    }
}
