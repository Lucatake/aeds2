class Is {

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static boolean allVogal (String s){
    boolean result = true;
    boolean vog = false;
    String vogais = "aeiouAEIOU";
    int j = 0;

    for(i = 0; i < s.length(); i++){
      j = 0;
      vog = false;

      do{
        if(s.charAt(i) == vogais.charAt(j) && !vog){
          vog = true;
          result = true;
        } else{
          result = false;
        }
        j++;
      } while(j < 10 && !vog);
      if(!result){
        i = s.length();
      }
    }
    return result;
  }

   public static boolean allConsonant (String s){
    boolean result = true;
    boolean vog = false;
    String vogais = "aeiouAEIOU";
    String num = "0123456789";
    int j = 0;

    for(int i = 0; i < s.length(); i++){
      j = 0;
      do{
        if((s.charAt(i) != vogais.charAt(j)) && (s.charAt(i) != num.charAt(j)) && !vog && (s.charAt(i)>'a'|| s.charAt(i)>'A') && (s.charAt(i)<='z'|| s.charAt(i)<='Z')){
          result = true;
        } else {
          result = false;
          vog = true;
        }
        j++;
      } while(j < 10 && !vog);
      if(!result){
        i = s.length();
      }
    }
    return result;
  }

   public static boolean allInt (String s){
    boolean result = true;
    boolean n = false;
    String nums = "0123456789";
    int j = 0;

    for(int i = 0; i < s.length(); i++){
      j = 0;
      n = false;

      do{
        if(s.charAt(i) == nums.charAt(j) && !n){
          n = true;
          result = true;
        } else{
          result = false;
        }
        j++;
      } while(j < 10 && !n);
      if(!result){
        i = s.length();
      }
    }
    return result;
  }

   public static boolean allReal (String s){
    boolean result = true;
    boolean n = false;
    boolean point = false;
    String nums = "0123456789";
    int j = 0;

    for(int i = 0; i < s.length(); i++){
      j = 0;
      n = false;

      do{
        if(s.charAt(i) == nums.charAt(j) && !n){
          n = true;
          result = true;
        } else if(!(point == true) && (s.charAt(i) == '.' || s.charAt(i) == ',')){
          n = true;
          point = true;
          result = true;
        } else{
          result = false;
        }
        j++;
      } while(j < 10 && !n);
      if(!result){
        i = s.length();
      }
    }
    return result;
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