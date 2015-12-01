package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.EmprestimoPesquisaObraEvBtnPesquisar;
import control.EmprestimoPesquisaObraEvTabela;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class EmprestimoPesquisaObraBoundary extends JDialog  {

	private JPanel contentPane;
	private JTextField TxtNomedaObra;
	private JTable tabelaResultado;
	private EmprestimoBoundary emprestimo;
	private JTextField txtid;
	private JTextField txtnomeObra;
	private long timeToDoubleClick = 0;
	private JScrollPane scrollPane;
	
	
	

	public long getTimeToDoubleClick() {
		return timeToDoubleClick;
	}

	public void setTimeToDoubleClick(long timeToDoubleClick) {
		this.timeToDoubleClick = timeToDoubleClick;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					/*ObraPesquisaBoundary frame = new ObraPesquisaBoundary();
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmprestimoPesquisaObraBoundary(EmprestimoBoundary emprestimo, JTextField txtid,JTextField txtnomeObra ) {
		setModal(true);
		
		this.emprestimo = emprestimo;
		this.txtid = txtid;
		this.TxtNomedaObra = txtnomeObra;
		
		setBounds(100, 100, 791, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TxtNomedaObra = new JTextField();
		TxtNomedaObra.setBounds(134, 11, 319, 34);
		contentPane.add(TxtNomedaObra);
		TxtNomedaObra.setColumns(10);
		
		JLabel lblNomeDaObra = new JLabel("Nome da obra");
		lblNomeDaObra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeDaObra.setBounds(10, 11, 114, 34);
		contentPane.add(lblNomeDaObra);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 755, 194);
		contentPane.add(scrollPane);

		tabelaResultado = new JTable();
		scrollPane.setViewportView(tabelaResultado);
		tabelaResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaResultado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Nome", "Autor", "Localização"
			}
		));
		
		// adicionando o evento ao botão pesquisar
		EmprestimoPesquisaObraEvBtnPesquisar evPesquisarObra = new EmprestimoPesquisaObraEvBtnPesquisar(TxtNomedaObra,tabelaResultado);
		
		
		//carregando a tabela ao abrir a tela
		evPesquisarObra.preenchertabela();
		
		// adicionando o evento do mouse a tabela
		EmprestimoPesquisaObraEvTabela evMouseClick = 
		new EmprestimoPesquisaObraEvTabela(emprestimo,
		this, tabelaResultado, txtid, txtnomeObra);
		tabelaResultado.addMouseListener(evMouseClick);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPesquisar.setBounds(463, 11, 158, 34);
		contentPane.add(btnPesquisar);
		btnPesquisar.addActionListener(evPesquisarObra);
		
		
	}
}
