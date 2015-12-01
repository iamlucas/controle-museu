package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import java.awt.Font;

public class ExposicaoBoundary extends JDialog {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField;
	private JDateChooser DataInicio;
	private JDateChooser DataFim;
	private JLabel lblDataTermino;
	private JButton btnPesquisar;
	private JTable TabelaObras;
	private JScrollPane scrollPane;
	private JTable TabelaExposicao;
	private JScrollPane scrollPane_1;
	private JButton BtnIncluir;
	private JButton BtnRemover;
	private JLabel lblClassificarPor;
	private JLabel lblObrasDisponiveis;
	private JLabel lblExposio;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExposicaoBoundary frame = new ExposicaoBoundary();
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
	public ExposicaoBoundary() {
		setTitle("Cadastro de Exposi\u00E7\u00E3o");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 823, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaExposio = new JLabel("Nome da Exposi\u00E7\u00E3o");
		lblNomeDaExposio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDaExposio.setBounds(10, 11, 127, 20);
		contentPane.add(lblNomeDaExposio);
		
		txtNome = new JTextField();
		txtNome.setBounds(137, 11, 574, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblValorDoIngresso = new JLabel("Valor do Ingresso (R$)");
		lblValorDoIngresso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDoIngresso.setBounds(10, 42, 127, 20);
		contentPane.add(lblValorDoIngresso);
		
		textField = new JTextField();
		textField.setBounds(137, 42, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDataInicio = new JLabel("Data inicio");
		lblDataInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataInicio.setBounds(10, 73, 127, 20);
		contentPane.add(lblDataInicio);
		
		DataInicio = new JDateChooser();
		DataInicio.setBounds(137, 73, 140, 20);
		contentPane.add(DataInicio);
		
		DataFim = new JDateChooser();
		DataFim.setBounds(365, 73, 140, 20);
		contentPane.add(DataFim);
		
		lblDataTermino = new JLabel("Data Termino");
		lblDataTermino.setBounds(287, 73, 89, 20);
		contentPane.add(lblDataTermino);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(ExposicaoBoundary.class.getResource("/resource/lupa_16.png")));
		btnPesquisar.setBounds(709, 11, 35, 20);
		contentPane.add(btnPesquisar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 190, 330, 350);
		contentPane.add(scrollPane);
		
		TabelaObras = new JTable();
		scrollPane.setViewportView(TabelaObras);
		TabelaObras.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Obra", "Autor"
			}
		));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(467, 190, 330, 350);
		contentPane.add(scrollPane_1);
		
		TabelaExposicao = new JTable();
		scrollPane_1.setViewportView(TabelaExposicao);
		TabelaExposicao.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Obra", "Autor"
			}
		));
		
		JComboBox CbFiltro = new JComboBox();
		CbFiltro.setBounds(117, 540, 236, 20);
		contentPane.add(CbFiltro);
		
		BtnIncluir = new JButton(">>");
		BtnIncluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		BtnIncluir.setBounds(365, 293, 89, 23);
		contentPane.add(BtnIncluir);
		
		BtnRemover = new JButton("<<");
		BtnRemover.setFont(new Font("Tahoma", Font.BOLD, 16));
		BtnRemover.setBounds(368, 364, 89, 23);
		contentPane.add(BtnRemover);
		
		lblClassificarPor = new JLabel("Classificar por:");
		lblClassificarPor.setBounds(23, 540, 89, 20);
		contentPane.add(lblClassificarPor);
		
		lblObrasDisponiveis = new JLabel("Obras Disponiveis");
		lblObrasDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblObrasDisponiveis.setHorizontalAlignment(SwingConstants.CENTER);
		lblObrasDisponiveis.setBounds(23, 169, 330, 20);
		contentPane.add(lblObrasDisponiveis);
		
		lblExposio = new JLabel("Exposi\u00E7\u00E3o");
		lblExposio.setHorizontalAlignment(SwingConstants.CENTER);
		lblExposio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExposio.setBounds(467, 169, 330, 20);
		contentPane.add(lblExposio);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(ExposicaoBoundary.class.getResource("/resource/save_32.png")));
		btnSalvar.setBounds(23, 616, 114, 41);
		contentPane.add(btnSalvar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ExposicaoBoundary.class.getResource("/resource/edit_32.png")));
		btnAlterar.setBounds(147, 616, 114, 41);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(ExposicaoBoundary.class.getResource("/resource/remove_32.png")));
		btnExcluir.setBounds(683, 616, 114, 41);
		contentPane.add(btnExcluir);
		TabelaObras.getColumnModel().getColumn(0).setPreferredWidth(300);
		TabelaObras.getColumnModel().getColumn(1).setPreferredWidth(320);
	}
}
