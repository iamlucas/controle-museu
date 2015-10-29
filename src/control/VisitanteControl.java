package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

import entity.VisitanteEntity;
import infrastructure.VisitanteDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class VisitanteControl implements TableModel {

	// VisitanteEntity[] visitante = new VisitanteEntity[5];

	// ********** private List<Visitante> VisitanteEntity = new
	// ArrayList<Visitante>();
	// https://drive.google.com/folderview?id=0B2rY8EW7SoEUTWtJWEx6dF93TkE&usp=drive_web
	private JLabel cadVisitante;
	private JLabel cpf;
	private JTextField txt_cpf;
	private JLabel nacionalidade;
	private JRadioButton Jcb_nacionalidade_opc1;
	private JRadioButton Jcb_nacionalidade_opc2;
	private JLabel idade;
	private JTextField Jtxt_idade;
	private JLabel sexo;
	private JRadioButton sexo_fem;
	private JRadioButton sexo_masc;
	private JLabel grauInst;
	private JComboBox cbx_grauInst;
	private JLabel meioTransp;
	private JComboBox cbx_meioTransp;
	private JButton btn_salvar;
	private JButton btn_alterar;

	private EventObject event;

	private List<VisitanteEntity> visitantes = new ArrayList<VisitanteEntity>();

	public VisitanteControl() {
		// this.visitantes = this.selecionarTodos();
	}

	public static void main(String[] args) {
		new VisitanteControl().selecionarTodos();
	}

	public long adicionar(VisitanteEntity visitante) {
		VisitanteDAO dao = new VisitanteDAO();
		long id = dao.insert(visitante);

		return id;
	}

	public String atualizar(VisitanteEntity visitante) {
		VisitanteDAO dao = new VisitanteDAO();

		// VisitanteEntity vis = dao.selectById((int) visitante.getId());

		// if (visitante.getCpf() != "" && visitante.getCpf() != null)
		// vis.setCpf(visitante.getCpf());
		//
		// if (visitante.getNacionalidade() != "" &&
		// visitante.getNacionalidade() != null)
		// vis.setNacionalidade(visitante.getNacionalidade());
		//
		// if (visitante.getIdade() != 0)
		// vis.setIdade(visitante.getIdade());
		//
		// if (visitante.getSexo() != "" && visitante.getSexo() != null)
		// vis.setSexo(visitante.getSexo());
		//
		// if (visitante.getGrauInstrucao() != "" &&
		// visitante.getGrauInstrucao() != null)
		// vis.setGrauInstrucao(visitante.getGrauInstrucao());
		//
		// if (visitante.getMeioTransporte() != "" &&
		// visitante.getMeioTransporte() != null)
		// vis.setMeioTransporte(visitante.getMeioTransporte());

		int rowsAffected = dao.update(visitante);

		String msg = "Falha na alteração do registro.";
		if (rowsAffected == 1) {
			msg = "Registro alterado com sucesso!";
		}

		return msg;
	}

	public VisitanteEntity selecionarPorId(VisitanteEntity visitante) {
		VisitanteDAO dao = new VisitanteDAO();

		if (visitante.getId() > 0)
			visitante = dao.selectById((int) visitante.getId());

		return visitante;
	}

	public String deletar(VisitanteEntity visitante) {
		VisitanteDAO dao = new VisitanteDAO();
		int rowsAffected = 0;
		if (visitante.getId() > 0) {
			rowsAffected = dao.delete((int) visitante.getId());
		}

		String msg = "Falha na exclusão do registro.";
		if (rowsAffected == 1) {
			msg = "Registro excluído com sucesso!";
		}

		return msg;
	}

	public List<VisitanteEntity> selecionarTodos() {
		VisitanteDAO dao = new VisitanteDAO();

		return dao.selectAll();

	}

	public VisitanteEntity selecionarPorCpf(VisitanteEntity visitante) {
		VisitanteDAO dao = new VisitanteDAO();

		return dao.selectByCpf(visitante.getCpf()).get(0);

	}

	// **********************************************************************//
	// ************************ CRIAR EVENTOS ******************************//

	// **********************************************************************//
	// **********************************************************************//

	@Override
	public int getRowCount() {
		return this.visitantes.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "CPF";
		case 1:
			return "Nacionalidade";
		case 2:
			return "Idade";
		case 3:
			return "Sexo";
		case 4:
			return "Grau de instrução";
		case 5:
			return "Meio de Transporte";
		}
		return "";
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
		default:
			throw new IndexOutOfBoundsException("Coluna fora dos limites.");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int row, int col) {
		VisitanteEntity visitante = this.visitantes.get(row);
		switch (col) {
		case 0:
			return visitante.getCpf();
		case 1:
			return visitante.getNacionalidade();
		case 2:
			return visitante.getIdade();
		case 3:
			return visitante.getSexo();
		case 4:
			return visitante.getGrauInstrucao();
		case 5:
			return visitante.getMeioTransporte();
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

	@Override
	public void addTableModelListener(TableModelListener tl) {
	}

	@Override
	public void removeTableModelListener(TableModelListener tl) {
	}

}