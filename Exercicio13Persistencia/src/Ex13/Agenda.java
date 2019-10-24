package Ex13;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Agenda {
	
	protected List<Pessoa> lista = new ArrayList<Pessoa>();

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
	
	public void incluir(Pessoa p) {
		lista.add(p);
	}
	
	public void alterar(Pessoa p, Pessoa novo) {
		lista.remove(p);
		lista.add(novo);
	}
	
	public void excluir(Pessoa p) {
		lista.remove(p);
	}
	
	
	
	public List<Pessoa> consultaPorNome(String nome){
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		
		for (Pessoa pessoa : lista) {
			if(pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) {
				retorno.add(pessoa);
			}
		}
		return retorno;
	}
	
	public List<Pessoa> aniversariantesDoMes(int mes){
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		
		Calendar calendario = Calendar.getInstance();
		for (Pessoa pessoa : lista) {
			calendario.setTime(pessoa.getDatanascimento());
			if(calendario.get(Calendar.MONTH)==mes) {
				retorno.add(pessoa);
			}
		}
		return retorno;
	}
	
	public List<Pessoa> consultaPorEmail(String email){
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		
		for (Pessoa pessoa : lista) {
		if(pessoa.getEmail().toLowerCase().contains("@"+email.toLowerCase()))
			retorno.add(pessoa);
		}
		
		return retorno;
	}
	

}
