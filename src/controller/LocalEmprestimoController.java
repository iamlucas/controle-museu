package controller;

import java.util.List;
import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.LocalEmprestimoEntity;
import infrastructure.LocalEmprestimoDAO;

public class LocalEmprestimoController implements TableModel {

	private List<LocalEmprestimoEntity> locais = new ArrayList<LocalEmprestimoEntity>();

	public LocalEmprestimoController() {
		this.locais = this.selecionarTodos();
	}

	public static void main(String[] args) {
		new LocalEmprestimoController().selecionarTodos();
	}

	public long adicionar(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		long id = dao.insert(local);

		return id;
	}

	public String atualizar(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		LocalEmprestimoEntity loc = dao.selectById(local.getId());
		System.out.println(local.getId());

		if (!local.getNomeLocal().equals("") && local.getNomeLocal() != null)
			loc.setNomeLocal(local.getNomeLocal());

		if (!local.getEmail().equals("") && local.getEmail() != null)
			loc.setEmail(local.getEmail());

		if (!local.getTelefone().equals("") && local.getTelefone() != null)
			loc.setTelefone(local.getTelefone());

		if (!local.getResponsavel().equals("") && local.getResponsavel() != null)
			loc.setResponsavel(local.getResponsavel());

		if (!local.getCep().equals("") && local.getCep() != null)
			loc.setCep(local.getCep());

		if (!local.getTipoLogradouro().equals("") && local.getTipoLogradouro() != null)
			loc.setTipoLogradouro(local.getTipoLogradouro());

		if (!local.getLogradouro().equals("") && local.getLogradouro() != null)
			loc.setLogradouro(local.getLogradouro());

		if (!local.getNomeLocal().equals("") && local.getNomeLocal() != null)
			loc.setBairro(local.getBairro());

		if (!local.getCidade().equals("") && local.getCidade() != null)
			loc.setCidade(local.getCidade());

		if (!local.getUf().equals("") && local.getUf() != null)
			loc.setUf(local.getUf());

		loc.setAtivo(local.isAtivo());

		int rowsAffected = dao.update(loc);

		String msg = "Falha na alteração do registro.";
		if (rowsAffected == 1) {
			msg = "Registro alterado com sucesso!";
		}

		return msg;
	}

	public String deletar(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();
		int rowsAffected = 0;
		if (local.getId() > 0)
			rowsAffected = dao.delete(local.getId());

		String msg = "Falha na exclusão do registro.";
		if (rowsAffected == 1) {
			msg = "Registro excluído com sucesso!";
		}

		return msg;
	}

	public LocalEmprestimoEntity selecionarPorId(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		if (local.getId() > 0)
			local = dao.selectById(local.getId());

		return local;
	}

	public List<LocalEmprestimoEntity> selecionarPorNome(LocalEmprestimoEntity local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		return dao.selectByName(local.getNomeLocal());

	}

	public List<LocalEmprestimoEntity> selecionarTodos() {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		return dao.selectAll();

	}

	public List<LocalEmprestimoEntity> getLocais() {
		return locais;
	}

	public void setLocais(List<LocalEmprestimoEntity> locais) {
		this.locais = locais;
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
		return 4;
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
