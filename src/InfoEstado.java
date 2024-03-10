/**
 * A classe {@code InfoEstado} representa informações sobre um estado, incluindo 
 * o nome, código IBGE e área em quilômetros quadrados.
 */
public class InfoEstado implements Cloneable
{
    private String nome;


    /**
     * Obtém o nome do estado.
     * @return O nome do estado.
     */
    public String getNome ()
    {
        return this.nome;
    }


     /**
     * Define o nome do estado.
     * @param nome O nome do estado a ser definido.
     * @throws Exception Se o nome fornecido for nulo ou vazio.
     */
    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.length()==0)
            throw new Exception ("Nome ausente");

        this.nome = nome;
    }

    private String codigo_ibge;



    /**
     * Obtém o código IBGE do estado.
     * @return O código IBGE do estado.
     */
    public  String getCodigo_ibge ()
    {
        return this.codigo_ibge;
    }


    /**
     * Define o código IBGE do estado.
     * @param codigoIBGE O código IBGE a ser definido.
     * @throws Exception Se o código IBGE fornecido for nulo ou vazio.
     */
    public void setCodigo_ibge (String codigoIBGE) throws Exception
    {
        if (codigoIBGE==null || codigoIBGE.length()==0)
            throw new Exception ("Codigo do IBGE ausente");

        this.codigo_ibge = codigoIBGE;
    }

    private String area_km2;


    /**
     * Obtém a área em quilômetros quadrados do estado.
     * @return A área em quilômetros quadrados do estado.
     */
    public  String getArea_km2 ()
    {
        return this.area_km2;
    }


    /**
     * Define a área em quilômetros quadrados do estado.
     * @param areaEmKm2 A área em quilômetros quadrados a ser definida.
     * @throws Exception Se a área fornecida for nula ou vazia.
     */
    public void setArea_km2 (String areaEmKm2) throws Exception
    {
        if (areaEmKm2==null || areaEmKm2.length()==0)
            throw new Exception ("Area ausente");

        this.area_km2 = areaEmKm2;
    }



    /**
     * Construtor que cria uma nova instância de InfoEstado com o nome, código IBGE e área especificados.
     * @param nome O nome do estado.
     * @param codigoIBGE O código IBGE do estado.
     * @param areaEmKm2 A área em quilômetros quadrados do estado.
     * @throws Exception Se o nome, código IBGE ou área forem nulos ou vazios.
     */
    public InfoEstado (String nome, String codigoIBGE, String areaEmKm2) throws Exception
    {
        this.setNome        (nome);
        this.setCodigo_ibge (codigoIBGE);
        this.setArea_km2    (areaEmKm2);
    }

    // exigencia do mapeador de JSon.
    public InfoEstado () {}



    /**
     * Retorna uma representação em string desta instância de InfoEstado.
     * @return Uma string contendo o nome, código IBGE e área do estado.
     */
    public String toString ()
    {
        return this.nome+
               " / Codigo IBGE: "+
               this.codigo_ibge+
               " / Area(km2): "+
               this.area_km2;
    }



    /**
     * Verifica se esta instância de InfoEstado é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof InfoEstado))
            return false;

        InfoEstado infoEstado = (InfoEstado)obj;

        if (!this.nome.equals(infoEstado.nome))
            return false;

        if (!this.codigo_ibge.equals(infoEstado.codigo_ibge))
            return false;

        if (!this.area_km2.equals(infoEstado.area_km2))
            return false;

        return true;
    }



     /**
     * Retorna o hash code desta instância de InfoEstado.
     * @return O hash code desta instância.
     */
    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.nome       .hashCode();
        ret = 2*ret + this.codigo_ibge.hashCode();
        ret = 2*ret + this.area_km2   .hashCode();

        return ret;
    }



    /**
     * Construtor de cópia que cria uma nova instância de InfoEstado a partir de outro objeto InfoEstado.
     * @param modelo O objeto InfoEstado a ser copiado.
     * @throws Exception Se o modelo fornecido for nulo.
     */
    public InfoEstado (InfoEstado modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.nome        = modelo.nome;
        this.codigo_ibge = modelo.codigo_ibge;
        this.area_km2    = modelo.area_km2;
    }



    /**
     * Cria e retorna uma cópia desta instância de InfoEstado.
     * @return Uma cópia desta instância.
     */
    public Object clone ()
    {
        InfoEstado ret=null;

        try
        {
            ret = new InfoEstado (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
