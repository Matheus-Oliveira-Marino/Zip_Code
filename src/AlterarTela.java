import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;



/**
 * A classe {@code AlterarTela} representa a interface gráfica para a alteração de cadastro de um produto.
 * Esta classe estende a classe {@code JFrame} e implementa as interfaces 
 * {@code MouseListener}, {@code MouseMotionListener} e {@code ActionListener}.
 */
public class AlterarTela extends JFrame implements MouseListener, MouseMotionListener, ActionListener
{
    ResultSet rs;

    // Labels para as entradas de texto.
    protected JLabel
            lb_nome = new JLabel("Insira o novo nome:"),
            lb_CEP = new JLabel("Insira o novo CEP: "),
            lb_Rua = new JLabel("Insira a nova Rua: "),

            lb_ID = new JLabel("Insira o ID a ser alterado: ");


    // Campos de entrada de texto.        
    protected JTextField
            txt_nome = new JTextField(20),
            txt_CEP = new JTextField(20),
            txt_Rua = new JTextField(20),
            txt_ID = new JTextField(20);

    // Botões para confirmar e voltar.     
    protected  JButton
            btn_confirmar = new JButton("Confirmar"),
            btn_voltar = new JButton("Voltar");


    // Strings para armazenar os valores dos campos de entrada de texto.
    private String txtCEP,txtRua,txtID,txtNome;

    /**
     * Construtor da classe {@code AlterarTela}.
     * Este método cria a interface gráfica para a alteração de cadastro de um produto.
     */
    public AlterarTela()
    {
        super("Alterar cadastro"); // Define o título da janela como "Alterar cadastro".
        this.setResizable(false); // Define a capacidade de redimensionamento da janela como falso.
        JPanel painel = new JPanel(); // Cria um novo painel para conter os componentes.

        // Cria um layout de grade com 0 linhas e 2 colunas, 
        // com espaçamento de 10 pixels entre linhas e colunas.
        GridLayout layout = new GridLayout(0, 2, 10, 10); 
        

        // Restrições para os campos de texto.
        RestrictedTextField valida_ID = new RestrictedTextField(txt_ID);
        valida_ID.setOnlyNums(true);
        valida_ID.setLimit(6);

        RestrictedTextField valida_CEP = new RestrictedTextField(txt_CEP);
        valida_CEP.setOnlyNums(true);
        valida_CEP.setLimit(8);

        RestrictedTextField valida_rua = new RestrictedTextField(txt_Rua);
        valida_rua.setOnlyNums(true);
        valida_rua.setLimit(4);


        // Define o layout do painel como GridLayout com 0 linhas e 2 colunas, 
        // espaçamento de 10 pixels entre linhas e colunas.
        painel.setLayout(layout);

        // Adiciona os componentes ao painel.
        painel.add(lb_ID); // Adiciona o rótulo "Insira o ID a ser alterado" ao painel.
        painel.add(txt_ID); // Adiciona o campo de texto para inserção do ID ao painel.

        painel.add(lb_nome); // Adiciona o rótulo "Insira o novo nome" ao painel.
        painel.add(txt_nome); // Adiciona o campo de texto para inserção do novo nome ao painel.

        painel.add(lb_CEP); // Adiciona o rótulo "Insira o novo CEP" ao painel.
        painel.add(txt_CEP); // Adiciona o campo de texto para inserção do novo CEP ao painel.

        painel.add(lb_Rua); // Adiciona o rótulo "Insira a nova Rua" ao painel.
        painel.add(txt_Rua); // Adiciona o campo de texto para inserção da nova Rua ao painel.

        painel.add(btn_confirmar); // Adiciona o botão "Confirmar" ao painel.
        painel.add(btn_voltar); // Adiciona o botão "Voltar" ao painel.


        // Adiciona o painel à janela.
        super.add(painel);

        // Adiciona listeners de ação aos botões.
        btn_confirmar.addActionListener(this); // Adiciona um listener de ação ao botão "Confirmar".
        btn_voltar.addActionListener(this); // Adiciona um listener de ação ao botão "Voltar".

        this.setLocation(400, 190); // Centraliza a tela.
        this.setSize(490, 200); // Define o tamanho da tela.
        this.setVisible(true); // Torna a janela visível.
    }


     /**
     * Método invocado quando um botão é clicado.
     * Este método realiza as operações necessárias quando os botões 
     * "Confirmar" ou "Voltar" são pressionados.
     * @param e O evento de ação.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Cria um objeto Endereco com o CEP fornecido.
        Endereco endereco2 = new Endereco();
        endereco2.setCep(txt_CEP.getText());
        boolean valido = Janela.validarCEP(String.valueOf(endereco2));

        // Obtém os valores dos campos de entrada de texto.
        txtNome = txt_nome.getText();
        txtCEP = String.valueOf(endereco2);
        txtRua = txt_Rua.getText();
        txtID = txt_ID.getText();


        // Verifica qual botão foi pressionado.
        if(e.getSource() == btn_confirmar)
        {

            // Validação dos campos de entrada.
            if(!valido && txtCEP.isEmpty() || txtRua.isEmpty() || txtID.isEmpty() || txtNome.isEmpty())
            {
                JOptionPane.showMessageDialog(null , "Invalid CEP! " +
                        "Por favor digite os dados corretamente!");
                txt_nome.setText("");
                txt_CEP.setText("");
                txt_Rua.setText("");
                txt_ID.setText("");
                return;
            }

            // Se os campos estiverem preenchidos corretamente, abre a tela de confirmação.
            if(valido && txtCEP.isEmpty() || txtRua.isEmpty() || txtID.isEmpty()|| txtNome.isEmpty())
            {
                // Exibe uma mensagem se o CEP estiver válido, mas algum outro campo estiver vazio.
                JOptionPane.showMessageDialog(null , "CEP OK! " +
                        "Por favor digite os outros dados corretamente!");

                // Limpa os campos de texto.        
                txt_nome.setText("");
                txt_CEP.setText("");
                txt_Rua.setText("");
                txt_ID.setText("");
                return;
            }
            if(txtCEP.isEmpty()  || txtRua.isEmpty() || txtID.isEmpty()|| txtNome.isEmpty())
            {
                // Exibe uma mensagem se algum campo estiver vazio.
                JOptionPane.showMessageDialog(null , "Preenchha todos os campos corretamente");

                // Limpa os campos de texto.
                txt_nome.setText("");
                txt_CEP.setText("");
                txt_Rua.setText("");
                txt_ID.setText("");
            }

            // Se todos os campos estiverem preenchidos corretamente, abre a tela de confirmação.
            if(valido && (!txtCEP.isEmpty() && !txtRua.isEmpty() && !txtNome.isEmpty()))
            {
                try
                {
                    // Fecha a tela atual e abre a tela de confirmação.
                    this.dispose();
                    new confirmarTela2(txtID,txtNome,txtCEP,txtRua);
                }
                catch (Exception erro)
                {
                    System.out.println("Preencha os dados corretamente");
                }
            }
        }

        // Se o botão "Voltar" for pressionado, fecha a tela atual e retorna à tela anterior.
        if (e.getSource() == btn_voltar)
        {
            this.dispose();
            new Janela();
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
