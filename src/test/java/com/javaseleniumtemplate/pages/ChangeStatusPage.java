package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ChangeStatusPage extends PageBase {
    //Mapping
    By selecionarSituacaoIssueField = By.xpath("//select[@name='resolution']");
    By anotacaoField = By.xpath("//textarea[@name='bugnote_text']");
    By fecharIssueButton = By.xpath("//input[@value='Close Issue']");

    //Actions
    public void selecionarSituacaoDaIssue(String situacaoIssue){
        comboBoxSelectByVisibleText(selecionarSituacaoIssueField, situacaoIssue);
    }

    public void preencherCampoAnotacao(String anotacaoIssue){
        sendKeys(anotacaoField, anotacaoIssue);
    }

    public void clicarEmFecharIssue(){
        click(fecharIssueButton);
    }
}
