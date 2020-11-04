package rpgcreationtools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author jdavi
 */
public class Personagem {

    private int id;
    private String nome;
    private int raca;
    private int classe;
    private int nivel;

    // getters e setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRaca() {
        return this.raca;
    }

    public void setRaca(int raca) {
        this.raca = raca;
    }

    public int getClasse() {
        return this.classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    // criar personagem
    public void criarPersonagem() {

        // criando conexao para inserir os dados
        ConexaoBD conexaobd = new ConexaoBD();
        Connection conexao = conexaobd.conectar();

        // obtendo dados do personagem
        this.setNome(JOptionPane.showInputDialog("Insira o nome do Personagem"));
        Object[] racas = {"Anao", "Elfo", "Halfling", "Humano", "Draconato", "Gnomo",
            "Meio-Elfo", "Meio-Orc", "Tiefling"};
        this.setRaca(JOptionPane.showOptionDialog(null, "Selecione a raca", "RpgCreationTools",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, racas, racas[0]));
        Object[] classes = {"Barbaro", "Bardo", "Bruxo", "Clerigo", "Druida", "Feiticeiro",
            "Guerreiro", "Ladino", "Mago", "Monge", "Paladino", "Patrulheiro"};
        this.setClasse(JOptionPane.showOptionDialog(null, "Selecione a classe", "RpgCreationTools",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, classes, classes[0]));
        this.setNivel(1);

        // armazenando os dados para depois inserir no db
        String nome = this.nome;
        String raca = "";
        String classe = "";
        String nivel = Integer.toString(this.nivel);

        // switch case para definir a raca
        switch (this.raca) {

            case 0:
                raca = "Anao";
                break;
            case 1:
                raca = "Elfo";
                break;
            case 2:
                raca = "Halfling";
                break;
            case 3:
                raca = "Humano";
                break;
            case 4:
                raca = "Draconato";
                break;
            case 5:
                raca = "Gnomo";
                break;
            case 6:
                raca = "Meio-Elfo";
                break;
            case 7:
                raca = "Meio-Orc";
                break;
            case 8:
                raca = "Tiefling";
                break;
        }

        // switch case para definir a classe
        switch (this.classe) {

            case 0:
                classe = "Barbaro";
                break;
            case 1:
                classe = "Bardo";
                break;
            case 2:
                classe = "Bruxo";
                break;
            case 3:
                classe = "Clerigo";
                break;
            case 4:
                classe = "Druida";
                break;
            case 5:
                classe = "Feiticeiro";
                break;
            case 6:
                classe = "Guerreiro";
                break;
            case 7:
                classe = "Ladino";
                break;
            case 8:
                classe = "Mago";
                break;
            case 9:
                classe = "Monge";
                break;
            case 10:
                classe = "Paladino";
                break;
            case 11:
                classe = "Patrulheiro";
                break;
        }

        // adicionando os dados no banco de dados
        try {
            Statement stms = conexao.createStatement();
            stms.executeUpdate("INSERT INTO personagens(nome, raca, classe, nivel) VALUES('" + nome + "','" + raca + "','" + classe + "','" + nivel + "')");

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }

    }

    // para gerar a ficha do personagem criado em uma janela
    public void gerarFicha() {

        String[] colunas = {"nome", "raca", "classe", "nivel"};
        Object[][] dados = {
            {this.nome, this.raca, this.classe, this.nivel}
        };
        JFrame window = new JFrame("ficha"); // criando um JFrame
        JPanel painel = new JPanel(); // criando um JPanel
        JTable sheet = new JTable(dados, colunas); // criando um JTable
        painel.add(sheet); // adicionando o JTable criadoo no JPanel

        window.getContentPane().add(painel); // adicionando o JPanel no JFrame
        window.setSize(500, 450); // setando o tamanho do JFrame
        window.setVisible(true); // setando a visibilidade do JFrame para true

        System.out.println("Hello world");
    }

    // ver personagem
    public static void verPersonagens() {

        ConexaoBD conexaobd = new ConexaoBD();
        Connection conexao = conexaobd.conectar();
        /*
        String[] colunas = {"nome", "raca", "classe", "nivel"};
        JFrame window = new JFrame("personagens");
        JPanel panel = new JPanel();
        JTable sheet = new JTable(dados, colunas);
        */
        
        try {
            Statement stms = conexao.createStatement();

            ResultSet rs = stms.executeQuery("SELECT * FROM personagens");

            while (rs.next()) {
                String id = rs.getString("id");
                String nome = rs.getString("nome");
                String raca = rs.getString("raca");
                String classe = rs.getString("classe");

                
                
                System.out.println("id: " + id + " nome: " + nome + " raca: "
                        + raca + " classe: " + classe);
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }

    }

    // excluir personagem
    public static void excluirPersonagem() {

        ConexaoBD conexaobd = new ConexaoBD();
        Connection conexao = conexaobd.conectar();
        
        String op = JOptionPane.showInputDialog("Insira o id do personagem que deseja excluir");
        
        try {
            Statement stms = conexao.createStatement();
            stms.executeUpdate("DELETE FROM personagens WHERE id = '"+op+"'");
            
            
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }

    }

}
