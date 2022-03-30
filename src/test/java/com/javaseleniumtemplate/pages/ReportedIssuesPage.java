package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ReportedIssuesPage extends PageBase {
    //Mapping
    By campoIdIssue = By.xpath("//table[3]/tbody/tr[3]/td[1]");
    By campoResponsavelAtual = By.xpath("//table[3]/tbody/tr[6]/td[2]");
    By campoSelecionarResponsavel = By.xpath("//select[@name='handler_id']");
    By botaoAdicionarResponsavel = By.xpath("//input[@value='Assign To:']");

    //Actions
    public void selecionarResponsavel(String responsavel){
        comboBoxSelectByVisibleText(campoSelecionarResponsavel, responsavel);
    }

    public void clicarEmAdicionarResponsavel(){
        click(botaoAdicionarResponsavel);
    }

    public String retornarResponsavelAtual(){
        return getText(campoResponsavelAtual);
    }



}