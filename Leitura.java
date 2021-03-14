import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class Leitura {

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public static String html(String link){
      String html = new String();

      try {
      URL u = new URL(link);
      URLConnection uc = u.openConnection();
      InputStreamReader isr = new InputStreamReader(uc.getInputStream());
      BufferedReader br = new BufferedReader(isr);


      String linha = br.readLine(); 

      while (linha != null) { 
        html = html + br.readLine();
      } 
      }

      catch (IOException e) {

        e.printStackTrace();
    }
    
      return html;
   }

   public static String contagem(String html){
     String result = new String();
     int[] somas = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

     for(int i = 0; i < html.length(); i++){
       if(html.charAt(i) == 'a'){
         somas[0] = somas[0] + 1;
       } else if(html.charAt(i) == 'e'){
         somas[1] = somas[1] + 1;
       } else if(html.charAt(i) == 'i'){
         somas[2] = somas[2] + 1;
       } else if(html.charAt(i) == 'o'){
         somas[3] = somas[3] + 1;
       } else if(html.charAt(i) == 'u'){
         somas[4] = somas[4] + 1;
       } else if(html.charAt(i) == 'á'){
         somas[5] = somas[5] + 1;
       } else if(html.charAt(i) == 'é'){
         somas[6] = somas[6] + 1;
       } else if(html.charAt(i) == 'í'){
         somas[7] = somas[7] + 1;
       } else if(html.charAt(i) == 'ó'){
         somas[8] = somas[8] + 1;
       } else if(html.charAt(i) == 'ú'){
         somas[9] = somas[9] + 1;
       } else if(html.charAt(i) == 'à'){
         somas[10] = somas[10] + 1;
       } else if(html.charAt(i) == 'è'){
         somas[11] = somas[11] + 1;
       } else if(html.charAt(i) == 'ì'){
         somas[12] = somas[12] + 1;
       } else if(html.charAt(i) == 'ò'){
         somas[13] = somas[13] + 1;
       } else if(html.charAt(i) == 'ù'){
         somas[14] = somas[14] + 1;
       } else if(html.charAt(i) == 'ã'){
         somas[15] = somas[15] + 1;
       } else if(html.charAt(i) == 'õ'){
         somas[16] = somas[16] + 1;
       } else if(html.charAt(i) == 'â'){
         somas[17] = somas[17] + 1;
       } else if(html.charAt(i) == 'ê'){
         somas[18] = somas[18] + 1;
       } else if(html.charAt(i) == 'î'){
         somas[19] = somas[19] + 1;
       } else if(html.charAt(i) == 'ô'){
         somas[20] = somas[20] + 1;
       } else if(html.charAt(i) == 'û'){
         somas[21] = somas[21] + 1;
       } else if(html.charAt(i) == '<' && html.charAt(i+1) == 'b' && html.charAt(i+2) == 'r' && html.charAt(i+3) == '>'){
         somas[23] = somas[23] + 1;
       } else if(html.charAt(i) == '<' && html.charAt(i+1) == 't' && html.charAt(i+2) == 'a'&& html.charAt(i+2) == 'b'&& html.charAt(i+2) == 'l'&& html.charAt(i+2) == 'e' && html.charAt(i+3) == '>'){
         somas[24] = somas[24] + 1;
       } else if(html.charAt(i) > 'a' && html.charAt(i) <= 'z'){
         somas[22] = somas[22] + 1;
       }
     }

     result = "a("+somas[0]+") e("+somas[1]+") i("+somas[2]+") o("+somas[3]+") u("+somas[4]+") á("+somas[5]+") é("+somas[6]+") í("+somas[7]+") ó("+somas[8]+") ú("+somas[9]+") à("+somas[10]+") è("+somas[11]+") ì("+somas[12]+") ò("+somas[13]+") ù("+somas[14]+") ã("+somas[15]+") ã("+somas[16]+") â("+somas[17]+") ê("+somas[18]+") î("+somas[19]+") ô("+somas[20]+") û("+somas[21]+") consoante("+somas[22]+") <br>("+somas[23]+") <table>("+somas[24]+") ";
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

      //Para cada linha de entrada, gerando uma de saida boleana se e' ou nao palindromo
      for(int i = 0; i < numEntrada; i+=2){
         MyIO.println(html(entrada[i+1]));
         MyIO.println(entrada[i]+"\n");
      }
   }
}
