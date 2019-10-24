package Ex13;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class PersistenciaCSV implements Gravacao{
	
	public boolean gravar(List<Pessoa> list) {
		try {
		//Scanner ler = new Scanner(System.in);
		FileWriter arq = new FileWriter("csv/agenda.csv");
		PrintWriter gravarArq = new PrintWriter(arq);
		for (Pessoa pessoa : list) {
			gravarArq.printf("%d;%s;%s;%d;%d\n",pessoa.getCodigo(),pessoa.getNome(),pessoa.getEmail(),pessoa.getTelefone(),pessoa.getDatanascimento().getTime());
		}
		arq.close();
		return true;
		}catch (IOException e) {
			return false;
		}
	}
	
	public List<Pessoa> ler(){
		List <Pessoa> lista = new ArrayList <Pessoa>();
		Pessoa p = new Pessoa();
		try {
			FileReader arq1 = new FileReader("csv/agenda.csv");
			BufferedReader lerArq = new BufferedReader(arq1);
			String linha = lerArq.readLine();
			lista = new ArrayList <Pessoa>();
			while (linha != null) {
				String [] leitura = linha.split(";");
				p = new Pessoa ();
				p.setCodigo(Integer.parseInt(leitura[0]));
				p.setNome(leitura[1]);
				p.setEmail(leitura[2]);
				p.setTelefone(Long.parseLong(leitura[3]));
				Date d = new Date(Long.parseLong(leitura[4]));
				p.setDatanascimento(d);
				lista.add(p);
				linha = lerArq.readLine ();
			}
			arq1.close();
			return lista;
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo : %s.\n" , e.getMessage());
			return null;
		}
	}
}