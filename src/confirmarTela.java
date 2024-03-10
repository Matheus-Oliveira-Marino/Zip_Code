import bd.daos.Produtos;
import bd.dbos.Produto;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;


/**
 * A classe  {@code confirmarTela} representa a tela de confirmação para exclusão de um produto.
 * Implementa a interface {@code ActionListener} para lidar com eventos de botão.
 * Implementa as interfaces {@code MouseListener} e {@code MouseMotionListener}, 
 * mas não contém implementações para seus métodos.
 */
public class confirmarTela  extends JFrame implements MouseListener, MouseMotionListener,ActionListener
{
    JTextArea txt_result = new JTextArea(100, 5);
    private  String logra, complemento, bairro, cidade, info,UF, ID;
    
    @SuppressWarnings("unused")
    private String cep;
    
    Logradouro logradouro;


    // Componentes da interface.
    private JLabel
            lblCEP = new JLabel("CEP"),
            lblLogradouro = new JLabel("Logradouro"),
            lblBairro = new JLabel("Bairro"),
            lblCidade = new JLabel("Cidade"),
            lblComplemento = new JLabel("Complemento"),
            lblUF = new JLabel("UF"),
            lblInfo = new JLabel("Info"),
            lblRua = new JLabel("Rua"),
            lblID = new JLabel("ID");


    private JTextField
            txtCep = new JTextField(),
            txtLogradouro = new JTextField(),
            txtBairro = new JTextField(),
            txtCidade = new JTextField(),
            txtComplemento = new JTextField(),
            txtUF = new JTextField(),
            txtInfo = new JTextField(),
            txtRua = new JTextField(),
            txtID = new JTextField();


    JButton
            btnCep = new JButton("Confirmar"),
            btnVoltar = new JButton("Voltar");

    private JPanel contentPane;

    Endereco endereco;


    /**
     * Construtor da classe {@code confirmarTela}.
     * Cria a interface gráfica e inicializa seus componentes.
     * @param valor O valor do 'ID' do produto a ser excluído.
     */
    public confirmarTela(String valor)
    {
        // Configura o título da janela
        setTitle("Consultar CEP");

        // Define que a janela não é redimensionável
        this.setResizable(false);

        // Cria o painel principal.
        contentPane = new JPanel();

        // Definindo a borda do painel.
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Define as dimensões da janela.
        setBounds(300, 300, 510, 390);

        // Define a posição da janela para que fique centralizada.
        this.setLocation(400, 190);

        // Define a janela como visível.
        this.setVisible(true);

        System.out.println("valor 1"+valor);

        // Configuração inicial dos campos de texto
        txtCidade.setEditable(false);
        txtLogradouro.setEditable(false);
        txtUF.setEditable(false);
        txtInfo.setEditable(false);
        txtBairro.setEditable(false);
        txtComplemento.setEditable(false);
        txtRua.setEditable(false);

        // Configuração do layout.
        setContentPane(contentPane);
        contentPane.setLayout(null);


        // Adiciona os componentes à interface.
        // Define a posição e o tamanho do rótulo 'lblCEP' e o adiciona ao painel.
        lblCEP.setBounds(23, 38, 46, 14);
        contentPane.add(lblCEP);

        // Define a posição e o tamanho do rótulo 'lblRua' e o adiciona ao painel.
        lblRua.setBounds(200, 38, 40, 14);
        contentPane.add(lblRua);

        // Define a posição e o tamanho do campo de texto 'txtRua' e o adiciona ao painel.
        txtRua.setBounds(233, 40, 40, 14);
        contentPane.add(txtRua);
        txtRua.setColumns(10);

        // Define a posição e o tamanho do rótulo 'lblID' e o adiciona ao painel.
        lblID.setBounds(360, 38, 46, 14);
        contentPane.add(lblID);

        // Define a posição e o tamanho do rótulo 'lblBairro' e o adiciona ao painel.
        lblBairro.setBounds(23, 120, 46, 14);
        contentPane.add(lblBairro);

        // Define a posição e o tamanho do rótulo 'lblCidade' e o adiciona ao painel.
        lblCidade.setBounds(23, 165, 46, 14);
        contentPane.add(lblCidade);

        // Define a posição e o tamanho do rótulo 'lblComplemento' e o adiciona ao painel.
        lblComplemento.setBounds(23, 210, 85, 20);
        contentPane.add(lblComplemento);

        // Define a posição e o tamanho do rótulo 'lblUF' e o adiciona ao painel.
        lblUF.setBounds(315, 165, 20, 14);
        contentPane.add(lblUF);

        // Define a posição e o tamanho do rótulo 'lblLogradouro' e o adiciona ao painel.
        lblLogradouro.setBounds(23, 78, 75, 14);
        contentPane.add(lblLogradouro);

        // Define a posição e o tamanho do rótulo 'lblInfo' e o adiciona ao painel.
        lblInfo.setBounds(23, 250, 34, 20);
        contentPane.add(lblInfo);

        // Define a posição e o tamanho do campo de texto 'txtInfo' e o adiciona ao painel.
        txtInfo.setBounds(60, 250, 370, 20);
        contentPane.add(txtInfo);

        // Define a posição e o tamanho do campo de texto 'txtUF' e o adiciona ao painel.
        txtUF.setBounds(340, 165, 40, 14);
        contentPane.add(txtUF);

        // Define a posição e o tamanho do campo de texto 'txtComplemento' e o adiciona ao painel.
        txtComplemento.setBounds(110, 210, 350, 20);
        contentPane.add(txtComplemento);

        // Define a posição e o tamanho do campo de texto 'txtCep' e o adiciona ao painel.
        txtCep.setBounds(61, 35, 104, 20);
        contentPane.add(txtCep);

        // Obtém o CEP associado ao valor e define o texto do campo de texto 'txtCep'.
        String cep;
        try
        {
            cep = Produtos.retornaCEP(Integer.parseInt(valor));
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        // Define o texto do campo de texto txtCep como o valor do 'CEP'.
        txtCep.setText(cep);

        // Torna o campo de texto txtCep não editável.
        txtCep.setEditable(false);

        // Define o número de colunas do campo de texto txtCep como '10'.
        txtCep.setColumns(10);

        // Define o posicionamento e o número de colunas do campo de texto 'txtLogradouro'.
        txtLogradouro.setBounds(110, 78, 275, 18);
        contentPane.add(txtLogradouro);
        txtLogradouro.setColumns(10);

        // Define o posicionamento e o número de colunas do campo de texto 'txtBairro'.
        txtBairro.setBounds(79, 120, 325, 20);
        contentPane.add(txtBairro);
        txtBairro.setColumns(10);

        // Define o posicionamento e o número de colunas do campo de texto 'txtCidade'.
        txtCidade.setBounds(79, 162, 218, 20);
        contentPane.add(txtCidade);
        txtCidade.setColumns(10);

        // Define o posicionamento, o texto, torna não editável e define o número de colunas 
        // do campo de texto 'txtID'.
        txtID.setBounds(380, 39, 50, 14);
        contentPane.add(txtID);
        txtID.setText(valor);
        txtID.setEditable(false);
        txtID.setColumns(10);

        // Define o posicionamento e dimensões do botão 'btnCep'.
        btnCep.setBounds(23, 310, 100, 23);
        contentPane.add(btnCep);

        // Define o posicionamento e dimensões do botão 'btnVoltar'.
        btnVoltar.setBounds(360, 310, 89, 23);
        contentPane.add(btnVoltar);



        // Adiciona listeners aos botões.
        btnCep.addActionListener(this);
        btnVoltar.addActionListener(this);

        ID = valor; // Atribui o valor recebido como parâmetro à variável 'ID'.

        // Obtém informações do CEP através do serviço web.
        logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cep);
        
        // Obtém a cidade do objeto Logradouro e a exibe no campo de texto txtCidade
        cidade =  logradouro.getCidade();

        txtCidade.setText(cidade);
        txtCidade.setEditable(false); // Torna o campo de texto txtCidade não editável.
        
        // Obtém o logradouro do objeto Logradouro e o exibe no campo de texto txtLogradouro
        logra = logradouro.getLogradouro();

        txtLogradouro.setText(logra);
        txtLogradouro.setEditable(false); // Torna o campo de texto txtLogradouro não editável.
        
        // Obtém o estado do objeto Logradouro e o exibe no campo de texto txtUF
        UF = logradouro.getEstado();

        txtUF.setText(UF);
        txtUF.setEditable(false); // Torna o campo de texto txtUF não editável.
        
        // Obtém as informações do estado do objeto Logradouro e as exibe no campo de texto txtInfo
        info = String.valueOf(logradouro.getEstado_info());

        txtInfo.setText(info);
        txtInfo.setEditable(false); // Torna o campo de texto txtInfo não editável.
        
        // Obtém o bairro do objeto Logradouro e o exibe no campo de texto txtBairro
        bairro = logradouro.getBairro();

        txtBairro.setText(bairro);
        txtBairro.setEditable(false); // Torna o campo de texto txtBairro não editável.
        
        txtRua.setEditable(false); // Torna o campo de texto txtRua não editável.
        txtID.setEditable(false); // Torna o campo de texto txtID não editável.

        try
        {
            complemento = logradouro.getComplemento();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        txtComplemento.setText(String.valueOf(complemento));
        txtComplemento.setEditable(false);

        int id = Integer.parseInt(valor);
        String r;
        try
        {
            r = Produtos.getRua(new Produto(id));
            txtRua.setText(r);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
        System.out.println("valor 2" + valor);

    }


    /**
     * Método 'actionPerformed' para lidar com eventos de botão.
     * Se o botão "Confirmar" for pressionado, o produto é excluído.
     * Se o botão "Voltar" for pressionado, a tela de exclusão é fechada.
     * @param e O evento de ação.
     */
    @Override
public void actionPerformed(ActionEvent e)
{
    // Verifica se o botão "Confirmar" foi pressionado.
    if (e.getSource() == btnCep)
    {
        try
        {
            // Imprime o 'ID' do produto no console.
            System.out.println(ID);
            
            // Converte o 'ID' para um número inteiro.
            int exclu = Integer.parseInt(ID);
            
            // Exclui o produto do banco de dados.
            Produtos.excluir(exclu);
            
            // Exibe uma mensagem de sucesso ao usuário.
            JOptionPane.showMessageDialog(null , "Excluido com sucesso");

        }
        catch (Exception erro)
        {
            // Imprime informações sobre o erro no console.
            erro.printStackTrace();
        }
    }

    // Verifica se o botão "Voltar" foi pressionado.
    if(e.getSource() == btnVoltar)
    {
        // Fecha a janela atual.
        this.dispose();
        
        // Abre a tela de exclusão novamente.
        new ExcluirTela();
    }
}


    /**
     * Invocado quando o mouse é clicado (pressionado e solto) em um componente.
     * @param e O evento do mouse gerado.
     */
    @Override
    public void mouseClicked(MouseEvent e) {}

    /**
     * Invocado quando um botão do mouse é pressionado em um componente.
     * @param e O evento do mouse gerado.
     */
    @Override
    public void mousePressed(MouseEvent e) {}

    /**
     * Invocado quando um botão do mouse é solto em um componente.
     * @param e O evento do mouse gerado.
     */
    @Override
    public void mouseReleased(MouseEvent e) {}

    /**
     * Invocado quando o mouse entra em um componente.
     * @param e O evento do mouse gerado.
     */
    @Override
    public void mouseEntered(MouseEvent e) {}
        

    /**
     * Invocado quando o mouse sai de um componente.
     * @param e O evento do mouse gerado.
     */
    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * Invocado quando o mouse é arrastado enquanto um botão do mouse é pressionado.
     * @param e O evento do mouse gerado.
     */
    @Override
    public void mouseDragged(MouseEvent e) {}

    /**
     * Invocado quando o mouse é movido sem pressionar nenhum botão do mouse.
     * @param e O evento do mouse gerado.
     */
    @Override
    public void mouseMoved(MouseEvent e) {}
}
