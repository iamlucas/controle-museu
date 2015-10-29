package infrastructure;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.ObraEntity;

public class ObraDAO {

	public long insert(ObraEntity obra) {
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `obra` (`obra_nome`, `obra_autor`, `obra_data`, `obra_biografia`, `obra_tipo`, `obra_categoria`, `obra_localizacao`, `obra_disponibilidade`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, obra.getNomeObra());
			stmt.setString(2, obra.getNomeAutor());
			stmt.setDate(3, new Date(obra.getDataObra().getTime()));
			stmt.setString(4, obra.getBiografia());
			stmt.setString(5, obra.getTipoObra());
			stmt.setString(6, obra.getCategoriaObra());
			stmt.setString(7, obra.getLocalizacaoObra());
			stmt.setBoolean(8, obra.isDisponivel());

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

	public int update(ObraEntity obra) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `obra` SET `obra_nome`=?, `obra_autor`=?,  `obra_data`=?, `obra_biografia`=?, `obra_tipo`=?, `obra_categoria`=?, `obra_localizacao`=?, `obra_disponibilidade`=? WHERE  `obra_id`=?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, obra.getNomeObra());
			stmt.setString(2, obra.getNomeAutor());
			stmt.setDate(3, new Date(obra.getDataObra().getTime()));
			stmt.setString(4, obra.getBiografia());
			stmt.setString(5, obra.getTipoObra());
			stmt.setString(6, obra.getCategoriaObra());
			stmt.setString(7, obra.getLocalizacaoObra());
			stmt.setBoolean(8, obra.isDisponivel());

			stmt.setLong(9, obra.getId());

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

			String query = "DELETE FROM obra WHERE obra_id = ?;";

			PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}

	public ObraEntity selectById(long id) {
		ObraEntity obra = new ObraEntity();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM obra WHERE obra_id = ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				obra.setId(rs.getLong("obra_id"));
				obra.setNomeObra(rs.getString("obra_nome"));
				obra.setNomeAutor(rs.getString("obra_autor"));
				obra.setDataObra((java.util.Date) rs.getDate("obra_data"));
				obra.setBiografia(rs.getString("obra_biografia"));
				obra.setTipoObra(rs.getString("obra_tipo"));
				obra.setCategoriaObra(rs.getString("obra_categoria"));
				obra.setLocalizacaoObra(rs.getString("obra_localizacao"));
				obra.setDisponivel(rs.getBoolean("obra_disponibilidade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obra;
	}

	public List<ObraEntity> selectByName(String name) {
		List<ObraEntity> locais = new ArrayList<ObraEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM obra WHERE obra_nome LIKE ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ObraEntity obra = new ObraEntity();
				obra.setId(rs.getLong("obra_id"));
				obra.setNomeObra(rs.getString("obra_nome"));
				obra.setNomeAutor(rs.getString("obra_autor"));
				obra.setDataObra((java.util.Date) rs.getDate("obra_data"));
				obra.setBiografia(rs.getString("obra_biografia"));
				obra.setTipoObra(rs.getString("obra_tipo"));
				obra.setCategoriaObra(rs.getString("obra_categoria"));
				obra.setLocalizacaoObra(rs.getString("obra_localizacao"));
				obra.setDisponivel(rs.getBoolean("obra_disponibilidade"));
				locais.add(obra);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}

	public List<ObraEntity> selectByAutor(String name) {
		List<ObraEntity> locais = new ArrayList<ObraEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM obra WHERE obra_autor LIKE ?;";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ObraEntity obra = new ObraEntity();
				obra.setId(rs.getLong("obra_id"));
				obra.setNomeObra(rs.getString("obra_nome"));
				obra.setNomeAutor(rs.getString("obra_autor"));
				obra.setDataObra((java.util.Date) rs.getDate("obra_data"));
				obra.setBiografia(rs.getString("obra_biografia"));
				obra.setTipoObra(rs.getString("obra_tipo"));
				obra.setCategoriaObra(rs.getString("obra_categoria"));
				obra.setLocalizacaoObra(rs.getString("obra_localizacao"));
				obra.setDisponivel(rs.getBoolean("obra_disponibilidade"));
				locais.add(obra);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}

	public List<ObraEntity> selectAll() {
		List<ObraEntity> locais = new ArrayList<ObraEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM obra;";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ObraEntity obra = new ObraEntity();
				obra.setId(rs.getLong("obra_id"));
				obra.setNomeObra(rs.getString("obra_nome"));
				obra.setNomeAutor(rs.getString("obra_autor"));
				obra.setDataObra((java.util.Date) rs.getDate("obra_data"));
				obra.setBiografia(rs.getString("obra_biografia"));
				obra.setTipoObra(rs.getString("obra_tipo"));
				obra.setCategoriaObra(rs.getString("obra_categoria"));
				obra.setLocalizacaoObra(rs.getString("obra_localizacao"));
				obra.setDisponivel(rs.getBoolean("obra_disponibilidade"));

				locais.add(obra);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return locais;
	}
}