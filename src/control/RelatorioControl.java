package control;

import infrastructure.RelatorioDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;

public class RelatorioControl {

	public RelatorioControl() {

	}

	public JRResultSetDataSource dataFaixaEtaria() throws JRException {
		// estabelece conex�o
		RelatorioDAO dao = new RelatorioDAO();

		// implementa��o da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = dao.selectBarraFaixaEtaria();

		return jrRS;
	}

	public JRResultSetDataSource dataFaixaSexo() throws JRException {
		// estabelece conex�o
		RelatorioDAO dao = new RelatorioDAO();

		// implementa��o da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = dao.selectBarraSexo();

		return jrRS;
	}

	public JRResultSetDataSource dataFaixaNacionalidade() throws JRException {
		// estabelece conex�o
		RelatorioDAO dao = new RelatorioDAO();

		// implementa��o da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = dao.selectBarraNacionalidade();

		return jrRS;
	}

	public JRResultSetDataSource dataVenda() throws JRException {
		// estabelece conex�o
		RelatorioDAO dao = new RelatorioDAO();

		// implementa��o da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = dao.selectBarraVendas();

		return jrRS;
	}

}
