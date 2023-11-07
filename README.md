# 🥳 Birthday Reminder - Web App 🥳 
O Birthday Reminder é um aplicativo web desenvolvido em Java que se conecta a um banco de dados MySQL para gerenciar informações de pessoas, incluindo seus aniversários. Além disso, o aplicativo utiliza um agendador (scheduler) para enviar automaticamente emails com os detalhes das pessoas que estão fazendo aniversário no dia. Isso ajuda a lembrar e celebrar os aniversários de amigos e familiares.

## 🕵️‍♂️ Funcionalidades 🕵️‍♂️
O aplicativo possui as seguintes funcionalidades:

* Cadastro de pessoas com informações como nome, data de nascimento e observação.
* Edição e atualização dos detalhes das pessoas cadastradas.
* Exclusão de registros de pessoas no banco de dados.
* Listagem de todas as pessoas registradas no banco de dados.
* Além disso, o aplicativo também tem uma funcionalidade agendada:
Todos os dias, às 6 da manhã, o aplicativo verifica se alguém está fazendo aniversário naquele dia.
Se houver aniversariantes, o aplicativo envia automaticamente um email com os detalhes das pessoas aniversariantes para o endereço de email configurado.
Pré-requisitos


# 🧑‍🔧 Antes de executar o aplicativo, você precisa garantir que os seguintes pré-requisitos estejam configurados: 🧑‍🔧

- Java Development Kit (JDK) instalado.
- Servidor de aplicação compatível com Java (por exemplo, Apache Tomcat).
- Banco de dados MySQL instalado e configurado.
- Conta de email para o envio automático de mensagens.


# 🛠 Configuração 🛠
## Para configurar o aplicativo, siga as etapas abaixo:
- Configure o banco de dados MySQL e defina as credenciais de acesso no arquivo de configuração do aplicativo.
- Configure as informações da conta de email, incluindo o servidor SMTP, porta, nome de usuário e senha no arquivo de configuração do aplicativo.
- Importe o projeto para a sua IDE Java (Eclipse, IntelliJ, etc.) como um Dynamic Web Project.
- Implante o aplicativo no servidor de aplicação Java.
- Certifique-se de que o agendador esteja configurado corretamente para rodar todos os dias às 6 da manhã.
- Inicie o servidor de aplicação (Faça o Deploy em núvem).
- Acesse o aplicativo via navegador web.

# ✈️ Uso ✈️
## Após configurar o aplicativo, você pode começar a usá-lo das seguintes maneiras:

- Cadastre as pessoas e seus detalhes, incluindo a data de nascimento.
- Edite ou exclua informações de pessoas conforme necessário.
- Liste todas as pessoas registradas.
- Aguarde o agendador enviar automaticamente emails de aniversário todos os dias às 6 da manhã.

# 📚 Contribuição 📚
- Se você deseja contribuir para o projeto, sinta-se à vontade para criar pull requests ou relatar problemas (issues) no repositório do projeto no GitHub.

# ⚖️ Licença ⚖️
Este projeto é licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

# ☎️ Contato ☎️ 
Se você tiver alguma dúvida ou precisar de assistência, entre em contato.

# 📅 Aproveite o uso do aplicativo Birthday Reminder e mantenha-se conectado com seus amigos e familiares em seus dias especiais! 📅
