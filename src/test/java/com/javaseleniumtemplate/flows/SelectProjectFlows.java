package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.SelectProjectPage;

public class SelectProjectFlows {
    //Objects and constructor
    SelectProjectPage selectProjectPage;

    public SelectProjectFlows(){
        //Page and Steps Objects
        selectProjectPage = new SelectProjectPage();
    }

    //Flows
    public void selecionarProjeto(String nomeProjeto){
        selectProjectPage.selecionarProjeto(nomeProjeto);
    }
}
