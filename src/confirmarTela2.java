import bd.daos.Produtos;
import bd.dbos.Produto;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;



/**
 * A classe {@code confirmarTela2} é responsável por criar a interface de usuário 
 * para confirmar a alteração de um cadastro.
 */
public class confirmarTela2  extends JFrame implements MouseListener, MouseMotionListener,ActionListener
{
    JTextArea txt_result = new JTextArea(100, 5);
    private  String logra, complemento, bairro, cidade, info,UF, ID;
    
    @SuppressWarnings("unused")
    private String cep,txt_Nome,txt_ID,txt_CEP,txt_Numero;

    Logradouro logradouro;

    private JLabel
            lblCEP = new JLabel("CEP"),
            lblLogradouro = new JLabel("Logradouro"),
            lblBairro = new JLabel("Bairro"),
            lblCidade = new JLabel("Cidade"),
            lblComplemento = new JLabel("Complemento"),
            lblUF = new JLabel("UF"),
            lblInfo = new JLabel("Info"),
            lblRua = new JLabel("Rua"),
            lbNome = new JLabel("Nome"),
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
            txtNome = new JTextField(),
            txtID = new JTextField();


    JButton
            btnCep = new JButton("Confirmar"),
            btnVoltar = new JButton("Voltar");

    private JPanel contentPane;

    Endereco endereco;


    /**
     * Cria uma nova instância de `confirmarTela2`.
     * @param id O 'ID' do cadastro a ser alterado.
     * @param nome O 'nome' associado ao cadastro.
     * @param cep O 'CEP' associado ao cadastro.
     * @param numero O 'número' associado ao cadastro.
     */
    public confirmarTela2(String id, String nome, String cep, String numero)
    {
        /**
         * Define o título da tela como "Consultar CEP".
         */
        setTitle("Consultar CEP");

        /**
         * Impede que a janela seja redimensionada pelo usuário.
         */
        this.setResizable(false);

        /**
         * Cria um novo painel para conter os componentes da interface.
         */
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        /**
         * Define o tamanho e a posição da janela.
         */
        setBounds(350, 350, 530, 510);

        /**
         * Define a posição da janela para que ela fique centralizada na tela.
         */
        this.setLocation(400, 190);

        /**
         * Torna a janela visível.
         */
        this.setVisible(true);

        /**
         * Define que o campo de texto para a cidade não pode ser editado pelo usuário.
         */
        txtCidade.setEditable(false);

        /**
         * Define que o campo de texto para o logradouro não pode ser editado pelo usuário.
         */
        txtLogradouro.setEditable(false);

        /**
         * Define que o campo de texto para a UF não pode ser editado pelo usuário.
         */
        txtUF.setEditable(false);

        /**
         * Define que o campo de texto para a informação não pode ser editado pelo usuário.
         */
        txtInfo.setEditable(false);

        /**
         * Define que o campo de texto para o bairro não pode ser editado pelo usuário.
         */
        txtBairro.setEditable(false);

        /**
         * Define que o campo de texto para o complemento não pode ser editado pelo usuário.
         */
        txtComplemento.setEditable(false);

        /**
         * Define que o campo de texto para a rua não pode ser editado pelo usuário.
         */
        txtRua.setEditable(false);

        /**
         * Define o conteúdo do painel como o painel criado.
         */
        setContentPane(contentPane);

        /**
         * Define o layout do painel como nulo para que os componentes sejam posicionados manualmente.
         */
        contentPane.setLayout(null);

        /**
         * Adiciona o rótulo "CEP" ao painel e define sua posição.
         */
        lblCEP.setBounds(23, 38, 46, 14);
        contentPane.add(lblCEP);

        /**
         * Adiciona o rótulo "Rua" ao painel e define sua posição.
         */
        lblRua.setBounds(200, 38, 40, 14);
        contentPane.add(lblRua);

        /**
         * Adiciona o campo de texto para a rua ao painel e define sua posição e tamanho.
         */
        txtRua.setBounds(233, 40, 40, 14);
        contentPane.add(txtRua);
        txtRua.setColumns(10);

        /**
         * Adiciona o rótulo "ID" ao painel e define sua posição.
         */
        lblID.setBounds(360, 38, 46, 14);
        contentPane.add(lblID);

        /**
         * Adiciona o rótulo "Bairro" ao painel e define sua posição.
         */
        lblBairro.setBounds(23, 120, 46, 14);
        contentPane.add(lblBairro);

        /**
         * Adiciona o rótulo "Cidade" ao painel e define sua posição.
         */
        lblCidade.setBounds(23, 165, 46, 14);
        contentPane.add(lblCidade);

        /**
         * Adiciona o rótulo "Complemento" ao painel e define sua posição.
         */
        lblComplemento.setBounds(23, 210, 85, 20);
        contentPane.add(lblComplemento);

        /**
         * Adiciona o rótulo "UF" ao painel e define sua posição.
         */
        lblUF.setBounds(315, 165, 20, 14);
        contentPane.add(lblUF);

        /**
         * Adiciona o rótulo "Logradouro" ao painel e define sua posição.
         */
        lblLogradouro.setBounds(23, 78, 75, 14);
        contentPane.add(lblLogradouro);

        /**
         * Adiciona o rótulo "Info" ao painel e define sua posição.
         */
        lblInfo.setBounds(23, 250, 34, 20);
        contentPane.add(lblInfo);

        /**
         * Adiciona o campo de texto para a informação ao painel e define sua posição e tamanho.
         */
        txtInfo.setBounds(60, 250, 370, 20);
        contentPane.add(txtInfo);

        /**
         * Adiciona o campo de texto para a UF ao painel e define sua posição e tamanho.
         */
        txtUF.setBounds(340, 165, 40, 14);
        contentPane.add(txtUF);

        /**
         * Adiciona o campo de texto para o complemento ao painel e define sua posição e tamanho.
         */
        txtComplemento.setBounds(110, 210, 350, 20);
        contentPane.add(txtComplemento);

        /**
         * Adiciona o rótulo "Nome" ao painel e define sua posição.
         */
        lbNome.setBounds(23, 300, 350, 20);
        contentPane.add(lbNome);

        /**
         * Adiciona o campo de texto para o nome ao painel e define sua posição e tamanho.
         * Define o texto do campo como o nome fornecido.
         * Define que o campo não pode ser editado pelo usuário.
         */
        txtNome.setBounds(66, 300, 150, 20);
        contentPane.add(txtNome);
        txtNome.setText(nome);
        txtNome.setEditable(false);
        txtNome.setColumns(10);

        /**
         * Obtém o texto do campo de texto para o nome e atribui à variável 'txt_Nome'.
         */
        txt_Nome = txtNome.getText();

        /**
         * Adiciona o campo de texto para o 'CEP' ao painel e define sua posição e tamanho.
         */
        txtCep.setBounds(61, 35, 104, 20);
        contentPane.add(txtCep);

        /**
         * Define o texto do campo de texto para o 'CEP' como o valor fornecido 
         * e atribui esse valor à variável 'txt_CEP'.
         * Define que o campo não pode ser editado pelo usuário.
         * Define o número de colunas do campo como '10'.
         */
        txtCep.setText(cep);
        txt_CEP = txtCep.getText();
        txtCep.setEditable(false);
        txtCep.setColumns(10);

        /**
         * Adiciona o campo de texto para o 'logradouro' ao painel e define sua posição e tamanho.
         */
        txtLogradouro.setBounds(110, 78, 275, 18);
        contentPane.add(txtLogradouro);
        txtLogradouro.setColumns(10);

        /**
         * Adiciona o campo de texto para o 'bairro' ao painel e define sua posição e tamanho.
         */
        txtBairro.setBounds(79, 120, 325, 20);
        contentPane.add(txtBairro);
        txtBairro.setColumns(10);

        /**
         * Adiciona o campo de texto para a 'cidade' ao painel e define sua posição e tamanho.
         */
        txtCidade.setBounds(79, 162, 218, 20);
        contentPane.add(txtCidade);
        txtCidade.setColumns(10);

        /**
         * Adiciona o campo de texto para o 'ID' ao painel 
         * e define sua posição e tamanho.
         * Define o texto do campo como o 'ID' fornecido.
         * Define que o campo não pode ser editado pelo usuário.
         * Define o número de colunas do campo como '10'.
         */
        txtID.setBounds(380, 39, 50, 14);
        contentPane.add(txtID);
        txtID.setText(id);
        txtID.setEditable(false);
        txtID.setColumns(10);

        /**
         * Adiciona o botão "Confirmar" ao painel e define sua posição e tamanho.
         */
        btnCep.setBounds(23, 360, 100, 23);
        contentPane.add(btnCep);

        /**
         * Adiciona o botão "Voltar" ao painel e define sua posição e tamanho.
         */
        btnVoltar.setBounds(360, 360, 89, 23);
        contentPane.add(btnVoltar);

        /**
         * Adiciona um ouvinte de ação ao botão "Confirmar".
         */
        btnCep.addActionListener(this);

        /**
         * Adiciona um ouvinte de ação ao botão "Voltar".
         */
        btnVoltar.addActionListener(this);

        /**
         * Obtém os dados do logradouro usando a API Postmon.
         */
        logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cep);

        /**
         * Obtém a cidade do 'logradouro' e define o texto do campo de texto correspondente.
         */
        cidade =  logradouro.getCidade();
        txtCidade.setText(cidade);
        txtCidade.setEditable(false);

        /**
         * Obtém o 'logradouro' e define o texto do campo de texto correspondente.
         */
        logra = logradouro.getLogradouro();
        txtLogradouro.setText(logra);
        txtLogradouro.setEditable(false);

        /**
         * Obtém a 'UF' e define o texto do campo de texto correspondente.
         */
        UF = logradouro.getEstado();
        txtUF.setText(UF);
        txtUF.setEditable(false);

        /**
         * Obtém a informação do estado e define o texto do campo de texto correspondente.
         */
        info = String.valueOf(logradouro.getEstado_info());
        txtInfo.setText(info);
        txtInfo.setEditable(false);

        /**
         * Obtém o bairro e define o texto do campo de texto correspondente.
         */
        bairro = logradouro.getBairro();
        txtBairro.setText(bairro);
        txtBairro.setEditable(false);

        /**
         * Define que o campo de texto para a rua e o campo de texto 
         * para o 'ID' não podem ser editados pelo usuário.
         */
        txtRua.setEditable(false);
        txtID.setEditable(false);
        
       /**
         * Tenta obter o complemento do logradouro.
         * Se ocorrer uma exceção, imprime o rastreamento do erro.
         */
        try
        {
            complemento = logradouro.getComplemento();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        /**
         * Define o texto do campo de texto para o complemento como o valor do complemento obtido.
         * Define que o campo de texto não pode ser editado pelo usuário.
         */
        txtComplemento.setText(String.valueOf(complemento));
        txtComplemento.setEditable(false);

        /**
         * Tenta definir o texto do campo de texto para a rua como o número fornecido.
         * Atribui esse valor à variável 'txt_Numero'.
         * Se ocorrer uma exceção, lança uma 'RuntimeException' com o erro.
         */
        @SuppressWarnings("unused")
        String r;
        try
        {
            txtRua.setText(numero);
            txt_Numero = txtRua.getText();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        /**
         * Atribui o valor do 'id' à variável 'ID'.
         */
        ID = id;
    }





    /**
     * Método que responde às ações dos botões da interface.
     * Se o botão "Confirmar" for pressionado, tenta alterar o cadastro com as informações fornecidas.
     * Se o botão "Voltar" for pressionado, fecha a tela atual e abre a tela de alteração.
     * @param e O evento que acionou o método.
     */
    public void actionPerformed(ActionEvent e) 
    {
        // Verifica se o botão "Confirmar" foi pressionado.
        if (e.getSource() == btnCep) 
        {
            try 
            {
                // Obtém o 'ID' convertendo a string em um inteiro.
                System.out.println(ID);
                int id = Integer.parseInt(ID);
    
                // Chama o método para alterar o cadastro.
                Produtos.alterar(new Produto(txt_CEP, txt_Nome, txt_Numero, id));
                
                // Exibe uma mensagem de sucesso.
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
    
            } 
            catch (Exception erro) 
            {
                // Em caso de erro, imprime o rastreamento do erro.
                erro.printStackTrace();
            }
        }
    
        // Verifica se o botão "Voltar" foi pressionado.
        if(e.getSource() == btnVoltar) 
        {
            // Fecha a tela atual.
            this.dispose();
            
            // Abre a tela de alteração.
            new AlterarTela();
        }
    }

    /**
     * Invocado quando o mouse é clicado (pressionado e solto) em um componente.
     * @param e O evento do mouse gerado
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
