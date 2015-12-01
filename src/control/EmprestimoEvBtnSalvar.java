package control;

import infrastructure.EmprestimoDAO;
import infrastructure.ObraDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import boundary.EmprestimoBoundary;

import com.toedter.calendar.JDateChooser;

import entity.EmprestimoEntity;
import entity.LocalEmprestimoEntity;
import entity.ObraEntity;

public class EmprestimoEvBtnSalvar implements ActionListener {
	private JTextField TxtObra;
	private JTextField TxtNomeObra;
	private JTextField TxtDestinatario;
	private JDateChooser DataSaida;
	private JDateChooser PrevisaoDevolucao;
	private EmprestimoBoundary emprestimo;
	private JTable tabela;
	

	
	public EmprestimoEvBtnSalvar(JTextField txtObra, JTextField txtNomeObra,
			JTextField txtDestinatario, JDateChooser dataSaida,
			JDateChooser previsaoDevolucao, 
			EmprestimoBoundary emprestimo,
			JTable tabela) {			
		this.TxtObra = txtObra;
		this.TxtNomeObra = txtNomeObra;
		this.TxtDestinatario = txtDestinatario;
		this.DataSaida = dataSaida;
		this.PrevisaoDevolucao = previsaoDevolucao;
		this.emprestimo = emprestimo;
		this.tabela = tabela;
	}

	public void acao() {
		EmprestimoDAO dao = new EmprestimoDAO();
		ObraDAO obradao = new ObraDAO();
		ObraEntity obraentity = new ObraEntity();
		EmprestimoEntity emprestimoEntity = new EmprestimoEntity();
		
		emprestimoEntity = this.emprestimo.getEmprestimoEntity();
		
		obraentity.setId(emprestimoEntity.getObra_id());
		obraentity.setDisponivel(false);		
					
		emprestimoEntity.setDataSaida(DataSaida.getDate());
		emprestimoEntity.setPrevisaoDevolucao(PrevisaoDevolucao.getDate());
		emprestimoEntity.setDevolvido("Emprestado");
		emprestimoEntity.setData(new Date());
		
		
		try {
			obradao.updateDisponibilidade(obraentity);
			dao.insert(emprestimoEntity);
			JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso!");
			
			EmprestimoEvTabela atualizaTabela = new EmprestimoEvTabela(tabela);
			atualizaTabela.SelectAll();
			
			TxtObra.setText("");
			TxtNomeObra.setText("");
			TxtDestinatario.setText("");
			DataSaida.setDate(null);
			PrevisaoDevolucao.setDate(null);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Falha ao realizar emprestimo, erro: " + e.getMessage());
		}
		
		
		
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(emprestimo.validaCampos() && emprestimo.validaData()){
		this.acao();
		emprestimo.TelaDefault();
		}			
	}
	
	
}
