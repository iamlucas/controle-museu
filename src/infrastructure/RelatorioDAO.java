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

	public JRResultSetDataSource selectBarraSexo() {
		JRResultSetDataSource jrr = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT count(visitante_id), visitante_sexo FROM visitante GROUP BY visitante_sexo";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			jrr = new JRResultSetDataSource(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jrr;
	}

	public JRResultSetDataSource selectBarraNacionalidade() {
		JRResultSetDataSource jrr = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT count(visitante_id), visitante_nacionalidade FROM visitante GROUP BY visitante_nacionalidade";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			jrr = new JRResultSetDataSource(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jrr;
	}

	public JRResultSetDataSource selectBarraVendas() {
		JRResultSetDataSource jrr = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT " + "count(ingresso.ingresso_id), " + "ingresso.ingresso_exposicao_nome,"
					+ " SUM(ingresso.ingresso_pagar_valor)," + "exposicao.exposicao_dataInicio,"
					+ " exposicao.exposicao_dataFim," + "SUM(ingresso.ingresso_meiaentrada),"
					+ " SUM(ingresso.ingresso_gratuito)" + "FROM ingresso"
					+ " INNER JOIN exposicao ON exposicao.exposicao_id = ingresso.ingresso_exposicao_id"
					+ " GROUP BY ingresso.ingresso_exposicao_id";

			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			jrr = new JRResultSetDataSource(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jrr;
	}
}
