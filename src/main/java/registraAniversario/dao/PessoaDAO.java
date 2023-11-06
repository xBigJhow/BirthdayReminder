package registraAniversario.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import registraAniversario.model.Pessoa;

public class PessoaDAO {
	
	String url = "jdbc:mysql://localhost:3306/cadastro_pessoa";
	String user = "root";
	String password = "123456";
	
	private static final String INSERT_USER_SQL = "INSERT INTO aniversariantes (nome, data_nascimento, obs) VALUES (?,?,?);";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM aniversariantes WHERE id = ?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM aniversariantes;";
	private static final String DELETE_USER_SQL = "DELETE FROM aniversariantes WHERE id = ?;";
	private static final String UPDATE_USER_SQL = "UPDATE aniversariantes SET nome=?, data_nascimento=?, obs=? WHERE id=?;";
	
	// CREATE CONNECTION
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		return connection;
	}
	// CREATE USER
	public void criaPessoa(Pessoa pessoa) throws SQLException {
	    Connection connection = null;
	    try {
	        connection = getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
	        preparedStatement.setString(1, pessoa.getNome());
	        preparedStatement.setDate(2, pessoa.getDataNascimento());
	        preparedStatement.setString(3, pessoa.getObs());
	        
	        preparedStatement.executeUpdate();
	    } catch (SQLException exception) {
	        exception.printStackTrace();
	    } finally {
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	// READ USERS
	public List<Pessoa> listaPessoas(){
		List<Pessoa> pessoas = new ArrayList<>();
		
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				Date dataNascimento = resultSet.getDate("data_nascimento");
				String obs = resultSet.getString("obs");
				pessoas.add(new Pessoa(id, nome, dataNascimento, obs));
				}
			}  catch(SQLException exception) {
				exception.printStackTrace();
			
		}
		return pessoas;
	}
	// SELECT USER BY ID
	public Pessoa selecionaPessoaPorId(int id) {
	    Pessoa pessoa = null;
	    try (Connection connection = getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
	        preparedStatement.setInt(1, id);
	        System.out.println(preparedStatement);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            String nome = resultSet.getString("nome");
	            Date dataNascimento = resultSet.getDate("data_nascimento"); 
	            String obs = resultSet.getString("obs");
	            pessoa = new Pessoa(id, nome, dataNascimento, obs);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pessoa;
	}
	
	// UPDATE USER
	public boolean atualizaPessoa(Pessoa pessoa) throws SQLException {
	    boolean linhaAtualizada;
	    
	    try (Connection connection = getConnection();
	         PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
	        statement.setString(1, pessoa.getNome());
	        statement.setDate(2, pessoa.getDataNascimento());
	        statement.setString(3, pessoa.getObs());
	        statement.setInt(4, pessoa.getId());
	        System.out.println("SQL de Atualização: " + statement); // Adicione esta linha para verificar o SQL gerado
	        linhaAtualizada = statement.executeUpdate() > 0;
	        System.out.println("Linhas atualizadas: " + (linhaAtualizada ? "1" : "0")); // Adicione esta linha para verificar o número de linhas atualizadas
	    } catch (SQLException e) {
	        e.printStackTrace();
	        linhaAtualizada = false; // Defina como falso em caso de erro
	    }
	    return linhaAtualizada;
	}
		
		
	// DELETE USERS
	public boolean deletaPessoa(int id) throws SQLException {
		boolean linhaDeletada;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);){
			statement.setInt(1,  id);
			linhaDeletada = statement.executeUpdate() > 0;
		}
		return linhaDeletada;
	}
	
	public List<Pessoa> obterAniversariantesDoDia() {
        List<Pessoa> aniversariantesDoDia = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String obs = resultSet.getString("obs");

                // Verifique se a data de nascimento corresponde ao dia atual
                if (dataNascimento != null) {
                    Calendar dataNascimentoCal = Calendar.getInstance();
                    dataNascimentoCal.setTime(dataNascimento);
                    String dataNascimentoStr = sdf.format(dataNascimentoCal.getTime());
                    String dataAtualStr = sdf.format(Calendar.getInstance().getTime());
                    if (dataNascimentoStr.equals(dataAtualStr)) {
                        aniversariantesDoDia.add(new Pessoa(id, nome, dataNascimento, obs));
                    }
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return aniversariantesDoDia;
    }
}
