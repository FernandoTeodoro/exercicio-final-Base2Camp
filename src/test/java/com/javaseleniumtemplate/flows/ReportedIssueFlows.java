package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.ReportedIssuesPage;

public class ReportedIssueFlows {
    //Objects and constructor
    ReportedIssuesPage reportedIssuesPage;

    public ReportedIssueFlows(){
        //Page and Steps Objects
        reportedIssuesPage = new ReportedIssuesPage();
    }

    //Flows
    public void adicionarRsponsavelPelaIssue( String nomeResponsavel){

        reportedIssuesPage.selecionarResponsavel(nomeResponsavel);
        reportedIssuesPage.clicarEmAdicionarResponsavel();
    }
}
