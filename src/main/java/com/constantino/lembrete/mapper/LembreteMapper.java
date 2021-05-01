package com.constantino.lembrete.mapper;

import com.constantino.lembrete.model.Lembrete;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LembreteMapper {


    private List<Lembrete> lembretes = new ArrayList<Lembrete>();

    public LembreteMapper(){
        Instant agora = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

        Lembrete lembrete = new Lembrete();
        lembrete.setId(1L);
        lembrete.setTitulo("Comprar leite");
        lembrete.setDescricao("Hoje, 11h");
        lembrete.setDataCadastro(Date.from(agora));
        lembrete.setDataInicio(Date.from(agora));

        adicionar(lembrete);
    }

    public List<Lembrete> getLembretes() {
        return lembretes;
    }

    private void adicionar(Lembrete lembrete) {
        lembrete.setId(lembretes.size() +1);

        Instant agora = LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date hoje = Date.from(agora);
        lembrete.setDataCadastro(hoje);

        lembretes.add(lembrete);
    }

    private void remover(Lembrete lembrete){
        try{
            lembrete = buscar(lembrete.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void editar(Lembrete lembrete){
        try{
            for(Lembrete item : lembretes){
                if(item.getId() == lembrete.getId()){
                    item = lembrete;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Lembrete buscar(long id){
        Lembrete lembrete = null;

        try{
            for(Lembrete item : lembretes){
                if(item.getId() == id){
                    lembrete = item;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lembrete;
    }
}