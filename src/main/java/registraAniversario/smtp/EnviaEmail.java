package registraAniversario.smtp;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import registraAniversario.dao.PessoaDAO;
import registraAniversario.model.Pessoa;

public class EnviaEmail {

    public void enviarEmail() {
        //put your e-mail that will be connected with smtp
    	final String username = "your e-mail";
        // and your password.
        // if u want, create a new e-mails just for send birthday's mail.
    	final String password = "your password";
        
        
        

        
        Properties props = new Properties();

        // the properties, u will put your server smtp, below will be connected by a gmail smtp
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
            List<Pessoa> pessoas = pessoaDAO.obterAniversariantesDoDia();
            for (Pessoa pessoa : pessoas) {
                mensagem.append("Nome: ").append(pessoa.getNome()).append("\n");
                mensagem.append("Data de Nascimento: ").append(pessoa.getDataNascimento()).append("\n");
                mensagem.append("Observação: ").append(pessoa.getObs()).append("\n\n");
            }

			if (!(pessoas.isEmpty())) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                //put below your recipient, like your Personal Email that u will receive the reminder.
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("your e-mail"));
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
