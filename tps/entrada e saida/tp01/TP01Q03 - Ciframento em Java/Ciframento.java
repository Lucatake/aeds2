class Ciframento {

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

  
   public static String cifra(String texto, int chave) {
      int i = texto.length();
      String novoTexto = "";
 
      for (i=0; i < texto.length(); i++) {
        novoTexto = novoTexto + (char)(texto.charAt(i) + chave);
      }
 
      return novoTexto;
   }
        

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando a saida sendo o texto criptografado.
      for(int i = 0; i < numEntrada; i++){
         MyIO.println(cifra(entrada[i], 3));
      }
   }
}
