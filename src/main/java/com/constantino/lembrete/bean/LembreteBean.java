package com.constantino.lembrete.bean;

import com.constantino.lembrete.mapper.LembreteMapper;
import com.constantino.lembrete.model.Lembrete;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class LembreteBean {

    private Lembrete lembrete;
    private LembreteMapper mapper = new LembreteMapper();

    public Lembrete getLembrete(){
        return lembrete;
    }

    public List<Lembrete> getLembretes(){
        return mapper.getLembretes();
    }
}
