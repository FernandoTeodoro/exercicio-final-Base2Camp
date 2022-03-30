package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ReportedIssuesPage extends PageBase {
    //Mapping
    By responsavelAtualField = By.xpath("//table[3]/tbody/tr[6]/td[2]");
    By selecionarResponsavelField = By.xpath("//select[@name='handler_id']");
    By adicionarResponsavelButton = By.xpath("//input[@value='Assign To:']");
    By statusAtualField = By.xpath("//table[3]/tbody/tr[8]/td[2]");
    By selecionarStatusField = By.xpath("//select[@name='new_status']");
    By alterarStatusButton = By.xpath("//input[@value='Change Status To:']");

    //Actions
    public void selecionarResponsavel(String responsavel){
        comboBoxSelectByVisibleText(selecionarResponsavelField, responsavel);
    }

    public void clicarEmAdicionarResponsavel(){
        click(adicionarResponsavelButton);
    }

    public String retornarResponsavelAtual(){
        return getText(responsavelAtualField);
    }

    public void selecionarNovoStatus(String novoStatus){
        comboBoxSelectByVisibleText(selecionarStatusField, novoStatus);
    }

    public void clicarEmAltrarStatus(){
        click(alterarStatusButton);
    }

    public String retornaStatusAtual(){
        return getText(statusAtualField);
    }
}