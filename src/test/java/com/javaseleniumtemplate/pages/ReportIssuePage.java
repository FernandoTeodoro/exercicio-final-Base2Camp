package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ReportIssuePage extends PageBase {
    //Mapping
    By campoSelecionarCategoria = By.xpath("//select[@name='category_id']");
    By campoSelecionarReprodutibilidade = By.xpath("//select[@name='reproducibility']");
    By campoSelecionarSeveridade = By.xpath("//select[@name='severity']");
    By campoSelecionarPrioridade = By.xpath("//select[@name='priority']");
    By campoSelecionarPlataforma = By.xpath("//select[@name='profile_id']");
    By campoResumo = By.xpath("//input[@name='summary']");
    By campoDescricao = By.xpath("//textarea[@name='description']");
    By campoPassosParaReproducao = By.xpath("//textarea[@name='steps_to_reproduce']");
    By botaoSubmeterIssue = By.xpath("//input[@value='Submit Report']");
    By mensagemDeSucesso = By.xpath("//div[contains(text(),'Operation successful.')]");

    //Actions
    public void selecionarCategoria(String categoria){
        comboBoxSelectByVisibleText(campoSelecionarCategoria, categoria);
    }

    public void selecionarReprodutibilidade(String reprodutibilidade){
        comboBoxSelectByVisibleText(campoSelecionarReprodutibilidade, reprodutibilidade);
    }

    public void selecionarSeveridade(String severidade){
        comboBoxSelectByVisibleText(campoSelecionarSeveridade, severidade);
    }

    public void selecionarPrioridade(String prioridade){
        comboBoxSelectByVisibleText(campoSelecionarPrioridade, prioridade);
    }

    public void selecionarPlataforma(String plataforma){
        comboBoxSelectByVisibleText(campoSelecionarPlataforma, plataforma);
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
