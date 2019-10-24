package Ex13;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AgendaMain {

	public static void main(String[] args) {
		
		
		//PersistenciaCSV csv = new PersistenciaCSV();
		//Persistencia pers = new Persistencia(csv);
		
		PersistenciaJSon json = new PersistenciaJSon();
		Persistencia pers = new Persistencia(json);
		
		//PersistenciaXML xml = new PersistenciaXML();
		//Persistencia pers = new Persistencia(xml);
		
		Agenda ag = new Agenda();
		
		Calendar calendario = Calendar.getInstance();
		
		Scanner entrada = new Scanner(System.in);
		
		ag.setLista(pers.ler());
		
		boolean aberto = true;
		
		
		while(aberto) {
		System.out.println("Escolha uma opção");
		System.out.println("1 - Incluir contato");
		System.out.println("2 - Alterar contato");
		System.out.println("3 - Excluir contato");
		System.out.println("4 - Consulta por nome");
		System.out.println("5 - Aniversariantes do mês");
		System.out.println("6 - Consulta por e-mail");
		
		
		int opcao = entrada.nextInt();
		String nomeConsulta;
		String emailConsulta;
		List<Pessoa> listaConsulta;
		
		switch (opcao) {
		case 1:
			Pessoa p = new Pessoa();
			System.out.print("Cod: ");
			p.setCodigo(entrada.nextInt());
			entrada.nextLine();
			System.out.print("Nome: ");
			p.setNome(entrada.nextLine());
			System.out.print("Email: ");
			p.setEmail(entrada.nextLine());
			System.out.print("Telefone: ");
			p.setTelefone(entrada.nextLong());
			entrada.nextLine();
			System.out.print("DataDeNascimento(dd/mm/aaaa h:mm:ss): ");
			p.setDatanascimento(DataUtil.StringToDate(entrada.nextLine()));
			ag.incluir(p);
			pers.gravar(ag.getLista());	
			break;
		case 2:
			System.out.print("Informe o nome: ");
			entrada.nextLine();
			nomeConsulta = entrada.nextLine();
			
			
			System.out.println("Escolha o contato a ser alterado: ");
			listaConsulta = ag.consultaPorNome(nomeConsulta);
			int ind = 1;
			for (Pessoa pessoa : listaConsulta) {
				
				System.out.printf("%d: %s \n",ind,pessoa.getNome());
				ind++;
			}
			int escolha = entrada.nextInt();
			
			Pessoa novaPessoa = new Pessoa();
			System.out.print("Cod: ");
			novaPessoa.setCodigo(entrada.nextInt());
			entrada.nextLine();
			System.out.print("Nome: ");
			novaPessoa.setNome(entrada.nextLine());
			System.out.print("Email: ");
			novaPessoa.setEmail(entrada.nextLine());
			System.out.print("Telefone: ");
			novaPessoa.setTelefone(entrada.nextLong());
			entrada.nextLine();
			System.out.print("DataDeNascimento(dd/mm/aaaa h:mm:ss): ");
			novaPessoa.setDatanascimento(DataUtil.StringToDate(entrada.nextLine()));
			
			ind = 1;
			for (Pessoa pessoa : listaConsulta) {
				if(ind == escolha) {
				ag.alterar(pessoa, novaPessoa);
				}
				ind++;
			}
			pers.gravar(ag.getLista());	
			break;
		case 3:
			System.out.print("Informe o nome: ");
			entrada.nextLine();
			nomeConsulta = entrada.nextLine();
			
			
			System.out.println("Escolha o contato a ser excluido: ");
			listaConsulta = ag.consultaPorNome(nomeConsulta);
			int indc = 1;
			for (Pessoa pessoa : listaConsulta) {
				
				System.out.printf("%d: %s \n",indc,pessoa.getNome());
				indc++;
			}
			int escolhaEx = entrada.nextInt();
			
			
			indc = 1;
			for (Pessoa pessoa : listaConsulta) {
				if(indc == escolhaEx) {
				ag.excluir(pessoa);
				}
				indc++;
			}
			pers.gravar(ag.getLista());	
			break;
		case 4:
			System.out.print("Informe o nome: ");
			entrada.nextLine();
			nomeConsulta = entrada.nextLine();
			
			listaConsulta = ag.consultaPorNome(nomeConsulta);
			
			if(listaConsulta.isEmpty())
				System.out.println("Não foram encontrados resultados.");
			else {
				for (Pessoa pessoa : listaConsulta) {
					System.out.println(pessoa);
				}
			}
			break;
		case 5:
			
			System.out.println(ag.aniversariantesDoMes(calendario.get(Calendar.MONTH)));
			break;
		case 6:
			System.out.print("Informe o email: ");
			entrada.nextLine();
			emailConsulta = entrada.nextLine();
			
			listaConsulta = ag.consultaPorEmail(emailConsulta);
			if(listaConsulta.isEmpty())
				System.out.println("Não foram encontrados resultados.");
			else {
				for (Pessoa pessoa : listaConsulta) {
					System.out.println(pessoa);
				}
			}
			break;

		default:
			aberto = false;
			break;
		}
		
		}
	entrada.close();
	}

}
