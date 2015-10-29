package infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.EmprestimoEntity;

public class EmprestimoDAO {

	public long insert(EmprestimoEntity local) {
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `emprestimo` (`emprestimo_id`, `obra_id`, `local_emprestimo_id`, `emprestimo_sysdata`, `emprestimo_locatario`, `emprestimo_data_saida`, `emprestimo_previsao_devolucao`, `emprestimo_data_devolucao`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, local.getEmprestimo_id());
			stmt.setInt(2, local.getObra_id());
			stmt.setInt(3, local.getLocal_emprestimo_id());
			stmt.setString(4, local.getData().toString());
			stmt.setString(5, local.getLocatario());
			stmt.setString(6, local.getDataSaida().toString());
			stmt.setString(7, local.getPrevisaoDevolucao().toString());
			stmt.setString(8, local.getDataDevolucao().toString());			

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

			String query = "UPDATE `emprestimo` SET `emprestimo_id`=?, `obra_id`=?, `local_emprestimo_id`=?, `emprestimo_sysdata`=?, `emprestimo_locatario`=?, `emprestimo_data_saida`=?, `emprestimo_previsao_devolucao`=?, `emprestimo_data_devolucao`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, local.getEmprestimo_id());
			stmt.setInt(2, local.getObra_id());
			stmt.setInt(3, local.getLocal_emprestimo_id());
			stmt.setString(4, local.getData().toString());
			stmt.setString(5, local.getLocatario());
			stmt.setString(6, local.getDataSaida().toString());
			stmt.setString(7, local.getPrevisaoDevolucao().toString());
			stmt.setString(8, local.getDataDevolucao().toString());	

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
				local.setLocatario(rs.getString("emprestimo_locatario"));
				local.setData(rs.getDate("emprestimo_data_saida"));
				local.setData(rs.getDate("emprestimo_previsao_devolucao"));
				local.setData(rs.getDate("emprestimo_data_devolucao"));				
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
				local.setLocatario(rs.getString("emprestimo_locatario"));
				local.setData(rs.getDate("emprestimo_data_saida"));
				local.setData(rs.getDate("emprestimo_previsao_devolucao"));
				local.setData(rs.getDate("emprestimo_data_devolucao"));			

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

			String query = "SELECT * FROM emprestimo";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EmprestimoEntity local = new EmprestimoEntity();
				local.setEmprestimo_id(rs.getInt("emprestimo_id"));
				local.setObra_id(rs.getInt("obra_id"));
				local.setLocal_emprestimo_id(rs.getInt("local_emprestimo_id"));
				local.setData(rs.getDate("emprestimo_sysdata"));
				local.setLocatario(rs.getString("emprestimo_locatario"));
				local.setData(rs.getDate("emprestimo_data_saida"));
				local.setData(rs.getDate("emprestimo_previsao_devolucao"));
				local.setData(rs.getDate("emprestimo_data_devolucao"));			

				locais.add(local);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}
}