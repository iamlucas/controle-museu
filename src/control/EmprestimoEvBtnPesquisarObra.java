package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import boundary.EmprestimoBoundary;
import boundary.EmprestimoPesquisaObraBoundary;

public class EmprestimoEvBtnPesquisarObra implements ActionListener{

		private EmprestimoBoundary emprestimo;
		private JTextField txtid;
		private JTextField txtNomeObra;
	
	
	public EmprestimoEvBtnPesquisarObra(EmprestimoBoundary emprestimo,
				JTextField txtid, JTextField txtNomeObra) {
			super();
			this.emprestimo = emprestimo;
			this.txtid = txtid;
			this.txtNomeObra = txtNomeObra;
		}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		EmprestimoPesquisaObraBoundary telapesquisaobra = new EmprestimoPesquisaObraBoundary(
				emprestimo, txtid, txtNomeObra
				);
		telapesquisaobra.setVisible(true);
		
	}

}
