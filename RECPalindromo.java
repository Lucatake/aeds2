class RECPalindromo{
   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static boolean isPalindromo (String s){
     return isPalindromo(s, 0);
   }

   public static boolean isPalindromo (String s, int i){
      boolean isP = false;

      if(s.charAt(i) == s.charAt((s.length()-1)-i) && i < s.length()){
        isP = true;
        isP = isPalindromo(s, i+1);
      } else{
        isP = false;
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
        if(isPalindromo(entrada[i])){
          MyIO.println("SIM");
        } else {
          MyIO.println("NAO");
        }
      }
   }
}
