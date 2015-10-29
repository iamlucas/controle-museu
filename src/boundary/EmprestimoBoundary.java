package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.LocalEmprestimoEntity;

import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class EmprestimoBoundary extends JFrame {

	private JPanel contentPane;
	private JTextField TxtObra;
	private JTextField TxtNomeObra;
	private JTextField TxtDestinatario;

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
		setTitle("Empr\u00E9stimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDaObra = new JLabel("Nome da Obra");
		lblNomeDaObra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDaObra.setBounds(10, 94, 104, 14);
		contentPane.add(lblNomeDaObra);

		JDateChooser DataAtual = new JDateChooser();
		DataAtual.setBounds(395, 12, 154, 20);
		contentPane.add(DataAtual);

		Label label = new Label("Data");
		label.setBounds(366, 10, 28, 22);
		contentPane.add(label);

		Label label_1 = new Label("Obra");
		label_1.setAlignment(Label.RIGHT);
		label_1.setBounds(10, 65, 104, 14);
		contentPane.add(label_1);

		TxtObra = new JTextField();
		TxtObra.setBounds(124, 59, 140, 20);
		contentPane.add(TxtObra);
		TxtObra.setColumns(10);

		TxtNomeObra = new JTextField();
		TxtNomeObra.setBounds(124, 91, 376, 20);
		contentPane.add(TxtNomeObra);
		TxtNomeObra.setColumns(10);

		JLabel lblDestinatario = new JLabel("Destinat\u00E1rio");
		lblDestinatario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestinatario.setBounds(10, 125, 104, 14);
		contentPane.add(lblDestinatario);

		TxtDestinatario = new JTextField();
		TxtDestinatario.setBounds(124, 122, 376, 20);
		contentPane.add(TxtDestinatario);
		TxtDestinatario.setColumns(10);

		JLabel lblDataDeSaida = new JLabel("Data de saida");
		lblDataDeSaida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDeSaida.setBounds(10, 161, 104, 14);
		contentPane.add(lblDataDeSaida);

		JDateChooser DataSaida = new JDateChooser();
		DataSaida.setBounds(124, 155, 140, 20);
		contentPane.add(DataSaida);

		JLabel lblPrevisoDeDevoluo = new JLabel("Previs\u00E3o de devolu\u00E7\u00E3o");
		lblPrevisoDeDevoluo.setBounds(10, 197, 115, 14);
		contentPane.add(lblPrevisoDeDevoluo);

		JDateChooser PrevisaoDevolucao = new JDateChooser();
		PrevisaoDevolucao.setBounds(124, 191, 140, 20);
		contentPane.add(PrevisaoDevolucao);

		JButton btnProcurarObra = new JButton("Q");
		btnProcurarObra.setBounds(264, 58, 50, 23);
		contentPane.add(btnProcurarObra);

		JButton btnProcurarDestinatario = new JButton("Q");
		btnProcurarDestinatario.setBounds(500, 121, 50, 23);
		contentPane.add(btnProcurarDestinatario);

		JButton btnReagendar = new JButton("Reagendar");
		btnReagendar.setBounds(273, 188, 121, 23);
		contentPane.add(btnReagendar);

		JDateChooser DataDevolvido = new JDateChooser();
		DataDevolvido.setBounds(395, 228, 154, 20);
		contentPane.add(DataDevolvido);

		JRadioButton rdbtnDevolvido = new JRadioButton("Devolvido");
		rdbtnDevolvido.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnDevolvido.setBounds(273, 228, 121, 23);
		contentPane.add(rdbtnDevolvido);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(135, 305, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(261, 305, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(383, 305, 89, 23);
		contentPane.add(btnExcluir);
	}

	public void recebeLocalEmprestimo(LocalEmprestimoEntity local) {

	}
}
