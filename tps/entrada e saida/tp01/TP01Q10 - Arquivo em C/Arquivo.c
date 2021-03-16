#include<stdio.h>

/**
 * writeDoubles - Gravar em arquivo texto certa quantidade de valores.
 * @param fileName - nome do arquivo
 * @param x - quantidade de valores
*/
void writeDoubles(chars fileName, int x)
{
    // definir dados
    FILE *arquivo = fopen(fileName, "wt");
    int y = 0;
    // gravar quantidade de valores
    IO_fprintf(arquivo, "%d\n", x);
    // repetir para a quantidade de dados
    for (y = 1; y <= x; y = y + 1)
    {
        // gravar valor
        IO_fprintf(arquivo, "%lf\n", (0.1 * y));
    } // fim repetir
    // fechar arquivo (INDISPENSAVEL para gravacao)
    fclose(arquivo);
} // fim writeDoubles ( )

/**
 * readDoubles - Ler de arquivo texto certa quantidade de valores.
 * @param fileName - nome do arquivo
 * @param x - quantidade de valores
*/
void readDoubles(chars fileName)
{
    // definir dados
    FILE *arquivo = fopen(fileName, "rt");
    int x = 0;
    int y = 1;
    double z = 0.0;
    // tentar ler a quantidade de dados
    fscanf(arquivo, "%d", &x);
    // repetir enquanto houver dados e
    // quantidade nao tiver sido alcancada
    while (!feof(arquivo) && y <= x)
    {
        // tentar ler
        fscanf(arquivo, "%lf", &z);
        // mostrar valor
        printf("%lf\n", z);
        // passar ao proximo
        y = y + 1;
    } // fim repetir
    // fechar arquivo (RECOMENDAVEL para leitura)
    fclose(arquivo);
} // fim readDoubles ( )


int main( )
{
    
 return 0;
}