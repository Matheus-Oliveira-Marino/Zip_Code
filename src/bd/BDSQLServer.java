package bd;

import bd.core.MeuPreparedStatement;


/**
 * A classe {@code BDSQLServer} fornece um objeto {@code MeuPreparedStatement} configurado 
 * para se conectar a um banco de dados SQL Server.
 * Ela encapsula detalhes de conexão, como o driver 'JDBC', a 'URL de conexão', 
 * o 'nome de usuário' e a 'senha'.
 */
public class BDSQLServer 
{
    // Declaração do campo estático 'COMANDO', que representa um objeto 
    // de 'MeuPreparedStatement'.
    public static final MeuPreparedStatement COMANDO;

    static 
    {
        // Inicialização do objeto 'MeuPreparedStatement'.
        MeuPreparedStatement comando = null;

        try 
        {
            // Configuração do objeto 'MeuPreparedStatement' com os detalhes da conexão 'JDBC'.
            comando = new MeuPreparedStatement(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver", // Driver 'JDBC' para SQL Server.
                "jdbc:sqlserver://regulus.cotuca.unicamp.br:1433;databasename=BD22326", // URL de conexão
                "BD22326", // Nome de usuário do banco de dados.
                "BD22326" // Senha do banco de dados.
            );
        } 
        catch (Exception erro) 
        {
            // Tratamento de exceção em caso de problemas na conexão.
            System.err.println("Problemas de conexao com o BD");
            System.exit(0); // Aborta o programa em caso de falha na conexão.
        }

        // Atribuição do objeto MeuPreparedStatement configurado ao campo 'COMANDO'.
        COMANDO = comando;
    }
}