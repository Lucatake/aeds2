import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

class ListaMusica {
  private Musica[] musicas;
  private int n;

  //Construtor vazio
  public ListaMusica() {
    this(80);
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
      return musicas[n-1];     
    return null;
  }

  //Remover musica na posicao p
  public Musica remover(int posicao) {
    if (n > 0 && posicao >= 0 && posicao <= n) {
      Musica musica = musicas[posicao];
      n--;

      for(int i = n; i > posicao; i--)
        musicas[i]= musicas[i+1];
        
      return musica;      
    }
    return null;
  }

  //Mostrar lista de musicas
  public void mostrar( ) {
    int quat = 0;
    for(int i = 0; i < n; i++)
    MyIO.println("[" + quat + "] " + musicas[i]);
  }


}

public class TP03Q1 {

  public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

	public static Musica procura(String id) throws Exception {
    Musica music = new Musica();
		FileReader arquivo = new FileReader("./tmp/data.csv");
		BufferedReader ler = new BufferedReader(arquivo);
		String linha = ler.readLine();
		linha = ler.readLine();
		int i = 0;
		while (linha != null && musica.getId() != id) {
			music = linha;
			linha = ler.readLine();
			i++;
		}
		arquivo.close();
		return music;
	}


  
  public static void main (String[] args) {
      String[] cdM = new String();
      int q = 0;
      ListaMusica ms = new ListaMusica();

      //Leitura da entrada padrao (codigos das musicas)
      do {
         cdM[q] = MyIO.readLine();
      } while (isFim(lm[q++]) == false);

      //Ler musicas nos arquivos e criar lista (inserir elementos fim)
      for(int i = 0; i < q; i++){
        ms.inserirFim(procura(cdM[i]).toString());
      }

      musicas.mostrar();

  }


}