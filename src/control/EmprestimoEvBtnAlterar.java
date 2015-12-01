package control;

import infrastructure.EmprestimoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import boundary.EmprestimoBoundary;

import com.toedter.calendar.JDateChooser;

import entity.EmprestimoEntity;

public class EmprestimoEvBtnAlterar implements ActionListener{
	private JTextField TxtObra;
	private JTextField TxtNomeObra;
	private JTextField TxtDestinatario;
	private JDateChooser DataSaida;
	private JDateChooser PrevisaoDevolucao;
	private EmprestimoBoundary emprestimo;
	private JTable tabela;
	
	
	
	public EmprestimoEvBtnAlterar(JTextField txtObra, JTextField txtNomeObra,
			JTextField txtDestinatario, JDateChooser dataSaida,
			JDateChooser previsaoDevolucao, EmprestimoBoundary emprestimo,
			JTable tabela) {
		super();
		this.TxtObra = txtObra;
		this.TxtNomeObra = txtNomeObra;
		this.TxtDestinatario = txtDestinatario;
		this.DataSaida = dataSaida;
		this.PrevisaoDevolucao = previsaoDevolucao;
		this.emprestimo = emprestimo;
		this.tabela = tabela;
	}

	public void alterar(){
		try{
			EmprestimoDAO dao = new EmprestimoDAO();
			EmprestimoEntity Entity = emprestimo.getEmprestimoEntity();
	 
	    	Entity.setDataSaida(DataSaida.getDate());
			Entity.setPrevisaoDevolucao(PrevisaoDevolucao.getDate());
			Entity.setDevolvido("Emprestado");
			Entity.setData(new Date());
			
			
			dao.update(Entity);
			
			EmprestimoEvTabela evtabela = new EmprestimoEvTabela(tabela);
			evtabela.SelectAll();
			this.emprestimo.TelaDefault();			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this.emprestimo, "não foi possivel alterar o registro" + e.getMessage());
		}
		

		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(emprestimo.validaCampos() && emprestimo.validaData()){
		alterar();
		}		
	}

}
