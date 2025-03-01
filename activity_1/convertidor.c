#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//FUNCION PARA CONVERTIR EL TEXTO A BINARIO
void stringToBinary(char *str) {
    while (*str) {
        for (int i = 7; i >= 0; i--) {
            printf("%c", (*str & (1 << i)) ? '1' : '0');
        }
        printf(" ");
        str++;
    }
    printf("\n");
}

//FUNCION PARA DCONVERTIR BINARIO A TEXTO (CARACTER)
void binaryToChar(char *binary) {
    if (strlen(binary) != 8) {
        printf("OJO: Debe contener 8 bits.\n");
        return;
    }

    int decimalValue = 0;
    for (int i = 0; i < 8; i++) {
        if (binary[i] != '0' && binary[i] != '1') {
            printf("ERROR: Solo se permiten caracteres '0' y '1'.\n");
            return;
        }
        decimalValue = (decimalValue << 1) | (binary[i] - '0');
    }

    printf("Caracter: %c\n", (char)decimalValue);
}

//MENU DE OPCIONES
int main() {
    int opcion;
    char input[256];

    do {
        printf("\nCONVERTIDOR\n");
        printf("1.S2B (Texto a Binario)\n");
        printf("2.B2B (Binario a Caracter)\n");
        printf("3.Salir\n");
        printf("Seleccione una de las opciones: ");
        scanf("%d", &opcion);
        getchar();  

        switch (opcion) {
            case 1:
                printf("Ingrese una cadena de texto: ");
                fgets(input, sizeof(input), stdin);
                input[strcspn(input, "\n")] = '\0'; 
                stringToBinary(input);
                break;
            case 2:
                printf("Ingrese una cadena binaria de 8 bits: ");
                fgets(input, sizeof(input), stdin);
                input[strcspn(input, "\n")] = '\0'; 
                binaryToChar(input);
                break;
            case 3:
                printf("Finalizando\n");
                break;
            default:
                printf("Opcion incorrecta. Intente nuevamente por favor.\n");
        }
    } while (opcion != 3);

    return 0;
}