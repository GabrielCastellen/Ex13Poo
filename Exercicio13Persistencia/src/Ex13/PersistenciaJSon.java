package Ex13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PersistenciaJSon implements Gravacao {

	@Override
	public boolean gravar(List<Pessoa> list) {
		try {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer = new FileWriter("json/agenda.json");
	    writer.write(gson.toJson(list));
	    writer.close();
	    return true;
		}catch (IOException e) {
			return false;
		}
	    
	}

	@Override
	public List<Pessoa> ler() {
		try {
		//GsonBuilder builder = new GsonBuilder();
	    //Gson gson = builder.create();
	    BufferedReader bufferedReader = new BufferedReader(
	    								new FileReader("json/agenda.json"));

	    Type listType = new TypeToken<ArrayList<Pessoa>>(){}.getType();

	    List<Pessoa> lista = new ArrayList<Pessoa>();
	    
	    lista = new ArrayList<Pessoa>();
	   
	    lista = new Gson().fromJson(bufferedReader, listType);
	    
	    return lista;
		}catch (IOException e) {
			return null;
		}
	}

}
