package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.DAO;

public class Clientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCliCpf;
	private JTextField txtCliNome;
	private JTextField txtCliDataNasc;
	private JTextField txtCliId;
	private JTextField txtCliCep;
	private JTextField txtCliEnd;
	private JTextField txtCliNum;
	private JTextField txtCliCidade;
	private JTextField txtCliBairro;
	private JTextField txtCliTelefone;
	private JTextField txtCliEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/favicon.png")));
		setTitle("Clientes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 705, 404);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(57, 32, 36, 14);
		getContentPane().add(lblNewLabel);
		
		txtCliCpf = new JTextField();
		txtCliCpf.setBounds(126, 29, 113, 20);
		getContentPane().add(txtCliCpf);
		txtCliCpf.setColumns(10);
		
		JButton btnBuscarCpf = new JButton("Buscar CPF");
		btnBuscarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCli();
			}
		});
		btnBuscarCpf.setBounds(249, 28, 100, 23);
		getContentPane().add(btnBuscarCpf);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(57, 71, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtCliNome = new JTextField();
		txtCliNome.setBounds(126, 68, 196, 20);
		getContentPane().add(txtCliNome);
		txtCliNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(350, 71, 113, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtCliDataNasc = new JTextField();
		txtCliDataNasc.setBounds(473, 68, 109, 20);
		getContentPane().add(txtCliDataNasc);
		txtCliDataNasc.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(57, 104, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtCliId = new JTextField();
		txtCliId.setBounds(126, 101, 36, 20);
		getContentPane().add(txtCliId);
		txtCliId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CEP");
		lblNewLabel_4.setBounds(236, 104, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtCliCep = new JTextField();
		txtCliCep.setBounds(279, 101, 100, 20);
		getContentPane().add(txtCliCep);
		txtCliCep.setColumns(10);
		
		JButton btnCliBuscarCep = new JButton("Buscar CEP");
		btnCliBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnCliBuscarCep.setBounds(389, 100, 107, 23);
		getContentPane().add(btnCliBuscarCep);
		
		JLabel lblNewLabel_5 = new JLabel("Endereço");
		lblNewLabel_5.setBounds(57, 138, 63, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtCliEnd = new JTextField();
		txtCliEnd.setBounds(126, 135, 279, 20);
		getContentPane().add(txtCliEnd);
		txtCliEnd.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Número");
		lblNewLabel_6.setBounds(427, 138, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtCliNum = new JTextField();
		txtCliNum.setBounds(483, 134, 86, 20);
		getContentPane().add(txtCliNum);
		txtCliNum.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Cidade");
		lblNewLabel_7.setBounds(57, 178, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtCliCidade = new JTextField();
		txtCliCidade.setBounds(126, 175, 141, 20);
		getContentPane().add(txtCliCidade);
		txtCliCidade.setColumns(10);
		
		cboCliUf = new JComboBox();
		cboCliUf.setModel(new DefaultComboBoxModel(new String []{"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboCliUf.setBounds(323, 174, 46, 22);
		getContentPane().add(cboCliUf);
		
		JLabel lblNewLabel_8 = new JLabel("UF");
		lblNewLabel_8.setBounds(292, 178, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Bairro");
		lblNewLabel_9.setBounds(389, 178, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtCliBairro = new JTextField();
		txtCliBairro.setBounds(437, 175, 113, 20);
		getContentPane().add(txtCliBairro);
		txtCliBairro.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Telefone");
		lblNewLabel_10.setBounds(57, 217, 63, 14);
		getContentPane().add(lblNewLabel_10);
		
		txtCliTelefone = new JTextField();
		txtCliTelefone.setBounds(126, 214, 100, 20);
		getContentPane().add(txtCliTelefone);
		txtCliTelefone.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Email");
		lblNewLabel_11.setBounds(249, 217, 46, 14);
		getContentPane().add(lblNewLabel_11);
		
		txtCliEmail = new JTextField();
		txtCliEmail.setBounds(292, 214, 181, 20);
		getContentPane().add(txtCliEmail);
		txtCliEmail.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Marketing");
		lblNewLabel_12.setBounds(493, 217, 76, 14);
		getContentPane().add(lblNewLabel_12);
		
		cboCliMark = new JComboBox();
		cboCliMark.setModel(new DefaultComboBoxModel(new String []{"","Sim","Não"}));
		cboCliMark.setBounds(558, 213, 55, 22);
		getContentPane().add(cboCliMark);
		
		btnCliAdd = new JButton("");
		btnCliAdd.setContentAreaFilled(false);
		btnCliAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarCli();
			}
		});
		btnCliAdd.setBorderPainted(false);
		btnCliAdd.setIcon(new ImageIcon(Clientes.class.getResource("/img/create.png")));
		btnCliAdd.setBounds(427, 277, 64, 64);
		getContentPane().add(btnCliAdd);
		
		btnCliAtualizar = new JButton("");
		btnCliAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarCli();
			}
		});
		btnCliAtualizar.setContentAreaFilled(false);
		btnCliAtualizar.setBorderPainted(false);
		btnCliAtualizar.setIcon(new ImageIcon(Clientes.class.getResource("/img/update.png")));
		btnCliAtualizar.setBounds(501, 277, 64, 64);
		getContentPane().add(btnCliAtualizar);
		
		btnCliDelete = new JButton("");
		btnCliDelete.setContentAreaFilled(false);
		btnCliDelete.setBorderPainted(false);
		btnCliDelete.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete.png")));
		btnCliDelete.setBounds(575, 277, 64, 64);
		getContentPane().add(btnCliDelete);
		
		btnCliId = new JButton("");
		btnCliId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCliId();
			}
		});
		btnCliId.setBorderPainted(false);
		btnCliId.setContentAreaFilled(false);
		btnCliId.setIcon(new ImageIcon(Clientes.class.getResource("/img/search.png")));
		btnCliId.setBounds(172, 100, 36, 23);
		getContentPane().add(btnCliId);

	}//fim do construtor
	
	DAO dao = new DAO();
	private JScrollPane scrollPesquisarForne;
	private JTextArea txtForneObs;
	private JComboBox cboCliMark;
	private JComboBox cboCliUf;
	private JButton btnCliAdd;
	private JButton btnCliAtualizar;
	private JButton btnCliDelete;
	private JButton btnCliId;
	
	/**
	 * M�todo rrespons�vel pela pesquisa de usu�rios pelo CPF
	 */
	private void pesquisarCli() {
		//valida��o
		if (txtCliCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o CPF do cliente");
			txtCliCpf.requestFocus();
		} else {
			//l�gica principal
			//Query (instru��o SQL)
			String read = "select * from clientes where cpf = ?";
			//tratar exce��es sempre que lidar com o banco
			try {
				//Estabelecer a conex�o
				Connection con = dao.conectar();
				//Preparar a execu��o da query
				PreparedStatement pst = con.prepareStatement(read);
				//Setar o argumento (id)
				//Substituir o ? pelo conte�do da caixa de texto
				pst.setString(1, txtCliCpf.getText());
				//Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				//Valida��o (exist�ncia de usu�rio)
				//rs.next() -> exist�ncia de usu�rio
				if (rs.next()) {
					//preencher(setar) os campos do formul�rio
					txtCliId.setText(rs.getString(1));
					txtCliNome.setText(rs.getString(2));
					txtCliDataNasc.setText(rs.getString(3));
					txtCliTelefone.setText(rs.getString(4));
					txtCliCpf.setText(rs.getString(5));
					txtCliEmail.setText(rs.getString(6));
					cboCliMark.setSelectedItem(rs.getString(7));
					txtCliCep.setText(rs.getString(8));
					txtCliEnd.setText(rs.getString(9));
					txtCliNum.setText(rs.getString(9));
					txtCliBairro.setText(rs.getString(10));
					txtCliCidade.setText(rs.getString(11));
					cboCliUf.setSelectedItem(rs.getString(12));
					
				} else {
					JOptionPane.showMessageDialog(null, "Usu�rio inexistente");
				}
				// NUNCA esquecer de encerrar a conex�o
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * M�todo rrespons�vel pela pesquisa de usu�rios pelo ID
	 */
	private void pesquisarCliId() {
		//valida��o
		if (txtCliId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Id do cliente");
			txtCliId.requestFocus();
		} else {
			//l�gica principal
			//Query (instru��o SQL)
			String read = "select * from clientes where idcli = ?";
			//tratar exce��es sempre que lidar com o banco
			try {
				//Estabelecer a conex�o
				Connection con = dao.conectar();
				//Preparar a execu��o da query
				PreparedStatement pst = con.prepareStatement(read);
				//Setar o argumento (id)
				//Substituir o ? pelo conte�do da caixa de texto
				pst.setString(1, txtCliId.getText());
				//Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				//Valida��o (exist�ncia de usu�rio)
				//rs.next() -> exist�ncia de usu�rio
				if (rs.next()) {
					//preencher(setar) os campos do formul�rio
					txtCliId.setText(rs.getString(1));
					txtCliNome.setText(rs.getString(2));
					txtCliDataNasc.setText(rs.getString(3));
					txtCliTelefone.setText(rs.getString(4));
					txtCliCpf.setText(rs.getString(5));
					txtCliEmail.setText(rs.getString(6));
					cboCliMark.setSelectedItem(rs.getString(7));
					txtCliCep.setText(rs.getString(8));
					txtCliEnd.setText(rs.getString(9));
					txtCliNum.setText(rs.getString(10));
					txtCliBairro.setText(rs.getString(11));
					txtCliCidade.setText(rs.getString(12));
					cboCliUf.setSelectedItem(rs.getString(13));
					
				} else {
					JOptionPane.showMessageDialog(null, "Usu�rio inexistente");
				}
				// NUNCA esquecer de encerrar a conex�o
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * 
	 * Método responsável por adicionar um novo usuário no banco
	 * 
	 */
	
	private void adicionarCli() {
		//validação
				if (txtCliCpf.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o CPF do Cliente");
					txtCliCpf.requestFocus();
					
				}else if (txtCliNome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente");
					txtCliNome.requestFocus();
					
				}else if (txtCliDataNasc.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha a data de nascimento do Cliente");
					txtCliDataNasc.requestFocus();
					
				}else if (txtCliTelefone.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o telefone do Cliente");
					txtCliTelefone.requestFocus();
					
				}else if (txtCliCpf.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o CPF do Cliente");
					txtCliCpf.requestFocus();
					
				}else if (txtCliEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Email do Cliente");
					txtCliEmail.requestFocus();
					
				}else if (cboCliMark.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Selecione se deseja receber Promoçoes");
					cboCliMark.requestFocus();
					
				}else if (txtCliEnd.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Endereço do Cliente");
					txtCliEnd.requestFocus();
					
				}else if (txtCliCep.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Cep do Cliente");
					txtCliCep.requestFocus();
					
				}else if (txtCliNum.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o número do Cliente");
					txtCliNum.requestFocus();	
					
				}else if(cboCliUf.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Selecione a UF do Cliente");
					cboCliUf.requestFocus();
					
				}else if (txtCliBairro.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Bairro do Cliente");
					txtCliBairro.requestFocus();
					
				}else if (txtCliCidade.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha a Cidade do Cliente");
					txtCliCidade.requestFocus();
					
				}else {
					// Lógica principal
					String create = " insert into clientes (nome,datanasc,telefone,cpf,email,marketing,cep,endereco,bairro,cidade,uf) values (?,?,?,?,?,?,?,?,?,?,?)";
				try {
					// Estabelecer a conex�o
					Connection con = dao.conectar();
					//Preparar a execu��o da query
					PreparedStatement pst = con.prepareStatement(create);
					// Substituir os ????? pelo conteúdo das caixas de texto
					pst.setString(1, txtCliNome.getText());
					pst.setString(2, txtCliDataNasc.getText());
					pst.setString(3, txtCliTelefone.getText());
					pst.setString(4, txtCliCpf.getText());
					pst.setString(5, txtCliEmail.getText());
					pst.setString(6, cboCliMark.getSelectedItem().toString());
					pst.setString(7, txtCliCep.getText());
					pst.setString(8, txtCliEnd.getText());
					pst.setString(9, txtCliNum.getText());
					pst.setString(10, txtCliBairro.getText());
					pst.setString(11, txtCliCidade.getText());
					pst.setString(12, cboCliUf.getSelectedItem().toString());		
					
					//executar a query e inserir o usuário no banco
					pst.executeUpdate();
					// Encerrar a conexão
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
					limparcampos();
					con.close();
				}catch(SQLIntegrityConstraintViolationException ex){
					JOptionPane.showMessageDialog(null, "Cliente existente");
					txtCliCpf.setText(null);
					txtCliCpf.requestFocus();
				}catch (Exception e) {
					System.out.println(e);
					}
				
				}
			}
	
	private void atualizarCli() {
		//validação
		if (txtCliCpf.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o CPF do Cliente");
			txtCliCpf.requestFocus();
			
		}else if (txtCliNome.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Nome do Cliente");
			txtCliNome.requestFocus();
			
		}else if (txtCliDataNasc.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha a data de nascimento do Cliente");
			txtCliDataNasc.requestFocus();
			
		}else if (txtCliTelefone.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o telefone do Cliente");
			txtCliTelefone.requestFocus();
			
		}else if (txtCliCpf.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o CPF do Cliente");
			txtCliCpf.requestFocus();
			
		}else if (txtCliEmail.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Email do Cliente");
			txtCliEmail.requestFocus();
			
		}else if (cboCliMark.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione se deseja receber Promoçoes");
			cboCliMark.requestFocus();
			
		}else if (txtCliEnd.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Endereço do Cliente");
			txtCliEnd.requestFocus();
			
		}else if (txtCliCep.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Cep do Cliente");
			txtCliCep.requestFocus();
			
		}else if (txtCliNum.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o número do Cliente");
			txtCliNum.requestFocus();	
			
		}else if(cboCliUf.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione a UF do Cliente");
			cboCliUf.requestFocus();
			
		}else if (txtCliBairro.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Bairro do Cliente");
			txtCliBairro.requestFocus();
			
		}else if (txtCliCidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha a Cidade do Cliente");
			txtCliCidade.requestFocus();
			} else {
			// lógica principal
			String update = "update clientes set nome=?,datanasc=?,telefone=?,cpf=?,email=?,marketing=?,cep=?,endereco=?,numero=?,bairro=?,cidade=?,uf=? where idcli=?";
			try {
				// Estabelecer a conexão 
				Connection con = dao.conectar();
				// Preparar a execução da Query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir o ? pelo conteúdo da caixa de texto 
				pst.setString(1, txtCliNome.getText());
				pst.setString(2, txtCliDataNasc.getText());
				pst.setString(3, txtCliTelefone.getText());
				pst.setString(4, txtCliCpf.getText());
				pst.setString(5, txtCliEmail.getText());
				pst.setString(6, cboCliMark.getSelectedItem().toString());
				pst.setString(7, txtCliCep.getText());
				pst.setString(8, txtCliEnd.getText());
				pst.setString(9, txtCliNum.getText());
				pst.setString(10, txtCliBairro.getText());
				pst.setString(11, txtCliCidade.getText());
				pst.setString(12, cboCliUf.getSelectedItem().toString());
				pst.setString(13, txtCliId.getText());
				
				// Executar a query e alterar o usuário no banco
				pst.executeUpdate();
				// confirmação
				limparcampos();
				JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
				// Encerrar a conexão
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login");
				txtCliCpf.setText(null);
				txtCliCpf.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
			
	}
	
	/**
	 * 
	 * Método responsável por excluir um usuário no banco
	 * 
	 */
	private void excluirUsuario() {
		//validação (cofrmação de exclusão)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do usuário?", "Atenção!",JOptionPane.YES_NO_OPTION);
		
		if(confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from usuarios where idusu=?";
			try {
				// Estabelecer a conex�o
				Connection con = dao.conectar();
				//Preparar a execu��o da query
				PreparedStatement pst = con.prepareStatement(delete);
				// Substituir os ????? pelo conteúdo das caixas de texto
				pst.setString(1, txtCliId.getText());
				//executar a query e inserir o usuário no banco
				pst.executeUpdate();
				
				//confirmação
				limparcampos();
				JOptionPane.showMessageDialog(null, "Usuário excluído");
				con.close();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCliCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCliCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtCliBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboCliUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {

					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}

			}
			// Setar Campo Endereço
			txtCliEnd.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void limparcampos() {
		txtCliId.setText(null);
		txtCliNome.setText(null);
		txtCliDataNasc.setText(null);
		txtCliTelefone.setText(null);
		txtCliCpf.setText(null);
		txtCliEmail.setText(null);
		cboCliMark.setSelectedItem("");
		txtCliCep.setText(null);
		txtCliEnd.setText(null);
		txtCliNum.setText(null);
		txtCliBairro.setText(null);
		txtCliCidade.setText(null);
		cboCliUf.setSelectedItem("");
	}

}//fim do código
