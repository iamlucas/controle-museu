package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;










import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

import control.ObraEvBtnAlterar;
import control.ObraEvBtnDeletar;
import control.ObraEvBtnSalvar;
import control.ObraEvbtnPesquisarObra;
import entity.ObraEntity;

public class ObraBoundary {

	private JFrame frame = new JFrame();
	private JPanel contentPane;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JScrollPane scrollPane;
	private JLabel lblDataObra;
	private JLabel lblTipoObra;
	private JCheckBoxMenuItem checkDisponivel = new JCheckBoxMenuItem("Disponível para empréstimo");
	private JTextArea txtrBiografia = new JTextArea("Biografia");

	private JButton BtnVoltar;
	private JButton bntPesquisarAutor;
	private JButton bntPesquisarObra;
	private JButton bntDeletar;
	private JButton bntAlterar;
	private JButton bntSalvar;

	private JComboBox comboTipoObra = new JComboBox();
	private JComboBox comboCategoriaObra = new JComboBox();
	private JComboBox comboLocalizacaoObra = new JComboBox();

	private JDateChooser DataObra;
	private ObraEntity obraEntity;
	

	public ObraEntity getObraEntity() {
		return obraEntity;
	}

	public void setObraEntity(ObraEntity obraEntity) {
		this.obraEntity = obraEntity;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new ObraBoundary();

	}

	/**
	 * Create the frame.
	 */
	public ObraBoundary() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 529, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		frame.setLocationRelativeTo(null);
		//frame.setModal(true);
		frame.setTitle("Obras - Sistema Gerenciador de Museus.");
		contentPane.setLayout(null);

		txtNomeObra = new JTextField();
		txtNomeObra.setBounds(111, 13, 337, 20);
		txtNomeObra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomeObra.setText("");
		contentPane.add(txtNomeObra);
		txtNomeObra.setColumns(10);

		txtNomeAutor = new JTextField();
		txtNomeAutor.setBounds(111, 44, 337, 20);
		txtNomeAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomeAutor.setText("");
		txtNomeAutor.setColumns(10);
		contentPane.add(txtNomeAutor);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 482, 64);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(txtrBiografia);
		txtrBiografia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrBiografia.setText("");											

		lblDataObra = new JLabel("Data da Obra:");
		lblDataObra.setBounds(10, 172, 86, 23);
		contentPane.add(lblDataObra);	

		lblTipoObra = new JLabel("Tipo da Obra:");
		lblTipoObra.setBounds(10, 211, 75, 23);
		contentPane.add(lblTipoObra);
		comboTipoObra.setBounds(104, 211, 177, 22);

		comboTipoObra.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione", 
						"Pintura", "Escultura", "Fotografia", "Livro", "Outro" }));
		contentPane.add(comboTipoObra);

		JLabel lblCategoriaObra = new JLabel("Categoria:");
		lblCategoriaObra.setBounds(10, 245, 75, 23);
		contentPane.add(lblCategoriaObra);
		comboCategoriaObra.setBounds(104, 245, 177, 22);

		comboCategoriaObra.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione", "Moderna", "Barroca", "Cubista", "Realista", "Outro" }));
		contentPane.add(comboCategoriaObra);

		JLabel lblLocalizacaoObra = new JLabel("Localiza\u00E7\u00E3o:");
		lblLocalizacaoObra.setBounds(10, 279, 75, 23);
		contentPane.add(lblLocalizacaoObra);
		comboLocalizacaoObra.setBounds(104, 279, 177, 22);

		comboLocalizacaoObra.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione", "Salao Principal", "Primeiro Andar", "Subterr\u00E2neo", "Outro" }));
		contentPane.add(comboLocalizacaoObra);

		bntSalvar = new JButton("Salvar");
		bntSalvar.setIcon(new ImageIcon(ObraBoundary.class.getResource("/resource/save_32.png")));
		bntSalvar.setBounds(63, 352, 125, 37);
		contentPane.add(bntSalvar);

		bntAlterar = new JButton("Alterar");
		bntAlterar.setIcon(new ImageIcon(ObraBoundary.class.getResource("/resource/edit_32.png")));
		bntAlterar.setBounds(198, 352, 125, 37);
		contentPane.add(bntAlterar);

		bntDeletar = new JButton("Deletar");
		bntDeletar.setBounds(333, 352, 125, 37);
		contentPane.add(bntDeletar);

		bntPesquisarObra = new JButton("");
		bntPesquisarObra.setBounds(454, 11, 37, 24);
		bntPesquisarObra.setIcon(new ImageIcon(ObraBoundary.class.getResource("/resource/lupa_16.png")));
		contentPane.add(bntPesquisarObra);

		bntPesquisarAutor = new JButton("");
		bntPesquisarAutor.setBounds(455, 43, 37, 24);
		bntPesquisarAutor.setIcon(new ImageIcon(ObraBoundary.class.getResource("/resource/lupa_16.png")));
		contentPane.add(bntPesquisarAutor);
		
		BtnVoltar = new JButton("");
		BtnVoltar.setIcon(new ImageIcon(ObraBoundary.class.getResource("/resource/remove_32.png")));
		BtnVoltar.setBounds(449, 265, 43, 37);
		contentPane.add(BtnVoltar);
		
		checkDisponivel.setSelected(true);
		checkDisponivel.setBounds(301, 172, 191, 22);
		contentPane.add(checkDisponivel);
		
		DataObra = new JDateChooser();
		DataObra.setBounds(104, 172, 177, 20);
		contentPane.add(DataObra);

		frame.setVisible(true);
		
		JLabel lblNomeDaObra = new JLabel("Nome da Obra");
		lblNomeDaObra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDaObra.setBounds(10, 17, 93, 14);
		contentPane.add(lblNomeDaObra);
		
		JLabel lblNomeDoAutor = new JLabel("Nome do Autor");
		lblNomeDoAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoAutor.setBounds(10, 48, 93, 14);
		contentPane.add(lblNomeDoAutor);
				
		JLabel lblNewLabel = new JLabel("Biografia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(11, 79, 482, 14);
		contentPane.add(lblNewLabel);
		
		// adicionando evento ao botão salvar
		ObraEvBtnSalvar evsalvar = new ObraEvBtnSalvar(this, txtNomeObra, txtNomeAutor, 
				checkDisponivel, txtrBiografia, comboTipoObra,
					comboCategoriaObra, comboLocalizacaoObra, DataObra);
		bntSalvar.addActionListener(evsalvar);
		
		// adicionando evento ao botao bntpesquisar obra
		ObraEvbtnPesquisarObra EvPesquisarNome = 
				new ObraEvbtnPesquisarObra(this, txtNomeObra,
						txtNomeAutor, checkDisponivel, txtrBiografia,
						comboTipoObra, comboCategoriaObra, comboLocalizacaoObra, DataObra,"Obra");
		bntPesquisarObra.addActionListener(EvPesquisarNome);
		
		// adicionando evento ao botao btnpesquisar Autor
		ObraEvbtnPesquisarObra EvPesquisarAutor = 
				new ObraEvbtnPesquisarObra(this, txtNomeObra,
						txtNomeAutor, checkDisponivel, txtrBiografia,
						comboTipoObra, comboCategoriaObra, comboLocalizacaoObra, DataObra,"Autor");
		bntPesquisarAutor.addActionListener(EvPesquisarAutor);
		
		// adicionando evento ao botão alterar
		ObraEvBtnAlterar EvAlterar = new ObraEvBtnAlterar(
				this, txtNomeObra, txtNomeAutor, checkDisponivel, txtrBiografia,
				comboTipoObra, comboCategoriaObra, comboLocalizacaoObra, DataObra);				
		bntAlterar.addActionListener(EvAlterar);

		// adicionando evento ao botão deletar
		ObraEvBtnDeletar Evdeletar = new ObraEvBtnDeletar(this);
		bntDeletar.addActionListener(Evdeletar);
		
		// adicionando evento ao botão voltar
		ActionListener EvVoltar = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				telaDefault();
			}
		};
		BtnVoltar.addActionListener(EvVoltar);
		
		this.telaDefault();
	}
	
	public void telaDefault(){
		txtNomeAutor.setText("");
		txtNomeObra.setText("");
		txtrBiografia.setText("");
		comboCategoriaObra.setSelectedItem("Selecione");
		comboLocalizacaoObra.setSelectedItem("Selecione");
		comboTipoObra.setSelectedItem("Selecione");
		DataObra.setDate(null);
		checkDisponivel.setSelected(true);
		
		bntAlterar.setEnabled(false);
		bntDeletar.setEnabled(false);		
		BtnVoltar.setEnabled(false);
		bntSalvar.setEnabled(true);
	    }
	public void telaAlterar(){
		bntAlterar.setEnabled(true);
		bntDeletar.setEnabled(true);		
		BtnVoltar.setEnabled(true);
		bntSalvar.setEnabled(false);
	}
	public boolean validaCampos(){
		if(
			txtNomeAutor.getText().length() <= 0 ||
			txtNomeObra.getText().length() <= 0 ||
			txtrBiografia.getText().length() <= 0 ||
			comboCategoriaObra.getSelectedItem().equals("Selecione") ||
			comboLocalizacaoObra.getSelectedItem().equals("Selecione") ||
			comboTipoObra.getSelectedItem().equals("Selecione") ||
			DataObra.getDate() == null
				){
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
			return false;
		}
		return true;
	}
}

