package com.constantino.lembrete.bean;

import com.constantino.lembrete.mapper.LembreteMapper;
import com.constantino.lembrete.model.Lembrete;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class LembreteBean {

    private Lembrete lembrete;
    private LembreteMapper mapper = new LembreteMapper();

    @PostConstruct
    public void init(){
        lembrete = new Lembrete();
    }

    public Lembrete getLembrete(){
        return lembrete;
    }

    public List<Lembrete> getLembretes(){
        return mapper.getLembretes();
    }

    public String adicionar(){
        mapper.adicionar(lembrete);

        lembrete = new Lembrete();

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage("Lembrete adicionado com Sucesso!"));
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "index.xhtml";
    }
}
