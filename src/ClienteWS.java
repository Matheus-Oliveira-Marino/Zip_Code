import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * A classe {@code ClienteWS} fornece métodos utilitários para realizar
 *  solicitações HTTP GET e POST em um serviço da web.
 */
public class ClienteWS
{

    /**
     * Realiza uma solicitação HTTP GET para o serviço da web e retorna o objeto obtido.
     * 
     * @param tipoObjetoRetorno O tipo de objeto esperado como resposta.
     * @param urlWebService A URL do serviço da web.
     * @param parametros Os parâmetros da solicitação GET.
     * @return O objeto obtido do serviço da web.
     */
    @SuppressWarnings("rawtypes")
    public static Object getObjeto (Class tipoObjetoRetorno,
                                    String urlWebService,
                                    String... parametros)
    {
        Object objetoRetorno = null;
	
        try
        {
            // Adiciona os parâmetros à URL da solicitação.
            for (String parametro : parametros)
                urlWebService = urlWebService + "/" + parametro.replaceAll(" ", "%20");
		

            // Cria uma conexão HTTP com a URL fornecida.    
            URL url = new URL (urlWebService);
            HttpURLConnection connection =
            (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.connect();

             // Lê a resposta da conexão e converte-a para uma string JSON.
            String responseJson = inputStreamToString(connection.getInputStream());
            connection.disconnect();
		

            // Converte a string JSON de resposta em um objeto Java.
            return fromJson(responseJson, tipoObjetoRetorno);
        }
        catch (Exception erro)
        {
             erro.printStackTrace();
        }	

        return objetoRetorno;
    }


    /**
     * Realiza uma solicitação HTTP POST para o serviço da web e retorna o objeto obtido.
     * 
     * @param objetoEnvio O objeto a ser enviado no corpo da solicitação POST.
     * @param tipoObjetoRetorno O tipo de objeto esperado como resposta.
     * @param urlWebService A URL do serviço da web.
     * @return O objeto obtido do serviço da web.
     */
    @SuppressWarnings("rawtypes")
    public static Object postObjeto (Object objetoEnvio,
                                     Class tipoObjetoRetorno,
                                     String urlWebService)
    {
        // Inicializa o objeto de retorno como nulo.
        Object objetoRetorno = null;
	
        try
        {
            // Converte o objeto de envio em uma string JSON.
            String requestJson = toJson(objetoEnvio);
		
            // Cria uma conexão HTTP com a URL fornecida.
            URL url = new URL(urlWebService);

            HttpURLConnection connection =
            (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setUseCaches(false);
	    connection.setConnectTimeout(15000);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Length", Integer.toString(requestJson.length()));
			

            // Envia a string JSON como corpo da solicitação POST.
            DataOutputStream stream =
            new DataOutputStream (connection.getOutputStream());
            stream.write (requestJson.getBytes("UTF-8"));
            stream.flush ();
            stream.close ();
            connection.connect ();


            // Lê a resposta da conexão e converte-a para uma string JSON.
            String responseJson = inputStreamToString (connection.getInputStream());
            connection.disconnect();

            // Converte a string JSON de resposta em um objeto Java.
            objetoRetorno = fromJson (responseJson, tipoObjetoRetorno);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return objetoRetorno;
    }



    /**
     * Converte um fluxo de entrada em uma string.
     * 
     * @param is O fluxo de entrada a ser convertido.
     * @return A string resultante da conversão.
     * @throws IOException Se ocorrer um erro de entrada/saída durante a conversão.
     */
    public static String inputStreamToString(InputStream is) throws IOException
     {
        if (is != null) 
        {
            // Cria um StringWriter para armazenar os dados lidos do InputStream.
            Writer writer = new StringWriter();
            
            // Cria um buffer de caracteres para ler os dados do InputStream.
            char[] buffer = new char[1024];
            
            try 
            {
                // Cria um BufferedReader para ler os dados do InputStream usando a codificação UTF-8.
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                
                // Lê os dados do InputStream para o buffer e escreve-os no StringWriter.
                while ((n = reader.read(buffer)) != -1) 
                {
                    writer.write(buffer, 0, n);
                }
            } 
            finally 
            {
                // Fecha o InputStream após a leitura.
                is.close();
            }
            
            // Retorna os dados lidos do InputStream como uma string.
            return writer.toString();
        } 
        else 
        {
            // Retorna uma string vazia se o InputStream for nulo.
            return "";
        }
    }


    /**
     * Converte um objeto Java em uma string JSON.
     * 
     * @param objeto O objeto Java a ser convertido.
     * @return A string JSON resultante da conversão.
     * @throws Exception Se ocorrer um erro durante a conversão.
     */
    public static String toJson(Object objeto) throws Exception
    {
        // Cria um ObjectMapper, que é usado para mapear objetos Java para JSON e vice-versa.
        ObjectMapper mapper = new ObjectMapper();

        // Cria um StringWriter para armazenar o JSON resultante.
        StringWriter jsonValue = new StringWriter();

        // Escreve o objeto fornecido como JSON no StringWriter usando o ObjectMapper.
        mapper.writeValue(new PrintWriter(jsonValue), objeto);

        // Retorna o JSON resultante como uma string.
        return jsonValue.toString();
    }


    /**
     * Converte uma string JSON em um objeto Java.
     * 
     * @param json A string JSON a ser convertida.
     * @param objectClass A classe do objeto Java esperado como resultado da conversão.
     * @return O objeto Java resultante da conversão.
     * @throws Exception Se ocorrer um erro durante a conversão.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Object fromJson(String json, Class objectClass) throws Exception
    {
        // Cria uma fábrica de parser JSON.
        JsonFactory f = new MappingJsonFactory();

        // Cria um parser JSON usando a fábrica criada anteriormente.
        JsonParser jp = f.createJsonParser(json);

        // Lê o conteúdo JSON do parser e converte-o em um objeto Java da classe especificada.
        Object obj = jp.readValueAs(objectClass);

        // Retorna o objeto Java resultante da conversão.
        return obj;
    }
}
