package boundary;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.RelatorioControl;
import javafx.scene.layout.Border;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ref Leia mais em: JasperReport: Relatórios em Java com iReport
 *      http://www.devmedia.com.br/jasperreport-relatorios-em-java-com-ireport/
 *      31075#ixzz3tCGxkSP3
 * @author Rafael
 *
 */
public class RelatorioBoundary implements ActionListener {

	private RelatorioControl ctrlRelatorio;

	private JFrame frame = new JFrame("Museum Management Relatórios");
	private JPanel pnlPrincipal = new JPanel();
	private JPanel pnlFiltros = new JPanel();
	private JPanel pnlJasper = new JPanel();

	private JButton btnGerar;

	private String[] tiposRelatorio = { "Vendas x Exposição", "Nacionalidade x Visitante", "Visitante x Idade",
			"Visitante x Sexo" };
	private JComboBox cmbRelatorio;

	public RelatorioBoundary() {
		ctrlRelatorio = new RelatorioControl();
		init();
	}

	public void init() {
		pnlPrincipal.setLayout(null);
		pnlFiltros.setBounds(0, 150, 1174, -147);
		pnlPrincipal.add(pnlFiltros);
		pnlFiltros.setLayout(null);
		pnlJasper.setBounds(0, 664, 1174, -457);

		pnlPrincipal.add(this.relatorioFaixaEtaria());
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(RelatorioBoundary.class.getResource("/resource/mini_logo.png")));

		frame.setContentPane(pnlPrincipal);

		JLabel label = new JLabel("");
		label.setBounds(-42, 14, 345, 122);
		label.setIcon(new ImageIcon(RelatorioBoundary.class.getResource("/resource/Logo Museu.png")));
		pnlPrincipal.add(label);

		JSeparator separator = new JSeparator();
		separator.setBounds(313, 111, 330, -5);
		pnlPrincipal.add(separator);

		JLabel lblNewLabel = new JLabel("Relat\u00F3rios");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		lblNewLabel.setBounds(321, 61, 162, 45);
		pnlPrincipal.add(lblNewLabel);

		cmbRelatorio = new JComboBox(tiposRelatorio);
		cmbRelatorio.setBounds(149, 150, 251, 31);
		pnlPrincipal.add(cmbRelatorio);

		JLabel lblTipoDeRelatrio = new JLabel("Tipo de Relat\u00F3rio");
		lblTipoDeRelatrio.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTipoDeRelatrio.setBounds(10, 150, 129, 31);
		pnlPrincipal.add(lblTipoDeRelatrio);

		btnGerar = new JButton("Gerar");
		btnGerar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnGerar.setBounds(410, 150, 110, 31);
		btnGerar.addActionListener(this);
		pnlPrincipal.add(btnGerar);

		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public JRViewer relatorioFaixaEtaria() {
		JRViewer viewer = null;
		try {
			pnlJasper.setLayout(null);
			viewer = this.criaVisualizacaoRelatorio("/reports/VendasPorExposicaoRelatorio.jrxml",
					ctrlRelatorio.dataFaixaEtaria());
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return viewer;
	}

	public JRViewer criaVisualizacaoRelatorio(String resource, JRResultSetDataSource data) {
		JRViewer viewer = null;
		try {

			URL url = RelatorioBoundary.class.getResource(resource);

			String nomePath = url.getFile();
			// gerando o jasper design
			JasperDesign desenho = JRXmlLoader.load(nomePath);

			// compila o relatório
			JasperReport relatorio = JasperCompileManager.compileReport(desenho);

			// executa o relatório
			Map parametros = new HashMap();
			parametros.put("Total", new Double(5));

			JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ctrlRelatorio.dataVenda());

			// exibe o resultado
			viewer = new JRViewer(impressao);
			viewer.setBounds(10, 204, 964, 447);
		} catch (JRException e) {
			e.printStackTrace();
		}
		return viewer;
	}

	public static void main(String[] args) {
		new RelatorioBoundary().relatorioFaixaEtaria();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String b = e.getActionCommand();

		if ("Gerar".equals(b)) {
			String tipoRelatorio = (String) cmbRelatorio.getSelectedItem();

			if ("Vendas x Exposição".equals(tipoRelatorio)) {
				JFrame rel = new JFrame("Vendas x Exposição");
				JPanel p = new JPanel();
				p.setLayout(null);
				p.add(this.relatorioFaixaEtaria());
				rel.setContentPane(p);
				rel.setLocationRelativeTo(null);
				rel.setSize(1000, 700);
				rel.setResizable(false);
				rel.setVisible(true);
			}

			else if ("Nacionalidade x Visitante".equals(tipoRelatorio))
				this.relatorioFaixaEtaria();

			else if ("Visitante x Idade".equals(tipoRelatorio))
				this.relatorioFaixaEtaria();
			else if ("Visitante x Sexo".equals(tipoRelatorio))
				this.relatorioFaixaEtaria();
		}
	}

}
