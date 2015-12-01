package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;

import control.EmprestimoEvBtnAlterar;
import control.EmpretimoEvBtnDeletar;
import control.EmprestimoEvBtnDevolver;
import control.EmprestimoPesquisarLocalEvBtnPesquisar;
import control.EmprestimoEvBtnPesquisarObra;
import control.EmprestimoEvBtnSalvar;
import control.EmprestimoEvTabela;
import control.EmprestimoPesquisaObraEvTabela;
import entity.EmprestimoEntity;
import entity.LocalEmprestimoEntity;
import entity.ObraEntity;

import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;

public class EmprestimoBoundary extends JDialog {

	private JPanel contentPane;
	private JTextField TxtObra;
	private JTextField TxtNomeObra;
	private JTextField TxtDestinatario;
	private EmprestimoEntity emprestimoEntity;
	private JTable tabela;
	private JTextField TxtPequisar;
	private JDateChooser DataSaida;
	private JDateChooser PrevisaoDevolucao;
	private JButton btnProcurarDestinatario;
	private JButton btnSalvar;
	private JButton btnNovo;
	private JButton btnCancelar;
	private JButton btnProcurarObra;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnDevolverObra;
	private EmprestimoEvBtnSalvar evsalvar;
	private EmprestimoEvBtnAlterar evAlterar;
	
		
	@Override
	public String toString() {
		return "" + emprestimoEntity.getEmprestimo_id() 
				+ " " + emprestimoEntity.getLocatario() ;
	}

	public EmprestimoEntity getEmprestimoEntity() {
		return emprestimoEntity;
	}		

	public void setEmprestimoEntity(EmprestimoEntity emprestimoEntity) {
		this.emprestimoEntity = emprestimoEntity;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmprestimoBoundary frame = new EmprestimoBoundary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmprestimoBoundary() {
		this.emprestimoEntity = new EmprestimoEntity();
		
		setTitle("Empr\u00E9stimo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 891, 722);
		setModal(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 328, 857, 292);
		contentPane.add(scrollPane);
		
		tabela = new JTable();
		scrollPane.setViewportView(tabela);
		DefaultTableModel modelotabela = new DefaultTableModel(new Object[][] {},new String[] {
					"ID", "Nome da Obra", "Locatario", "Data Saida", "Previs\u00E3o Devolu\u00E7\u00E3o", "Status"}); 
		tabela.setModel(modelotabela);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(31);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(185);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(283);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(149);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(140);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(116);				
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados do Emprestimo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 581, 251);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNomeDaObra = new JLabel("Nome da Obra");
		lblNomeDaObra.setBounds(0, 56, 104, 14);
		panel_1.add(lblNomeDaObra);
		lblNomeDaObra.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Label label_1 = new Label("Obra");
		label_1.setBounds(0, 27, 104, 14);
		panel_1.add(label_1);
		label_1.setAlignment(Label.RIGHT);
		
		
		
		TxtNomeObra = new JTextField();
		TxtNomeObra.setBounds(114, 53, 426, 20);
		panel_1.add(TxtNomeObra);
		TxtNomeObra.setColumns(10);
		
		JLabel lblDestinatario = new JLabel("Destinat\u00E1rio");
		lblDestinatario.setBounds(0, 87, 104, 14);
		panel_1.add(lblDestinatario);
		lblDestinatario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		TxtDestinatario = new JTextField();
		TxtDestinatario.setBounds(114, 84, 376, 20);
		panel_1.add(TxtDestinatario);
		TxtDestinatario.setColumns(10);				
		
		TxtObra = new JTextField();
		TxtObra.setBounds(114, 21, 140, 20);
		panel_1.add(TxtObra);
		TxtObra.setColumns(10);
		
		JLabel lblDataDeSaida = new JLabel("Data de saida");
		lblDataDeSaida.setBounds(0, 123, 104, 14);
		panel_1.add(lblDataDeSaida);
		lblDataDeSaida.setHorizontalAlignment(SwingConstants.RIGHT);
				
				
		DataSaida = new JDateChooser();
		DataSaida.setBounds(114, 117, 140, 20);
		panel_1.add(DataSaida);
				
		JLabel lblPrevisoDeDevoluo = new JLabel("Previs\u00E3o de devolu\u00E7\u00E3o");
		lblPrevisoDeDevoluo.setBounds(264, 121, 134, 14);
		panel_1.add(lblPrevisoDeDevoluo);
		lblPrevisoDeDevoluo.setHorizontalAlignment(SwingConstants.CENTER);
						
						
		PrevisaoDevolucao = new JDateChooser();
		PrevisaoDevolucao.setBounds(400, 117, 140, 20);
		panel_1.add(PrevisaoDevolucao);
						
		btnProcurarDestinatario = new JButton("");
		btnProcurarDestinatario.setBounds(490, 83, 50, 23);
		panel_1.add(btnProcurarDestinatario);
		btnProcurarDestinatario.setIcon(new ImageIcon(EmprestimoBoundary.class.getResource("/resource/lupa_16.png")));
						
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(133, 199, 121, 41);
		panel_1.add(btnSalvar);
		btnSalvar.setIcon(new ImageIcon(EmprestimoBoundary.class.getResource("/resource/save_32.png")));
				
		btnNovo = new JButton("Novo");		
		btnNovo.setBounds(10, 199, 121, 41);
		panel_1.add(btnNovo);
		btnNovo.setIcon(new ImageIcon(EmprestimoBoundary.class.getResource("/resource/add.png")));
					
		btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDefault();
			}
		});
		btnCancelar.setBounds(515, 199, 56, 41);
		panel_1.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon(EmprestimoBoundary.class.getResource("/resource/remove_32.png")));
						
		btnProcurarObra = new JButton("");
		btnProcurarObra.setBounds(255, 19, 49, 25);
		panel_1.add(btnProcurarObra);
		btnProcurarObra.setIcon(new ImageIcon(EmprestimoBoundary.class.getResource("/resource/lupa_16.png")));						
		
		JLabel lblDatasys = new JLabel("");
		lblDatasys.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatasys.setBounds(601, 120, 248, 20);
		contentPane.add(lblDatasys);
		Date agora = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		lblDatasys.setText("" + df.format(agora));
		
		
		btnAlterar = new JButton("Alterar");		
		btnAlterar.setIcon(new ImageIcon(EmprestimoBoundary.class.getResource("/resource/edit_32.png")));
		btnAlterar.setBounds(10, 631, 121, 41);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(EmprestimoBoundary.class.getResource("/resource/remove_32.png")));
		btnExcluir.setBounds(137, 631, 121, 41);
		contentPane.add(btnExcluir);				
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(EmprestimoBoundary.class.getResource("/resource/mini_logo.png")));
		label.setBounds(601, -4, 269, 151);
		contentPane.add(label);					
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pesquisar", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(601, 257, 266, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TxtPequisar = new JTextField();
		TxtPequisar.setBounds(55, 22, 184, 23);
		panel.add(TxtPequisar);
		TxtPequisar.setColumns(10);				
		
		JLabel lblObra = new JLabel("Obra");
		lblObra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObra.setBounds(10, 22, 41, 23);
		panel.add(lblObra);
				
		btnDevolverObra = new JButton("Devolver obra");
		btnDevolverObra.setBounds(264, 631, 134, 41);
		contentPane.add(btnDevolverObra);
		
		JLabel lblEmprestimos = new JLabel("Emprestimos");
		lblEmprestimos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmprestimos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmprestimos.setBounds(10, 296, 855, 33);
		contentPane.add(lblEmprestimos);
		
		
		// aqui estou passando o evento para o botão
		EmprestimoPesquisarLocalEvBtnPesquisar evProcurarDestinatario = new
						EmprestimoPesquisarLocalEvBtnPesquisar(this, this.TxtDestinatario);
		btnProcurarDestinatario.addActionListener(evProcurarDestinatario);
				
		// aqui estou passando o evento para o botão
		EmprestimoEvBtnPesquisarObra ev1 = new EmprestimoEvBtnPesquisarObra(
						this, TxtObra, TxtNomeObra
						);
		btnProcurarObra.addActionListener(ev1);
				
				
		//Preenchendo a tabela
		EmprestimoEvTabela atualizaTabela = new EmprestimoEvTabela(tabela);
		atualizaTabela.SelectAll();
		
		// adicionando o evento do mouse a tabela
		EmprestimoEvTabela evMouse = new EmprestimoEvTabela(this.TxtObra, this.TxtNomeObra, 
						this.TxtDestinatario, this,
						this.tabela, this.DataSaida, this.PrevisaoDevolucao);
		tabela.addMouseListener(evMouse);
				
		// aqui passo o evento para o botão excluir
		EmpretimoEvBtnDeletar evDeletar = new EmpretimoEvBtnDeletar(this, this.tabela);
		btnExcluir.addActionListener(evDeletar);

		// Instanciando os eventos do botão salvar
		evsalvar = new EmprestimoEvBtnSalvar(TxtObra,
				TxtNomeObra, TxtDestinatario, DataSaida, PrevisaoDevolucao, 
		this, this.tabela);
		evAlterar = new EmprestimoEvBtnAlterar(TxtObra,
				TxtNomeObra, TxtDestinatario, DataSaida, PrevisaoDevolucao, 
		this, tabela);
		
		
		
		
		// adicionando evento keylistener a txtpesquisar
		EmprestimoEvTabela evPesquisarPorObra = new EmprestimoEvTabela(this.TxtPequisar, this.tabela);
		TxtPequisar.addKeyListener(evPesquisarPorObra);
		
		// adcionando o evento ao botão alterar
		ActionListener evalterar = new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
			TelaAlterarRegistro();	
			btnSalvar.removeActionListener(evsalvar);
			btnSalvar.removeActionListener(evAlterar);
			btnSalvar.addActionListener(evAlterar);
			}
		};
		btnAlterar.addActionListener(evalterar);
		
		// adcionando o evento ao botão novo
		ActionListener evBtnNovo = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaNovoRegistro();
				btnSalvar.removeActionListener(evAlterar);
				btnSalvar.removeActionListener(evsalvar);
				btnSalvar.addActionListener(evsalvar);
			}
		}; 
		btnNovo.addActionListener(evBtnNovo);
		
		// adicionando o evento ao botão devolver
		EmprestimoEvBtnDevolver evdevolver = new EmprestimoEvBtnDevolver(this, this.tabela);
		btnDevolverObra.addActionListener(evdevolver);
		
		this.TelaDefault();
		
	}
	
	public void TelaDefault(){
		//this.TxtObra.setEnabled(false);
		this.TxtObra.setEditable(false);
		this.TxtObra.setText("");
		
		//this.TxtDestinatario.setEnabled(false);
		this.TxtDestinatario.setEditable(false);
		this.TxtDestinatario.setText("");
		
		//this.TxtNomeObra.setEnabled(false);
		this.TxtNomeObra.setEditable(false);
		this.TxtNomeObra.setText("");
		
		this.DataSaida.setEnabled(false);
		this.DataSaida.setDate(null);
		
		this.PrevisaoDevolucao.setEnabled(false);
		this.PrevisaoDevolucao.setDate(null);
		
		this.btnSalvar.setEnabled(false);
		
		this.btnCancelar.setEnabled(false);
		
		this.btnAlterar.setEnabled(false);
		
		this.btnExcluir.setEnabled(false);
		
		this.btnProcurarDestinatario.setEnabled(false);
		
		this.btnProcurarObra.setEnabled(false);
		
		this.btnDevolverObra.setEnabled(false);
		
		this.btnNovo.setEnabled(true);
		
		this.emprestimoEntity = new EmprestimoEntity();
	}
	public void TelaEmpSelecionado(){
		//this.TxtObra.setEnabled(false);
		this.TxtObra.setEditable(false);
		
		//this.TxtDestinatario.setEnabled(false);
		this.TxtDestinatario.setEditable(false);
		
		//this.TxtNomeObra.setEnabled(false);
		this.TxtNomeObra.setEditable(false);
		
		this.DataSaida.setEnabled(false);
		this.PrevisaoDevolucao.setEnabled(false);
		
		this.btnSalvar.setEnabled(false);
		
		this.btnCancelar.setEnabled(false);
		
		this.btnAlterar.setEnabled(true);
		
		this.btnExcluir.setEnabled(true);
		
		this.btnProcurarDestinatario.setEnabled(false);
		
		this.btnProcurarObra.setEnabled(false);
		
		this.btnDevolverObra.setEnabled(true);
						
		this.btnNovo.setEnabled(true);
	}
	public void TelaNovoRegistro(){
		this.TxtObra.setEnabled(true);
		this.TxtObra.setText("");
		
		this.TxtDestinatario.setEnabled(true);
		this.TxtDestinatario.setText("");
		
		this.TxtNomeObra.setEnabled(true);		
		this.TxtNomeObra.setText("");
		
		this.DataSaida.setEnabled(true);
		this.DataSaida.setDate(null);
		
		this.PrevisaoDevolucao.setEnabled(true);
		this.PrevisaoDevolucao.setDate(null);
		
		this.btnSalvar.setEnabled(true);
		
		this.btnCancelar.setEnabled(true);
		
		this.btnAlterar.setEnabled(false);
		
		this.btnExcluir.setEnabled(false);
		
		this.btnProcurarDestinatario.setEnabled(true);
		
		this.btnProcurarObra.setEnabled(true);
		
		this.btnDevolverObra.setEnabled(false);
		
		this.emprestimoEntity = new EmprestimoEntity();
		
		this.btnNovo.setEnabled(false);
	}
	public void TelaAlterarRegistro(){
		this.TxtObra.setEnabled(true);		
		
		this.TxtDestinatario.setEnabled(true);		
		
		this.TxtNomeObra.setEnabled(true);		
		
		this.DataSaida.setEnabled(true);
		this.PrevisaoDevolucao.setEnabled(true);
		
		this.btnSalvar.setEnabled(true);
		
		this.btnCancelar.setEnabled(true);
		
		this.btnAlterar.setEnabled(false);
		
		this.btnExcluir.setEnabled(false);
		
		this.btnProcurarDestinatario.setEnabled(true);
		
		this.btnProcurarObra.setEnabled(true);
		
		this.btnDevolverObra.setEnabled(false);
		
		this.btnNovo.setEnabled(false);
	}
	public boolean validaCampos(){		
		System.out.println(
				TxtDestinatario.getText() + 
				TxtNomeObra.getText() + 
				TxtObra.getText() 
				);
		if(TxtDestinatario.getText().length() <= 0 ||
				TxtNomeObra.getText().length() <=0 ||
				TxtObra.getText().length() <=0 ||
				DataSaida.getDate() == null ||
				PrevisaoDevolucao.getDate() == null
				){
			JOptionPane.showMessageDialog(this,
					"Todos os campos devem ser preenchidos!");
			return false;
		}
		
		return true;
	}
	public boolean validaData(){
		if(DataSaida.getDate().getTime() >= PrevisaoDevolucao.getDate().getTime()){
			JOptionPane.showMessageDialog(this,
					"A data de previsão da devolução não pode ser menor que a data de saida!");
			return false;
		}
		
		return true;
	}
}
	
