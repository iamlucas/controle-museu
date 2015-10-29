package control;

import entity.ObraEntity;
import infrastructure.ObraDAO;

public class ObraControl {

	public ObraControl() {
	}

	public void adicionar(ObraEntity obra) {
		ObraDAO dao = new ObraDAO();

		long id = dao.insert(obra);

		System.out.println("Retornou ID de inserção:" + id);
	}

	public void alterar(ObraEntity obra) {

	}

	public void emprestimo(ObraEntity obra) {

	}
}
