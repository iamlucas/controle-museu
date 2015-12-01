package control;

import infrastructure.EmprestimoDAO;
import infrastructure.ObraDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import entity.EmprestimoEntity;
import entity.ObraEntity;
import boundary.EmprestimoBoundary;

public class EmprestimoEvBtnDevolver implements ActionListener{
	private EmprestimoBoundary emprestimo;
	private JTable tabela;
	
	

	public EmprestimoEvBtnDevolver(EmprestimoBoundary emprestimo,
			JTable tabela) {
		super();
		this.emprestimo = emprestimo;
		this.tabela = tabela;
	}

	public void devolver(){
		Date data = new Date();
		ObraEntity obraentity = new ObraEntity();
		ObraDAO obraDAO = new ObraDAO();
		
		EmprestimoEntity entity = new EmprestimoEntity();
		entity = this.emprestimo.getEmprestimoEntity();
		
		obraentity.setId(entity.getObra_id());
		obraentity.setDisponivel(true);
		
		int resposta = JOptionPane.showConfirmDialog(this.emprestimo, 
				"Confirma a devolução da \nobra: '" +
		entity.getNomedaObra() + "' \nnessa data: " + 
						new Date(data.getTime()) + " ?");
		
		if (resposta == JOptionPane.OK_OPTION){
			try{
				EmprestimoDAO dao = new EmprestimoDAO();
				entity.setDevolvido("Fechado");
				entity.setDataDevolucao(data);
				dao.updateDevolvido(entity);
				obraDAO.updateDisponibilidade(obraentity);
				this.emprestimo.TelaDefault();
				EmprestimoEvTabela evtabela = new EmprestimoEvTabela(tabela);
				evtabela.SelectAll();
				JOptionPane.showMessageDialog(this.emprestimo, 
						"Obra devolvida com sucesso!\n"
						+ "Obra está novamente disponível para empréstimo ");
			}catch(Exception e){
				JOptionPane.showMessageDialog(this.emprestimo, e.getMessage());
			}
		}
							
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		devolver();
	}

}
