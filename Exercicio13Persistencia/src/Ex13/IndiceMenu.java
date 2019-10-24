package Ex13;

public enum IndiceMenu {
	INCLUIR(1,"1 - Incluir contato"),
	ALTERAR(2,"2 - Alterar contato"),
	EXCLUIR(3,"3 - Excluir contato"),
	CONSULTANOME(4,"4 - Consulta por nome"),
	ANIVERSARIANTES(5,"5 - Aniversariantes do mês"),
	CONSULTAEMAIL(6,"6 - Consulta por e-mail");
	
	private final int indice;
	private final String texto;
	
	IndiceMenu(int indice,String texto){
		this.indice = indice;
		this.texto = texto;
	}
	
	public int getIndice() {
		return indice;
	}
	public String getTexto() {
		return texto;
	}
	
	
	

}
