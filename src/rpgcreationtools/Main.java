package rpgcreationtools;

import javax.swing.JOptionPane;

/**
 *
 * @author jdavi
 */
public class Main {

    public static void menuPersonagem() {

        int op;
        // menu personagem
        do {
            Object[] opPersonagem = {"Criar Personagem", "Ver Personagens", "Excluir Personagem", "Voltar"};
            op = JOptionPane.showOptionDialog(null, "Personagem", "RpgCreationTools",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opPersonagem, opPersonagem[0]);
            switch (op) {

                case 0:
                    Personagem person = new Personagem();
                    person.criarPersonagem();
                    break;
                case 1:
                    Personagem.verPersonagens();
                    break;
                case 2:
                    Personagem.excluirPersonagem();
                    break;
            }

        } while (op != 3);

    }

    public static void main(String[] args) {

        int opcao;

        do {
            // menu principal		
            Object[] options = {"Personagem", "Monstro", "Item", "Sair"};
            // armazena o valor da opçao selecionada do JOptionPane na variavel int
            opcao = JOptionPane.showOptionDialog(null, "Bem vindo ao RpgCreationTools!", "RpgCreationTools",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (opcao) {
                case 0:
                    menuPersonagem();
            }
        } while (opcao != 3 );

    }
}
