package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

public class Fornecedores extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFornePesquisar;
	private JTextField txtForneId;
	private JTextField txtForneCnpj;
	private JTextField txtForneIm;
	private JTextField txtForneRS;
	private JTextField txtForneFantasia;
	private JTextField txtForneSite;
	private JTextField txtForneFone;
	private JTextField txtForneContato;
	private JTextField txtForneEmail;
	private JTextField txtForneCep;
	private JTextField txtForneEnd;
	private JTextField txtForneNum;
	private JTextField txtForneComp;
	private JTextField txtForneBairro;
	private JTextField txtForneCidade;
	private JTable tblForne;
	private JTextField txtForneIe;
	private JComboBox cboForneUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedores dialog = new Fornecedores();
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
	public Fornecedores() {
		setTitle("Fornecedores");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/favicon.png")));
		setModal(true);
		setBounds(100, 100, 731, 505);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(53, 32, 68, 14);
		getContentPane().add(lblNewLabel);
		
		txtFornePesquisar = new JTextField();
		txtFornePesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// evento digita????o
				pesquisarForneTable();
			}
		});
		txtFornePesquisar.setBackground(new Color(255, 255, 255));
		txtFornePesquisar.setBounds(131, 29, 181, 20);
		getContentPane().add(txtFornePesquisar);
		txtFornePesquisar.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(53, 139, 24, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtForneId = new JTextField();
		txtForneId.setBounds(101, 136, 59, 20);
		getContentPane().add(txtForneId);
		txtForneId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		lblNewLabel_3.setBounds(53, 264, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtForneCnpj = new JTextField();
		txtForneCnpj.setBounds(161, 261, 214, 20);
		getContentPane().add(txtForneCnpj);
		txtForneCnpj.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("IE");
		lblNewLabel_4.setBounds(292, 139, 15, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtForneIe = new JTextField();
		txtForneIe.setBounds(317, 136, 99, 20);
		getContentPane().add(txtForneIe);
		txtForneIe.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("IM");
		lblNewLabel_4_1.setBounds(441, 139, 15, 14);
		getContentPane().add(lblNewLabel_4_1);
		
		txtForneIm = new JTextField();
		txtForneIm.setColumns(10);
		txtForneIm.setBounds(466, 136, 107, 20);
		getContentPane().add(txtForneIm);
		
		JLabel lblNewLabel_5 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_5.setBounds(46, 233, 81, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtForneRS = new JTextField();
		txtForneRS.setBounds(161, 230, 214, 20);
		getContentPane().add(txtForneRS);
		txtForneRS.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fantasia");
		lblNewLabel_6.setBounds(53, 182, 74, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtForneFantasia = new JTextField();
		txtForneFantasia.setBounds(147, 179, 181, 20);
		getContentPane().add(txtForneFantasia);
		txtForneFantasia.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Site");
		lblNewLabel_7.setBounds(408, 309, 33, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtForneSite = new JTextField();
		txtForneSite.setBounds(491, 306, 149, 20);
		getContentPane().add(txtForneSite);
		txtForneSite.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fone");
		lblNewLabel_8.setBounds(408, 248, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtForneFone = new JTextField();
		txtForneFone.setBounds(491, 245, 149, 20);
		getContentPane().add(txtForneFone);
		txtForneFone.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Contato");
		lblNewLabel_9.setBounds(408, 213, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtForneContato = new JTextField();
		txtForneContato.setBounds(491, 210, 149, 20);
		getContentPane().add(txtForneContato);
		txtForneContato.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("E-mail");
		lblNewLabel_10.setBounds(408, 279, 46, 14);
		getContentPane().add(lblNewLabel_10);
		
		txtForneEmail = new JTextField();
		txtForneEmail.setBounds(491, 276, 149, 20);
		getContentPane().add(txtForneEmail);
		txtForneEmail.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("CEP");
		lblNewLabel_11.setBounds(53, 301, 46, 14);
		getContentPane().add(lblNewLabel_11);
		
		txtForneCep = new JTextField();
		txtForneCep.setBounds(161, 295, 107, 20);
		getContentPane().add(txtForneCep);
		txtForneCep.setColumns(10);
		
		JButton btnBuscarCep = new JButton("Buscar");
		btnBuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscarCep.setBounds(278, 292, 99, 23);
		getContentPane().add(btnBuscarCep);
		
		JLabel lblNewLabel_12 = new JLabel("Endere\u00E7o");
		lblNewLabel_12.setBounds(53, 326, 59, 14);
		getContentPane().add(lblNewLabel_12);
		
		txtForneEnd = new JTextField();
		txtForneEnd.setBounds(161, 323, 214, 20);
		getContentPane().add(txtForneEnd);
		txtForneEnd.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("N\u00FAmero");
		lblNewLabel_13.setBounds(282, 351, 46, 14);
		getContentPane().add(lblNewLabel_13);
		
		txtForneNum = new JTextField();
		txtForneNum.setBounds(328, 348, 46, 20);
		getContentPane().add(txtForneNum);
		txtForneNum.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Complemento");
		lblNewLabel_14.setBounds(408, 182, 87, 14);
		getContentPane().add(lblNewLabel_14);
		
		txtForneComp = new JTextField();
		txtForneComp.setBounds(491, 179, 149, 20);
		getContentPane().add(txtForneComp);
		txtForneComp.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(53, 351, 46, 14);
		getContentPane().add(lblNewLabel_15);
		
		txtForneBairro = new JTextField();
		txtForneBairro.setBounds(161, 348, 113, 20);
		getContentPane().add(txtForneBairro);
		txtForneBairro.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(53, 376, 46, 14);
		getContentPane().add(lblNewLabel_16);
		
		txtForneCidade = new JTextField();
		txtForneCidade.setBounds(161, 373, 99, 20);
		getContentPane().add(txtForneCidade);
		txtForneCidade.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("UF");
		lblNewLabel_17.setBounds(276, 376, 24, 14);
		getContentPane().add(lblNewLabel_17);
		
		cboForneUf = new JComboBox();
		cboForneUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboForneUf.setBounds(317, 372, 54, 22);
		getContentPane().add(cboForneUf);
		
		JLabel lblNewLabel_18 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_18.setBounds(53, 404, 74, 14);
		getContentPane().add(lblNewLabel_18);
		
		txtForneObs = new JTextArea();
		txtForneObs.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtForneObs.setBounds(161, 399, 214, 56);
		getContentPane().add(txtForneObs);
		
		JButton btnForneAdd = new JButton("");
		btnForneAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarForne();
			}
		});
		btnForneAdd.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/create.png")));
		btnForneAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnForneAdd.setContentAreaFilled(false);
		btnForneAdd.setBorderPainted(false);
		btnForneAdd.setToolTipText("Adicionar");
		btnForneAdd.setBounds(495, 391, 64, 64);
		getContentPane().add(btnForneAdd);
		
		JButton btnForneReload = new JButton("");
		btnForneReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarForne();
			}
		});
		btnForneReload.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/update.png")));
		btnForneReload.setToolTipText("Alterar");
		btnForneReload.setContentAreaFilled(false);
		btnForneReload.setBorderPainted(false);
		btnForneReload.setBounds(560, 391, 64, 64);
		getContentPane().add(btnForneReload);
		
		JButton btnForneDelete = new JButton("");
		btnForneDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirForne();
			}
		});
		btnForneDelete.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/delete.png")));
		btnForneDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnForneDelete.setToolTipText("Excluir");
		btnForneDelete.setContentAreaFilled(false);
		btnForneDelete.setBorderPainted(false);
		btnForneDelete.setBounds(623, 391, 64, 64);
		getContentPane().add(btnForneDelete);
		
		scrollPesquisarForne = new JScrollPane();
		scrollPesquisarForne.setBounds(53, 64, 526, 56);
		getContentPane().add(scrollPesquisarForne);
		
		tblForne = new JTable();
		tblForne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//evento clicar com o mouse
				setarCaixasTexto();
			}
		});
		scrollPesquisarForne.setViewportView(tblForne);
		
		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarForne();
			}
		});
		btnPesquisar.setBounds(180, 135, 81, 23);
		getContentPane().add(btnPesquisar);
		
		// Valida????o com o uso a biblioteca Atxy2k
				//txtUsuId
				RestrictedTextField validarCnpj = new RestrictedTextField(txtForneCnpj);
				validarCnpj.setOnlyNums(true);
				validarCnpj.setLimit(14);
				
				//txtUsuNome
				RestrictedTextField validarIe = new RestrictedTextField(txtForneIe);
				validarIe.setOnlyNums(true);
				validarIe.setLimit(14);
				
				//txtLogin
				RestrictedTextField validarIm = new RestrictedTextField(txtForneIm);
				validarIm.setLimit(14);
				
				//txtUsuSenha
				RestrictedTextField validarFone = new RestrictedTextField(txtForneFone);
				validarFone.setLimit(8);
				
				RestrictedTextField validarEmail = new RestrictedTextField(txtForneEmail);
				validarEmail.setLimit(50);
				
				RestrictedTextField validarCep = new RestrictedTextField(txtForneCep);
				validarCep.setLimit(8);
				
				RestrictedTextField validarNum = new RestrictedTextField(txtForneNum);
				validarNum.setLimit(10);
				
				RestrictedTextField validarComp = new RestrictedTextField(txtForneComp);
				
				btnForneFantasia = new JButton("");
				btnForneFantasia.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pesquisarForneFantasia();
					}
				});
				btnForneFantasia.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/pesquisar.png")));
				btnForneFantasia.setBorderPainted(false);
				btnForneFantasia.setContentAreaFilled(false);
				btnForneFantasia.setBounds(338, 167, 33, 35);
				getContentPane().add(btnForneFantasia);
				validarComp.setLimit(10);

	}//fim do construtor
	
	DAO dao = new DAO();
	private JScrollPane scrollPesquisarForne;
	private JTextArea txtForneObs;
	private JButton btnForneFantasia;
	
	/*
	 * M??todo respons??vel pela pesquisa do fornecedor na tabela
	 */
	private void pesquisarForneTable() {
		String readT = "select idfor as ID,fantasia as fornecedor,telefone,contato from fornecedores where fantasia like ? ";
		try {
			//Estabelecer a conex???o
			Connection con = dao.conectar();
			//Preparar a execu??????o da query
			PreparedStatement pst = con.prepareStatement(readT);
			//Setar o argumento (id)
			//Substituir o ? pelo conte???do da caixa de texto
			pst.setString(1, txtFornePesquisar.getText() + "%");
			//Executar a query e exibir o resultado no formulario
			ResultSet rs = pst.executeQuery();
			//uso da biblioteca rs2xml para popular a tabela
			tblForne.setModel(DbUtils.resultSetToTableModel(rs));
			
			if (rs.next()) {
			} else {
			}
			// NUNCA esquecer de encerrar a conex???o
			con.close();
			
			} catch (Exception e) {
				System.out.println(e);
		}
	}
	
	/**
	 * M??todo respons??vel por setar as caixas de texto 
	 * de acordo com os campos da tabela
	 */
	private void setarCaixasTexto() {
		//criar vari??vel para receber a linha da tabela
		int setar = tblForne.getSelectedRow();
		txtForneId.setText(tblForne.getModel().getValueAt(setar, 0).toString());
		//txtForneFantasia.setText(tblForne.getModel().getValueAt(setar, 0).toString());
	}
	
	//demais metodos de CRUD
	
	/**
	 * Limpar campos
	 */
	private void limparCamposFornecedor() {
		//limpar a tabela
		((DefaultTableModel)tblForne.getModel()).setRowCount(0);
	}
	

	/**
	 * M???todo rrespons???vel pela pesquisa de usu???rios pelo nome fantasia
	 */
	private void pesquisarForneFantasia() {
		//valida??????o
		if (txtForneFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome fantasia do Fornecedor");
			txtForneFantasia.requestFocus();
		} else {
			//l???gica principal
			//Query (instru??????o SQL)
			String read = "select * from fornecedores where fantasia = ?";
			//tratar exce??????es sempre que lidar com o banco
			try {
				//Estabelecer a conex???o
				Connection con = dao.conectar();
				//Preparar a execu??????o da query
				PreparedStatement pst = con.prepareStatement(read);
				//Setar o argumento (id)
				//Substituir o ? pelo conte???do da caixa de texto
				pst.setString(1, txtForneFantasia.getText());
				//Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				//Valida??????o (exist???ncia de usu???rio)
				//rs.next() -> exist???ncia de usu???rio
				if (rs.next()) {
					//preencher(setar) os campos do formul???rio
					txtForneId.setText(rs.getString(1));
					txtForneCnpj.setText(rs.getString(2));
					txtForneIe.setText(rs.getString(3));
					txtForneIm.setText(rs.getString(4));
					txtForneRS.setText(rs.getString(5));
					txtForneFantasia.setText(rs.getString(6));
					txtForneSite.setText(rs.getString(7));
					txtForneFone.setText(rs.getString(8));
					txtForneContato.setText(rs.getString(9));
					txtForneEmail.setText(rs.getString(10));
					txtForneCep.setText(rs.getString(11));
					txtForneEnd.setText(rs.getString(12));
					txtForneNum.setText(rs.getString(13));
					txtForneComp.setText(rs.getString(14));
					txtForneBairro.setText(rs.getString(15));
					txtForneCidade.setText(rs.getString(16));
					cboForneUf.setSelectedItem(rs.getString(17));
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Usu???rio inexistente");
				}
				// NUNCA esquecer de encerrar a conex???o
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * M???todo rrespons???vel pela pesquisa de usu???rios pelo id
	 */
	private void pesquisarForne() {
		//valida??????o
		if (txtForneId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome fantasia do Fornecedor");
			txtForneId.requestFocus();
		} else {
			//l???gica principal
			//Query (instru??????o SQL)
			String read = "select * from fornecedores where idfor = ?";
			//tratar exce??????es sempre que lidar com o banco
			try {
				//Estabelecer a conex???o
				Connection con = dao.conectar();
				//Preparar a execu??????o da query
				PreparedStatement pst = con.prepareStatement(read);
				//Setar o argumento (id)
				//Substituir o ? pelo conte???do da caixa de texto
				pst.setString(1, txtForneId.getText());
				//Executar a query e exibir o resultado no formulario
				ResultSet rs = pst.executeQuery();
				//Valida??????o (exist???ncia de usu???rio)
				//rs.next() -> exist???ncia de usu???rio
				if (rs.next()) {
					//preencher(setar) os campos do formul???rio
					txtFornePesquisar.setText(rs.getString(1));
					txtForneCnpj.setText(rs.getString(2));
					txtForneIe.setText(rs.getString(3));
					txtForneIm.setText(rs.getString(4));
					txtForneRS.setText(rs.getString(5));
					txtForneFantasia.setText(rs.getString(6));
					txtForneSite.setText(rs.getString(7));
					txtForneFone.setText(rs.getString(8));
					txtForneContato.setText(rs.getString(9));
					txtForneEmail.setText(rs.getString(10));
					txtForneCep.setText(rs.getString(11));
					txtForneEnd.setText(rs.getString(12));
					txtForneNum.setText(rs.getString(13));
					txtForneComp.setText(rs.getString(14));
					txtForneBairro.setText(rs.getString(15));
					txtForneCidade.setText(rs.getString(16));
					cboForneUf.setSelectedItem(rs.getString(17));
					
				} else {
					JOptionPane.showMessageDialog(null, "Usu???rio inexistente");
				}
				// NUNCA esquecer de encerrar a conex???o
				limparcampos();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * 
	 * M??todo respons??vel por adicionar um novo usu??rio no banco
	 * 
	 */
	
	private void adicionarForne() {
		//valida????o
				if (txtForneIe.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Ie do fornecedor");
					txtForneIe.requestFocus();
					
				}else if (txtForneIm.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Im do fornecedor");
					txtForneIm.requestFocus();
					
				}else if (txtForneRS.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha a Raz??o social do fornecedor");
					txtForneRS.requestFocus();
					
				}else if (txtForneFantasia.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Nome Fantasia do fornecedor");
					txtForneFantasia.requestFocus();
					
				}else if (txtForneCnpj.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o CNPJ do fornecedor");
					txtForneCnpj.requestFocus();
					
				}else if (txtForneCep.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o CEP do fornecedor");
					txtForneCep.requestFocus();
					
				}else if (txtForneEnd.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Endere??o do fornecedor");
					txtForneEnd.requestFocus();
					
				}else if (txtForneBairro.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Bairro do fornecedor");
					txtForneBairro.requestFocus();
					
				}else if (txtForneNum.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o N??mero do fornecedor");
					txtForneNum.requestFocus();
					
				}else if (txtForneCidade.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha a cidade do fornecedor");
					txtForneCidade.requestFocus();	
					
				}else if(cboForneUf.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Selecione a UF do fornecedor");
					cboForneUf.requestFocus();
					
				}else if (txtForneComp.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Complemento do fornecedor");
					txtForneComp.requestFocus();
					
				}else if (txtForneContato.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Contato do fornecedor");
					txtForneContato.requestFocus();
					
				}else if (txtForneFone.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Telefone do fornecedor");
					txtForneFone.requestFocus();
					
				}else if (txtForneEmail.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Email do fornecedor");
					txtForneEmail.requestFocus();
					
				}else if (txtForneSite.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Preencha o Site do fornecedor");
					txtForneSite.requestFocus();
					
				}else {
					// L??gica principal
					String create = "insert into fornecedores(ie,im,razao,fantasia,cnpj,cep,endereco,bairro,numero,cidade,uf,complemento,contato,telefone,email,site) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					// Estabelecer a conex???o
					Connection con = dao.conectar();
					//Preparar a execu??????o da query
					PreparedStatement pst = con.prepareStatement(create);
					// Substituir os ????? pelo conte??do das caixas de texto
					pst.setString(1, txtForneIe.getText());
					pst.setString(2, txtForneIm.getText());
					pst.setString(3, txtForneRS.getText());
					pst.setString(4, txtForneFantasia.getText());
					pst.setString(5, txtForneCnpj.getText());
					pst.setString(6, txtForneCep.getText());
					pst.setString(7, txtForneEnd.getText());
					pst.setString(8, txtForneBairro.getText());
					pst.setString(9, txtForneNum.getText());
					pst.setString(10, txtForneCidade.getText());
					pst.setString(11, cboForneUf.getSelectedItem().toString());
					pst.setString(12, txtForneComp.getText());
					pst.setString(13, txtForneContato.getText());
					pst.setString(14, txtForneFone.getText());
					pst.setString(15, txtForneEmail.getText());
					pst.setString(16, txtForneSite.getText());		
					
					//executar a query e inserir o usu??rio no banco
					pst.executeUpdate();
					// Encerrar a conex??o
					JOptionPane.showMessageDialog(null, "Usu??rio cadastrado com sucesso.");
					limparcampos();
					con.close();
				}catch(SQLIntegrityConstraintViolationException ex){
					JOptionPane.showMessageDialog(null, "Fornecedor existente");
					txtForneFantasia.setText(null);
					txtForneFantasia.requestFocus();
				}catch (Exception e) {
					System.out.println(e);
					}
				
				}
			}
	
	private void atualizarForne() {
		//valida????o
		if (txtForneIe.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o IE do Fornecedor");
			txtForneIe.requestFocus();
			
		}else if (txtForneIm.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o IM do Fornecedor");
			txtForneIm.requestFocus();
			
		}else if (txtForneRS.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha a Raz??o social do fornecedor");
			txtForneRS.requestFocus();
			
		}else if (txtForneFantasia.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o nome fantasia do fornecedor");
			txtForneFantasia.requestFocus();
			
		}else if (txtForneCnpj.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Cnpj do Fornecedor");
			txtForneCnpj.requestFocus();
			
		}else if (txtForneCep.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Cep do fornecedor");
			txtForneCep.requestFocus();
			
		}else if (txtForneEnd.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Endere??o do fornecedor");
			txtForneEnd.requestFocus();
			
		}else if (txtForneBairro.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o Bairro do fornecedor");
			txtForneBairro.requestFocus();
			
		}else if (txtForneNum.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o n??mero do fornecedor");
			txtForneNum.requestFocus();	
			
		}else if (txtForneCidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha a cidade do fornecedor");
			txtForneCidade.requestFocus();
			
		}else if(cboForneUf.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione a UF do fornecedor");
			cboForneUf.requestFocus();
			
		}else if (txtForneComp.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o complemento do fornecedor");
			txtForneComp.requestFocus();
		
		}else if (txtForneContato.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o contato do fornecedor");
			 txtForneContato.requestFocus();
			 
		}else if (txtForneFone.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor");
			 txtForneFone.requestFocus();
			 
		}else if (txtForneEmail.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o email do fornecedor");
			txtForneEmail.requestFocus();
			
		}else if (txtForneSite.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha o site do fornecedor");
			txtForneSite.requestFocus();
			 
			} else {
			// l??gica principal
			String update = "update fornecedores set ie=?,im=?,razao=?,fantasia=?,cnpj=?,cep=?,endereco=?,numero=?,bairro=?,cidade=?,uf=?,complemento=?,contato=?,telefone=?,email=?,site=? where idfor=?";
			try {
				// Estabelecer a conex??o 
				Connection con = dao.conectar();
				// Preparar a execu????o da Query
				PreparedStatement pst = con.prepareStatement(update);
				// Substituir o ? pelo conte??do da caixa de texto 
				pst.setString(1, txtForneIe.getText());
				pst.setString(2, txtForneIm.getText());
				pst.setString(3, txtForneRS.getText());
				pst.setString(4, txtForneFantasia.getText());
				pst.setString(5, txtForneCnpj.getText());
				pst.setString(6, txtForneCep.getText());
				pst.setString(7, txtForneEnd.getText());
				pst.setString(8, txtForneNum.getText());
				pst.setString(9, txtForneBairro.getText());
				pst.setString(10, txtForneCidade.getText());
				pst.setString(11, cboForneUf.getSelectedItem().toString());
				pst.setString(12, txtForneComp.getText());
				pst.setString(13, txtForneContato.getText());
				pst.setString(14, txtForneFone.getText());
				pst.setString(15, txtForneEmail.getText());
				pst.setString(16, txtForneSite.getText());
				pst.setString(17, txtForneId.getText());
				
				// Executar a query e alterar o usu??rio no banco
				pst.executeUpdate();
				// confirma????o
				limparcampos();
				JOptionPane.showMessageDialog(null, "Usu??rio alterado com sucesso");
				// Encerrar a conex??o
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Login em uso.\nEscolha outro login");
				txtForneId.setText(null);
				txtForneId.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
			
	}
	
	private void excluirForne() {
		//valida????o (cofrma????o de exclus??o)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclus??o do fornecedor?", "Aten????o!",JOptionPane.YES_NO_OPTION);
		
		if(confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from fornecedores where idfor=?";
			try {
				// Estabelecer a conex???o
				Connection con = dao.conectar();
				//Preparar a execu??????o da query
				PreparedStatement pst = con.prepareStatement(delete);
				// Substituir os ????? pelo conte??do das caixas de texto
				pst.setString(1, txtForneId.getText());
				//executar a query e inserir o usu??rio no banco
				pst.executeUpdate();
				
				//confirma????o
				limparcampos();
				JOptionPane.showMessageDialog(null, "Fornecedores exclu??do");
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
		String cep = txtForneCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtForneCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtForneBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboForneUf.setSelectedItem(element.getText());
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
						JOptionPane.showMessageDialog(null, "CEP n??o encontrado");
					}
				}

			}
			// Setar Campo Endere??o
			txtForneEnd.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void limparcampos() {
		txtFornePesquisar.setText(null);
		txtForneCnpj.setText(null);
		txtForneIe.setText(null);
		txtForneIm.setText(null);
		txtForneRS.setText(null);
		txtForneFantasia.setText(null);
		txtForneSite.setText(null);
		txtForneFone.setText(null);
		txtForneContato.setText(null);
		txtForneEmail.setText(null);
		txtForneCep.setText(null);
		txtForneEnd.setText(null);
		txtForneNum.setText(null);
		txtForneComp.setText(null);
		txtForneBairro.setText(null);
		txtForneCidade.setText(null);
		cboForneUf.setSelectedItem("");
	}
	}//fim do codigo
