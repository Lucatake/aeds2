#include<stdio.h>
#include<stdlib.h>
int main( )
{
  double num = 0.0;
  int i;
  FILE *fw = fopen("nums.txt", "wb");
  //Leitura da quantidade de valores
  int numEntrada;
  scanf("%d", &numEntrada);
  int aux = numEntrada;

  //Leitura da entrada padrao e gravar em arquivo numeros reais
  while(aux > 0){
    scanf("%lf", &num);
    fwrite(&num, sizeof(double), 1, fw);
    aux--;
  }
  //Fechar arquivo, indispensavel para gravar
  fclose(fw);

  FILE *fr = fopen("nums.txt", "rb");
  //Para cada linha gravada, ler e mostrar a saida
  i = (numEntrada*8)-8;
  aux = 0;
  while(i >= 0){
    //Ler de arquivo
    fseek(fr, i, SEEK_SET);
    fread(&num, sizeof(double), 1, fr);
    printf("%lf\n", num);
    i-=8;
    aux++;
    rewind(fr);
  }
  //Fechar arquivo, indispensavel
  fclose(fr);   
  
  return 0;
}