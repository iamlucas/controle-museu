package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.css.CalculatedValue;

import control.CarregaDados;
import control.VendaIngressosControl;
import entity.VendaIngressosEntity;
import javafx.scene.GroupBuilder;
import javafx.scene.control.ComboBox;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class VendaIngressoBoundary {

	private JFrame frame = new JFrame("Venda de Ingressos - Sistema Gerenciador de Museus.");
	private JPanel contentPane;
	private JLabel lblTotalApagar;
	private JRadioButton rdbtnEstudante;
	private JRadioButton rdbtnProfessor;
	private JRadioButton rdbtnOutros;
	private JRadioButton rdbtnMenorQue5;
	private JRadioButton rdbtnMaiorQue60;
	private JLabel lblVlrDesconto;
	private JLabel lblVlrIngresso;
	private JLabel lblTotalPgr;
	private static double[] ValorObra;
	private double Desconto;
	private ButtonGroup tipoSelecao;
	private ButtonGroup gratuidade;
	private static VendaIngressosControl controllerIngressos;
	private int escolhaObra;
	private static VendaIngressosEntity DadosIngressos;
	private JComboBox comboBox;
	private static CarregaDados dados;
	private static int capacidade;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// try {
		new VendaIngressoBoundary();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// });
	}

	/**
	 * Create the frame.
	 */
	public VendaIngressoBoundary() {

		controllerIngressos = new VendaIngressosControl();
		DadosIngressos = new VendaIngressosEntity();
		capacidade = 5;
		dados = new CarregaDados(capacidade);
		ValorObra = new double[capacidade + 1];

		dados.adiciona("Picasso", 10.0);
		dados.adiciona("Ron Mueck", 50);
		dados.adiciona("Milor", 30);
		dados.adiciona("Monzart", 120);

		// frame.setTitle("Venda de Ingressos");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 564, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblData = new JLabel("Data: ");
		lblData.setBounds(392, 11, 39, 14);
		contentPane.add(lblData);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date date = new Date();
		String data = dateFormat.format(date);
		contentPane.setLayout(null);

		JLabel lbldataAtual = new JLabel(data);
		lbldataAtual.setBounds(440, 11, 83, 14);
		contentPane.add(lbldataAtual);

		comboBox = new JComboBox();
		comboBox.setBounds(222, 35, 299, 20);
		contentPane.add(comboBox);
		comboBox.addItem("");
		CarregaVetor();

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escolhaObra = comboBox.getSelectedIndex();

				if (escolhaObra != 0) {
					habilitaTudo();

				} else {
					ValorObra[escolhaObra] = 0;
					DesabilitaTudo();
					lblVlrDesconto.setText("R$ 0.0");
				}
				lblTotalPgr.setText("R$ " + ValorObra[escolhaObra]);
				// System.out.println(ValorObra[escolhaObra]);
				lblVlrIngresso.setText("R$ " + ValorObra[escolhaObra]);

			}
		});

		JLabel lblObra = new JLabel("Obras em exposi\u00E7\u00E3o:");
		lblObra.setBounds(26, 38, 186, 14);
		contentPane.add(lblObra);

		JLabel lblTipoDeVisitante = new JLabel("Tipo de Visitante:");
		lblTipoDeVisitante.setBounds(26, 153, 186, 14);
		contentPane.add(lblTipoDeVisitante);

		tipoSelecao = new ButtonGroup();
		rdbtnEstudante = new JRadioButton("Estudante");
		rdbtnEstudante.setBounds(218, 149, 97, 23);
		contentPane.add(rdbtnEstudante);

		rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setBounds(315, 149, 109, 23);
		contentPane.add(rdbtnProfessor);

		rdbtnOutros = new JRadioButton("Outros");
		rdbtnOutros.setBounds(433, 149, 109, 23);
		contentPane.add(rdbtnOutros);
		tipoSelecao.add(rdbtnEstudante);
		tipoSelecao.add(rdbtnProfessor);
		tipoSelecao.add(rdbtnOutros);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(26, 99, 186, 14);
		contentPane.add(lblIdade);

		JLabel lblValorDoIngresso = new JLabel("Valor do Ingresso Inteiro:");
		lblValorDoIngresso.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblValorDoIngresso.setBounds(26, 225, 351, 36);
		contentPane.add(lblValorDoIngresso);

		lblVlrIngresso = new JLabel("R$ 0.0");
		lblVlrIngresso.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVlrIngresso.setBounds(348, 225, 161, 31);
		contentPane.add(lblVlrIngresso);

		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDesconto.setBounds(26, 260, 351, 36);
		contentPane.add(lblDesconto);

		lblTotalApagar = new JLabel("Total a Pagar");
		lblTotalApagar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalApagar.setBounds(26, 296, 351, 36);
		contentPane.add(lblTotalApagar);

		lblVlrDesconto = new JLabel("R$ 0.0");
		lblVlrDesconto.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVlrDesconto.setBounds(348, 261, 161, 31);
		contentPane.add(lblVlrDesconto);

		lblTotalPgr = new JLabel("R$ 0.0");
		lblTotalPgr.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTotalPgr.setBounds(348, 297, 161, 31);
		contentPane.add(lblTotalPgr);

		JButton btnAjustarDescontos = new JButton("Ajustar Descontos");
		btnAjustarDescontos.setBounds(10, 367, 155, 23);
		contentPane.add(btnAjustarDescontos);

		JButton btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFinalizarVenda.setBounds(376, 367, 147, 23);
		contentPane.add(btnFinalizarVenda);

		rdbtnMenorQue5 = new JRadioButton("Menor que 5 anos");
		rdbtnMenorQue5.setBounds(222, 95, 155, 23);
		contentPane.add(rdbtnMenorQue5);

		rdbtnMaiorQue60 = new JRadioButton("Maior que 60 anos");
		rdbtnMaiorQue60.setBounds(387, 95, 136, 23);
		contentPane.add(rdbtnMaiorQue60);

		frame.setVisible(true);

		rdbtnMaiorQue60.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DesabilitaTipo();
				Desconto = ValorObra[escolhaObra];
				AtualizaValores();
			}
		});

		rdbtnMenorQue5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DesabilitaTipo();
				Desconto = ValorObra[escolhaObra];
				AtualizaValores();

			}
		});

		rdbtnEstudante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Desconto = controllerIngressos.CalculaMeiaEntrada(ValorObra[escolhaObra]);
				AtualizaValores();

			}
		});
		rdbtnProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Desconto = controllerIngressos.CalculaMeiaEntrada(ValorObra[escolhaObra]);
				AtualizaValores();

			}
		});
		rdbtnOutros.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Desconto = 0.0;
				lblVlrDesconto.setText("R$ " + Desconto);

				lblTotalPgr.setText("R$ " + ValorObra[escolhaObra]);

			}
		});
		gratuidade = new ButtonGroup();
		gratuidade.add(rdbtnMenorQue5);
		gratuidade.add(rdbtnMaiorQue60);

		JButton btnNovaVenda = new JButton("Nova Venda");
		btnNovaVenda.setBounds(217, 367, 119, 23);
		contentPane.add(btnNovaVenda);

		ActionListener iniciaNovaVenda = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NovaVenda();
			}
		};
		btnNovaVenda.addActionListener(iniciaNovaVenda);

		DesabilitaTudo();

		ActionListener FinalizaVenda = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FinalizarVenda();
				exibeMsgVendaFinalizada();
				NovaVenda();

			}

		};
		btnFinalizarVenda.addActionListener(FinalizaVenda);

	}

	private void FinalizarVenda() {

		if (escolhaObra == 0) {
			JOptionPane.showMessageDialog(null, "É necessário escolher a Obra para prosseguir");
		} else {

			controllerIngressos.tipoVisitante(rdbtnEstudante, rdbtnProfessor, rdbtnOutros);
			controllerIngressos.Gratuidade(rdbtnMenorQue5, rdbtnMaiorQue60);
		}

	}

	public void DesabilitaTudo() {

		rdbtnEstudante.setEnabled(false);
		rdbtnProfessor.setEnabled(false);
		rdbtnOutros.setEnabled(false);
		rdbtnMenorQue5.setEnabled(false);
		rdbtnMaiorQue60.setEnabled(false);

	}

	public void habilitaTudo() {
		rdbtnEstudante.setEnabled(true);
		rdbtnProfessor.setEnabled(true);
		rdbtnOutros.setEnabled(true);
		rdbtnMaiorQue60.setEnabled(true);
		rdbtnMenorQue5.setEnabled(true);

		tipoSelecao.clearSelection();
		gratuidade.clearSelection();
		lblVlrDesconto.setText("R$ " + 0.0);

	}

	public void DesabilitaTipo() {
		rdbtnEstudante.setEnabled(false);
		rdbtnProfessor.setEnabled(false);
		rdbtnOutros.setEnabled(false);
	}

	public void AtualizaValores() {

		double Total = ValorObra[escolhaObra] - Desconto;
		lblVlrDesconto.setText("R$ " + Desconto);
		lblTotalPgr.setText("R$ " + Total);

	}

	public void CarregaVetor() {

		for (int i = 0; i < capacidade - 1; i++) {
			String NomeObra = dados.retornaNomeObra(i);
			comboBox.addItem(NomeObra);
			ValorObra[i + 1] = dados.retornaValorObra(i);
			// System.out.println(ValorObra[i]);

		}

	}

	public void NovaVenda() {
		lblVlrIngresso.setText("R$ " + 0.0);
		lblVlrDesconto.setText("R$ " + 0.0);

		lblTotalPgr.setText("R$ " + 0.0);
		comboBox.setSelectedIndex(0);
		DesabilitaTudo();
	}

	public void exibeMsgVendaFinalizada() {
		if (escolhaObra != 0)
			JOptionPane.showMessageDialog(null, "Venda finalizada com Sucesso, Imprimindo do Ingresso");
	}
}
