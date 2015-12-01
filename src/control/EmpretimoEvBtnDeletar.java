package control;

import infrastructure.EmprestimoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import boundary.EmprestimoBoundary;
import entity.EmprestimoEntity;

public class EmpretimoEvBtnDeletar implements ActionListener{

	private EmprestimoBoundary emprestimo;
	private JTable tabela;
	
	
	public EmpretimoEvBtnDeletar(EmprestimoBoundary emprestimo
			,JTable tabela) {
		super();
		this.emprestimo = emprestimo;
		this.tabela = tabela;
	}
	
	public void deletar(){
		try{
			int resposta = JOptionPane.showConfirmDialog(
					this.emprestimo, 
					"Tem certeza que deseja excluir o registro?");
					
			if (resposta == JOptionPane.OK_OPTION){
			EmprestimoDAO dao = new EmprestimoDAO();
			
			EmprestimoEntity empEntity = new EmprestimoEntity();
			empEntity = this.emprestimo.getEmprestimoEntity();
									
			dao.delete(empEntity.getEmprestimo_id());
			
			EmprestimoEvTabela evtabela = new EmprestimoEvTabela(tabela);
			evtabela.SelectAll();
			this.emprestimo.TelaDefault();
			}
		}catch(Exception e ){
			JOptionPane.showMessageDialog(this.emprestimo, e);
		}
		
	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.deletar();
	}

}
