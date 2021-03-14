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
     int x = 0;
     int[] somas = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

     for(int i = 0; i < html.length(); i++){
       
       switch (html.charAt(i))
            {
              case 'a':
                somas[0] += 1;
                break;

              case 'e':
                somas[1] += 1;
                break;
          
              case 'i':
                somas[2] += 1;
                break;

              case 'o':
                somas[3] += 1;
                break;

              case 'u':
                somas[4] += 1;
                break;

              case 'á':
                somas[5] += 1;
                break;

              case 'é':
                somas[6] += 1;
                break;
                
              case 'í':
                somas[7] += 1;
                break;

              case 'ó':
                somas[8] += 1;
                break;

              case 'ú':
                somas[9] += 1;
                break;

              case 'à':
                somas[10] += 1;
                break;

              case 'è':
                somas[11] += 1;
                break;
                
              case 'ì':
                somas[12] += 1;
                break;

              case 'ò':
                somas[13] += 1;
                break;

              case 'ù':
                somas[14] += 1;
                break;

              case 'ã':
                somas[15] += 1;
                break;

              case 'õ':
                somas[16] += 1;
                break;

              case 'â':
                somas[17] += 1;
                break;

              case 'ê':
                somas[18] += 1;
                break;
                
              case 'î':
                somas[19] += 1;
                break;

              case 'ô':
                somas[20] += 1;
                break;

              case 'û':
                somas[21] += 1;
                break;
       
              default: x = 1;
                }
              if(x == 1){
                if(html.charAt(i) == '<' && html.charAt(i+1) == 'b' && html.charAt(i+2) == 'r' && html.charAt(i+3) == '>'){
                  somas[23] = somas[23] + 1;
                } else if(html.charAt(i) == '<' && html.charAt(i+1) == 't' && html.charAt(i+2) == 'a'&& html.charAt(i+2) == 'b'&& html.charAt(i+2) == 'l'&& html.charAt(i+2) == 'e' && html.charAt(i+3) == '>'){
                  somas[24] = somas[24] + 1;
                } else if(html.charAt(i) > 'a' && html.charAt(i) <= 'z'){
                  somas[22] = somas[22] + 1;
                }
                x=0;
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
