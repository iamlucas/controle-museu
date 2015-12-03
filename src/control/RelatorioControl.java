package control;

import infrastructure.RelatorioDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;

public class RelatorioControl {

	public RelatorioControl() {

	}

	public JRResultSetDataSource dataFaixaEtaria() throws JRException {
		// estabelece conexão
		RelatorioDAO dao = new RelatorioDAO();

		// implementação da interface JRDataSource para DataSource ResultSet
		JRResultSetDataSource jrRS = dao.selectBarraFaixaEtaria();

		return jrRS;
	}

}
