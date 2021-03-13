class Is {

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static boolean allVogal (String s){
     boolean is = true;
     boolean vog = false;
     String vogais = new String();
     vogais = "aeiouAEIOUÁÉÍÓÚáéíóúÀÈÌÒÙàèìòùãõÃÕÂÊÎÔÛâêîôû";

     for (int i = 0; i < s.length(); i++) {
       int j = 0;

       do{
         if(is == true && !vog && s.charAt(i) == vogais.charAt(j)){
           vog = true;
           is = true;
         } else{
           is = false;
         }

         j++;
       } while(j<44 && !vog && is == true);
     }

     return is;
  }

   public static boolean allConsonant (String s){
     boolean is = true;
     boolean vog = false;
     String vogais = new String();
     vogais = "aeiouAEIOUÁÉÍÓÚáéíóúÀÈÌÒÙàèìòùãõÃÕÂÊÎÔÛâêîôû";

     for (int i = 0; i < s.length(); i++) {
       int j = 0;

       do{
         if(!vog && s.charAt(i) == vogais.charAt(j)){
           vog = true;
           is = false;
         } else if(vog != true){
           is = true;
         }

         j++;
       } while(j<44 && !vog && is == true);
     }

     return is;
  }

   public static boolean allInt (String s){
     boolean is = true;
     boolean nums = false;
     String num = new String();
     num = "0123456789";

     for (int i = 0; i < s.length(); i++) {
       int j = 0;

       do{
         if(is == true && !nums && s.charAt(i) == num.charAt(j)){
           nums = true;
           is = true;
         } else{
           is = false;
         }

         j++;
       } while(j<10 && !nums && is == true);
       nums = false;
     }

     return is;
  }

   public static boolean allReal (String s){
     boolean is = true;
     boolean nums = false;
     boolean point = false;
     String num = new String();
     num = "0123456789";

     for (int i = 0; i < s.length(); i++) {
       int j = 0;

       do{
         if(is == true && !nums && s.charAt(i) == num.charAt(j)){
           nums = true;
           is = true;
         } else if(s.charAt(i) =='.' && !point){
           point = true;
           is = true;
         } else{
           is = false;
         }

         j++;
       } while(j<10 && !nums && is == true);
       nums = false;
     }

     return is;
  }

   public static String isAll (String s){
      String result = new String();
      result = "";

      if(allVogal(s)){
        result = result + "SIM ";
      } else {
        result = result + "NAO ";
      }

      if(allConsonant(s)){
        result = result + "SIM ";
      } else {
        result = result + "NAO ";
      }

      if(allInt(s)){
        result = result + "SIM ";
      } else {
        result = result + "NAO ";
      }

      if(allReal(s)){
        result = result + "SIM";
      } else {
        result = result + "NAO";
      }

      return result;
   }

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida SIM e NAO dos resultados
      //X1 - vogais | X2 - consoantes | X3 - numero int | X4 - numero real
      for(int i = 0; i < numEntrada; i++){
         MyIO.println(isAll(entrada[i]));
      }
   }
}