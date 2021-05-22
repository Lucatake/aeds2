import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;

class ListaMusica {
  private Musica[] musicas;
  private int n;

  //Construtor vazio
  public ListaMusica() {
    this(100);
    n = 0;
  }

  //Construtor 
  // @param tamanho da lista
  public ListaMusica(int tam) {
    musicas = new Musica[tam];
    n = 0;
  }

  //Inserir musica no inicio
  public void inserirInicio(Musica musica) {
    if (n < musicas.length) {
      for(int i = n; i > 0; i--)
        musicas[i]= musicas[i-1];
      musicas[0] = musica;
      n++;      
    }
  }

  //Inserir musica no fim
  public void inserirFim(Musica musica) {
    if (n < musicas.length) {
      musicas[n] = musica;
      n++;      
    }
  }

  //Inserir musica na posicao p
  public void inserir(Musica musica, int posicao) {
    if (n < musicas.length && posicao >=0 && posicao <= n) {
      for(int i = n; i > posicao; i--)
        musicas[i]= musicas[i-1];
      musicas[posicao] = musica;
      n++;      
    }
  }


  //Remover musica no inicio
  public Musica removerInicio( ) {
    if (n > 0) {
      Musica musica = musicas[0];
      n--;
      for (int i = 0; i < n; i++) 
        musicas[i] = musicas[i+1];
        
      return musica;     
    }
    return null;
  }

  //Remover musica no fim
  public Musica removerFim( ) {
    if (n > 0) {
    	n--;
    	return musicas[n-1];  
    }
    return null;
  }

  //Remover musica na posicao p
  public Musica remover(int posicao) {
    if (n > 0 && posicao >= 0 && posicao <= n) {
      Musica musica = musicas[posicao];
      n--;

      for(int i = posicao; i <n; i++)
        musicas[i]= musicas[i+1];
        
      return musica;      
    }
    return null;
  }

  //Mostrar lista de musicas
  public void mostrar( ) {
    for(int i = 0; i < n; i++)
    	MyIO.println("[" + i + "] " + musicas[i].toString());
  }

  	public int getQuantidade() {
  		return this.n;
  	}

}

public class TP03Q1 {

  public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

	public static String procura(String id) throws Exception {
		String music = new String();
		FileReader arquivo = new FileReader("../data.csv");
		BufferedReader ler = new BufferedReader(arquivo);
		String linha = ler.readLine();
		
		while (linha != null) {
			if(linha.contains(id))
				music = linha;
			linha = ler.readLine();
		}
		arquivo.close();
		return music;
	}


  
  public static void main (String[] args) throws ParseException, Exception {
      String[] cdM = new String[80];
      int q = 0;
      ListaMusica ms = new ListaMusica();
      int quant = 0;
      String line = new String();
      String meto = new String();
      String id = new String();
      int pos = 0;
      Musica musR = new Musica();

      //Criação da Lista
      //Leitura da entrada padrao (codigos das musicas)
      do {
         cdM[q] = MyIO.readLine();
      } while (isFim(cdM[q++]) == false);

      //Ler musicas nos arquivos e criar lista (inserir elementos fim)
      for(int i = 0; i < q-1; i++)
        ms.inserirFim(Musica.cadastra(procura(cdM[i])));

      //Execução dos Métodos
      //Ler quantidade de registros inseridos/removidos
      quant = (int)MyIO.readInt();
      
      for(int i = 0; i < quant; i++) {
    	  line = MyIO.readLine();
    	  meto = line.substring(0, 2);
    	  if(meto.equals("I*")) {
    		  pos = Integer.parseInt(line.substring(3,5));
    		  id = line.substring(6);
    	  } else if (meto.equals("R*")) {
    		  pos = Integer.parseInt(line.substring(3,5));
    	  }  else if (meto.equals("RI") || meto.contains("RF")) {
    		  id = null;
    	  } else {
    		  id = line.substring(3);
    	  }
    	  
    	  switch (meto) {
	    	  case "II":
				  ms.inserirInicio(Musica.cadastra(procura(id)));
				  break;
	    	  case "I*":
	    		  ms.inserir(Musica.cadastra(procura(id)), pos);
    			  break;
	    	  case "IF":
	    		  ms.inserirFim(Musica.cadastra(procura(id)));
				  break;
	    	  case "RI":
	    		  musR = ms.removerInicio();
	    		  MyIO.println("(R) " + musR.getNome());
				  break;
	    	  case "R*":
	    		  musR = ms.remover(pos);
	    		  MyIO.println("(R) " + musR.getNome());
    			  break;
	    	  case "RF":
	    		  musR = ms.removerFim();
	    		  MyIO.println("(R) " + musR.getNome());
				  break;
    	  }
      }
      
      
      ms.mostrar();
  }


}