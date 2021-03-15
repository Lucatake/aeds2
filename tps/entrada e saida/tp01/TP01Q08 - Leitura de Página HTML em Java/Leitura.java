import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class Leitura {

   public static boolean isFim(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
   }

   public String htmlLink(String link){
      String texto = new String();
      String html = new String();
      
      
      try {
        URL url = new URL(link);
        URLConnection uc = url.openConnection();
        InputStreamReader isr = new InputStreamReader(uc.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        texto = br.readLine(); 

        while (br.readLine() != null) { 
          texto = br.readLine(); 
          html = html + texto;
        }
        br.close();
        isr.close();
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
       int a = (int)html.charAt(i);
       
       switch (a)
            {
              case 97:
                somas[0] += 1;
                break;

              case 101:
                somas[1] += 1;
                break;
          
              case 105:
                somas[2] += 1;
                break;

              case 111:
                somas[3] += 1;
                break;

              case 117:
                somas[4] += 1;
                break;

              case 160:
                somas[5] += 1;
                break;

              case 130:
                somas[6] += 1;
                break;
                
              case 161:
                somas[7] += 1;
                break;

              case 162:
                somas[8] += 1;
                break;

              case 163:
                somas[9] += 1;
                break;

              case 133:
                somas[10] += 1;
                break;

              case 138:
                somas[11] += 1;
                break;
                
              case 141:
                somas[12] += 1;
                break;

              case 149:
                somas[13] += 1;
                break;

              case 151:
                somas[14] += 1;
                break;

              case 198:
                somas[15] += 1;
                break;

              case 228:
                somas[16] += 1;
                break;

              case 131:
                somas[17] += 1;
                break;

              case 136:
                somas[18] += 1;
                break;
                
              case 140:
                somas[19] += 1;
                break;

              case 147:
                somas[20] += 1;
                break;

              case 150:
                somas[21] += 1;
                break;
       
              default: 
                  if(html.charAt(i) == '<' && html.charAt(i+1) == 'b' && html.charAt(i+2) == 'r' && html.charAt(i+3) == '>'){
                    somas[23] = somas[23] + 1;
                  } else if(html.charAt(i) == '<' && html.charAt(i+1) == 't' && html.charAt(i+2) == 'a'&& html.charAt(i+2) == 'b'&& html.charAt(i+2) == 'l'&& html.charAt(i+2) == 'e' && html.charAt(i+3) == '>'){
                    somas[24] = somas[24] + 1;
                  } else if(html.charAt(i) > 'a' && html.charAt(i) <= 'z'){
                    somas[22] = somas[22] + 1;
                
            }
              
          }
     }

     result = "a("+somas[0]+") e("+somas[1]+") i("+somas[2]+") o("+somas[3]+") u("+somas[4]+") á("+somas[5]+") é("+somas[6]+") í("+somas[7]+") ó("+somas[8]+") ú("+somas[9]+") à("+somas[10]+") è("+somas[11]+") ì("+somas[12]+") ò("+somas[13]+") ù("+somas[14]+") ã("+somas[15]+") ã("+somas[16]+") â("+somas[17]+") ê("+somas[18]+") î("+somas[19]+") ô("+somas[20]+") û("+somas[21]+") consoante("+somas[22]+") <br>("+somas[23]+") <table>("+somas[24]+") ";
     return result;
   }
    

   public static void main (String[] args){
      String[] entrada = new String[1000];
      int numEntrada = 0;
      Leitura th = new Leitura();
      String url = "";
      String texto = new String();

      //Leitura da entrada padrao
      do {
         entrada[numEntrada] = MyIO.readLine();
      } while (isFim(entrada[numEntrada++]) == false);
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      //Para cada linha de entrada, gerando uma de saida boleana se e' ou nao palindromo
      for(int i = 0; i < numEntrada; i+=2){
        url = entrada[i+1];
        
        MyIO.print(contagem(th.htmlLink(url)));
        MyIO.print(entrada[i]+"\n");
      }
   }
}
