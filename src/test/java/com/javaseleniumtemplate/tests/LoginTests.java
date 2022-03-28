package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.HomePage;
import com.javaseleniumtemplate.pages.LoginPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.junit.Test;


public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    HomePage homePage;

    //Tests
    @Test
    public void efetuarLoginComSucesso(){

        //Objects instances
        loginPage = new LoginPage();
        homePage = new HomePage();
        Dotenv dotenv = Dotenv.load();

        //Parameteres
        String usuario = dotenv.get("USER_LOGIN");
        String senha = dotenv.get("USER_PASSWORD");
        String usuarioLogado = "Fernando Teodoro de Oliveira";

        //Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertTrue(homePage.obterUsuarioLogado().contains(usuarioLogado));
    }
}
