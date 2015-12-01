package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import infrastructure.ObraDAO;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import boundary.ObraBoundary;
import boundary.ObraPesquisaObraBoundary;

import com.toedter.calendar.JDateChooser;

import entity.ObraEntity;

public class ObraPesquisaObraEvTabela implements MouseListener{
	private ObraBoundary TelaObra;
	private ObraPesquisaObraBoundary TelaPesquisa;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JCheckBoxMenuItem checkDisponivel;
	private JTextArea txtrBiografia;
	private JComboBox comboTipoObra;
	private JComboBox comboCategoriaObra;
	private JComboBox comboLocalizacaoObra;
	private JDateChooser DataObra;
	private JTable tabela;
	

	
	public ObraPesquisaObraEvTabela(ObraBoundary telaObra,
			ObraPesquisaObraBoundary telaPesquisa, JTextField txtNomeObra,
			JTextField txtNomeAutor, JCheckBoxMenuItem checkDisponivel,
			JTextArea txtrBiografia, JComboBox comboTipoObra,
			JComboBox comboCategoriaObra, JComboBox comboLocalizacaoObra,
			JDateChooser dataObra, JTable tabela) {
		super();
		this.TelaObra = telaObra;
		this.TelaPesquisa = telaPesquisa;
		this.txtNomeObra = txtNomeObra;
		this.txtNomeAutor = txtNomeAutor;
		this.checkDisponivel = checkDisponivel;
		this.txtrBiografia = txtrBiografia;
		this.comboTipoObra = comboTipoObra;
		this.comboCategoriaObra = comboCategoriaObra;
		this.comboLocalizacaoObra = comboLocalizacaoObra;
		this.DataObra = dataObra;
		this.tabela = tabela;
	}



	public void acao(){
		int linha = tabela.getSelectedRow();
		long id =  (Long) tabela.getValueAt(linha, 0);
		
		ObraEntity obra = new ObraEntity();
		ObraDAO dao = new ObraDAO();
		
		obra = dao.selectById(id);
		
		txtNomeObra.setText(obra.getNomeObra());
		txtNomeAutor.setText(obra.getNomeAutor());
		checkDisponivel.setSelected(obra.isDisponivel());
		txtrBiografia.setText(obra.getBiografia());
		comboTipoObra.setSelectedItem(obra.getTipoObra());
		comboCategoriaObra.setSelectedItem(obra.getCategoriaObra());
		comboLocalizacaoObra.setSelectedItem(obra.getLocalizacaoObra());
		DataObra.setDate(obra.getDataObra());
		
		TelaObra.setObraEntity(obra);
		TelaPesquisa.dispose();
	}



	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.acao();
		TelaObra.telaAlterar();
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
