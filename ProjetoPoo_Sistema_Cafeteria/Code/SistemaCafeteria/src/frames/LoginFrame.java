package frames;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classes.Login;

public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTextField email = new JTextField(20);
	private JPasswordField senha = new JPasswordField(20);
	private JButton botaoLogin = new JButton("Login");
	
	public LoginFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tela Login");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JLabel labelEmail = new JLabel("Email:");
		JLabel labelSenha = new JLabel("Senha:");
		
		this.botaoLogin.addActionListener(e -> {
			abrirMenu();
		});
		
		add(labelEmail);
		add(email);
		add(labelSenha);
		add(senha);
		add(botaoLogin);
		
		setVisible(true);
	}

	
	public void abrirMenuRH() {
		this.dispose();
		RHFrame rhf = new RHFrame();
	}
	
	public void abrirMenuCozinheiro() {
		this.dispose();
		CozinheiroFrame cr = new CozinheiroFrame();
	}

	public void abrirMenu() {
		Login lg = new Login();
		String cargo = lg.autenticar(email.getText(), new String(senha.getPassword()));
		

	    if (cargo == null) {
	        JOptionPane.showMessageDialog(this, "Email ou senha inválidos.");
	        return;
	    }
	    
		switch (cargo.toLowerCase()) {
		case "rh":
			abrirMenuRH();
			break;
		case "cozinheiro":
			abrirMenuCozinheiro();
			break;
		default:
			break;
		}

	}
}
