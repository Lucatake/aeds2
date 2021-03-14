#include<stdio.h>
#include<stdbool.h>
#include<string.h>

bool isPalindromo (char s[], int i, int a)
{
    bool is = true;

    if(a < (i/2)){
      
          if(s[a] != s[i-1-a]){
            is = false;
          } else{
            is = true;
            is = isPalindromo(s, i, a+1);
          }
      
    }

    return(is);   
}

bool isFim(char s[], int i)
{
    return (i == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

void main( )
{
    int size = 0;
    char s[1000];
    int i = 0;

    do
    {
        fgets(s, 1000, stdin);
        size = strlen(s)-1; 
        
        if (!isFim(s, size))
        {
            if (isPalindromo(s, size, 0))
            {
                printf("SIM\n");
            } 
            else
            {
                printf("NAO\n");
            } 
        }

    }while (!isFim(s, size));
 
}