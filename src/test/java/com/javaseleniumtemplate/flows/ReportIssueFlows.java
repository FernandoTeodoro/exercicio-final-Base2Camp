package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.ReportIssuePage;

public class ReportIssueFlows {
    //Objects and constructor
    ReportIssuePage reportIssuePage;

    public ReportIssueFlows(){
        //Page and Steps Objects
        reportIssuePage = new ReportIssuePage();
    }

    //Flows
    public void cadastrarNovaIssue(String categoria, String reprodutibilidade, String severidade, String prioridade,
                                   String plataforma, String resumo, String descricao, String passosParaRproducao){

        reportIssuePage.selecionarCategoria(categoria);
        reportIssuePage.selecionarReprodutibilidade(reprodutibilidade);
        reportIssuePage.selecionarSeveridade(severidade);
        reportIssuePage.selecionarPrioridade(prioridade);
        reportIssuePage.selecionarPlataforma(plataforma);
        reportIssuePage.preencherResumo(resumo);
        reportIssuePage.preencherDescricao(descricao);
        reportIssuePage.preencherPassosParaReproducao(passosParaRproducao);
        reportIssuePage.clicarEmRegistrarIssue();
    }






















}
