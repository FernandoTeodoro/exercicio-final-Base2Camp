package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IssuesTests extends TestBase {

    //Metodo responsavel por fazer o login antes da execução de cada teste
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
    ReportedIssuesPage reportedIssuesPage;
    ChangeStatusPage changeStatusPage;

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
        String URL_CADASTRARISSUE = "https://mantis-prova.base2.com.br/bug_report_page.php";

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
        homePage.navigateTo(URL_CADASTRARISSUE);

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
        reportedIssuesPage = new ReportedIssuesPage();

        /*
        MASSA DE DADOS:
        Para a realização desse teste é necessario que exista uma issue ja cadastrada no sistema
        e sem um responsável associado a ela. Alem disso tambem precisa existir um usuario que
        possa ser colocado como responsável por essa issue.

        OBS.: Como no momento da criação desse script já existiam algumas issues assim na plataforma por conta
        de alguns testes anteriores eu resolvi usá-las no meu teste.
        */

        //Parameters
        String URL_ISSUE = "https://mantis-prova.base2.com.br/view.php?id=";
        String idIssue = "9073";
        String novoResponsavelPelaIssue = "Treinamento07";

        //Test
        homePage.navigateTo(URL_ISSUE + idIssue);

        reportedIssuesPage.selecionarResponsavel(novoResponsavelPelaIssue);
        reportedIssuesPage.clicarEmAdicionarResponsavel();

        Assert.assertEquals(reportedIssuesPage.retornarResponsavelAtual(), novoResponsavelPelaIssue);
    }

    @Test
    public void alterarStatusDaIssueParaClosed(){
        //Objects instances
        homePage = new HomePage();
        reportedIssuesPage = new ReportedIssuesPage();
        changeStatusPage = new ChangeStatusPage();

        /*
        MASSA DE DADOS:
        Para a realização desse teste é necessario que exista uma issue ja cadastrada no sistema.

        OBS.: Como no momento da criação desse script já existiam algumas issues assim na plataforma por conta
        de alguns testes anteriores eu resolvi usá-las no meu teste.

        OBS2.: Nesse teste, ao escolher o status "Closed" o usuário é redirecionado pra outra página, aonde existem
        novos campos para serem preenchidos. Eu então decidir tratar tudo como um fluxo unico.
        */

        //Parameters
        String URL_ISSUE = "https://mantis-prova.base2.com.br/view.php?id=";
        String idIssue = "9073";
        String novoStatus = "closed";
        String situacaoIssue = "not fixable";
        String anotacao = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ex lectus, consequat at " +
                          "efficitur in, dignissim a nisl.";

        //Test

        homePage.navigateTo(URL_ISSUE + idIssue);

        reportedIssuesPage.selecionarNovoStatus(novoStatus);
        reportedIssuesPage.clicarEmAltrarStatus();

        changeStatusPage.selecionarSituacaoDaIssue(situacaoIssue);
        changeStatusPage.preencherCampoAnotacao(anotacao);
        changeStatusPage.clicarEmFecharIssue();

        Assert.assertEquals(reportedIssuesPage.retornaStatusAtual(), novoStatus);
    }
}
