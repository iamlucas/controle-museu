package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import boundary.ObraBoundary;
import boundary.ObraPesquisaObraBoundary;

import com.toedter.calendar.JDateChooser;

public class ObraEvbtnPesquisarObra implements ActionListener {

	private ObraBoundary Telaobra;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JCheckBoxMenuItem checkDisponivel;
	private JTextArea txtrBiografia;
	private JComboBox comboTipoObra;
	private JComboBox comboCategoriaObra;
	private JComboBox comboLocalizacaoObra;
	private JDateChooser DataObra;
	private String criterio;
	
	
	public ObraEvbtnPesquisarObra(ObraBoundary telaobra,
			JTextField txtNomeObra, JTextField txtNomeAutor,
			JCheckBoxMenuItem checkDisponivel, JTextArea txtrBiografia,
			JComboBox comboTipoObra, JComboBox comboCategoriaObra,
			JComboBox comboLocalizacaoObra, JDateChooser dataObra,
			String criterio) {
		super();
		Telaobra = telaobra;
		this.txtNomeObra = txtNomeObra;
		this.txtNomeAutor = txtNomeAutor;
		this.checkDisponivel = checkDisponivel;
		this.txtrBiografia = txtrBiografia;
		this.comboTipoObra = comboTipoObra;
		this.comboCategoriaObra = comboCategoriaObra;
		this.comboLocalizacaoObra = comboLocalizacaoObra;
		this.DataObra = dataObra;
		this.criterio = criterio;
	}

	public void acao(){
		ObraPesquisaObraBoundary TelaPesuisa =
				new ObraPesquisaObraBoundary(Telaobra,
						txtNomeObra, txtNomeAutor,
						checkDisponivel, txtrBiografia,
						comboTipoObra, comboCategoriaObra,
						comboLocalizacaoObra, DataObra, criterio);
		TelaPesuisa.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		acao();
	}

}
