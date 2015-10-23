package controller;

import java.util.List;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import infrastructure.LocalEmprestimoDAO;
import model.LocalEmprestimo;

public class LocalEmprestimoController implements TableModel {

	private List<LocalEmprestimo> locais = new ArrayList<LocalEmprestimo>();

	public LocalEmprestimoController() {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();

		this.locais = dao.selectAll();
	}

	public void adicionar(LocalEmprestimo local) {
		LocalEmprestimoDAO dao = new LocalEmprestimoDAO();
		
		dao.insert(local);
	}

	@Override
	public Object getValueAt(int row, int col) {
		LocalEmprestimo local = this.locais.get(row);
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
			return local.getNumLogradouro();
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
