package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase{
    //Mapping
    By usuarioLogadoInfo = By.xpath("//td[@class='login-info-left']/span[@class='small']");
    By botaoReportarIssue = By.xpath("//a[text()='Report Issue']");

    //Actions
    public String obterUsuarioLogado(){
        return getText(usuarioLogadoInfo);
    }

    public void clicarReportIssue(){
        click(botaoReportarIssue);
    }
}
