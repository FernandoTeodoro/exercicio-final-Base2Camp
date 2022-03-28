package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase{
    //Mapping
    By userLogadoInfo = By.xpath("//td[@class='login-info-left']/span[@class='small']");

    //Actions
    public String obterUsuarioLogado(){
        return getText(userLogadoInfo);
    }
}
