//index

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        // Configurações da janela principal
        setTitle("Página Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        // Adicionar conteúdo (baseado no conteúdo do index.html)
        JLabel welcomeLabel = new JLabel("Bem-vindo!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(welcomeLabel);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Cadastro");
        
        // Ações dos botões
        loginButton.addActionListener(e -> new LoginFrame());
        registerButton.addActionListener(e -> new CadastroFrame());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        mainPanel.add(buttonPanel);

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}


//login

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Campos de entrada
        add(new JLabel("Usuário:"));
        JTextField userField = new JTextField();
        add(userField);

        add(new JLabel("Senha:"));
        JPasswordField passField = new JPasswordField();
        add(passField);

        JButton loginButton = new JButton("Entrar");
        add(loginButton);

        setVisible(true);
    }
}


//cadastro

import javax.swing.*;
import java.awt.*;

public class CadastroFrame extends JFrame {

    public CadastroFrame() {
        setTitle("Cadastro");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Campos de entrada
        add(new JLabel("Nome:"));
        JTextField nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        add(emailField);

        add(new JLabel("Senha:"));
        JPasswordField passField = new JPasswordField();
        add(passField);

        JButton registerButton = new JButton("Cadastrar");
        add(registerButton);

        setVisible(true);
    }
}


//carrinho

import javax.swing.*;
import java.awt.*;

public class CarrinhoFrame extends JFrame {

    public CarrinhoFrame() {
        setTitle("Carrinho de Compras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabela de itens
        String[] colunas = {"Produto", "Quantidade", "Preço"};
        Object[][] dados = {
            {"Produto 1", "2", "R$ 50,00"},
            {"Produto 2", "1", "R$ 30,00"}
        };

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        // Botão de pagamento
        JButton pagarButton = new JButton("Ir para Pagamento");
        pagarButton.addActionListener(e -> new PagamentoFrame());
        add(pagarButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}


//pagamento


import javax.swing.*;
import java.awt.*;

public class PagamentoFrame extends JFrame {

    public PagamentoFrame() {
        setTitle("Pagamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Campos de pagamento
        add(new JLabel("Nome no Cartão:"));
        JTextField nomeCartaoField = new JTextField();
        add(nomeCartaoField);

        add(new JLabel("Número do Cartão:"));
        JTextField numeroCartaoField = new JTextField();
        add(numeroCartaoField);

        add(new JLabel("Data de Expiração:"));
        JTextField expiracaoField = new JTextField();
        add(expiracaoField);

        add(new JLabel("CVV:"));
        JTextField cvvField = new JTextField();
        add(cvvField);

        JButton pagarButton = new JButton("Confirmar Pagamento");
        add(pagarButton);

        setVisible(true);
    }
}

//scripthelper

public class ScriptHelper {

    public static void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static boolean validarCampos(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void realizarLogin(String usuario, String senha) {
        if (validarCampos(usuario, senha)) {
            mostrarMensagem("Login realizado com sucesso!");
        } else {
            mostrarMensagem("Por favor, preencha todos os campos.");
        }
    }

    public static void cadastrarUsuario(String nome, String email, String senha) {
        if (validarCampos(nome, email, senha)) {
            mostrarMensagem("Cadastro realizado com sucesso!");
        } else {
            mostrarMensagem("Todos os campos são obrigatórios.");
        }
    }
}



//assisstente


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProdutoFrame extends JFrame {

    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField tamanhoField;
    private JTextField precoField;
    private JPanel resultadoPanel;

    private final List<Tenis> listaTenis = new ArrayList<>();

    public ProdutoFrame() {
        setTitle("Loja de Tênis - Busca de Produtos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de formulário
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Buscar por Produtos"));

        formPanel.add(new JLabel("Marca do Tênis:"));
        marcaField = new JTextField();
        formPanel.add(marcaField);

        formPanel.add(new JLabel("Modelo do Tênis:"));
        modeloField = new JTextField();
        formPanel.add(modeloField);

        formPanel.add(new JLabel("Tamanho:"));
        tamanhoField = new JTextField();
        formPanel.add(tamanhoField);

        formPanel.add(new JLabel("Preço:"));
        precoField = new JTextField();
        formPanel.add(precoField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new BuscarListener());
        formPanel.add(buscarButton);

        add(formPanel, BorderLayout.NORTH);

        // Painel de resultados
        resultadoPanel = new JPanel();
        resultadoPanel.setLayout(new BoxLayout(resultadoPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(resultadoPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Dados simulados
        inicializarTenis();

        setVisible(true);
    }

    private void inicializarTenis() {
        listaTenis.add(new Tenis("Nike", "Air Max", "42", "800", "https://www.jotagestore.com.br/cdn/shop/products/IMG_3157.jpg?v=1687371009"));
        listaTenis.add(new Tenis("Adidas", "Ultraboost", "40", "700", "https://imgcentauro-a.akamaihd.net/1366x1366/98840051.jpg"));
        listaTenis.add(new Tenis("Puma", "RS-X", "41", "600", "https://authenticfeet.vtexassets.com/arquivos/ids/410772-800-800?v=638460366290500000&width=800&height=800&aspect=true"));
    }

    private class BuscarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultadoPanel.removeAll();
            String marca = marcaField.getText().toLowerCase();
            String modelo = modeloField.getText().toLowerCase();
            String tamanho = tamanhoField.getText();
            String preco = precoField.getText();

            boolean encontrado = false;
            for (Tenis tenis : listaTenis) {
                if ((marca.isEmpty() || tenis.getMarca().toLowerCase().contains(marca)) &&
                    (modelo.isEmpty() || tenis.getModelo().toLowerCase().contains(modelo)) &&
                    (tamanho.isEmpty() || tenis.getTamanho().equals(tamanho)) &&
                    (preco.isEmpty() || tenis.getPreco().equals(preco))) {
                    
                    JLabel tenisLabel = new JLabel("<html>" +
                        "<img src='" + tenis.getImagem() + "' width='100' height='100'><br>" +
                        tenis.getMarca() + " " + tenis.getModelo() + " - Tamanho " + tenis.getTamanho() + " - R$ " + tenis.getPreco() +
                        "</html>");
                    resultadoPanel.add(tenisLabel);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                resultadoPanel.add(new JLabel("Nenhum tênis encontrado."));
            }

            resultadoPanel.revalidate();
            resultadoPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProdutoFrame::new);
    }
}

//classetenis
public class Tenis {
    private String marca;
    private String modelo;
    private String tamanho;
    private String preco;
    private String imagem;

    public Tenis(String marca, String modelo, String tamanho, String preco, String imagem) {
        this.marca = marca;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.preco = preco;
        this.imagem = imagem;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }
}




//css

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Criar os componentes
        Label label = new Label("Bem-vindo!");
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Cadastro");

        // Definir o layout
        VBox vbox = new VBox(10, label, loginButton, registerButton);

        // Aplicar o CSS
        vbox.getStylesheets().add("styles.css");

        // Criar a cena e configurar o palco
        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setTitle("Página Principal");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//index