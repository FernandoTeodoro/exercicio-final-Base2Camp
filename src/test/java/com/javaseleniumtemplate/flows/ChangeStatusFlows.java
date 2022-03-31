package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.ChangeStatusPage;

public class ChangeStatusFlows {
    //Objects and constructor
    ChangeStatusPage changeStatusPage;

    public ChangeStatusFlows(){
        //Page and Steps Objects
        changeStatusPage = new ChangeStatusPage();
    }

    //Flows
    public void alterarStatusParaFechado(String status, String anotacao){
        changeStatusPage.selecionarSituacaoDaIssue(status);
        changeStatusPage.preencherCampoAnotacao(anotacao);
        changeStatusPage.clicarEmFecharIssue();
    }
}
