package com.javaseleniumtemplate.tests;

import com.github.javafaker.Faker;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.javaseleniumtemplate.GlobalParameters;


public class IssuesTests extends TestBase {

    //Método responsável por fazer o login antes da execução de cada teste
    @Before
    public void efetuarLogin(){

        LoginPage loginPage = new LoginPage();
        Dotenv dotenv = Dotenv.load();

        String usuario = dotenv.get("USER_LOGIN");
        String senha = dotenv.get("USER_PASSWORD");

        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();
    }

    //Objects


    HomePage homePage;
    SelectProjectPage selectProjectPage;
    ReportIssuePage reportIssuePage;
    ReportedIssuePage reportedIssuesPage;
    ChangeStatusPage changeStatusPage;
    Faker faker = new Faker();
    String URL_DEFAULT = GlobalParameters.URL_DEFAULT;

    //Tests
    @Test
    public void reportarUmaNovaIssue(){
        //Objects instances
        homePage = new HomePage();
        selectProjectPage = new SelectProjectPage();
        reportIssuePage = new ReportIssuePage();


        /*
        MASSA DE DADOS:
        Para a realização desse teste é necessario que exista um projeto ja cadastrado no sistema.

        OBS.: Como no momento da criação desse script já existia um projeto cadastrado na plataforma eu
        tomei a liberdade de usá-lo no meu teste.
        */

        //Parameters
        String nomeProjeto = "ProjectTatiane";
        String categoria = "[All Projects] General" ;
        String reprodutibilidade = "random";
        String severidade = "crash";
        String prioridade = "urgent";
        String plataforma = "PC Windows 10";
        String resumo = faker.harryPotter().quote();
        String descricao = faker.lorem().characters(100,500);
        String passosParaRproducao = "1- " + faker.harryPotter().character() + "\n" +
                                     "2- " + faker.harryPotter().character() + "\n" +
                                     "3- " + faker.harryPotter().character() + "\n" +
                                     "4- " + faker.harryPotter().character() + "\n" +
                                     "3- " + faker.harryPotter().character() + "\n" +
                                     "3- " + faker.harryPotter().character() + "\n";

        //Test
        homePage.navigateTo(URL_DEFAULT + "bug_report_page.php");

        selectProjectPage.selecionarProjeto(nomeProjeto);
        selectProjectPage.clicarEmSelcionarProjeto();

        reportIssuePage.selecionarCategoria(categoria);
        reportIssuePage.selecionarReprodutibilidade(reprodutibilidade);
        reportIssuePage.selecionarSeveridade(severidade);
        reportIssuePage.selecionarPrioridade(prioridade);
        reportIssuePage.selecionarPlataforma(plataforma);
        reportIssuePage.preencherCampoResumo(resumo);
        reportIssuePage.preencherCampoDescricao(descricao);
        reportIssuePage.preencherCampoPassosParaReproducao(passosParaRproducao);
        reportIssuePage.clicarEmRegistrarIssue();

        Assert.assertTrue(reportIssuePage.retornoMensagemDeSucesso().contains("Operation successful."));
    }

    @Test
    public void atriburIssueAUmResponsavel(){
        //Objects instances
        homePage = new HomePage();
        reportedIssuesPage = new ReportedIssuePage();

        /*
        MASSA DE DADOS:
        Para a realização desse teste é necessario que exista uma issue ja cadastrada no sistema
        e sem um responsável associado a ela. Alem disso tambem precisa existir um usuario que
        possa ser colocado como responsável por essa issue.

        OBS.: Como no momento da criação desse script já existiam algumas issues assim na plataforma por conta
        de alguns testes anteriores eu resolvi usá-las no meu teste.
        */

        //Parameters
        String idIssue = "9073";
        String novoResponsavelPelaIssue = "Treinamento07";

        //Test
        homePage.navigateTo(URL_DEFAULT + "view.php?id=" + idIssue);

        reportedIssuesPage.selecionarResponsavel(novoResponsavelPelaIssue);
        reportedIssuesPage.clicarEmAdicionarResponsavel();

        Assert.assertEquals(reportedIssuesPage.retornarResponsavelAtual(), novoResponsavelPelaIssue);
    }

    @Test
    public void alterarStatusDaIssueParaClosed(){
        //Objects instances
        homePage = new HomePage();
        reportedIssuesPage = new ReportedIssuePage();
        changeStatusPage = new ChangeStatusPage();

        /*
        MASSA DE DADOS:
        Para a realização desse teste é necessario que exista uma issue ja cadastrada no sistema.

        OBS.: Como no momento da criação desse script já existiam algumas issues assim na plataforma por conta
        de alguns testes anteriores eu resolvi usá-las no meu teste.

        OBS2.: Nesse teste, ao escolher o status "Closed" o usuário é redirecionado pra outra página, aonde existem
        novos campos para serem preenchidos. Eu então optei por tratar tudo como um fluxo unico.
        */

        //Parameters
        String idIssue = "9288";
        String novoStatus = "closed";
        String situacaoIssue = "not fixable";
        String anotacao = faker.harryPotter().quote();

        //Test
        homePage.navigateTo(URL_DEFAULT + "view.php?id=" +idIssue);

        reportedIssuesPage.selecionarNovoStatus(novoStatus);
        reportedIssuesPage.clicarEmAltrarStatus();

        changeStatusPage.selecionarSituacaoDaIssue(situacaoIssue);
        changeStatusPage.preencherCampoAnotacao(anotacao);
        changeStatusPage.clicarEmFecharIssue();

        Assert.assertEquals(reportedIssuesPage.retornaStatusAtual(), novoStatus);
    }

    @Test
    public void efetuarBuscaDeIssueExistente(){
        //Objects instances
        homePage = new HomePage();
        reportedIssuesPage = new ReportedIssuePage();

        /*
        MASSA DE DADOS:
        Para a realização desse teste é necessario que exista uma issue ja cadastrada no sistema.

        OBS.: Como no momento da criação desse script já existiam algumas issues assim na plataforma por conta
        de alguns testes anteriores eu resolvi usá-las no meu teste.
        */

        //Parameters
        String idIssue = "9187";

        homePage.preencherCampoIdIssue(idIssue);
        homePage.clicarEmBuscarIssue();

        Assert.assertEquals(reportedIssuesPage.retornaIdIssue(), "000"+idIssue);
    }

    @Test
    public void efetuarBuscaDeIssueInexistente(){
        //Objects instances
        homePage = new HomePage();
        reportedIssuesPage = new ReportedIssuePage();

        /*
        MASSA DE DADOS:
        Para a realização desse teste é necessario que exista um projeto ja cadastrado no sistema e o
        ID de uma issue que não exista no sistema.

        OBS.: Como no momento da criação desse script já existia um projeto cadastrado na plataforma eu
        tomei a liberdade de usá-lo no meu teste e inventei um Id para poder utilizar no teste.
        */

        //Parameters
        String idIssue = "1000000";
        String mensagemIssueNaoEncontrada = "Issue " + idIssue + " not found.";

        homePage.preencherCampoIdIssue(idIssue);
        homePage.clicarEmBuscarIssue();

        Assert.assertEquals(reportedIssuesPage.retornaMensagemIssueNaoEncontrada(), mensagemIssueNaoEncontrada);
    }

}
