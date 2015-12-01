package infrastructure;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.EmprestimoEntity;

public class EmprestimoDAO {

	public long insert(EmprestimoEntity local) throws SQLException{
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `emprestimo` (`emprestimo_id`, `obra_id`, `local_emprestimo_id`, `emprestimo_sysdata`, `obra_nome`, `emprestimo_locatario`, `emprestimo_data_saida`, `emprestimo_previsao_devolucao`, `emprestimo_data_devolucao`,`emprestimo_devolvido`) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, local.getEmprestimo_id());
			stmt.setLong(2, local.getObra_id());
			stmt.setLong(3, local.getLocal_emprestimo_id());
			stmt.setDate(4, new Date(local.getData().getTime()));
			stmt.setString(5, local.getNomedaObra());
			stmt.setString(6, local.getLocatario());
			stmt.setDate(7, new Date(local.getDataSaida().getTime()));
			stmt.setDate(8, new Date(local.getPrevisaoDevolucao().getTime()));
			stmt.setDate(9, null);			
			stmt.setString(10, local.getDevolvido());
			
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

	public int update(EmprestimoEntity local) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `emprestimo` SET"
					+ " `emprestimo_id`=?, `obra_id`=?, `local_emprestimo_id`=?,"
					+ " `emprestimo_sysdata`=?, `obra_nome`=?,"
					+ " `emprestimo_locatario`=?,"
					+ " `emprestimo_data_saida`=?,"
					+ " `emprestimo_previsao_devolucao`=?,"					
					+ " `emprestimo_devolvido`=? WHERE  `emprestimo_id`=?;";
								
			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, local.getEmprestimo_id());
			stmt.setLong(2, local.getObra_id());
			stmt.setLong(3, local.getLocal_emprestimo_id());
			stmt.setDate(4, new Date(new java.util.Date().getTime()));
			stmt.setString(5, local.getNomedaObra());
			stmt.setString(6, local.getLocatario());
			stmt.setDate(7, new Date(local.getDataSaida().getTime()));
			stmt.setDate(8, new Date(local.getPrevisaoDevolucao().getTime()));			
			stmt.setString(9, local.getDevolvido());
			stmt.setLong(10, local.getEmprestimo_id());
			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	public int updateDevolvido(EmprestimoEntity local) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `emprestimo` SET"					
					+ " `emprestimo_data_devolucao`=?,"					
					+ " `emprestimo_devolvido`=? WHERE  `emprestimo_id`=?;";
								
			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setDate(1, new Date(local.getDataDevolucao().getTime()));						
			stmt.setString(2, local.getDevolvido());
			stmt.setLong(3, local.getEmprestimo_id());
			affectedRows = stmt.executeUpdate();

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

			String query = "DELETE FROM `emprestimo` WHERE `emprestimo_id`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public EmprestimoEntity selectById(long id) {
		EmprestimoEntity local = new EmprestimoEntity();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM emprestimo WHERE emprestimo_id = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				local.setEmprestimo_id(rs.getInt("emprestimo_id"));
				local.setObra_id(rs.getInt("obra_id"));
				local.setLocal_emprestimo_id(rs.getInt("local_emprestimo_id"));
				local.setData(rs.getDate("emprestimo_sysdata"));
				local.setNomedaObra(rs.getString("obra_nome"));
				local.setLocatario(rs.getString("emprestimo_locatario"));
				local.setDataSaida(rs.getDate("emprestimo_data_saida"));
				local.setPrevisaoDevolucao(rs.getDate("emprestimo_previsao_devolucao"));
				local.setData(rs.getDate("emprestimo_data_devolucao"));
				local.setDevolvido(rs.getString("emprestimo_devolvido"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return local;
	}

	public List<EmprestimoEntity> selectByName(String name) {
		List<EmprestimoEntity> locais = new ArrayList<EmprestimoEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM emprestimo WHERE emprestimo_locatario LIKE ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EmprestimoEntity local = new EmprestimoEntity();
				local.setEmprestimo_id(rs.getInt("emprestimo_id"));
				local.setObra_id(rs.getInt("obra_id"));
				local.setLocal_emprestimo_id(rs.getInt("local_emprestimo_id"));
				local.setData(rs.getDate("emprestimo_sysdata"));
				local.setNomedaObra(rs.getString("obra_nome"));
				local.setLocatario(rs.getString("emprestimo_locatario"));
				local.setDataSaida(rs.getDate("emprestimo_data_saida"));
				local.setPrevisaoDevolucao(rs.getDate("emprestimo_previsao_devolucao"));
				local.setData(rs.getDate("emprestimo_data_devolucao"));
				local.setDevolvido(rs.getString("emprestimo_devolvido"));

				locais.add(local);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}
	
	public List<EmprestimoEntity> selectByNomeDaObra(String name) {
		List<EmprestimoEntity> locais = new ArrayList<EmprestimoEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM emprestimo WHERE (obra_nome LIKE ? AND emprestimo.emprestimo_devolvido = 'Emprestado');";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EmprestimoEntity local = new EmprestimoEntity();
				local.setEmprestimo_id(rs.getInt("emprestimo_id"));
				local.setObra_id(rs.getInt("obra_id"));
				local.setLocal_emprestimo_id(rs.getInt("local_emprestimo_id"));
				local.setData(rs.getDate("emprestimo_sysdata"));
				local.setNomedaObra(rs.getString("obra_nome"));
				local.setLocatario(rs.getString("emprestimo_locatario"));
				local.setDataSaida(rs.getDate("emprestimo_data_saida"));
				local.setPrevisaoDevolucao(rs.getDate("emprestimo_previsao_devolucao"));
				local.setDataDevolucao(rs.getDate("emprestimo_data_devolucao"));
				local.setDevolvido(rs.getString("emprestimo_devolvido"));

				locais.add(local);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}
	public List<EmprestimoEntity> selectAll() {
		List<EmprestimoEntity> locais = new ArrayList<EmprestimoEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM emprestimo where "
					+ "emprestimo.emprestimo_devolvido = 'Emprestado' ORDER BY emprestimo_previsao_devolucao";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EmprestimoEntity local = new EmprestimoEntity();
				local.setEmprestimo_id(rs.getInt("emprestimo_id"));
				local.setObra_id(rs.getInt("obra_id"));
				local.setLocal_emprestimo_id(rs.getInt("local_emprestimo_id"));
				local.setData(rs.getDate("emprestimo_sysdata"));
				local.setNomedaObra(rs.getString("obra_nome"));
				local.setLocatario(rs.getString("emprestimo_locatario"));
				local.setDataSaida(rs.getDate("emprestimo_data_saida"));
				local.setPrevisaoDevolucao(rs.getDate("emprestimo_previsao_devolucao"));
				local.setDataDevolucao(rs.getDate("emprestimo_data_devolucao"));
				local.setDevolvido(rs.getString("emprestimo_devolvido"));

				locais.add(local);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}
}