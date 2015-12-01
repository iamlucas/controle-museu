package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import com.toedter.calendar.JDateChooser;

import control.ObraPesquisaObraEvPesquisaAutor;
import control.ObraPesquisaObraEvPesquisarNome;
import control.ObraPesquisaObraEvTabela;

import java.awt.Dialog.ModalExclusionType;

public class ObraPesquisaObraBoundary extends JDialog {

	private JPanel contentPane;
	private JTextField TxtPesquisar;
	private JTable table;
	private ObraBoundary Telaobra;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JCheckBoxMenuItem checkDisponivel;
	private JTextArea txtrBiografia;
	private JComboBox comboTipoObra;
	private JComboBox comboCategoriaObra;
	private JComboBox comboLocalizacaoObra;
	private JDateChooser DataObra;
	private String criterio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ObraPesquisaObraBoundary frame = new ObraPesquisaObraBoundary();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ObraPesquisaObraBoundary(ObraBoundary telaobra,
			JTextField txtNomeObra, JTextField txtNomeAutor,
			JCheckBoxMenuItem checkDisponivel, JTextArea txtrBiografia,
			JComboBox comboTipoObra, JComboBox comboCategoriaObra,
			JComboBox comboLocalizacaoObra, JDateChooser dataObra
			, String criterio) {
		super();
		setModal(true);
		this.Telaobra = telaobra;
		this.txtNomeObra = txtNomeObra;
		this.txtNomeAutor = txtNomeAutor;
		this.checkDisponivel = checkDisponivel;
		this.txtrBiografia = txtrBiografia;
		this.comboTipoObra = comboTipoObra;
		this.comboCategoriaObra = comboCategoriaObra;
		this.comboLocalizacaoObra = comboLocalizacaoObra;
		this.DataObra = dataObra;
		this.criterio = criterio;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaObra = new JLabel("Nome " + criterio);
		lblNomeDaObra.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNomeDaObra.setBounds(10, 11, 136, 36);
		contentPane.add(lblNomeDaObra);
		
		TxtPesquisar = new JTextField();
		TxtPesquisar.setBounds(148, 11, 422, 36);
		contentPane.add(TxtPesquisar);
		TxtPesquisar.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon(ObraPesquisaObraBoundary.class.getResource("/resource/lupa_16.png")));
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPesquisar.setBounds(580, 11, 186, 36);
		contentPane.add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 756, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] {
					"Id", "Nome", "Autor", "Data", "Tipo", "Categoria", "Localiza\u00E7\u00E3o"
				}
			); 
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(289);
		table.getColumnModel().getColumn(2).setPreferredWidth(235);
		table.getColumnModel().getColumn(3).setPreferredWidth(195);
		table.getColumnModel().getColumn(4).setPreferredWidth(135);
		table.getColumnModel().getColumn(5).setPreferredWidth(142);
		table.getColumnModel().getColumn(6).setPreferredWidth(152);
		
		//adicionando evento ao botão pesquisar
		if(criterio.equals("Obra")){
		ObraPesquisaObraEvPesquisarNome EvPesquisarNome = new ObraPesquisaObraEvPesquisarNome(TxtPesquisar, table);
		btnPesquisar.addActionListener(EvPesquisarNome);
		EvPesquisarNome.preenchertabela();
		}
		else if(criterio.equals("Autor")){
		ObraPesquisaObraEvPesquisaAutor EvPesquisarAutor = new ObraPesquisaObraEvPesquisaAutor(TxtPesquisar, table);	
		btnPesquisar.addActionListener(EvPesquisarAutor);
		EvPesquisarAutor.preenchertabela();
		}
		
		//adicionando o evento do mouse na tabela
		ObraPesquisaObraEvTabela evtabela = 
				new ObraPesquisaObraEvTabela(Telaobra, this, 
						txtNomeObra, txtNomeAutor, checkDisponivel, txtrBiografia, comboTipoObra, 
						comboCategoriaObra, comboLocalizacaoObra, DataObra, table);
		table.addMouseListener(evtabela);
		
	}
}
