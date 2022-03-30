package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ReportIssuePage extends PageBase {
    //Mapping
    By selecionarCategoriaField = By.xpath("//select[@name='category_id']");
    By selecionarReprodutibilidadeField = By.xpath("//select[@name='reproducibility']");
    By selecionarSeveridadeField = By.xpath("//select[@name='severity']");
    By selecionarPrioridadeField = By.xpath("//select[@name='priority']");
    By selecionarPlataformaField = By.xpath("//select[@name='profile_id']");
    By resumoField = By.xpath("//input[@name='summary']");
    By descricaoField = By.xpath("//textarea[@name='description']");
    By passosParaReproducaoField = By.xpath("//textarea[@name='steps_to_reproduce']");
    By submeterIssueButton = By.xpath("//input[@value='Submit Report']");
    By mensagemDeSucesso = By.xpath("//div[contains(text(),'Operation successful.')]");

    //Actions
    public void selecionarCategoria(String categoria){
        comboBoxSelectByVisibleText(selecionarCategoriaField, categoria);
    }

    public void selecionarReprodutibilidade(String reprodutibilidade){
        comboBoxSelectByVisibleText(selecionarReprodutibilidadeField, reprodutibilidade);
    }

    public void selecionarSeveridade(String severidade){
        comboBoxSelectByVisibleText(selecionarSeveridadeField, severidade);
    }

    public void selecionarPrioridade(String prioridade){
        comboBoxSelectByVisibleText(selecionarPrioridadeField, prioridade);
    }

    public void selecionarPlataforma(String plataforma){
        comboBoxSelectByVisibleText(selecionarPlataformaField, plataforma);
    }

    public void preencherCampoResumo(String resumo){
        sendKeys(resumoField, resumo);
    }

    public void preencherCampoDescricao(String descricao){
        sendKeys(descricaoField, descricao);
    }

    public void preencherCampoPassosParaReproducao(String passosParaReproducao){
        sendKeys(passosParaReproducaoField, passosParaReproducao);
    }

    public void clicarEmRegistrarIssue(){
        click(submeterIssueButton);
    }

    public String retornoMensagemDeSucesso(){
        return getText(mensagemDeSucesso);
    }
}
