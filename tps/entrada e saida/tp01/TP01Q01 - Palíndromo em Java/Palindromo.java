class Palindromo {

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static String invertida (String invert, String s){
     for (int i = (s.length()-1); i >= 0; i--) {
        invert = invert + s.charAt(i);
     }
     
     return invert;
   }

   public static String isPalindromo (String s){
      String invert = new String();
      String isP = "SIM";
      
      invert = invertida("", s);
 
      for (int i = 0; i < s.length(); i++) {
        if(invert.charAt(i) == s.charAt(i) && isP == "SIM")
        {
          isP = "SIM";
        } else {
          isP = "NAO";
        }
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