#include<stdio.h>
#include<stdbool.h>
#include<string.h>

bool isPalindromo (char s[], int i)
{
    char invert[1000];
    int size = i;
    int palin = 0;
    bool is = false;
    i--;

    for (int j = 0; j < size; j++)
    {
        invert[j] = s[i];
        i--;
    }
    
    for (int a = 0; a <= size; a++)
    {
        if (s[a] == invert[a])
        {
            palin++;
        }
    }

    if (palin == size)
    {
        is = true;
    }
    return(is);   
    
}

bool isFim(char s[], int i)
{
    return (i == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int main( )
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
            if (isPalindromo(s, size))
            {
                printf("SIM\n");
            } 
            else
            {
                printf("NAO\n");
            } 
        }

    }while (!isFim(s, size));
 return 0;
}