package registraAniversario.smtp;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import registraAniversario.dao.PessoaDAO;
import registraAniversario.model.Pessoa;

public class EnviaEmail {

    public void enviarEmail() {
        final String username = "your@email.com";
        final String password = "yourPassword";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                }
        );

        try {
            // Obtém a lista de aniversariantes do dia
            PessoaDAO pessoaDAO = new PessoaDAO();
            StringBuilder mensagem = new StringBuilder("ANIVERSARIANTES DO DIA:\n\n");
            for (Pessoa pessoa : pessoaDAO.obterAniversariantesDoDia()) {
                mensagem.append("Nome: ").append(pessoa.getNome()).append("\n");
                mensagem.append("Data de Nascimento: ").append(pessoa.getDataNascimento()).append("\n\n");
                mensagem.append("Observação: ").append(pessoa.getObs()).append("\n\n");
            }

            if (!mensagem.toString().isEmpty()) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mail@recipient"));
                message.setSubject("ANIVERSARIANTE(S) DO DIA");
                message.setText(mensagem.toString());

                Transport.send(message);

                System.out.println("E-mail enviado com sucesso.");
            } else {
                System.out.println("Nenhum aniversariante hoje.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
