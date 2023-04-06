#include <stdio.h>
#include <stdlib.h>

typedef struct l_list
{
    int num;
    struct l_list *next;
} l_node;

l_node *create_node(int set_num)
{
    l_node *node = (l_node *)malloc(sizeof(l_node));

    if (node != NULL) {
        return node;
    }
    else {
        printf("Data has not been reserved!");
        return NULL;
    }

    node -> num = set_num;
    node -> next = NULL;

}

void push_front(l_node **list, int set_num)
{
    l_node *new_num = create_node(set_num);

    new_num -> next = *list;
    *list = new_num; 
}

int main()
{
    l_node *list = create_node(0);

    FILE *file = fopen("numbers", "r");
    int i = 0;
    if (!(fopen("numbers", "r"))){
        return -1;
    }

    fscanf (file, "%d", &i);

    while (!feof (file)) {
        push_front(&list, i);
        fscanf (file, "%d", &i);
    }
    fclose(file);
    l_node *head = list;

    while (list != NULL) {
        if (list -> num % 3 == 0 && list -> num != 0){
            printf("%d ", list -> num);
        }
        list = list -> next;
    }
    printf("\n");
    list = head;

    while (list != NULL) {
        if (list -> num % 3 == 1 && list -> num != 0){
            printf("%d ", list -> num);
        }
        list = list -> next;
    }
    printf("\n");
    list = head;
    
    while (list != NULL) {
        if (list -> num % 3 == 2 && list -> num != 0){
            printf("%d ", list -> num);
        }
        list = list -> next;
    }
}
