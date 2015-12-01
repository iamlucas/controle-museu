package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import infrastructure.ObraDAO;
import entity.ObraEntity;
import boundary.ObraBoundary;

public class ObraEvBtnDeletar implements ActionListener{
	private ObraBoundary TelaObra;

	public ObraEvBtnDeletar(ObraBoundary telaObra) {
		super();
		this.TelaObra = telaObra;
	}
	
	public void acao(){
		ObraEntity obraEntity = TelaObra.getObraEntity();
		ObraDAO dao = new ObraDAO();
		
		int resposta = JOptionPane.showConfirmDialog(
				null, "Tem Certeza que deseja excluir o registro?");
		if(resposta == JOptionPane.OK_OPTION){
			try{
				if(dao.delete(obraEntity.getId()) > 0){
					JOptionPane.showMessageDialog(null, 
							"Cadastro deletado com sucesso!");
							TelaObra.telaDefault();
				}else{
					JOptionPane.showMessageDialog(null, 
							"Não foi possivel deletar o cadastro");
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		acao();
	}
	
}
