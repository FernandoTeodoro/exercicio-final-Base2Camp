Exercício final proposto no Base2Camp para a criação de scripts automatizados de funções existentes na plataforma Mantis Bug Tracker


  <p>O exercício consistia na criação de 5 casos de testes automatizados que validassem cenários e repostas referentes a funções presentes na plataforma Mantis Bug     Tracker. Os cenários a serem testados eram de escolha do aluno, que deveria considerar o grau de relevância da funcionalidade do sistema.
  </p>

  <p>No meu caso os 5 cenários escolhidos foram:</p>

  <blockquote>
    <ol>
      <li> Validação da função de Login na Plataforma -> <strong>efetuarLoginComSucesso()</strong></br></li>
      <li> Validação da função de registro de uma nova issue -> <strong>reportarUmaNovaIssue()</strong></br></li>
      <li> Validação da função de atribuir uma issue a um responsável por tentar resolvê-la -> <strong>atriburIssueAUmResponsavel()</strong></br><l/i>
      <li> Validação da função de alterar o estado de uma issue para 'Closed' -> <strong>alterarStatusDaIssueParaClosed()</strong></br></li>
      <li> Validação da função de busca de uma issue utilizando seu ID (dividida em 2 métodos):
        <ol>
          <li><strong>Existente -> efetuarBuscaDeIssueExistente()</strong></br></li>
          <li><strong>Inexistente -> efetuarBuscaDeIssueInexistente()</strong></li>
        </ol>
      </li>
  </ol>
  </blockquote>
                                                                                       
  <p>Os scripts foram todos desenvolvidos usando as tecnologias e melhores praticas aprendidas durante todo o Base2Camp. Além disso por escolha minha adicionei as bibliotecas <a href="https://mvnrepository.com/artifact/com.github.javafaker/javafaker/1.0.2">Faker</a> para auxiliar no preenchimento de alguns campos e <a href="https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java">DotEnv</a> que ficou responsável pela ocultação das credenciais de acesso.
  </p>

  <p>Para rodar os scripts primeiro é preciso clonar o projeto ou baixa-lo na sua maquina, abrir com o <a href="https://www.jetbrains.com/pt-br/idea/">InteliJ IDEA</a> e abra a pasta do projeto nele. Apos isso navegue ate a pasta tests (src/test/java/com/javaseleniumtemplate/tests) e então execute as funções existentes nas classes LoginTests e IssueTests.
  </p>

  <p>
    <strong>OBS.: para executar os scripts é necessário substituir o valor das variáveis 'usuario' e 'senha' nos métodos de login ou ciar um arquivo .env na pasta raiz do projeto criando as variáveis 'USER_LOGIN' e 'USER_PASSWORD' inicializando as mesmas com as credenciais de acesso.
    </strong>
  </p>

