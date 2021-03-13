class RECPalindromo{
   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static String isPalindromo (String s){
     return isPalindromo(s, 0, s.length()-1);
   }

   public static String isPalindromo (String s, int i, int size){
      String isP = "NAO";

      if(s.charAt(i) == s.charAt(size)){
        isP = isPalindromo(s, i+1, size-1);
        isP = "SIM";
      } else{
        isP = "NAO";
      }

      return isP;
   }

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida boleana se e' ou nao palindromo
      for(int i = 0; i < numEntrada; i++){
         MyIO.println(isPalindromo(entrada[i]));
      }
   }
}
