import java.util.Random;

class Aleatorio {

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

  
   public static String alteracao(String texto, char a, char b) {
      int i = texto.length();
      String novoTexto = "";

      for (i=0; i < texto.length(); i++) {
        if(texto.charAt(i) == a){
          novoTexto = novoTexto + b;
        } else {
          novoTexto = novoTexto + texto.charAt(i);
        }
      }
 
      return novoTexto;
   }
        

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;
      Random gerador = new Random();
      gerador.setSeed(4);

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando a saida com a alteracao aleatoria.
      for(int i = 0; i < numEntrada; i++){
         char a = (char)( 'a' + (Math.abs(gerador.nextInt()) % 26));
         char b = (char)( 'a' + (Math.abs(gerador.nextInt()) % 26));
         MyIO.println(alteracao(entrada[i], a, b));
      }
   }
}
