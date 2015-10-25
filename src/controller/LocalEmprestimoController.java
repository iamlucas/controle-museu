package controller;

import java.util.List;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.LocalEmprestimoEntity;
import infrastructure.LocalEmprestimoDAO;

public class LocalEmprestimoController implements TableModel {

	private List<LocalEmprestimoEntity> locais = new ArrayList<LocalEmprestimoEntity>();

	public LocalEmprestimoController() {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		this.locais = dao.selectAll();
	}

	public static void main(String[] args) {
		new LocalEmprestimoController().selecionarTodos();
	}

	public void adicionar(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		local.setNomeLocal("FATEC Zona Leste");
		local.setEmail("teste@fatec.com.br");
		local.setTelefone("(11) 99999-9999");
		local.setResponsavel("Sr. Fatec");
		local.setCep("03030-100");
		local.setTipoLogradouro("Avenida");
		local.setLogradouro("Aguia de Haia");
		local.setBairro("Arthur Alvim");
		local.setCidade("São Paulo");
		local.setUf("SP");
		local.setAtivo(true);

		long id = dao.insert(local);
	}

	public void atualizar(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		local.setId(7);

		local.setNomeLocal("FATEC Zona Sul");
		local.setEmail("teste@fatec.com.br");
		local.setTelefone("(11) 99999-9999");
		local.setResponsavel("Sr. Fatec");
		local.setCep("03030-100");
		local.setTipoLogradouro("Avenida");
		local.setLogradouro("Aiuga ed Aiah");
		local.setBairro("Arthur Sulvim");
		local.setCidade("São Paulo");
		local.setUf("SP");
		local.setAtivo(true);

		int id = dao.update(local);

		System.out.println(id);
	}

	public void deletar(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		local.setId(7);

		int id = dao.delete(local.getId());

		System.out.println(id);
	}

	public void selecionarPorId(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		local.setId(6);

		LocalEmprestimoEntity loc = dao.selectById(local.getId());

		System.out.println(loc.getNomeLocal());
	}

	public void selecionarPorNome(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		local.setNomeLocal("Sul");

		List<LocalEmprestimoEntity> locs = dao.selectByName(local.getNomeLocal());

		System.out.println(locs.get(0).getNomeLocal());
	}

	public void selecionarTodos() {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		List<LocalEmprestimoEntity> locs = dao.selectAll();

		for (LocalEmprestimoEntity l : locs)
			System.out.println(l.getNomeLocal());
	}

	@Override
	public Object getValueAt(int row, int col) {
		LocalEmprestimoEntity local = this.locais.get(row);
		switch (col) {
		case 0:
			return local.getId();
		case 1:
			return local.getNomeLocal();
		case 2:
			return local.getEmail();
		case 3:
			return local.getTelefone();
		case 4:
			return local.getResponsavel();
		case 5:
			return local.getCep();
		case 6:
			return local.getTipoLogradouro();
		case 7:
			return local.getLogradouro();
		case 8:
			return local.getBairro();
		case 9:
			return local.getCidade();
		case 10:
			return local.getUf();
		case 11:
			return local.isAtivo();
		}
		return "";
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return this.locais.size();
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Codigo";
		case 1:
			return "Nome";
		case 2:
			return "Email";
		case 3:
			return "Telefone";
		case 4:
			return "Responsável";
		case 5:
			return "CEP";
		case 6:
			return "Tipo Logradouro";
		case 7:
			return "Logradouro";
		case 8:
			return "Bairro";
		case 9:
			return "Cidade";
		case 10:
			return "Uf";
		case 11:
			return "Status";
		}
		return "";
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
		case 9:
			return String.class;
		case 10:
			return String.class;
		case 11:
			return String.class;
		default:
			throw new IndexOutOfBoundsException("Coluna fora dos limites.");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}
}
