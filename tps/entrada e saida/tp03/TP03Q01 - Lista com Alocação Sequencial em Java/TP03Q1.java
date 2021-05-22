import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Musica {

	// (0)valence,(1)year,(2)acousticness,(3)artists,(4)danceability,(5)duration_ms,(6)energy,
	// (7)explicit,(8)id,(9)instrumentalness,(10)key,(11)liveness,(12)loudness,(13)mode,
	// (14)name,(15)popularity,(16)release_date,(17)speechiness,(18)tempo
	private String nome;
        private String id; // 8
	private String key; // 10
	private String artists; // 3
	private Date realease; // 16
	private double acousticness; // 2
	private double danceability; // 4
	private double energy; // 6
	private int duration; // 5
	private double instrumentalness; // 9
	private double valence; // 0
	private int popularity; // 15
	private float tempo; // 18
	private double liveness; // 11
	private double loudness; // 12
	private double speechiness; // 17
	private int year; // 1

	public Musica() {
		this.id = "";
	}

	public Musica(String[] values) throws ParseException {
		this.id = values[8]; // 8
		this.nome = values[14]; // 14
		this.key = values[10]; // 10
		this.acousticness = Double.parseDouble(values[2]); // 2
		this.danceability = Double.parseDouble(values[4]); // 4
		this.energy = Double.parseDouble(values[6]); // 6
		this.duration = Integer.parseInt(values[5]); // 5
		this.instrumentalness = Double.parseDouble(values[9]); // 9
		this.valence = Double.parseDouble(values[0]); // 0
		this.popularity = Integer.parseInt(values[15]); // 15
		this.tempo = Float.parseFloat(values[18]); // 18
		this.liveness = Double.parseDouble(values[11]); // 11
		this.loudness = Double.parseDouble(values[12]); // 12
		this.speechiness = Double.parseDouble(values[17]); // 17
		this.year = Integer.parseInt(values[1]); // 1

		String artistsString = "";
		int i = 0;
		while (i < values[3].length()) {
			if (!(values[3].charAt(i) == 39 && (values[3].charAt(i - 1) == 91 || 
					values[3].charAt(i + 1) == 93 || values[3].charAt(i + 1) == 44 || 
					values[3].charAt(i - 2) == 44))) {
				artistsString += values[3].charAt(i);
			}
			i++;
		}
		artists = artistsString; // 3 ;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		if (values[16].length() == 4) {
			realease = formato.parse(values[16] + "-01-01");
		} else if (values[16].length() == 7) {
			realease = formato.parse(values[16] + "-01");
		} else {
			realease = formato.parse(values[16]);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getArtists() {
		return artists;
	}

	public void setArtists(String artists) {
		this.artists = artists;
	}

	public Date getRealease() {
		return realease;
	}

	public void setRealease(Date realease) {
		this.realease = realease;
	}

	public double getAcousticness() {
		return acousticness;
	}

	public void setAcousticness(double acousticness) {
		this.acousticness = acousticness;
	}

	public double getDanceability() {
		return danceability;
	}

	public void setDanceability(double danceability) {
		this.danceability = danceability;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getInstrumentalness() {
		return instrumentalness;
	}

	public void setInstrumentalness(double instrumentalness) {
		this.instrumentalness = instrumentalness;
	}

	public double getValence() {
		return valence;
	}

	public void setValence(double valence) {
		this.valence = valence;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public float getTempo() {
		return tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

	public double getLiveness() {
		return liveness;
	}

	public void setLiveness(double liveness) {
		this.liveness = liveness;
	}

	public double getLoudness() {
		return loudness;
	}

	public void setLoudness(double loudness) {
		this.loudness = loudness;
	}

	public double getSpeechiness() {
		return speechiness;
	}

	public void setSpeechiness(double speechiness) {
		this.speechiness = speechiness;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	public Musica clone() {
		Musica novo = new Musica();
		novo.nome = this.nome;
		novo.id = this.id;
		novo.key = this.key;
		novo.artists = this.artists;
		novo.realease = this.realease;
		novo.acousticness = this.acousticness;
		novo.danceability = this.danceability;
		novo.energy = this.energy;
		novo.duration = this.duration;
		novo.instrumentalness = this.instrumentalness;
		novo.valence = this.valence;
		novo.popularity = this.popularity;
		novo.tempo = this.tempo;
		novo.liveness = this.liveness;
		novo.loudness = this.loudness;
		novo.speechiness = this.speechiness;
		novo.year = this.year;
		return novo;
	}

	
	public void imprimir() throws Exception {
		System.out.println(this.toString());
	}

	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return id + " ## " + artists.toString() + " ## " + nome + " ## " + sdf.format(realease) + " ## " + acousticness
				+ " ## " + danceability + " ## " + instrumentalness + " ## " + liveness + " ## " + loudness + " ## "
				+ speechiness + " ## " + energy + " ## " + duration;
	}
	
	
	// funcao que simula um construtor
	public static Musica cadastra(String dadosMusica) throws ParseException {
		String campos[] = new String[19];
		int j = 0;
		String temp = "";
		for (int i = 0; i < 19; i++) {
			temp = "";
			while (j < dadosMusica.length() && ((dadosMusica.charAt(j) != ',')
					|| !(dadosMusica.charAt(j) == ',' && dadosMusica.charAt(j + 1) != ' '))) {
				if (dadosMusica.charAt(j) != '"')
					temp += dadosMusica.charAt(j);
				j++;
			}
			j++;
			campos[i] = temp;
		}
		Musica musica = new Musica(campos);
		
		return musica;
	}
}

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
		FileReader arquivo = new FileReader("/tmp/data.csv");
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