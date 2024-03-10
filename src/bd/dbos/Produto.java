package bd.dbos;


/**
 * A classe {@code Produto} representa um produto associado a um shopping em um banco de dados.
 * Cada produto tem um 'ID' único, um 'nome', um 'CEP' e um 'número de rua'.
 */
public class Produto implements Cloneable
{
    private int id;
    private String CEP;
    private String nome;

    private String numero;


     /**
     * Obtém o 'ID' do produto.
     *
     * @return O 'ID' do produto.
     */
    public int getId()
    {
        return this.id;
    }


    /**
     * Define o ID do produto.
     *
     * @param idShopping O 'ID' do produto.
     * @throws Exception Se o 'ID' fornecido for inválido.
     */
    public void setId(int idShopping) throws Exception
    {
        if(idShopping <= 0)
            throw new Exception("Codigo invalido");

        this.id = idShopping;
    }


    /**
     * Obtém o 'nome' do produto.
     *
     * @return O 'nome' do produto.
     */
    public String getNome() {
        return this.nome;
    }


    /**
     * Define o 'nome' do produto.
     *
     * @param nome O 'nome' do produto.
     * @throws Exception Se o nome fornecido for inválido.
     */
    public void setNome(String nome) throws Exception
    {
        if(nome == null || nome.equals(""))
            throw new Exception("Nome invalido");

        this.nome = nome;
    }


     /**
     * Obtém o 'CEP' associado ao produto.
     *
     * @return O 'CEP' associado ao produto.
     */
    public String getCEP() {return this.CEP;}


    /**
     * Define o 'CEP' associado ao produto.
     *
     * @param cep O 'CEP' associado ao produto.
     * @throws Exception Se o 'CEP' fornecido for inválido.
     */
    public void setCEP(String cep) throws Exception
    {
        if(cep == null || cep.equals(""))
            throw new Exception("CEP invalido");

        this.CEP = cep;
    }


     /**
     * Obtém o 'número da rua''' associado ao produto.
     *
     * @return O 'número da rua' associado ao produto.
     */
    public String getRua() {return this.numero;}


    /**
     * Define o 'número da rua' associado ao produto.
     *
     * @param numero O 'número da rua' associado ao produto.
     * @throws Exception Se o 'número da rua' fornecido for inválido.
     */
    public void setRua(String numero) throws Exception
    {
        if (numero == null || numero.equals(""))
            throw new Exception("erro");

        this.numero = numero;
    }


    /**
     * Construtor que cria um novo {@code Produto} com o 'CEP', 'nome' e 'número de rua' especificados.
     *
     * @param cep O 'CEP' do produto.
     * @param nome O 'nome' do produto.
     * @param descricao O 'número de rua' do produto.
     * @throws Exception Se algum parâmetro for inválido.
     */
    public Produto(String cep, String nome, String descricao) throws Exception
    {
        this.setNome(nome);
        this.setCEP(cep);
        this.setRua(descricao);

    }


     /**
     * Construtor que cria um novo Produto com o 'ID', 'nome', 'CEP' e 'número de rua' especificados.
     *
     * @param id O 'ID' do produto.
     * @param nome O 'nome' do produto.
     * @param cep O 'CEP' do produto.
     * @param rua O 'número de rua' do produto.
     * @throws Exception Se algum parâmetro for inválido.
     */
    public Produto(int id,String nome, String cep, String rua) throws Exception
    {
        this.setId(id);
        this.setNome(nome);
        this.setCEP(cep);
        this.setRua(rua);

    }


    /**
     * Construtor que cria um novo {@code Produto} com o 'CEP' e 'número de rua' especificados.
     *
     * @param cep O CEP do produto.
     * @param rua O número de rua do produto.
     * @throws Exception Se algum parâmetro for inválido.
     */
    public Produto(String cep, String rua) throws Exception
    {
        this.setCEP(cep);
        this.setRua(rua);

    }


    /**
     * Construtor que cria um novo {@code Produto} com o 'ID' especificado.
     *
     * @param id O 'ID' do produto.
     * @throws Exception Se o 'ID' for inválido.
     */
    public Produto(int id) throws Exception
    {
        this.setId(id);
    }


     /**
     * Construtor que cria um novo {@code Produto} com o 'número de rua' especificado.
     *
     * @param rua O 'número de rua' do produto.
     * @throws Exception Se o 'número de rua' for inválido.
     */
    public Produto(String rua) throws Exception
    {
        this.setRua(rua);
    }


    /**
     * Construtor que cria um novo {@code Produto} com o 
     * 'CEP', 'nome', 'número de rua' e 'ID' especificados.
     *
     * @param cep O 'CEP' do produto.
     * @param nome O 'nome' do produto.
     * @param numero O 'número de rua' do produto.
     * @param id O 'ID' do produto.
     * @throws Exception Se algum parâmetro for inválido.
     */
    public Produto(String cep, String nome,String numero, int id) throws Exception
    {
        this.setId(id);
        this.setNome(nome);
        this.setCEP((cep));
        this.setRua(numero);
    }


    /**
     * Retorna uma representação em formato de string do objeto {@code Produto}, 
     * contendo o 'código', 'nome', 'preço (CEP)'
     * e 'descrição' (número de rua) do produto.
     *
     * @return Uma string contendo as informações do produto.
     */
    @Override
    public String toString()
    {
        String ret = "";

        ret += "Codigo: "    + this.id + "\n";
        ret += "Nome: "      + this.nome      + "\n";
        ret += "Preco: "     + this.CEP     + "\n";
        ret += "Descricao: " + this.numero + "\n";

        return ret;
    }


    /**
     * Verifica se o objeto passado como argumento é igual ao produto chamante do método.
     *
     * @param obj O objeto a ser comparado com o chamante.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;

        Produto p = (Produto) obj;

        if (this.id != p.id) return false;
        if (this.nome != p.nome) return false;
        if (this.CEP != p.CEP) return false;
        if (this.numero != p.numero) return false;

        return true;
    }


    /**
     * Retorna um valor de {@code hashcode} para o {@code Produto}, baseado nos seus atributos.
     *
     * @return O hashcode calculado para o Produto.
     */
    @Override
    public int hashCode()
    {
        int ret = 26;

        ret *= 13 + Integer.valueOf(this.id).hashCode();
        ret *= 13 + String.valueOf(this.nome).hashCode();
        ret *= 13 + Double.valueOf(this.CEP).hashCode();
        ret *= 13 + String.valueOf(this.numero).hashCode();

        if(ret < 0) return ret = -ret;

        return ret;
    }


    /**
     * Construtor de cópia que cria um novo {@code Produto} com base em outro 
     * {@code Produto} passado como argumento.
     *
     * @param p O produto a ser copiado.
     * @throws Exception Se ocorrer algum erro durante a cópia.
     */
    public Produto(Produto p) throws Exception
    {
        this.id = p.id;
        this.nome = p.nome;
        this.CEP = p.CEP;
        this.numero = p.numero;
    }


    /**
     * Cria e retorna uma cópia (clone) do produto a ser clonado.
     *
     * @return Uma cópia deste Produto.
     */
    @Override
    public Object clone()
    {
        Produto clone = null;

        try {
            clone = new Produto(this);
        }
        catch (Exception e)
        {

        }

        return clone;
    }
}
