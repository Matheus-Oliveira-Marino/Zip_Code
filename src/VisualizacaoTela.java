import bd.daos.Produtos;
import bd.dbos.Produto;
import javax.swing.*;
import java.awt.event.*;


import javax.swing.border.EmptyBorder;


/**
 * A classe {@code VisualizacaoTela} é responsável por criar a interface gráfica 
 * para visualização de informações sobre um logradouro.
 */
public class VisualizacaoTela  extends JFrame implements MouseListener, MouseMotionListener,ActionListener
{
    // JTextArea para exibir resultados, com 100 linhas e 5 colunas.
    JTextArea txt_result = new JTextArea(100, 5);

    // Declaração de variáveis para armazenar informações sobre o endereço.
    private String logra, complemento, bairro, cidade, info, UF, ID;
    private String cep;
    Logradouro logradouro;

    // Declaração de 'JLabels' para exibir rótulos na interface gráfica
    private JLabel
            lblCEP = new JLabel("CEP"), // Rótulo para o campo 'CEP'.
            lblLogradouro = new JLabel("Logradouro"), // Rótulo para o campo 'Logradouro'.
            lblBairro = new JLabel("Bairro"), // Rótulo para o campo 'Bairro'.
            lblCidade = new JLabel("Cidade"), // Rótulo para o campo 'Cidade'.
            lblComplemento = new JLabel("Complemento"), // Rótulo para o campo 'Complemento'.
            lblUF = new JLabel("UF"), // Rótulo para o campo 'UF'.
            lblInfo = new JLabel("Info"), // Rótulo para o campo de 'informações adicionais'.
            lblRua = new JLabel("Rua"), // Rótulo para o campo 'Rua'.
            lblID = new JLabel("ID"); // Rótulo para o campo 'ID'.

    // Declaração de 'JTextFields' para permitir a entrada de dados na interface gráfica.
    private JTextField
            txtCep = new JTextField(), // Campo de entrada para o 'CEP'.
            txtLogradouro = new JTextField(), // Campo de entrada para o 'Logradouro'.
            txtBairro = new JTextField(), // Campo de entrada para o 'Bairro'.
            txtCidade = new JTextField(), // Campo de entrada para a 'Cidade'.
            txtComplemento = new JTextField(), // Campo de entrada para o 'Complemento'.
            txtUF = new JTextField(), // Campo de entrada para o 'UF'.
            txtInfo = new JTextField(), // Campo de entrada para 'informações adicionais'.
            txtRua = new JTextField(), // Campo de entrada para a 'Rua'.
            txtID = new JTextField(); // Campo de entrada para o 'ID'.

    // Declaração de 'JButtons' para permitir a execução de ações na interface gráfica.
    JButton
            btnLimpar = new JButton("Limpar"), // Botão para limpar os campos.
            btnCep = new JButton("Buscar"), // Botão para buscar informações com base no 'CEP'.
            btnVoltar = new JButton("Voltar"); // Botão para voltar a uma tela anterior.

    // Declaração de um 'JPanel' para conter todos os componentes da interface gráfica.
    private JPanel contentPane;

    // Objeto da classe 'Endereco'.
    Endereco endereco;



     /**
     * Construtor para criar a janela de visualização 
     * de informações sobre um logradouro.
     */
    public VisualizacaoTela()
    {
        // Define o título da janela.
        setTitle("Consultar CEP");

        // Impede que o usuário redimensione a janela.
        this.setResizable(false);

        // Cria um painel para o conteúdo da janela e define suas margens internas.
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Define as dimensões e a posição da janela na tela.
        setBounds(300, 300, 510, 390);

        // Define a posição da janela para que fique centralizada na tela.
        this.setLocation(400, 190);

        // Torna a janela visível.
        this.setVisible(true);

        // Define se o campo de texto da 'cidade' pode ser editado.
        txtCidade.setEditable(false);

        // Define se o campo de texto do 'logradouro' pode ser editado.
        txtLogradouro.setEditable(false);

        // Define se o campo de texto 'UF' pode ser editado.
        txtUF.setEditable(false);

        // Define se o campo de texto da 'informação' pode ser editado.
        txtInfo.setEditable(false);

        // Define se o campo de texto do 'bairro' pode ser editado.
        txtBairro.setEditable(false);

        // Define se o campo de texto do 'complemento' pode ser editado.
        txtComplemento.setEditable(false);

        // Define se o campo de texto da 'rua' pode ser editado.
        txtRua.setEditable(false);

        // Define o conteúdo do painel da janela como o painel criado anteriormente.
        setContentPane(contentPane);

        // Define o layout do painel como nulo.
        contentPane.setLayout(null);

        // Adiciona um rótulo para exibir "CEP" na posição especificada.
        lblCEP.setBounds(23, 38, 46, 14);
        contentPane.add(lblCEP);

        // Adiciona um rótulo para exibir "Rua" na posição especificada.
        lblRua.setBounds(200, 38, 40, 14);
        contentPane.add(lblRua);

        // Adiciona um campo de texto para a 'rua' na posição especificada.
        txtRua.setBounds(233, 40, 40, 14);
        contentPane.add(txtRua);
        txtRua.setColumns(10);

        // Adiciona um rótulo para exibir "ID" na posição especificada.
        lblID.setBounds(360, 38, 46, 14);
        contentPane.add(lblID);

        // Adiciona um rótulo para exibir "Bairro" na posição especificada.
        lblBairro.setBounds(23, 120, 46, 14);
        contentPane.add(lblBairro);

        // Adiciona um rótulo para exibir "Cidade" na posição especificada.
        lblCidade.setBounds(23, 165, 46, 14);
        contentPane.add(lblCidade);

        // Adiciona um rótulo para exibir "Complemento" na posição especificada.
        lblComplemento.setBounds(23, 210, 85, 20);
        contentPane.add(lblComplemento);

        // Adiciona um rótulo para exibir "UF" na posição especificada.
        lblUF.setBounds(315, 165, 20, 14);
        contentPane.add(lblUF);

        // Adiciona um rótulo para exibir "Logradouro" na posição especificada.
        lblLogradouro.setBounds(23, 78, 75, 14);
        contentPane.add(lblLogradouro);

        // Adiciona um rótulo para exibir "Info" na posição especificada.
        lblInfo.setBounds(23, 250, 34, 20);
        contentPane.add(lblInfo);

        // Adiciona um campo de texto para a 'informação' na posição especificada.
        txtInfo.setBounds(60, 250, 370, 20);
        contentPane.add(txtInfo);

        // Adiciona um campo de texto para 'UF' na posição especificada.
        txtUF.setBounds(340, 165, 40, 14);
        contentPane.add(txtUF);

        // Adiciona um campo de texto para o 'complemento' na posição especificada.
        txtComplemento.setBounds(110, 210, 350, 20);
        contentPane.add(txtComplemento);

        // Adiciona um campo de texto para o 'CEP' na posição especificada.
        txtCep.setBounds(61, 35, 104, 20);
        contentPane.add(txtCep);
        txtCep.setEditable(false);
        txtCep.setColumns(10);

        // Adiciona um campo de texto para o 'logradouro' na posição especificada.
        txtLogradouro.setBounds(110, 78, 275, 18);
        contentPane.add(txtLogradouro);
        txtLogradouro.setColumns(10);

        // Adiciona um campo de texto para o 'bairro' na posição especificada.
        txtBairro.setBounds(79, 120, 325, 20);
        contentPane.add(txtBairro);
        txtBairro.setColumns(10);

        // Adiciona um campo de texto para a 'cidade' na posição especificada.
        txtCidade.setBounds(79, 162, 218, 20);
        contentPane.add(txtCidade);
        txtCidade.setColumns(10);

        // Adiciona um campo de texto para o 'ID' na posição especificada.
        txtID.setBounds(380, 39, 50, 14);
        contentPane.add(txtID);
        txtID.setColumns(10);

        // Adiciona um botão para limpar na posição especificada.
        btnLimpar.setBounds(23, 310, 89, 23);
        contentPane.add(btnLimpar);

        // Adiciona um botão para buscar 'CEP' na posição especificada.
        btnCep.setBounds(190, 310, 89, 23);
        contentPane.add(btnCep);

        // Adiciona um botão para voltar na posição especificada.
        btnVoltar.setBounds(360, 310, 89, 23);
        contentPane.add(btnVoltar);


         /**
          * Realiza a busca do CEP quando o botão de busca é clicado.
          * @param e O evento de clique do botão.
          */
          btnCep.addActionListener(new ActionListener() // Adiciona um ouvinte de ação ao botão 'btnCep'.
          {
              public void actionPerformed(ActionEvent e) // Define o comportamento ao clicar no botão 'btnCep'.
              {
                  try
                  {
                      String id = txtID.getText(); // Obtém o ID digitado no campo de texto 'txtID'.
          
                      if (id.equals("")) // Verifica se o campo de 'ID' está vazio.
                      {
                        // Exibe uma mensagem de alerta para o usuário.
                        JOptionPane.showMessageDialog(null, "Digite o id"); 
                        txtID.requestFocus(); // Move o foco para o campo de texto 'txtID'.
                      }
          
                      // Obtém o 'CEP' correspondente ao 'ID'.
                      cep = Produtos.retornaCEP(Integer.parseInt(id)); 
          
                      ID = txtID.getText(); // Obtém novamente o 'ID' digitado.
          
                      // Obtém informações do logradouro com base no 'CEP'.
                      logradouro = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cep);
          
                      try 
                      {
                          int idt = Integer.parseInt(ID);

                          // Obtém a rua correspondente ao 'ID'.
                          String r = Produtos.getRua(new Produto(idt)); 
                          txtRua.setText(r); // Define a rua no campo de texto txtRua
                      } catch (Exception ex) 
                      {
                          ex.printStackTrace(); // Imprime o rastreamento da pilha de exceção.
                      }
          
                      txtCep.setText(cep); // Define o 'CEP' no campo de texto 'txtCep'.
          
                      if(logradouro == null) // Verifica se o logradouro é nulo.
                      {
                        // Exibe uma mensagem de alerta
                        JOptionPane.showMessageDialog(null,"esse cep nao retorna nada"); 
                      }
          
                      cidade = logradouro.getCidade(); // Obtém a cidade do 'logradouro'.
                      txtCidade.setText(cidade); // Define a cidade no campo de texto 'txtCidade'.
                      txtCidade.setEditable(false); // Define o campo de texto 'txtCidade' como não editável.
          
                      logra = logradouro.getLogradouro(); // Obtém o 'logradouro'.
                      txtLogradouro.setText(logra); // Define o 'logradouro' no campo de texto 'txtLogradouro'.
                      txtLogradouro.setEditable(false); // Define o campo de texto 'txtLogradouro' como não editável.
          
                      UF = logradouro.getEstado(); // Obtém o estado do 'logradouro'.
                      txtUF.setText(UF); // Define o estado no campo de texto 'txtUF'.
                      txtUF.setEditable(false); // Define o campo de texto 'txtUF' como não editável.
          
                      // Obtém informações adicionais do 'estado'.
                      info = String.valueOf(logradouro.getEstado_info()); 
                      txtInfo.setText(info); // Define as informações no campo de texto 'txtInfo'.
                      txtInfo.setEditable(false); // Define o campo de texto 'txtInfo' como não editável.
          
                      bairro = logradouro.getBairro(); // Obtém o bairro do 'logradouro'.
                      txtBairro.setText(bairro); // Define o bairro no campo de texto 'txtBairro'.
                      txtBairro.setEditable(false); // Define o campo de texto 'txtBairro' como não editável.
          
                      txtRua.setEditable(false); // Define o campo de texto 'txtRua' como não editável.
                      txtID.setEditable(false); // Define o campo de texto 'txtID' como não editável.
          
                      try 
                      {
                        // Obtém o complemento do 'logradouro'.
                        complemento = logradouro.getComplemento(); 
                      } catch (Exception ex) {
                          ex.printStackTrace(); // Imprime o rastreamento da pilha de exceção.
                      }

                      // Define o complemento no campo de texto 'txtComplemento'.
                      txtComplemento.setText(String.valueOf(complemento)); 

                       // Define o campo de texto txtComplemento como não editável.
                      txtComplemento.setEditable(false);
                  }
                  catch (Exception ex)
                  {
                      throw new RuntimeException(ex); // Lança uma exceção RuntimeException
                  }
              }
          });


        /**
         * Fecha a janela quando o botão de voltar é clicado.
         * @param e O evento de clique do botão.
         */
        btnVoltar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == btnVoltar)
                {
                    dispose();
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener()
        {

            /**
             * Limpa os campos de texto quando o botão de limpar é clicado.
             * @param e O evento de clique do botão.
             */
            public void actionPerformed(ActionEvent e) // Define o comportamento ao clicar no botão 'btnLimpar'.
            {
                if (e.getSource() == btnLimpar) // Verifica se a fonte do evento é o botão 'btnLimpar'.
                {
                    txtCep.setText(""); // Limpa o campo de texto 'txtCep'.
                    txtInfo.setText(""); // Limpa o campo de texto 'txtInfo'.
                    txtComplemento.setText(""); // Limpa o campo de texto 'txtComplemento'.
                    txtBairro.setText(""); // Limpa o campo de texto 'txtBairro'.
                    txtUF.setText(""); // Limpa o campo de texto 'txtUF'.
                    txtLogradouro.setText(""); // Limpa o campo de texto 'txtLogradouro'.
                    txtCidade.setText(""); // Limpa o campo de texto 'txtCidade';
                    txtRua.setText(""); // Limpa o campo de texto 'txtRua'.
                    txtID.setText(""); // Limpa o campo de texto 'txtID'.

                    txtCep.requestFocus(); // Define o foco para o campo de texto 'txtCep'.
                    txtID.setEditable(true); // Define o campo de texto 'txtID' como editável.

                }
            }       
        });
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



    /**
     * Método obrigatório devido à implementação da interface ActionListener, mas não utilizado.
     * @param arg0 O evento de ação.
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {}

}
