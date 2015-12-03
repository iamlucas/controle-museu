package infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRResultSetDataSource;

public class RelatorioDAO {

	public JRResultSetDataSource selectBarraFaixaEtaria() {
		JRResultSetDataSource jrr = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT COUNT(visitante_id), visitante_idade FROM visitante GROUP BY visitante_idade ASC";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			jrr = new JRResultSetDataSource(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jrr;
	}
}
