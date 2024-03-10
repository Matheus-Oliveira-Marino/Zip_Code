
/**
 * A classe {@code Logradouro} representa informações de um logradouro.
 */
public class Logradouro
{
    private String logradouro;

    /**
     * Obtém o logradouro.
     * @return O logradouro.
     */
    public  String getLogradouro ()
    {
        return this.logradouro;
    }


    /**
     * Define o logradouro.
     * @param logradouro O logradouro a ser definido.
     * @throws Exception se o logradouro for nulo ou vazio.
     */
    public void setLogradouro (String logradouro) throws Exception
    {
        if (logradouro==null || logradouro.length()==0)
            throw new Exception ("Logradouro ausente");

        this.logradouro = logradouro;
    }

    private String complemento;


    /**
     * Obtém o complemento do endereço.
     * @return O complemento do endereço, ou uma mensagem padrão se não houver complemento.
     */
    public  String getComplemento ()
    {
        if(this.complemento == null)
        {
           String message = "N\u00e3o h\u00e1 complemento ou inexistente";
           this.complemento = message;
           return this.complemento;
        }
        return this.complemento;
    }


    /**
     * Define o complemento do endereço.
     * @param complemento O complemento do endereço.
     */
    public void setComplemento (String complemento) throws Exception
    {
        this.complemento = complemento;
    }

    private String bairro;


    /**
     * Obtém o bairro do logradouro.
     * @return O bairro.
     */
    public  String getBairro ()
    {
        return this.bairro;
    }


    /**
     * Define o bairro do logradouro.
     * @param bairro O bairro a ser definido.
     * @throws Exception se o bairro for nulo ou vazio.
     */
    public void setBairro (String bairro) throws Exception
    {
        if (bairro==null || bairro.length()==0)
            throw new Exception ("Bairro ausente");

        this.bairro = bairro;
    }

    private String cidade;


    /**
     * Obtém o nome da cidade associada a este logradouro.
     * @return O nome da cidade.
     */
    public  String getCidade ()
    {
        return this.cidade;
    }


    /**
     * Define o nome da cidade associada a este logradouro.
     * @param cidade O nome da cidade a ser definido.
     * @throws Exception se o nome da cidade for nulo ou vazio.
     */
    public void setCidade (String cidade) throws Exception
    {
        if (cidade==null || cidade.length()==0)
            throw new Exception ("Cidade ausente");

        this.cidade = cidade;
    }

    private InfoCidade cidade_info;


     /**
     * Obtém as informações detalhadas sobre a cidade associada a este logradouro.
     * @return As informações sobre a cidade.
     */
    public InfoCidade getCidade_info ()
    {
        return (InfoCidade)this.cidade_info.clone();
    }


    /**
     * Define as informações detalhadas sobre a cidade associada a este logradouro.
     * @param infoCidade As informações sobre a cidade a serem definidas.
     * @throws Exception se as informações sobre a cidade forem nulas.
     */
    public void setCidade_info (InfoCidade infoCidade) throws Exception
    {
        if (infoCidade==null)
            throw new Exception ("Informacao de cidade ausente");

        this.cidade_info = (InfoCidade)infoCidade.clone();
    }

    private String estado;


    /**
     * Obtém o nome do estado associado a este logradouro.
     * @return O nome do estado.
     */
    public  String getEstado ()
    {
        return this.estado;
    }


     /**
     * Define o nome do estado associado a este logradouro.
     * @param estado O nome do estado a ser definido.
     * @throws Exception se o nome do estado for nulo ou vazio.
     */
    public void setEstado (String estado) throws Exception
    {
        if (estado==null || estado.length()==0)
            throw new Exception ("Estado ausente");

        this.estado = estado;
    }

    private InfoEstado estado_info;



     /**
     * Obtém as informações detalhadas sobre o estado associado a este logradouro.
     * @return As informações sobre o estado.
     */
    public  InfoEstado getEstado_info ()
    {
        return (InfoEstado)this.estado_info.clone();
    }


    /**
     * Define as informações detalhadas sobre o estado associado a este logradouro.
     * @param infoEstado As informações sobre o estado a serem definidas.
     * @throws Exception se as informações sobre o estado forem nulas.
     */
    public void setEstado_info (InfoEstado infoEstado) throws Exception
    {
        if (infoEstado==null)
            throw new Exception ("Informacao de estado ausente");

         this.estado_info = (InfoEstado)infoEstado.clone();
    }

    private String cep;


    /**
     * Obtém o CEP associado a este logradouro.
     * @return O CEP.
     */
    public  String getCep ()
    {
         return this.cep;
    }


    /**
     * Define o CEP associado a este logradouro.
     * @param cep O CEP a ser definido.
     * @throws Exception se o CEP for nulo ou vazio.
     */
    public void setCep (String cep) throws Exception
    {
        if (cep==null || cep.length()==0)
            throw new Exception ("Logradouro ausente");

         this.cep = cep;
    }


    /**
     * Construtor para inicializar um logradouro.
     * @param complemento O complemento do endereço.
     * @param logradouro O logradouro.
     * @param bairro O bairro.
     * @param cidade A cidade.
     * @param cidade_info As informações sobre a cidade.
     * @param estado O estado.
     * @param estado_info As informações sobre o estado.
     * @param cep O CEP.
     * @param rua A rua.
     * @throws Exception se o logradouro, bairro, cidade, estado ou CEP forem nulos ou vazios.
     */
    public Logradouro (String complemento,
                       String logradouro, String bairro,
                       String cidade, InfoCidade cidade_info,
                       String estado, InfoEstado estado_info,
                       String cep, String rua) throws Exception
    {
        this.setComplemento (complemento);
        this.setLogradouro  (logradouro);
        this.setBairro      (bairro);
        this.setCidade      (cidade);
        this.setCidade_info (cidade_info);
        this.setEstado      (estado);
        this.setEstado_info (estado_info);
        this.setCep         (cep);

    }

    // exigencia do mapeador de JSon
    public Logradouro () {}


    /**
     * Retorna uma representação em string deste objeto.
     * @return Uma string representando este objeto.
     */
    public String toString ()
    {
        return "Logradouro: "+
               this.logradouro+
               "\nComplemento: "+
               this.complemento+
               "\nCidade.....: "+
               this.cidade+
               " / "+
               this.cidade_info+
               "\nEstado.....: "+
               this.estado+
               " / "+
               this.estado_info+
               "\nC.E.P......: "+
               this.cep;
    }


    /**
     * Verifica se o objeto chamante do método(this) é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return {@code true} se os objetos forem iguais, {@code false} caso contrário.
     */
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof Logradouro))
            return false;

        Logradouro cep = (Logradouro)obj;

        if (!this.logradouro.equals(cep.logradouro))
            return false;

        if ((this.complemento==null && cep.complemento!=null) ||
            (this.complemento!=null && cep.complemento==null) ||
            !this.complemento.equals(cep.complemento))
            return false;

        if (!this.cidade.equals(cep.cidade))
            return false;

        if (!this.cidade_info.equals(cep.cidade_info))
            return false;

        if (!this.estado.equals(cep.estado))
            return false;

        if (!this.estado_info.equals(cep.estado_info))
            return false;

        if (!this.cep.equals(cep.cep))
            return false;

        return true;
    }


    /**
     * Retorna um valor de hash para este objeto.
     * @return Um valor de hash para este objeto.
     */
    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.logradouro .hashCode();

        if (this.complemento!=null)
            ret = 2*ret + this.complemento.hashCode();

        ret = 2*ret + this.cidade     .hashCode();
        ret = 2*ret + this.cidade_info.hashCode();
        ret = 2*ret + this.estado     .hashCode();
        ret = 2*ret + this.estado_info.hashCode();
        ret = 2*ret + this.cep        .hashCode();

        return ret;
    }


    /**
     * Construtor de cópia para inicializar um logradouro com base em outro objeto do mesmo tipo.
     * @param modelo O logradouro a ser copiado.
     * @throws Exception se o modelo for nulo.
     */
    public Logradouro (Logradouro modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.logradouro  = modelo.logradouro;
        this.complemento = modelo.complemento;
        this.cidade      = modelo.cidade;
        this.cidade_info = (InfoCidade)modelo.cidade_info.clone();
        this.estado      = modelo.estado;
        this.estado_info = (InfoEstado)modelo.estado_info.clone();
        this.cep         = modelo.cep;
    }


    /**
     * Cria e retorna uma cópia deste objeto.
     * @return Uma cópia deste objeto.
     */
    public Object clone ()
    {
        Logradouro ret=null;

        try
        {
            ret = new Logradouro (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}