package control;

import infrastructure.ObraDAO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.EmprestimoEntity;
import entity.ObraEntity;
import boundary.EmprestimoBoundary;
import boundary.EmprestimoPesquisaObraBoundary;

public class EmprestimoPesquisaObraEvTabela implements MouseListener{
	private EmprestimoBoundary emprestimo;
	private EmprestimoPesquisaObraBoundary obraPesquisa;	
	private JTable tabela;
	private JTextField Txtid;
	private JTextField Txtnome;	


	public EmprestimoPesquisaObraEvTabela(EmprestimoBoundary emprestimo,
			EmprestimoPesquisaObraBoundary obraPesquisa, JTable tabela, JTextField txtid,
			JTextField txtnome) {
		super();
		this.emprestimo = emprestimo;
		this.obraPesquisa = obraPesquisa;
		this.tabela = tabela;
		Txtid = txtid;
		Txtnome = txtnome;
	}


	public EmprestimoPesquisaObraEvTabela() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void acao(){
	
		
			int linha = tabela.getSelectedRow();
			long id =  (Long) tabela.getValueAt(linha, 0);
			
			ObraEntity obra = new ObraEntity();
			ObraDAO dao = new ObraDAO();
			
			obra = dao.selectById(id);
									
			Txtid.setText("" + obra.getId());
			Txtnome.setText(obra.getNomeObra());
			
			EmprestimoEntity emprestimoEntity = new EmprestimoEntity();
			emprestimoEntity = emprestimo.getEmprestimoEntity();
			
			emprestimoEntity.setObra_id(obra.getId());
			emprestimoEntity.setNomedaObra(obra.getNomeObra());
			
			
			
			obraPesquisa.dispose();
	}


	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	/*	if ((System.currentTimeMillis() - obraPesquisa.getTimeToDoubleClick() < 350)){
*/
			this.acao();
			/*
		}
		obraPesquisa.setTimeToDoubleClick(
		System.currentTimeMillis());*/
	}


	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


