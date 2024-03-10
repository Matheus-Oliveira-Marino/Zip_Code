/**
 * Classe que representa um endereço com o CEP.
 */
public class Endereco 
{
    private String cep;

    /**
     * Obtém o CEP do endereço.
     * @return O CEP do endereço.
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o CEP do endereço.
     * @param cep O CEP a ser definido.
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Retorna uma representação do endereço como uma string.
     * @return Uma string representando o CEP do endereço.
     */
    public String toString() {
        return cep;
    }
}
