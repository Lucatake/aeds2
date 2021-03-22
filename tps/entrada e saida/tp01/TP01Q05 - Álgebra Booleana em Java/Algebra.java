class Algebra {
  
   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static boolean algebraBool (String s){
      boolean resp = false;
      int numVariaveis = (int)s.charAt(0);
      int v[] = new int[numVariaveis];
      int j = 0;
      String[] eq = new String[1000];

      for(int i = 2; i <= numVariaveis*2; i+=2){
        v[j] = (int)s.charAt(i);
        j++;
      }

      for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) == "n" && s.charAt(i+1) == "o" && s.charAt(i+2) == "t"){

        } else if(s.charAt(i) == "a" && s.charAt(i+1) == "n" && s.charAt(i+2) == "d"){

        } else if(s.charAt(i) == "o" && s.charAt(i+1) == "r"){
          
        }
      }

      return resp;
   }

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida boleana resultado da algebra.
      for(int i = 0; i < numEntrada; i++){
         MyIO.println(algebraBool(entrada[i]));
      }
   }
}