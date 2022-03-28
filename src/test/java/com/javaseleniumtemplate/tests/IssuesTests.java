package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.HomePage;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.ReportIssuePage;
import com.javaseleniumtemplate.pages.SelectProjectPage;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.junit.Test;


public class IssuesTests extends TestBase {
    //Objects
    LoginPage loginPage;
    HomePage homePage;
    SelectProjectPage selectProjectPage;
    ReportIssuePage reportIssuePage;

    //Tests
    @Test
    public void reportarUmaNovaIssue(){

        //Objects instances
        loginPage = new LoginPage();
        homePage = new HomePage();
        selectProjectPage = new SelectProjectPage();
        reportIssuePage = new ReportIssuePage();
        Dotenv dotenv = Dotenv.load();

        //Parameteres
        String usuario = dotenv.get("USER_LOGIN");
        String senha = dotenv.get("USER_PASSWORD");

        //Dados necessarios para o cadastro de uma nova issue
        String nomeProjeto = "ProjectTatiane";
        String categoria = "[All Projects] General" ;
        String reprodutibilidade = "random";
        String severidade = "crash";
        String prioridade = "urgent";
        String plataforma = "PC Windows 10";
        String resumo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ex lectus, consequat at " +
                        "efficitur in, dignissim a nisl.";
        String descricao = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin\n" +
                           " literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney\n" +
                           " College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage,\n" +                "            and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum\n" +
                           " comes from sections 1.10.32 and 1.10.33 of \\\"de Finibus Bonorum et Malorum\\\" (The Extremes of Good and Evil)\n" +
                           " by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.\n" +
                           " The first line of Lorem Ipsum, \\\"Lorem ipsum dolor sit amet..\\\", comes from a line in section 1.10.32.";
        String passosParaRproducao = "1 - Dar o primeiro passo\n" +
                                     "2 - Dar o segundo passo\n" +
                                     "3 - Dar o terceiro passo\n" +
                                     "4 - Repetir o primeiro passo\n" +
                                     "5 - Se tudo der certo, vai dar errado aqui!";

        //Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();

        homePage.clicarReportIssue();

        selectProjectPage.selecionarProjeto(nomeProjeto);
        selectProjectPage.clicarEmSelcionarProjeto();

        reportIssuePage.selecionarCategoria(categoria);
        reportIssuePage.selecionarReprodutibilidade(reprodutibilidade);
        reportIssuePage.selecionarSeveridade(severidade);
        reportIssuePage.selecionarPrioridade(prioridade);
        reportIssuePage.selecionarPlataforma(plataforma);
        reportIssuePage.preencherResumo(resumo);
        reportIssuePage.preencherDescricao(descricao);
        reportIssuePage.preencherPassosParaReproducao(passosParaRproducao);
        reportIssuePage.clicarEmRegistrarIssue();

        Assert.assertTrue(reportIssuePage.retornoMensagemDeSucesso().contains("Operation successful."));
    }
}
