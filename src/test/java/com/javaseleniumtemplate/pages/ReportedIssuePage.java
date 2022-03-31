package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ReportedIssuePage extends PageBase {
    //Mapping
    By idIssueField = By.xpath("//table[3]/tbody/tr[3]/td[1]");
    By responsavelAtualField = By.xpath("//table[3]/tbody/tr[6]/td[2]");
    By selecionarResponsavelField = By.xpath("//select[@name='handler_id']");
    By adicionarResponsavelButton = By.xpath("//input[@value='Assign To:']");
    By statusAtualField = By.xpath("//table[3]/tbody/tr[8]/td[2]");
    By selecionarStatusField = By.xpath("//select[@name='new_status']");
    By alterarStatusButton = By.xpath("//input[@value='Change Status To:']");
    By mensagemIssueNaoEncontada =By.xpath("//p[contains(text(),'not found')]");

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

    public String retornaIdIssue(){
        return getText(idIssueField);
    }

    public String retornaStatusAtual(){
        return getText(statusAtualField);
    }

    public String retornaMensagemIssueNaoEncontrada(){
        return getText(mensagemIssueNaoEncontada);
    }
}