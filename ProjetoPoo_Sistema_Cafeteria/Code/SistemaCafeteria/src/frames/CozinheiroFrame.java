package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import classes.Cozinheiro;
import classes.Funcionario;
import classes.RH;
import classes.Receita;

public class CozinheiroFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
    private JTextField txtNome = new JTextField();
    private JTextArea txtPreparo = new JTextArea();
    private JTextField txtObservacoes = new JTextField();
    private JTextField txtIdExcluir = new JTextField();
    private JButton btnCadastrar = new JButton("Cadastrar Receita");
    private JButton btnListar = new JButton("Listar Receitas");
    private JButton btnExcluir = new JButton("Excluir Receita");
    private JButton btnVoltar = new JButton("Voltar");


	
	public CozinheiroFrame(){
		
		setTitle("Tela Cozinheiro");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        
        btnCadastrar.setBounds(200, 100, 200, 50);
        add(btnCadastrar);

        btnListar.setBounds(200, 200, 200, 50);
        add(btnListar);

        btnExcluir.setBounds(200, 300, 200, 50);
        add(btnExcluir);
        
        // AÇÕES BOTÕES COZINHEIRO
        // ação cadastrar
        btnCadastrar.addActionListener(e -> {
            novaReceita();
        });

        // ação listar
        btnListar.addActionListener(e -> {
            listarReceita();
        });

        // ação excluir
        btnExcluir.addActionListener(e -> {
            excluirReceita();
        });

        // ação voltar
        btnVoltar.addActionListener(e -> {
            this.dispose();
            new LoginFrame();
        });

        setVisible(true); 
	}
	
	// Tela Cadastro Receita
	public void novaReceita() {
		this.dispose();
		
		JFrame cadastrarReceitaFrame = new JFrame();
		
		cadastrarReceitaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastrarReceitaFrame.setTitle("Nova Receita");
		cadastrarReceitaFrame.setSize(400, 390);
		cadastrarReceitaFrame.setLocationRelativeTo(null);
		cadastrarReceitaFrame.setLayout(null);
	    
		// Campos do Inserção das Novas Receitas
		
		// Nome
		JLabel lblNome = new JLabel("Nome da Receita:");
        lblNome.setBounds(20, 20, 120, 25);
        cadastrarReceitaFrame.add(lblNome);

        this.txtNome.setBounds(150, 20, 200, 25);
        cadastrarReceitaFrame.add(this.txtNome);

        // Modo de Preparo
        JLabel lblPreparo = new JLabel("Modo de Preparo:");
        lblPreparo.setBounds(20, 60, 120, 25);
        cadastrarReceitaFrame.add(lblPreparo);

        this.txtPreparo.setBounds(150, 60, 200, 120);
        this.txtPreparo.setLineWrap(true);
        this.txtPreparo.setWrapStyleWord(true);
        cadastrarReceitaFrame.add(this.txtPreparo);
        
        // Observacoes
        JLabel lblObs = new JLabel("Observações:");
        lblObs.setBounds(20, 200, 120, 25);
        cadastrarReceitaFrame.add(lblObs);

        this.txtObservacoes.setBounds(150, 200, 200, 25);
        cadastrarReceitaFrame.add(this.txtObservacoes);

		// Botão cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(120, 310, 120, 30);
		cadastrarReceitaFrame.add(btnCadastrar);

		// Botão voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(250, 310, 80, 30);
		cadastrarReceitaFrame.add(btnVoltar);

		// ação do botão voltar
		btnVoltar.addActionListener(e -> {
		    cadastrarReceitaFrame.dispose();
		    new CozinheiroFrame();
		});


	    // ação do botão cadastrar
	    btnCadastrar.addActionListener(e -> {
	    	Receita rc = new Receita();
	    	Cozinheiro cozi = new Cozinheiro();
	    	rc.setNomeBebida(txtNome.getText());
	    	rc.setModoPreparo(txtPreparo.getText());
	    	rc.setObservacoes(txtObservacoes.getText());
	    	
	    	int result = cozi.inserirReceita(rc); // Insere o funcionário no banco de dados
	    	
	        if (result > 0) { // Caso tenha inserido com sucesso
	        	JOptionPane.showMessageDialog(cadastrarReceitaFrame, "Receita inserida com sucesso!");
	        	// Limpar os campos
	        	txtNome.setText("");
		        txtPreparo.setText("");
		        txtObservacoes.setText("");
	        }
	        else { // Em caso de erro ao inserir
	        	JOptionPane.showMessageDialog(cadastrarReceitaFrame, "Erro ao inserir receita!");
	        	
	        }
	    });

	    cadastrarReceitaFrame.setVisible(true);
	}
	
	// Tela Listagem Receita
	public void listarReceita() {	
	    this.dispose();

	    JFrame listarReceitaFrame = new JFrame("Receitas");
	    listarReceitaFrame.setSize(700, 400);
	    listarReceitaFrame.setLocationRelativeTo(null);
	    listarReceitaFrame.setLayout(null);
	    listarReceitaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    // Colunas da receita
	    String[] colunas = {"ID", "Nome Bebida", "Modo Preparo", "Observações"};

	    // buscar do Cozinheiro
	    Cozinheiro cozi = new Cozinheiro();
	    String[][] dados = cozi.listarReceitas();

	    // Tabela
	    JTable tabela = new JTable(dados, colunas);
	    JScrollPane scroll = new JScrollPane(tabela);
	    scroll.setBounds(20, 20, 650, 250);
	    listarReceitaFrame.add(scroll);

	    JButton btnVoltar = new JButton("Voltar");
	    btnVoltar.setBounds(560, 300, 100, 30);
	    listarReceitaFrame.add(btnVoltar);
	    
	    btnVoltar.addActionListener(e -> {
	    	listarReceitaFrame.dispose();
	    	new CozinheiroFrame();
	    });


	    listarReceitaFrame.setVisible(true);
	}
	
	// Tela Excluir Receita
	public void excluirReceita() {
		this.dispose();
		
		JFrame excluirReceitaFrame = new JFrame("Receitas");
	    excluirReceitaFrame.setSize(400, 250);
	    excluirReceitaFrame.setLocationRelativeTo(null);
	    excluirReceitaFrame.setLayout(null);
	    excluirReceitaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblExcluir = new JLabel("ID da Receita:");
        lblExcluir.setBounds(20, 80, 120, 30);
        excluirReceitaFrame.add(lblExcluir);

        txtIdExcluir.setBounds(150, 80, 100, 30);
        excluirReceitaFrame.add(txtIdExcluir);
        
        JButton excluir = new JButton("Excluir");
        excluir.setBounds(280, 80, 100, 30);
        excluirReceitaFrame.add(excluir);
        
        JButton voltar = new JButton("Voltar");
        voltar.setBounds(280, 150, 100, 30);
        excluirReceitaFrame.add(voltar);
        
        excluir.addActionListener(e -> {
        	Cozinheiro cz = new Cozinheiro();
        	
        	int result = cz.deletarReceita(Integer.parseInt(txtIdExcluir.getText()));
        	if (result > 0) {
        		JOptionPane.showMessageDialog(excluirReceitaFrame, "Receita Deletada com Sucesso!");
        		txtIdExcluir.setText("");
        	}
        	else {
        		JOptionPane.showMessageDialog(excluirReceitaFrame, "Erro ao Excluir Receita!");
        	}
        });
        
        voltar.addActionListener(e -> {
        	excluirReceitaFrame.dispose();
        	new CozinheiroFrame();
        });
        
        excluirReceitaFrame.setVisible(true);
        
	}
	
}
