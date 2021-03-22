import java.io.*;

class Arquivo {
    public static void main (String[] args) throws Exception{
      double num = 0.0;
      int i;
      RandomAccessFile arqW = new RandomAccessFile("nums.txt", "rw");
      //Leitura da quantidade de valores
      int numEntrada = MyIO.readInt();
      int aux = numEntrada;

      //Leitura da entrada padrao e gravar em arquivo numeros reais
      while(aux > 0){
        num = MyIO.readDouble();
        arqW.writeDouble(num);
        aux--;
      }
      //Fechar arquivo, indispensavel para gravar
      arqW.close();

      RandomAccessFile arqR = new RandomAccessFile("nums.txt", "rw");

      //Para cada linha gravada, ler e mostrar a saida
      i = (numEntrada*8)-8;
      aux= 0;
      while(i >= 0){
        //Ler de arquivo
          arqR.seek(i);
          num = arqR.readDouble();
          MyIO.printf("%.g\n",num);
          i-=8;
          aux++;
      }
      //Fechar arquivo, indispensavel
      arqR.close();
    }
}