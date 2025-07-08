package frames;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import classes.Funcionario;
import classes.RH;

public class RHFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JButton cadastrar = new JButton("Cadastrar Funcionario");
	private JButton remover = new JButton("Remover Funcionario");
	private JButton listar = new JButton("Listar Funcionarios");

	
	public RHFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tela RH");
		this.setSize(400, 280);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		this.cadastrar.setBounds(100, 30, 200, 40);
		this.listar.setBounds(100, 90, 200, 40);
		this.remover.setBounds(100, 150, 200, 40);
		
		
		
		this.add(cadastrar);
		this.add(listar);
		this.add(remover);
		
		// Abre tela de Cadastro
		this.cadastrar.addActionListener(e -> {
	        telaCadastrar();
	    });
		
		// Abre tela de listagem
		this.listar.addActionListener(e -> {
	        telaListar();
	    });
		
		this.remover.addActionListener(e -> {
			telaRemover();
		});
		
		setVisible(true);
	}
	
	public void telaCadastrar() {
		this.dispose(); // Isso fecha a outra tela
		
		JFrame cadastrarFrame = new JFrame();
		
		cadastrarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastrarFrame.setTitle("Tela Cadastro");
		cadastrarFrame.setSize(400, 390);
		cadastrarFrame.setLocationRelativeTo(null);
		cadastrarFrame.setLayout(null);
	    
		// Campos do Formulário
		
		// Nome
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(30, 30, 80, 25);
		cadastrarFrame.add(lblNome);

		JTextField txtNome = new JTextField();
		txtNome.setBounds(120, 30, 200, 25);
		cadastrarFrame.add(txtNome);

		// Sobrenome
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(30, 70, 80, 25);
		cadastrarFrame.add(lblSobrenome);

		JTextField txtSobrenome = new JTextField();
		txtSobrenome.setBounds(120, 70, 200, 25);
		cadastrarFrame.add(txtSobrenome);

		// Email
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(30, 110, 80, 25);
		cadastrarFrame.add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(120, 110, 200, 25);
		cadastrarFrame.add(txtEmail);

		// Senha
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(30, 150, 80, 25);
		cadastrarFrame.add(lblSenha);

		JPasswordField txtSenha = new JPasswordField();
		txtSenha.setBounds(120, 150, 200, 25);
		cadastrarFrame.add(txtSenha);

		// Endereço
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(30, 190, 80, 25);
		cadastrarFrame.add(lblEndereco);

		JTextField txtEndereco = new JTextField();
		txtEndereco.setBounds(120, 190, 200, 25);
		cadastrarFrame.add(txtEndereco);

		// CPF
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(30, 230, 80, 25);
		cadastrarFrame.add(lblCpf);

		JTextField txtCpf = new JTextField();
		txtCpf.setBounds(120, 230, 200, 25);
		cadastrarFrame.add(txtCpf);

		// Cargo
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(30, 270, 80, 25);
		cadastrarFrame.add(lblCargo);

		String[] cargos = {"RH", "Atendente", "Cozinheiro", "Estoquista", "Gerente"};
		JComboBox<String> cmbCargo = new JComboBox<>(cargos);
		cmbCargo.setBounds(120, 270, 200, 25);
		cadastrarFrame.add(cmbCargo);

		// Botão cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(120, 310, 120, 30);
		cadastrarFrame.add(btnCadastrar);

		// Botão voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(250, 310, 80, 30);
		cadastrarFrame.add(btnVoltar);

		// ação do botão voltar
		btnVoltar.addActionListener(e -> {
		    cadastrarFrame.dispose();
		    new RHFrame();
		});


	    // ação do botão cadastrar
	    btnCadastrar.addActionListener(e -> {
	        Funcionario fun = new Funcionario();
	    	fun.setNome(txtNome.getText());
	    	fun.setSobrenome(txtSobrenome.getText());
	    	fun.setEmail(txtEmail.getText());
	    	fun.setSenha(new String(txtSenha.getPassword()));
	    	fun.setEndereco(txtEndereco.getText());
	    	fun.setCpf(txtCpf.getText());
	    	fun.setCargo((String) cmbCargo.getSelectedItem());

	        RH rh = new RH();
	        int result = rh.insert(fun); // Insere o funcionário no banco de dados
	    	
	        if (result > 0) { // Caso tenha inserido com sucesso
	        	JOptionPane.showMessageDialog(cadastrarFrame, "Funcionário cadastrado com sucesso!");
	        	// Limpar os campos
	        	txtNome.setText("");
		        txtSobrenome.setText("");
		        txtEmail.setText("");
		        txtSenha.setText("");
		        txtEndereco.setText("");
		        txtCpf.setText("");
		        cmbCargo.setSelectedIndex(0);
	        }
	        else { // Em caso de erro ao inserir
	        	JOptionPane.showMessageDialog(cadastrarFrame, "Erro ao cadastrar funcionário!");
	        	
	        }
	        
	    });

	    cadastrarFrame.setVisible(true);
	}
	
	public void telaListar() {
	    this.dispose();

	    JFrame listarFrame = new JFrame("Telas Funcionários");
	    listarFrame.setSize(600, 400);
	    listarFrame.setLocationRelativeTo(null);
	    listarFrame.setLayout(null);
	    listarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    // Colunas 
	    String[] colunas = {"ID", "Nome", "Sobrenome", "Email", "Cargo"};

	    // Uso de select
	    RH rh = new RH();
	    Funcionario[] funcionarios = rh.select(); 
	    
	    // Array de funcionarios em uma matriz
	    String[][] dados = new String[funcionarios.length][5];
	    for (int i = 0; i < funcionarios.length; i++) {
	        dados[i][0] = String.valueOf(funcionarios[i].getId());
	        dados[i][1] = funcionarios[i].getNome();
	        dados[i][2] = funcionarios[i].getSobrenome();
	        dados[i][3] = funcionarios[i].getEmail();
	        dados[i][4] = funcionarios[i].getCargo();
	    }

	    // Tabela para visualizar dados
	    JTable tabela = new JTable(dados, colunas);
	    JScrollPane scroll = new JScrollPane(tabela);
	    scroll.setBounds(20, 20, 550, 250);
	    listarFrame.add(scroll);

	    JButton btnVoltar = new JButton("Voltar");
	    btnVoltar.setBounds(480, 300, 80, 30);
	    listarFrame.add(btnVoltar);

	    btnVoltar.addActionListener(e -> {
	        listarFrame.dispose();
	        new RHFrame();
	    });

	    listarFrame.setVisible(true);
	}

	public void telaRemover() {
		this.dispose();
		
		JFrame removeFrame = new JFrame("Telas Funcionários");
	    removeFrame.setSize(600, 200);
	    removeFrame.setLocationRelativeTo(null);
	    removeFrame.setLayout(null);
	    removeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	    JLabel lblId = new JLabel("Id do Funcionário:");
		lblId.setBounds(50, 75, 120, 25);
		removeFrame.add(lblId);

		JTextField txtId = new JTextField();
		txtId.setBounds(180, 75, 200, 25);
		removeFrame.add(txtId);
		
		// Botao Remover
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(400, 75, 150, 25);
		removeFrame.add(btnRemover);
		
		btnRemover.addActionListener(e -> {
			RH rh = new RH();
			int result = rh.delete(Integer.parseInt(txtId.getText()));
			
			if (result > 0) { // Caso remova com sucesso
				txtId.setText("");
				JOptionPane.showMessageDialog(removeFrame, "Funcionário deletado com sucesso!");
			}
			else {
				JOptionPane.showMessageDialog(removeFrame, "Erro ao deletar funcionário!");
			}
		});
		
		// Botão voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(470, 120, 80, 25);
		removeFrame.add(btnVoltar);

		// ação do botão voltar
		btnVoltar.addActionListener(e -> {
		    removeFrame.dispose();
		    new RHFrame();
		});
		
		removeFrame.setVisible(true);
	    
	}
	
	
}
