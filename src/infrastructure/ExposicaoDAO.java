package infrastructure;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.EmprestimoEntity;
import entity.ExposicaoEntity;

public class ExposicaoDAO {
	public long insert(ExposicaoEntity exposicao) throws SQLException{
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `asgardprint01`.`exposicao` "
					+ "(`exposicao_nome`,"
					+ " `exposicao_valor`, "
					+ "`exposicao_dataInicio`,"
					+ " `exposicao_dataFim`) "
					+ "VALUES (?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, exposicao.getExposicao_nome());
			stmt.setDouble(2, exposicao.getValor());
			stmt.setDate(3, new Date(exposicao.getDataInicio().getTime()));
			stmt.setDate(4, new Date(exposicao.getDataFim().getTime()));			
			
			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();
			idGerado = r.getLong(1);

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idGerado;
	}
	public int update(ExposicaoEntity exposicao) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `asgardprint01`.`exposicao` "
					+ "SET `exposicao_nome`=?,"
					+ " `exposicao_valor`=?,"
					+ " `exposicao_dataInicio`=?,"
					+ " `exposicao_dataFim`=?"
					+ " WHERE  `exposicao_id`=?;";
								
			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, exposicao.getExposicao_nome());
			stmt.setDouble(2, exposicao.getValor());
			stmt.setDate(3, new Date(exposicao.getDataInicio().getTime()));
			stmt.setDate(4, new Date(exposicao.getDataFim().getTime()));
			stmt.setLong(4, exposicao.getExposicao_id());

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	public int delete(long id) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "DELETE FROM `exposicao` WHERE `exposicao_id`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	public ExposicaoEntity selectById(long id) {
		ExposicaoEntity exposicao = new ExposicaoEntity();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM exposicao WHERE exposicao_id = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				exposicao.setExposicao_id(rs.getInt("exposicao_id"));
				exposicao.setExposicao_nome(rs.getString("exposicao_nome"));
				exposicao.setValor(rs.getDouble("exposicao_valor"));
				exposicao.setDataInicio(rs.getDate("exposicao_dataInicio"));
				exposicao.setDataFim(rs.getDate("exposicao_dataFim"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exposicao;
	}
	
	public List<ExposicaoEntity> selectByName(String name) {
		ExposicaoEntity exposicao = new ExposicaoEntity();
		List<ExposicaoEntity> exposicoes = new ArrayList<ExposicaoEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM exposicao WHERE exposicao_nome LIKE ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, name);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				exposicao.setExposicao_id(rs.getInt("exposicao_id"));
				exposicao.setExposicao_nome(rs.getString("exposicao_nome"));
				exposicao.setValor(rs.getDouble("exposicao_valor"));
				exposicao.setDataInicio(rs.getDate("exposicao_dataInicio"));
				exposicao.setDataFim(rs.getDate("exposicao_dataFim"));

				exposicoes.add(exposicao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exposicoes;
	}
	
	public List<ExposicaoEntity> selectAll() {
		ExposicaoEntity exposicao = new ExposicaoEntity();
		List<ExposicaoEntity> exposicoes = new ArrayList<ExposicaoEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM exposicao";
			PreparedStatement stmt = con.prepareStatement(query);			

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				exposicao.setExposicao_id(rs.getInt("exposicao_id"));
				exposicao.setExposicao_nome(rs.getString("exposicao_nome"));
				exposicao.setValor(rs.getDouble("exposicao_valor"));
				exposicao.setDataInicio(rs.getDate("exposicao_dataInicio"));
				exposicao.setDataFim(rs.getDate("exposicao_dataFim"));

				exposicoes.add(exposicao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exposicoes;
	}
	
	
}
