package entity;

import java.util.Date;

public class EmprestimoEntity {
	private Date data;
	private int obra_id;
	private int emprestimo_id;
	private int local_emprestimo_id;
	private String locatario;
	private String nomedaObra;
	private String Destinatario;
	private Date dataSaida;
	private Date previsaoDevolucao;	
	private Date dataDevolucao;	
	    

	public EmprestimoEntity() {
		super();
	}


	public Date getData() {
		return data;
	}


	public int getObra_id() {
		return obra_id;
	}


	public int getEmprestimo_id() {
		return emprestimo_id;
	}
	
	public String getLocatario() {
		return locatario;
	}


	public int getLocal_emprestimo_id() {
		return local_emprestimo_id;
	}


	public String getNomedaObra() {
		return nomedaObra;
	}


	public String getDestinatario() {
		return Destinatario;
	}


	public Date getDataSaida() {
		return dataSaida;
	}


	public Date getPrevisaoDevolucao() {
		return previsaoDevolucao;
	}


	public Date getDataDevolucao() {
		return dataDevolucao;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	public void setLocatario(String locatario) {
		this.locatario = locatario;
	}


	public void setObra_id(int obra_id) {
		this.obra_id = obra_id;
	}


	public void setEmprestimo_id(int emprestimo_id) {
		this.emprestimo_id = emprestimo_id;
	}


	public void setLocal_emprestimo_id(int local_emprestimo_id) {
		this.local_emprestimo_id = local_emprestimo_id;
	}


	public void setNomedaObra(String nomedaObra) {
		this.nomedaObra = nomedaObra;
	}


	public void setDestinatario(String destinatario) {
		Destinatario = destinatario;
	}


	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}


	public void setPrevisaoDevolucao(Date previsaoDevolucao) {
		this.previsaoDevolucao = previsaoDevolucao;
	}


	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}


	
	
	
}
