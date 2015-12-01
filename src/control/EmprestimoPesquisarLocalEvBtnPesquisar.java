package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import entity.LocalEmprestimoEntity;
import boundary.EmprestimoBoundary;
import boundary.EmprestimoPesquisaLocalBoundary;

public class EmprestimoPesquisarLocalEvBtnPesquisar implements ActionListener {
	private EmprestimoBoundary telaemprestimo;
	private JTextField txtdestinatario;
	
	
	
	public EmprestimoPesquisarLocalEvBtnPesquisar(EmprestimoBoundary telaemprestimo,
			JTextField txtdestinatario) {
		super();
		this.telaemprestimo = telaemprestimo;
		this.txtdestinatario = txtdestinatario;
	}

	public void acao(){
		EmprestimoPesquisaLocalBoundary telaPesquisa = new 
				EmprestimoPesquisaLocalBoundary(telaemprestimo, txtdestinatario);
	}		

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.acao();
	}

}
