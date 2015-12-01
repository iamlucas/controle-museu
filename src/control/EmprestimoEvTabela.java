package control;

import infrastructure.EmprestimoDAO;
import infrastructure.ObraDAO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import boundary.EmprestimoBoundary;

import com.toedter.calendar.JDateChooser;

import entity.EmprestimoEntity;
import entity.ObraEntity;

public class EmprestimoEvTabela implements KeyListener, MouseListener{
	
	private JTextField TxtObra;
	private JTextField TxtNomeObra;
	private JTextField TxtDestinatario;
	private EmprestimoBoundary emprestimo;
	private JTable tabela;
	private JTextField TxtPesquisar;
	private JDateChooser DataSaida;
	private JDateChooser PrevisaoDevolucao;
	
	

	public EmprestimoEvTabela(JTextField txtObra, JTextField txtNomeObra,
			JTextField txtDestinatario, EmprestimoBoundary emprestimo,
			JTable tabela, JDateChooser dataSaida,
			JDateChooser previsaoDevolucao) {
		super();
		this.TxtObra = txtObra;
		this.TxtNomeObra = txtNomeObra;
		this.TxtDestinatario = txtDestinatario;
		this.emprestimo = emprestimo;
		this.tabela = tabela;
		this.DataSaida = dataSaida;
		this.PrevisaoDevolucao = previsaoDevolucao;
	}
	public EmprestimoEvTabela(JTable tabela) {
		super();
		this.tabela = tabela;
	}
	public EmprestimoEvTabela(JTextField txtPesquisar, JTable tabela) {
		super();
		this.TxtPesquisar = txtPesquisar;
		this.tabela = tabela;
	}
	
	public void AcaoDoMouse(){
		// pegando o valor do id da linha selecionada
		int linha = tabela.getSelectedRow();
		long id =  (Long) tabela.getValueAt(linha, 0);
		
		// fazendo a consulta no banco
		EmprestimoDAO dao = new EmprestimoDAO();
		EmprestimoEntity empEntity = new EmprestimoEntity(); 
		empEntity =	dao.selectById(id);
									
		this.emprestimo.setEmprestimoEntity(empEntity);
		
		
		//passando os calores da consulta para a tela

		this.TxtObra.setText("" + empEntity.getObra_id());
		this.TxtNomeObra.setText(empEntity.getNomedaObra());
		this.TxtDestinatario.setText(empEntity.getLocatario());
		this.DataSaida.setDate(empEntity.getDataSaida());
		this.PrevisaoDevolucao.setDate(empEntity.getPrevisaoDevolucao());
				
	}
	public void SelectAll(){
		EmprestimoDAO dao = new EmprestimoDAO();
		List<EmprestimoEntity> listaResultado = dao.selectAll();
		DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
		
		
		//limpando todos os registros da tabela 
		while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }															

		// adicionando as linha do array list para o defaulttablemodel
		for (EmprestimoEntity emp: listaResultado){
			Object[] linha = new Object[]{emp.getEmprestimo_id(), emp.getNomedaObra()
					, emp.getLocatario(), emp.getDataSaida(), emp.getPrevisaoDevolucao()
					, emp.getDevolvido()};
			modeloTabela.addRow(linha);
			
		}
		
		tabela.setModel(modeloTabela);
	}
	public void Selectbyobra(){
		EmprestimoDAO dao = new EmprestimoDAO();
		List<EmprestimoEntity> listaResultado = dao.selectByNomeDaObra(TxtPesquisar.getText());
		DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
		
		
		//limpando todos os registros da tabela 
		while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }															

		// adicionando as linha do array list para o defaulttablemodel
		for (EmprestimoEntity emp: listaResultado){
			Object[] linha = new Object[]{emp.getEmprestimo_id(), emp.getNomedaObra()
					, emp.getLocatario(), emp.getDataSaida(), emp.getPrevisaoDevolucao()
					, emp.getDevolvido()};
			modeloTabela.addRow(linha);
			
		}
		
		tabela.setModel(modeloTabela);
	}
	
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		this.Selectbyobra();		
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.AcaoDoMouse();
		emprestimo.TelaEmpSelecionado();
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
