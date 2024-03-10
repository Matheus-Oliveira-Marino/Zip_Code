import bd.daos.Produtos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * A classe {@code ExcluirTela} cria uma interface gráfica para excluir um shopping.
 * Ela contém campos para o usuário digitar o ID do shopping a ser excluído,
 * além de botões para confirmar a exclusão ou voltar para a tela anterior.
 */
public class ExcluirTela  extends JFrame implements MouseListener, MouseMotionListener,ActionListener
{
    // Componentes da interface.
    protected JLabel id = new JLabel("Digite o id: ");
    protected  JTextField exclui = new JTextField(10);
    protected JButton confirmar = new JButton("Confirmar"),
                      voltar = new JButton("Voltar");
    String txtExclui;



    /**
     * Construtor da classe {@code ExcluirTela}.
     * Inicializa a interface gráfica com os componentes necessários.
     */
    public ExcluirTela()
    {
        // Configurações da janela.
        super("Excluir Shopping");
        this.setResizable(false);

        // Criação do painel com layout de grade.
        JPanel painel = new JPanel(new GridLayout(1,0));

        // Adiciona os componentes ao painel.
        painel.add(id);
        painel.add(exclui);
        painel.add(confirmar);
        painel.add(voltar);

        // Adiciona o painel à janela.
        super.add(painel);

        // Adiciona os listeners aos botões.
        confirmar.addActionListener(this);
        voltar.addActionListener(this);

        // Define a posição e o tamanho da janela.
        this.setLocation(400, 190); // Deixa a tela no meio.
        this.setSize(390, 66); // Tamanho da tela.

        // Torna a janela visível.
        this.setVisible(true); // Deixa a janela visível
    }


    /**
     * Método 'actionPerformed' para lidar com eventos de botão.
     * @param e O evento que ocorreu.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
       // Se o botão "Confirmar" foi clicado.
    if (e.getSource() == confirmar)
    {
        try
        {
            // Obtém o texto digitado no campo de exclusão.
            txtExclui = exclui.getText();

            // Verifica se o campo está vazio.
            if (txtExclui.equals(""))
            {
                // Exibe uma mensagem de erro se o campo estiver vazio.
                JOptionPane.showMessageDialog(null, "Por favor, digite o ID");
            }

            // Verifica se nenhum shopping foi encontrado com o 'ID' especificado.
            else if (Produtos.retornaCEP(Integer.parseInt(txtExclui)).equals(""))
            {
                JOptionPane.showMessageDialog(null, "Nenhum shopping encontrado com o ID especificado");
            }
            else
            {
                // Fecha a janela atual e abre a tela de confirmação para o 'ID' especificado.
                this.dispose();
                new confirmarTela(txtExclui);
            }
           }
           catch(Exception error) {}

       }


       // Se o botão "Voltar" foi clicado.
       if(e.getSource() == voltar)
       {
           // Fecha a janela atual e abre a tela anterior.
           new Janela();
           this.dispose();
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
