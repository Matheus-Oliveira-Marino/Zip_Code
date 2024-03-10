/**
 * A classe {@code InfoCidade} representa informações sobre uma cidade, incluindo o código IBGE 
 * e a área em quilômetros quadrados.
 * Ela fornece métodos para acessar e manipular essas informações, 
 * bem como suporte para clonagem e comparação de objetos.
 */
public class InfoCidade implements Cloneable
{
    private String codigo_ibge;


    /**
     * Obtém o código IBGE da cidade.
     * @return O código IBGE da cidade.
     */
    public  String getCodigo_ibge ()
    {
        return this.codigo_ibge;
    }



    /**
     * Define o código IBGE da cidade.
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
     * Obtém a área em quilômetros quadrados da cidade.
     * @return A área em quilômetros quadrados da cidade.
     */
    public  String getArea_km2()
    {
        return this.area_km2;
    }



    /**
     * Define a área em quilômetros quadrados da cidade.
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
     * Construtor que cria uma nova instância de InfoCidade com o código IBGE e a área especificados.
     * @param codigoIBGE O código IBGE da cidade.
     * @param areaEmKm2 A área em quilômetros quadrados da cidade.
     * @throws Exception Se o código IBGE ou a área forem nulos ou vazios.
     */
    public InfoCidade (String codigoIBGE, String areaEmKm2) throws Exception
    {
        this.setCodigo_ibge (codigoIBGE);
        this.setArea_km2    (areaEmKm2);
    }

    // exigencia do mapeador de JSon.
    public InfoCidade () {}


    /**
     * Retorna uma representação em string desta instância de InfoCidade.
     * @return Uma string contendo o código IBGE e a área da cidade.
     */
    public String toString ()
    {
        return "Codigo IBGE: "+
               this.codigo_ibge+
               " / Area(km2): "+
               this.area_km2;
    }


    /**
     * Verifica se esta instância de InfoCidade é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (!(obj instanceof InfoCidade))
            return false;

        InfoCidade infoCidade = (InfoCidade)obj;

        if (!this.codigo_ibge.equals(infoCidade.codigo_ibge))
            return false;

        if (!this.area_km2.equals(infoCidade.area_km2))
            return false;

        return true;
    }


    /**
     * Retorna o hash code desta instância de InfoCidade.
     * @return O hash code desta instância.
     */
    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.codigo_ibge.hashCode();
        ret = 2*ret + this.area_km2   .hashCode();

        return ret;
    }


    /**
     * Construtor de cópia que cria uma nova instância de InfoCidade a partir de outro objeto InfoCidade.
     * @param modelo O objeto InfoCidade a ser copiado.
     * @throws Exception Se o modelo fornecido for nulo.
     */
    public InfoCidade (InfoCidade modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.codigo_ibge = modelo.codigo_ibge;
        this.area_km2    = modelo.area_km2;
    }



    /**
     * Cria e retorna uma cópia desta instância de InfoCidade.
     * @return Uma cópia desta instância.
     */
    public Object clone ()
    {
        InfoCidade ret=null;

        try
        {
            ret = new InfoCidade (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
