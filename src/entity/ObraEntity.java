package entity;

import java.util.Date;

public class ObraEntity {
	
	private long id;
	private String nomeAutor;
	private String nomeObra;
	private Date dataObra;
	private String biografia;
	private boolean disponivel;
	private String tipoObra;
	private String categoriaObra;
	private String localizacaoObra;
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipoObra() {
		return tipoObra;
	}
	public void setTipoObra(String tipoObra) {
		this.tipoObra = tipoObra;
	}
	public String getCategoriaObra() {
		return categoriaObra;
	}
	public void setCategoriaObra(String categoriaObra) {
		this.categoriaObra = categoriaObra;
	}
	public String getLocalizacaoObra() {
		return localizacaoObra;
	}
	public void setLocalizacaoObra(String localizacaoObra) {
		this.localizacaoObra = localizacaoObra;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getNomeObra() {
		return nomeObra;
	}
	public void setNomeObra(String nomeObra) {
		this.nomeObra = nomeObra;
	}
	public Date getDataObra() {
		return dataObra;
	}
	public void setDataObra(Date dataObra) {
		this.dataObra = dataObra;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	

}
