package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.ReportedIssuePage;

public class ReportedIssueFlows {
    //Objects and constructor
    ReportedIssuePage reportedIssuesPage;

    public ReportedIssueFlows(){
        //Page and Steps Objects
        reportedIssuesPage = new ReportedIssuePage();
    }

    //Flows
    public void adicionarResponsavelPelaIssue(String nomeResponsavel){
        reportedIssuesPage.selecionarResponsavel(nomeResponsavel);
        reportedIssuesPage.clicarEmAdicionarResponsavel();
    }

    public void alterarStatusDaIssue(String novoStatus){
        reportedIssuesPage.selecionarNovoStatus(novoStatus);
        reportedIssuesPage.clicarEmAltrarStatus();
    }

}
