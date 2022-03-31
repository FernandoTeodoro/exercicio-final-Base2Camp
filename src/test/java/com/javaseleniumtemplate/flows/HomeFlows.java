package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.HomePage;

public class HomeFlows {
    //Objects and constructor
    HomePage homePage;

    public HomeFlows() {
        homePage = new HomePage();
    }

    public void buscarIssueInexiistente(String idIssue){
        homePage.preencherCampoIdIssue(idIssue);
        homePage.clicarEmBuscarIssue();
    }

}
