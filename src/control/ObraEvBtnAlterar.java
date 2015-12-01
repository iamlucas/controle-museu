package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import infrastructure.ObraDAO;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import boundary.ObraBoundary;

import com.toedter.calendar.JDateChooser;

import entity.ObraEntity;

public class ObraEvBtnAlterar implements ActionListener {
	private ObraBoundary TelaObra;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JCheckBoxMenuItem checkDisponivel;
	private JTextArea txtrBiografia;
	private JComboBox comboTipoObra;
	private JComboBox comboCategoriaObra;
	private JComboBox comboLocalizacaoObra;
	private JDateChooser DataObra;
	
	public ObraEvBtnAlterar(ObraBoundary telaObra, JTextField txtNomeObra,
			JTextField txtNomeAutor, JCheckBoxMenuItem checkDisponivel,
			JTextArea txtrBiografia, JComboBox comboTipoObra,
			JComboBox comboCategoriaObra, JComboBox comboLocalizacaoObra,
			JDateChooser dataObra) {
		super();
		TelaObra = telaObra;
		this.txtNomeObra = txtNomeObra;
		this.txtNomeAutor = txtNomeAutor;
		this.checkDisponivel = checkDisponivel;
		this.txtrBiografia = txtrBiografia;
		this.comboTipoObra = comboTipoObra;
		this.comboCategoriaObra = comboCategoriaObra;
		this.comboLocalizacaoObra = comboLocalizacaoObra;
		DataObra = dataObra;
	}
	
	public void acao(){
		ObraEntity obraEntity = this.TelaObra.getObraEntity();
		ObraDAO dao = new ObraDAO();
		
		
		obraEntity.setNomeObra(txtNomeObra.getText());
		obraEntity.setNomeAutor(txtNomeAutor.getText());
		obraEntity.setDisponivel(checkDisponivel.getState());
		obraEntity.setBiografia(txtrBiografia.getText());
		obraEntity.setTipoObra(comboTipoObra.getSelectedItem().toString());
		obraEntity.setCategoriaObra(comboCategoriaObra.getSelectedItem().toString());
		obraEntity.setLocalizacaoObra(comboLocalizacaoObra.getSelectedItem().toString());
		obraEntity.setDataObra(DataObra.getDate());
		
		try{
			if(dao.update(obraEntity) > 0){
				JOptionPane.showMessageDialog(null, "Cadastro Alterado com sucesso!!");
			}else{
				JOptionPane.showMessageDialog(null, "erro ao cadastrar!!");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(TelaObra.validaCampos())
		acao();
	}
	
	
}
