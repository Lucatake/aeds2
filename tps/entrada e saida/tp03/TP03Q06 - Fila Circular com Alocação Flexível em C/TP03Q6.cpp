#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include<stdbool.h>

#define MAX_LINE_SIZE 860
#define TOTAL_MUSIC_NUMBER 170625
#define MAX_LINE_LENGTH 1000
#define MAX_PLAYLIST_LENGTH 500
#define MAX_ID_LENGTH 30

typedef struct {
    char id[30];
    char name[200];
    char key[15];
    char artists[40][100];
    int num_artists;
    char release_date[12];
    double acousticness;
    double danceability;
    double energy;
    int duration_ms;
    double instrumentalness;
    double valence;
    int popularity;
    float tempo;
    double liveness;
    double loudness;
    double speechiness;
    int year;
} Musica;

Musica clone_music(Musica *music) {
    return *music;
}

char *remove_line_break(char line[]) {
    int size = strlen(line);

    if (line[size - 2] == '\r')
        line[size - 2] = '\0';

    else if (line[size - 1] == '\r' || line[size - 1] == '\n')
        line[size - 1] = '\0';

    return line;
}

char *read_quotted_csv_field(char *field_ptr, char *output) {
    field_ptr++;
    while (*field_ptr != '\0') {
        if (*field_ptr == '"') {
            if (*(field_ptr + 1) == '"') {
                *output++ = '"';
                field_ptr += 2;
            } else {
                field_ptr++;
                break;
            }
        } else {
            *output++ = *field_ptr++;
        }
    }
    *output = '\0';
    return field_ptr;
}

/**
 * @brief Lê uma única célula de um CSV.
 * 
 * @param field_ptr Ponteiro para o primeiro caractere dessa célula.
 * @param output Arranjo que receberá o conteúdo da célula.
 * 
 * @return Ponteiro que aponta para uma posição depois da célula.
 * Geralmente um ponteiro para uma vírgula ou o fim da linha.
 */
char *read_csv_field(char *field_ptr, char *output) {
    if (*field_ptr == '"') return read_quotted_csv_field(field_ptr, output);

    while (*field_ptr != '\0' && *field_ptr != ',') *output++ = *field_ptr++;

    *output = '\0';
    return field_ptr;
}

char *read_artist(char *output, char *artist_ptr) {
    char delimiter = *artist_ptr++;

    while (*artist_ptr != delimiter) {
        if (*artist_ptr == '\\') *output++ = *artist_ptr++;
        *output++ = *artist_ptr++;
    }

    *output = '\0';
    return artist_ptr + 1;
}

/**
 * @brief Lê o campo artists de uma música e preenche o arranjo de artistas dela.
 * 
 * @param music Ponteiro para a struct da música.
 * @param artists_field Ponteiro para o primeiro caractere do campo artists.
 * Um colchete '[' em todos os casos.
 */
void read_artists(Musica *music, char *artists_field) {
    artists_field++;
    int i = 0;
    while (1) {
        artists_field = read_artist(music->artists[i++], artists_field);
        if (*artists_field == ']') break;
        artists_field += 2;
    }
    music->num_artists = i;
}

void read_release_date(Musica *music, char field[]) {
    strcpy(music->release_date, field);
    if (strlen(music->release_date) == 4) strcat(music->release_date, "/01/01");
    music->release_date[4] = '/';
    music->release_date[7] = '/';
}

double handle_percentage(double value) {
    return ceil(value) == value ? value / 100 : value;
}

/**
 * @brief Lê uma linha vinda do CSV e preenche os campos da Música.
 * 
 * @param music Ponteiro para a struct da música.
 * @param line Linha do CSV.
 * 
 * Ex.: read_music(&music, "0.598,2018,0.136,\"['Royce Da 5\\'9""', 'Eminem', 'King Green']\",0.706,283077,0.745,1,6LZe8JfVaqcpq8yjkHtWQe,0.0,10,0.268,-5.97,0,Caterpillar (feat. Eminem & King Green),61,2018-05-04,0.441,91.08")
 */
void read_music(Musica *music, char line[]) {
    char field[MAX_LINE_SIZE];
    remove_line_break(line);

    line = read_csv_field(line, field);
    music->valence = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    music->year = atoi(field);

    line = read_csv_field(line + 1, field);
    music->acousticness = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    read_artists(music, field);

    line = read_csv_field(line + 1, field);
    music->danceability = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    music->duration_ms = atoi(field);

    line = read_csv_field(line + 1, field);
    music->energy = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field); // Skip 'explicit' column

    line = read_csv_field(line + 1, field);
    strcpy(music->id, field);

    line = read_csv_field(line + 1, field);
    music->instrumentalness = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    strcpy(music->key, field);

    line = read_csv_field(line + 1, field);
    music->liveness = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    music->loudness = atof(field);

    line = read_csv_field(line + 1, field); // Skip 'mode' column

    line = read_csv_field(line + 1, field);
    strcpy(music->name, field);

    line = read_csv_field(line + 1, field);
    music->popularity = atoi(field);

    line = read_csv_field(line + 1, field);
    read_release_date(music, field);

    line = read_csv_field(line + 1, field);
    music->speechiness = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    music->tempo = atof(field);
}

void print_artists(Musica *music) {
    printf("[");

    if (music->num_artists > 0) {
        printf("%s", music->artists[0]);

        for (int i = 1; i < music->num_artists; i++)
            printf(", %s", music->artists[i]);
    }

    printf("]");
}

void print_music(Musica *music) {
    printf("%s ## ", music->id);
    print_artists(music);
    printf(" ## %s ## %c%c/%c%c/%c%c%c%c ## %G ## %G ## %G ## %G ## %G ## %G ## %G ## %d\n",
        music->name,
        music->release_date[8],
        music->release_date[9],
        music->release_date[5],
        music->release_date[6],
        music->release_date[0],
        music->release_date[1],
        music->release_date[2],
        music->release_date[3],
        music->acousticness,
        music->danceability,
        music->instrumentalness,
        music->liveness,
        music->loudness,
        music->speechiness,
        music->energy,
        music->duration_ms
    );
}

int getDuration(Musica *music) {
    return music -> duration_ms;
}
char *getName(Musica *music) {
    return music -> name;
}

//pesquisa sequencial do cadastro
void searchById(char id[MAX_ID_LENGTH], char **totalMusicList, char* resp){
  for(int i = 0; i < TOTAL_MUSIC_NUMBER; i++){
    if(strstr(totalMusicList[i], id) != NULL){
      strcpy(resp, totalMusicList[i]);
      i = TOTAL_MUSIC_NUMBER;
    }
  }
}

//=============================================================================
//--------------------------------Celula--------------------------------------
//=============================================================================
typedef struct Celula{
    Musica *musica;
    struct Celula *prox;
}Celula;
//=============================================================================
Celula* new_celula(Musica *music){
    Celula *temp = (Celula*)malloc(sizeof(Celula));
    temp->musica = music;
    temp->prox = NULL;
    return temp;
}
//=============================================================================
//-------------------------------Fila Circular--------------------------------
//=============================================================================
Celula* primeiro;
Celula* ultimo;
int q, last, first = 0;
int tam = 5;

/**
 * Cria uma fila sem elementos (somente no cabeca).
 */
void start () {
   primeiro = novaCelula(NULL);
   ultimo = primeiro;
}


/**
 * Insere elemento na fila (politica FIFO).
 * @param x int Elemento a inserir.
 */
void enfileirar(Musica *music) {
   if(((last+1) % tam) == first) 
    	desenfileirar();
    ultimo->prox = novaCelula(music);
    ultimo = ultimo->prox;
    last = (last+1) % tam;
    q++;
}


/**
 * Remove elemento da fila (politica FIFO).
 * @return Elemento removido.
 */
Musica *desenfileirar() {
   Musica *musica;
   if (first == last)
      errx(1, "Erro ao remover!");
   Celula* tmp = primeiro;
   primeiro = primeiro->prox;
   Musica *resp = primeiro->musica;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   first = (first+1) % tam;
   q--;
   return musica;
}


/**
 * Mostra os elementos separados por espacos.
 */
void mostrar() {
   Celula* aux;
   int i = first;
   while (i != last) {
      printf("[%d] %s\n", aux->musica);
      i  = (i+1)%tam;
   }
}

int mediaDuration() {
    Celula* aux;
    double med = 0;
    int i = first;
    while (i!=last) {
        med = med + getDuration(aux->musica);
        i = (i+1)%tam;
    }
    med = med/q;
    return (int)med;
}

bool isFim(char s[], int i){
    return (i == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

//METODO PRINCIPAL ==============================================================
int main(int argc, char** argv){
  char cdM[80];
  int q = 0;
  int quant = 0;
  char line[100];
  char meto;
  char id[30];
  Musica *musR;
  int size;
  char s[30];
  char **totalMusicList;
  char* resp;
  int c = -1;
  void start ();

  do
  {
    fgets(s, 30, stdin);
    size = strlen(s)-1; 
    searchById(s, totalMusicList, resp);
    enfileirar(resp);   
  } while (!isFim(s, size));
    printf("%d", mediaDuration());

    fgets(quant, 2, stdin);

    for (int i = 0; i < quant; i++)
    {
        fgets(line, 100, stdin);
        meto = strtok(line, " ");
        if (meto =="I")
        {
            c = 0;
            id[30] = strtok(line, " ");
        }else{
            c = 1;
        }
        switch (c) {
	    	  case 0:
                  searchById(s, totalMusicList, resp);
				  enfileirar(resp);
				  printf("%d\n", mediaDuration());
				  break;
	    	  case 1:
	    		  musR = desenfileirar();
	    		  printf("(R) %c\n", getName(musR));
    			  break;
    		default:
    			printf("Invalido");
    			break;
    	  }
        
    }
    



}