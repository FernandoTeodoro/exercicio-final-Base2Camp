package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase{
    //Mapping
    By usuarioLogadoInfo = By.xpath("//td[@class='login-info-left']/span[@class='small']");
    By issueIdField = By.xpath("//input[@name='bug_id']");
    By buscarIssuebutton = By.xpath("//input[@value='Jump']");


    //Actions
    public String obterUsuarioLogado(){
        return getText(usuarioLogadoInfo);
    }

    public void preencherCampoIdIssue(String idIssue){
        sendKeys(issueIdField, idIssue);
    }

    public void clicarEmBuscarIssue(){
        click(buscarIssuebutton);
    }

}
