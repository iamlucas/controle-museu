package control;

import entity.ObraEntity;
import infrastructure.ObraDAO;

public class ObraControl {

	public ObraControl() {
	}

	public long adicionar(ObraEntity obra) {
		ObraDAO dao = new ObraDAO();

		long id = dao.insert(obra);

		return id;
	}

	public void alterar(ObraEntity obra) {

	}

	public void emprestimo(ObraEntity obra) {

	}
}
