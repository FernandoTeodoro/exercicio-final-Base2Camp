package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ReportIssuePage extends PageBase {
    //Mapping
    By campoCategoria = By.xpath("//select[@name='category_id']");
    By campoReprodutibilidade = By.xpath("//select[@name='reproducibility']");
    By campoSeveridade = By.xpath("//select[@name='severity']");
    By campoPrioridade = By.xpath("//select[@name='priority']");
    By campoPlataforma = By.xpath("//select[@name='profile_id']");
    By campoResumo = By.xpath("//input[@name='summary']");
    By campoDescricao = By.xpath("//textarea[@name='description']");
    By campoPassosParaReproducao = By.xpath("//textarea[@name='steps_to_reproduce']");
    By botaoSubmeterIssue = By.xpath("//input[@value='Submit Report']");
    By mensagemDeSucesso = By.xpath("//div[contains(text(),'Operation successful.')]");

    //Actions
    public void selecionarCategoria(String categoria){
        comboBoxSelectByVisibleText(campoCategoria, categoria);
    }

    public void selecionarReprodutibilidade(String reprodutibilidade){
        comboBoxSelectByVisibleText(campoReprodutibilidade, reprodutibilidade);
    }

    public void selecionarSeveridade(String severidade){
        comboBoxSelectByVisibleText(campoSeveridade, severidade);
    }

    public void selecionarPrioridade(String prioridade){
        comboBoxSelectByVisibleText(campoPrioridade, prioridade);
    }

    public void selecionarPlataforma(String plataforma){
        comboBoxSelectByVisibleText(campoPlataforma, plataforma);
    }

    public void preencherResumo(String resumo){
        sendKeys(campoResumo, resumo);
    }

    public void preencherDescricao(String descricao){
        sendKeys(campoDescricao, descricao);
    }

    public void preencherPassosParaReproducao(String passosParaReproducao){
        sendKeys(campoPassosParaReproducao, passosParaReproducao);
    }

    public void clicarEmRegistrarIssue(){
        click(botaoSubmeterIssue);
    }

    public String retornoMensagemDeSucesso(){
        return getText(mensagemDeSucesso);
    }
}
