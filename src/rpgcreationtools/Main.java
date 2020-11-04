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
    
    public static void menuRolarDados() {
        
        int op;
        
        do {
            Object [] opDados = {"d20", "d4", "d6", "d8", "d10", "d12", "Voltar"};
            op = JOptionPane.showOptionDialog(null, "Dados", "RpgCreationTools", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opDados, opDados[0]);
            switch (op) {
                case 0:
                    Dado.rolarD20();
                    break;
                case 1:
                    Dado.rolarD4();
                    break;
                case 2:
                    Dado.rolarD6();
                    break;
                case 3:
                    Dado.rolarD8();
                    break;
                case 4:
                    Dado.rolarD10();
                    break;
                case 5:
                    Dado.rolarD12();
                    break;
            }
            
        } while (op!= 6);
    }

    public static void main(String[] args) {

        int opcao;

        do {
            // menu principal		
            Object[] options = {"Personagem", "Rolar Dados", "Item", "Sair"};
            // armazena o valor da opçao selecionada do JOptionPane na variavel int
            opcao = JOptionPane.showOptionDialog(null, "Bem vindo ao RpgCreationTools!", "RpgCreationTools",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (opcao) {
                case 0:
                    menuPersonagem();
                    break;
                case 1:
                    menuRolarDados();
            }
        } while (opcao != 3 );

    }
}
