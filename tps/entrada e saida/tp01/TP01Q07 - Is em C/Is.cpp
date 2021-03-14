#include<stdio.h>
#include<stdbool.h>
#include<string.h>

bool isFim(char s[], int i){
    return (i == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool allVogal(char s[], int size){
    bool result = true;
    bool vog = false;
    char vogais[10] = "aeiouAEIOU";
    int j = 0;
    for(int i = 0; i < size; i++){
      j = 0;
      vog = false;

      do{
        if(s[i] == vogais[j] && !vog){
          vog = true;
          result = true;
        } else{
          result = false;
        }
        j++;
      } while(j < 10 && !vog);
      if(!result){
        i = size;
      }
    }
    return (result);
}

bool allConsonant(char s[], int size){
    bool result = true;
    bool vog = false;
    char vogais[10] = "aeiouAEIOU";
    char num[10] = "0123456789";

    int j = 0;
    for(int i = 0; i < size; i++){
      j = 0;
      vog = false;

      do{
        if(s[i] != vogais[j] && s[i] != num[j] && !vog && (s[i]>'a'|| s[i]>'A') && (s[i]<='z'|| s[i]<='Z')){
          result = true;
        } else{
          vog = true;
          result = false;
        }
        j++;
      } while(j < 10 && !vog);
      if(!result){
        i = size;
      }
    }
    return (result);
}

bool allInt(char s[], int size){
    bool result = true;
    bool n = false;
    char nums[10] = "0123456789";
    int j = 0;

    for(int i = 0; i < size; i++){
      j = 0;
      n = false;

      do{
        if(s[i] == nums[j] && !n){
          n = true;
          result = true;
        } else{
          result = false;
        }
        j++;
      } while(j < 10 && !n);
      if(!result){
        i = size;
      }
    }
    return (result);
}

bool allReal(char s[], int size){
    bool result = true;
    bool n = false;
    bool point = false;
    char nums[10] = "0123456789";
    int j = 0;

    for(int i = 0; i < size; i++){
      j = 0;
      n = false;

      do{
        if(s[i] == nums[j] && !n){
          n = true;
          result = true;
        } else if(!point && (s[i] == '.' || s[i] == ',')){
          n = true;
          result = true;
          point = true;
        } else{
          result = false;
        }
        j++;
      } while(j < 10 && !n);
      if(!result){
        i = size;
      }
    }
    return (result);
}



int main( )
{
    int size = 0;
    char s[1000];
    int i = 0;
    char result[14];

    do
    {
        fgets(s, 1000, stdin);
        size = strlen(s)-1; 
        
        if (!isFim(s, size))
        {
            if(allVogal(s, size)){
                result[0] = 'S';
                result[1] = 'I';
                result[2] = 'M';
                result[3] = ' ';
            } else {
                result[0] = 'N';
                result[1] = 'A';
                result[2] = 'O';
                result[3] = ' ';
            }

            if(allConsonant(s, size)){
                result[4] = 'S';
                result[5] = 'I';
                result[6] = 'M';
                result[7] = ' ';
            } else {
                result[4] = 'N';
                result[5] = 'A';
                result[6] = 'O';
                result[7] = ' ';
            }

            if(allInt(s, size)){
                result[8] = 'S';
                result[9] = 'I';
                result[10] = 'M';
                result[11] = ' ';
            } else {
                result[8] = 'N';
                result[9] = 'A';
                result[10] = 'O';
                result[11] = ' ';
            }

            if(allReal(s, size)){
                result[12] = 'S';
                result[13] = 'I';
                result[14] = 'M';
            } else {
                result[12] = 'N';
                result[13] = 'A';
                result[14] = 'O';
            }
            
        }

        for (int k = 0; k < 15; k++)
        {
            printf("%c", result[k]);
        }
        printf("\n");
        
    }while (!isFim(s, size));

    return 0;
}