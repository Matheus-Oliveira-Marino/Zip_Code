import Atxy2k.CustomTextField.RestrictedTextField;
import bd.daos.Produtos;
import bd.dbos.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;


/**
 * A classe {@code Janela} representa a interface principal do programa.
 */
public class Janela extends JFrame implements ActionListener
{

    
    // Identificador único para serialização. 
    private static final long serialVersionUID = 1L;

    /**
     * Variáveis para armazenar dados de CEP, nome e número.
     */
    private String txtCEP, txtNome;
    public static String txtNumero;

    /**
     * Identificador para o produto.
     */
    @SuppressWarnings("unused")
    private int id = 1;

    // Botões da interface gráfica.
    protected JButton btn_adicionarItem = new JButton("Adicionar"),
            btn_verItem = new JButton("Procurar"),
            btn_alterarItem = new JButton("Alterar"),
            btn_excluirItem = new JButton("Excluir");

    
    // Rótulos da interface gráfica.
    protected JLabel lb_CEP = new JLabel("Insira o CEP "),
            lb_Nome = new JLabel("Insira o nome "),
            lb_Numero = new JLabel("Insira o numero "),
            lb_Resultado = new JLabel("");

    // Campos de texto da interface gráfica.
    protected JTextField txt_CEP = new JTextField(20),
            txt_Nome = new JTextField(20),
            txt_Numero = new JTextField(20);


    // Objeto para lidar com informações de logradouro.
    Logradouro logradouro = new Logradouro();

    
    /**
     * Construtor da classe Janela.
     */
    public Janela() 
    {
        // Configura o título da janela.
        super("Shopping");

        // Impede que o tamanho da janela seja alterado pelo usuário.
        this.setResizable(false);

        // Define a ação padrão ao fechar a janela.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Cria um novo painel para organizar os componentes da interface.
        JPanel painel = new JPanel();

        // Define o layout do painel como uma grade com 2 colunas e número ilimitado de linhas,
        // com espaçamento horizontal e vertical de 10 pixels.
        GridLayout layout = new GridLayout(0, 2, 10, 10);
        painel.setLayout(layout);
    
        // Restringe a entrada de texto no campo de CEP
        // para permitir apenas números e limita o número de caracteres.
        RestrictedTextField validar = new RestrictedTextField(txt_CEP);
        validar.setOnlyNums(true);
        validar.setLimit(8);
    
        // Restringe a entrada de texto no campo de número 
        // para permitir apenas números e limita o número de caracteres.
        RestrictedTextField valida_rua = new RestrictedTextField(txt_Numero);
        valida_rua.setOnlyNums(true);
        valida_rua.setLimit(4);
    
        // Adiciona os componentes relacionados ao CEP no painel.
        painel.add(lb_CEP);
        painel.add(txt_CEP);
    
        // Adiciona os componentes relacionados ao nome no painel.
        painel.add(lb_Nome);
        painel.add(txt_Nome);
    
        // Adiciona os componentes relacionados ao número no painel.
        painel.add(lb_Numero);
        painel.add(txt_Numero);
    
        // Adiciona um rótulo vazio ao painel (será usado para exibir resultados).
        painel.add(lb_Resultado);
    
        // Cria um novo painel para organizar os botões da interface.
        JPanel painelbotao = new JPanel();
        
        // Define o layout do painel de botões.
        GridLayout layout1 = new GridLayout();
        painelbotao.setLayout(layout1);

        // Adiciona os botões ao painel de botões.
        painelbotao.add(btn_adicionarItem);
        painelbotao.add(btn_verItem);
        painelbotao.add(btn_alterarItem);
        painelbotao.add(btn_excluirItem);
    
        // Obtém o contêiner de conteúdo da janela e define seu layout como 'BorderLayout'.
        Container cntForm = this.getContentPane();
        cntForm.setLayout(new BorderLayout());
        
        // Adiciona o painel principal à região oeste (esquerda) do contêiner.
        cntForm.add(painel, BorderLayout.WEST);

        // Adiciona o painel de botões à região sul (inferior) do contêiner.
        cntForm.add(painelbotao, BorderLayout.SOUTH);
    
        // Adiciona ouvintes de ação aos botões.
        btn_adicionarItem.addActionListener(this);
        btn_alterarItem.addActionListener(this);
        btn_verItem.addActionListener(this);
        btn_excluirItem.addActionListener(this);
    
        // Define a posição e o tamanho da janela.
        this.setLocation(400, 190); // Deixa a tela no meio.
        
        this.setSize(410, 180); // Tamanho da tela.
        
        // Torna a janela visível.
        this.setVisible(true); 
    }


    /**
     * Valida um CEP usando uma expressão regular.
     *
     * @param cep O CEP a ser validado.
     * @return {@code true} se o CEP é válido, caso contrário {@code false}.
     */
    public static boolean validarCEP(String cep)
    {
        // Expressão regular para validar CEP no formato "XXXXX-XXX" ou "XXXXXXXX".
        String regex = "\\d{5}-\\d{3}|\\d{8}";
        // Compila a expressão regular em um padrão
        Pattern pattern = Pattern.compile(regex);
        // Verifica se o CEP informado corresponde ao padrão
        return pattern.matcher(cep).matches();
    }


    /**
     * Método 'actionPerformed' é chamado quando uma ação é realizada por um componente 
     * que possui um ouvinte de ação(listener) registrado.
     * 
     * @param e O evento de ação que ocorreu.
     */
    @Override
public void actionPerformed(ActionEvent e) 
    {
        // Cria um novo objeto Endereco e define o CEP com o valor digitado no campo de texto.
        Endereco endereco = new Endereco();
        endereco.setCep(txt_CEP.getText());

        // Verifica se o CEP digitado é válido.
        boolean valido = validarCEP(String.valueOf(endereco));

        // Atribui os valores digitados nos campos de texto às variáveis correspondentes.
        txtCEP = String.valueOf(endereco);
        txtNome = txt_Nome.getText();
        txtNumero = txt_Numero.getText();

        // Verifica qual botão foi pressionado.
        if (e.getSource() == btn_adicionarItem) 
        {
            // Se o CEP for válido, mostra uma mensagem de confirmação.
            if (valido) 
            {
                JOptionPane.showMessageDialog(null, "CEP OK!");
            }

            // Se o CEP não for válido, exibe uma mensagem de erro e limpa os campos de texto.
            if (!valido)
             {
                JOptionPane.showMessageDialog(this, "CEP inválido! Preencha todos os dados corretamente!");
                txt_CEP.setText("");
                txt_Nome.setText("");
                txt_Numero.setText("");
                return;
            } else 
            {
                try {
                    // Adiciona um novo produto à lista de produtos e exibe uma mensagem de sucesso.
                    JOptionPane.showMessageDialog(null, "Shopping adicionado com sucesso!");
                    Produtos.incluir(new Produto(txtCEP, txtNome, txtNumero));
                } 
                catch (Exception erro) 
                {
                    // Imprime a pilha de erros.
                    erro.printStackTrace();
                }

            }

            // Limpa os campos de texto após a ação ser executada.
            txt_CEP.setText("");
            txt_Nome.setText("");
            txt_Numero.setText("");

        } else if (e.getSource() == btn_excluirItem)
         {
            // Se o botão de exclusão for pressionado, fecha a janela atual e abre a tela de exclusão.
            this.dispose();
            new ExcluirTela();
        } 
        else if (e.getSource() == btn_alterarItem) 
        {
            try 
            {
                // Se o botão de alteração for pressionado, fecha a janela atual e abre a tela de alteração.
                this.dispose();
                new AlterarTela();

                // Limpa os campos de texto após a ação ser executada.
                txt_CEP.setText("");
                txt_Nome.setText("");
                txt_Numero.setText("");
            } 
            catch (Exception erro) 
            {   // Imprime a pilha de erros.
                erro.printStackTrace();
            }
        }

        // Se o botão de visualização for pressionado, abre a tela de visualização.
        if (e.getSource() == btn_verItem) 
        {
            new VisualizacaoTela();
        }
    }
}
