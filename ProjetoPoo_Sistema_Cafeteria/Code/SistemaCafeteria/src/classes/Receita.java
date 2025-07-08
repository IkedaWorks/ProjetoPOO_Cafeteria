package classes;

public class Receita {
	
	private int idReceita;
	private String nomeBebida;
	private String modoPreparo;
	private String observacoes;
	
	public int getIdReceita() {
		return idReceita;
	}
	public void setIdReceita(int id) {
		this.idReceita = id;
	}
	public String getNomeBebida() {
		return nomeBebida;
	}
	public void setNomeBebida(String nomeBebida) {
		this.nomeBebida = nomeBebida;
	}
	public String getModoPreparo() {
		return modoPreparo;
	}
	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
}
