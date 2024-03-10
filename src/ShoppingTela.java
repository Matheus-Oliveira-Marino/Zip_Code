/**
 * A classe {@code ShoppingTela} é responsável por criar a interface gráfica 
 * para exibir informações sobre um logradouro.
 */
public class ShoppingTela 
{
    /**
     * Método principal para iniciar a aplicação da interface gráfica.
     * @param args Os argumentos da linha de comando (não utilizados neste caso).
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        try 
        {
            // Obtém informações sobre um logradouro utilizando um serviço web.
            Logradouro logradouro = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", "01310-100");
            
            // Cria uma nova janela para exibir informações sobre o logradouro.
            new Janela();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
