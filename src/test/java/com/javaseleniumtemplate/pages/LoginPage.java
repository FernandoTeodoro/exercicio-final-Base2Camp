package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By campoUsuario = By.xpath("//input[@name='username']");
    By campoSenha = By.xpath("//input[@name='password']");
    By botaoLogin = By.xpath("//input[@type='submit']");

    //Actions
    public void preenhcerUsuario(String usuario){
        sendKeys(campoUsuario, usuario);
    }

    public void preencherSenha(String senha){
        sendKeys(campoSenha, senha);
    }

    public void clicarEmLogin(){
        click(botaoLogin);
    }
}
