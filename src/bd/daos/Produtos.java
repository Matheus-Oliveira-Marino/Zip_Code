package bd.daos;

import bd.BDSQLServer;
import bd.core.MeuResultSet;
import bd.dbos.Produto;

import javax.swing.*;
import java.sql.SQLException;


/**
 * A classe {@code Produtos} fornece métodos para acessar e manipular informações sobre produtos
 * armazenados em um banco de dados relacionado a shopping.
 */
public class Produtos
{

    /**
     * Retorna o CEP associado a um shopping com base no seu 'ID'.
     *
     * @param idShopping O 'ID' do shopping para o qual o CEP será recuperado.
     * @return O CEP do shopping com o ID especificado.
     * @throws Exception Se ocorrer um erro durante a recuperação do CEP.
     */
    public static String retornaCEP(int idShopping) throws Exception
    {
        String sql;

        try
        {
             sql = "select CEP from SHOPPING.shopping where idShopping = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1,idShopping);
            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            if (resultado.next())
            {
                String cep = resultado.getString("CEP");
                return cep;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Nenhum shopping encontrado com o ID especificado");
                throw new Exception("Não cadastrado");
            }
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
            BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao inserir produto");
        }

    }


    /**
     * Verifica se um shopping está cadastrado no banco de dados com base no seu 'ID'.
     *
     * @param idshopping O 'ID' do shopping a ser verificado.
     * @return {@code true} se o shopping estiver cadastrado, {@code false} caso contrário.
     * @throws Exception Se ocorrer um erro durante a verificação.
     */
    public static boolean cadastro (int idshopping) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM SHOPPING.shopping WHERE IdShopping = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1,idshopping);

            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar produto");
        }

        return retorno;
    }


    /**
     * Inclui um novo produto (shopping) no banco de dados.
     *
     * @param produto O produto a ser incluído.
     * @throws Exception Se ocorrer um erro durante a inclusão do produto.
     */
    public static void incluir(Produto produto) throws Exception
    {
        if(produto == null)
            throw new Exception("Produto nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO SHOPPING.shopping (nome,CEP,NumeroRua) VALUES (?,?,?)";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1,produto.getNome());
            BDSQLServer.COMANDO.setString(2,produto.getCEP());
            BDSQLServer.COMANDO.setString(3,produto.getRua());
            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
            BDSQLServer.COMANDO.rollback();
            JOptionPane.showMessageDialog(null,"Ja exite esse cep com esse mesmo numero");
            throw new Exception("Erro ao inserir produto");
        }
    }


    /**
     * Exclui um produto (shopping) do banco de dados com base no seu 'ID'.
     *
     * @param idshopping O 'ID' do shopping a ser excluído.
     * @throws Exception Se ocorrer um erro durante a exclusão do produto.
     */
    public static void excluir(int idshopping) throws Exception
    {

        if (!cadastro(idshopping))
        {
            JOptionPane.showMessageDialog(null , "Id inválido ou não existente");
            throw new Exception("Não cadastrado");
        }


        try
        {
            String sql;

            sql = "DELETE FROM SHOPPING.shopping WHERE idShopping = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1,idshopping);

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao excluir produto");
        }
    }


    /**
     * Altera as informações de um produto (shopping) no banco de dados.
     *
     * @param shopping O objeto Produto contendo as informações atualizadas do shopping.
     * @throws Exception Se ocorrer um erro durante a atualização das informações do produto.
     */
    public static void alterar (Produto shopping) throws Exception
    {
        if (!cadastro(shopping.getId()))
        {
            JOptionPane.showMessageDialog(null , "Id invalido ou nao existente");
            throw new Exception("Nao cadastrado");
        }

        try
        {
            String sql;

            sql = "UPDATE SHOPPING.shopping SET nome = ?, CEP = ?," +
                    "  NumeroRua = ? WHERE idShopping = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, shopping.getNome());
            BDSQLServer.COMANDO.setString(2, shopping.getCEP());
            BDSQLServer.COMANDO.setString(3,shopping.getRua());
            BDSQLServer.COMANDO.setInt(4,shopping.getId());


            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao atualizar dados de produto");
        }
    }


    /**
     * Obtém as informações de um produto (shopping) do banco de dados com base no seu 'ID'.
     *
     * @param idshopping O 'ID' do shopping cujas informações serão recuperadas.
     * @return Um objeto Produto contendo as informações do shopping.
     * @throws Exception Se ocorrer um erro durante a recuperação das informações do produto.
     */
    public static Produto getProduto(int idshopping) throws Exception
    {
        Produto produto = null;
        try {
            String sql;

            sql = "SELECT * FROM shopping WHERE idShopping = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1,idshopping);

            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            if (!resultado.first())
                throw new Exception("Não cadastrado");

            produto = new Produto(//resultado.getInt("IDPRODUTO"),
                                  resultado.getString("Nome"),
                                  resultado.getString("CEP"),
                                  resultado.getString("NumeroRua")
            );
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar produto");
        }

        return produto;
    }


    /**
     * Obtém um conjunto de resultados contendo todos os produtos (shoppings) do banco de dados.
     *
     * @return Um objeto de {@code MeuResultSet} contendo os resultados da consulta.
     * @throws Exception Se ocorrer um erro durante a recuperação dos produtos.
     */
    public static MeuResultSet getProduto () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                    "FROM SHOPPING.shopping";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
            throw new Exception ("Erro ao recuperar produto");
        }

        return resultado;
    }


    /**
     * Obtém o CEP associado a um shopping com base no seu 'ID'.
     *
     * @param idshopping O 'ID' do shopping cujo CEP será recuperado.
     * @return O CEP do shopping com o 'ID' especificado.
     * @throws Exception Se ocorrer um erro durante a recuperação do CEP.
     */
    public static Double getCep(int idshopping) throws Exception
    {

        try
        {
            String sql;

            sql = "select p.CEP from SHOPPING.shopping as p where p.idShopping = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt(1,idshopping);

            MeuResultSet result = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            result.first();

            return result.getDouble("CEP");
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
            throw new Exception("Erro ao recuperar produto");
        }
    }


    /**
     * Obtém o número da rua associado a um shopping com base no objeto {@code Produto} fornecido.
     *
     * @param c O objeto {@code Produto} contendo o 'ID' do shopping cujo número da rua será recuperado.
     * @return O número da rua do shopping.
     * @throws Exception Se ocorrer um erro durante a recuperação do número da rua.
     */
    public static String getRua (Produto c) throws Exception
    {
        @SuppressWarnings("unused")
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT p.NumeroRua  " +
                    "FROM SHOPPING.shopping as p where p.idShopping = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);
            BDSQLServer.COMANDO.setInt(1,c.getId());
            MeuResultSet result = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
            result.first();
            return result.getString("NumeroRua");
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
            throw new Exception ("Erro ao recuperar produto");
        }
    }
}
