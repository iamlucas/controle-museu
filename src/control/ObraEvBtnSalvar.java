package control;

import infrastructure.ObraDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import entity.ObraEntity;
import boundary.ObraBoundary;

public class ObraEvBtnSalvar implements ActionListener{
	
	private ObraBoundary TelaObra;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JCheckBoxMenuItem checkDisponivel;
	private JTextArea txtrBiografia;
	private JComboBox comboTipoObra;
	private JComboBox comboCategoriaObra;
	private JComboBox comboLocalizacaoObra;
	private JDateChooser DataObra;
	
	public ObraEvBtnSalvar(ObraBoundary TelaObra, JTextField txtNomeObra,
			JTextField txtNomeAutor, JCheckBoxMenuItem checkDisponivel,
			JTextArea txtrBiografia, JComboBox comboTipoObra,
			JComboBox comboCategoriaObra, JComboBox comboLocalizacaoObra,
			JDateChooser dataObra) {
		super();
		this.TelaObra = TelaObra;
		this.txtNomeObra = txtNomeObra;
		this.txtNomeAutor = txtNomeAutor;
		this.checkDisponivel = checkDisponivel;
		this.txtrBiografia = txtrBiografia;
		this.comboTipoObra = comboTipoObra;
		this.comboCategoriaObra = comboCategoriaObra;
		this.comboLocalizacaoObra = comboLocalizacaoObra;
		this.DataObra = dataObra;
	}

	public void salvar(){
		ObraEntity obraEntity = new ObraEntity();
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
			if(dao.insert(obraEntity) > 0){
				JOptionPane.showMessageDialog(null, "Cadastro Salvo com sucesso!!");
				TelaObra.telaDefault();
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
		salvar();
	}

}
