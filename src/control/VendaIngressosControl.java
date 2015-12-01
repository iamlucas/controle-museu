package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import boundary.VendaIngressoBoundary;
import entity.VendaIngressosEntity;
import infrastructure.VendaIngressosDAO;

public class VendaIngressosControl {

	public List<VendaIngressosEntity> Ingressos = new ArrayList<VendaIngressosEntity>();

	public VendaIngressosControl() {

	}

	public List<VendaIngressosEntity> SelecionarTodos() {
		VendaIngressosDAO dao = new VendaIngressosDAO();
		return dao.selectAll;

	}

	public void tipoVisitante(JRadioButton estudante, JRadioButton professor, JRadioButton Outros) {
		if (estudante.isSelected()) {
			// System.out.println("Estudante Selecionado");
		} else if (professor.isSelected()) {
			// System.out.println("Professor Selecionado");
		} else {
			// System.out.println("Outros");
		}

	}

	public void Gratuidade(JRadioButton menorDe5, JRadioButton MaiorDe60) {
		if (menorDe5.isSelected()) {
			// System.out.println("Menor de 5");

		} else if (MaiorDe60.isSelected()) {
			// System.out.println("Maior de 60");
		} else {
			// System.out.println("Idade normal");
		}

	}

	public double CalculaMeiaEntrada(double n) {
		double total = n / 2;

		return total;
	}

}
