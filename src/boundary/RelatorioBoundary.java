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
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import control.RelatorioControl;

/**
 * @ref Leia mais em: JasperReport: Relatórios em Java com iReport
 *      http://www.devmedia.com.br/jasperreport-relatorios-em-java-com-ireport/
 *      31075#ixzz3tCGxkSP3
 * @author Rafael
 *
 */
public class RelatorioBoundary {

	private RelatorioControl ctrlRelatorio;

	public RelatorioBoundary() {
		ctrlRelatorio = new RelatorioControl();
	}

	public void relatorioFaixaEtaria() {
		try {
			File f = new File("D:\\ProjetosFatec\\controle-museu\\src\\reports\\VisitanteRelatorio.jrxml");
			// gerando o jasper design
			JasperDesign jasperDesign = JasperRunManager.loadXmlDesign("MyReport.xml");
			JasperDesign desenho = JRXmlLoader.load(f);

			// compila o relatório
			JasperReport relatorio = JasperCompileManager.compileReport(desenho);

			// executa o relatório
			Map parametros = new HashMap();
			parametros.put("Total", new Integer(10));

			JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros,
					ctrlRelatorio.dataFaixaEtaria());

			// exibe o resultado
			JasperViewer viewer = new JasperViewer(impressao, true);
			viewer.setVisible(true);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new RelatorioBoundary().relatorioFaixaEtaria();
	}

}
