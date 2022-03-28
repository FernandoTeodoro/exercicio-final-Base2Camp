package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class SelectProjectPage extends PageBase {
    //Mapping
    By campoProjeto = By.xpath("//tr[@class='row-1']//select[@name='project_id']");
    By botaoSelecionarProjeto = By.xpath("//input[@class='button']");

    //Actions
   public void selecionarProjeto (String nomePojeto){
       comboBoxSelectByVisibleText(campoProjeto, nomePojeto);
   }

   public void clicarEmSelcionarProjeto(){
       click(botaoSelecionarProjeto);
   }

}
