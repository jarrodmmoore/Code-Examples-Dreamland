/* Student struct, enum, malloc demo */
/* Author: Jarrod Moore */

#include <stdio.h>

typedef struct student {
    char* name;
    int age;
    enum grade {
        Freshman = 9,
        Sophomore, Junior, Senior
    } class;
} Student;

void display(Student* stu);

int main()
{
    Student *firstStudent;
    firstStudent = malloc(sizeof(Student));
    
    display(firstStudent);
    
    printf("\n");
    
    // get student info from user
    printf("Enter student name: ");
    scanf("%s", &(firstStudent->name));
    getchar();
    
    printf("Enter student age: ");
    scanf("%d", &(firstStudent->age));
    getchar();
    
    printf("Enter student grade (number): ");
    scanf("%d", &(firstStudent->class));
    getchar();
    
    printf("\n");
    
    display(firstStudent);

    printf("\nOne year later...\n");
    // increment age and class by 1
    firstStudent->age++;
    if (firstStudent->class < 12)
    {
        firstStudent->class++;
    }
    display(firstStudent);
    
    // goodbye horses
    free(firstStudent);
    
    return 0;
}

void display(Student* stu)
{
    printf("Student name: %s\n", &(stu->name));
    printf("Student age: %d\n", stu->age);
    // enums are not strings! using a switch.
    switch (stu->class)
    {
        case 9:
            printf("Student year: Freshman");
            break;
        case 10:
            printf("Student year: Sophomore");
            break;
        case 11: 
            printf("Student year: Junior");
            break;
        case 12:
            printf("Student year: Senior");
            break;
        default:
            printf("Not in high school!");
            break;
    }
    printf("\n");
    return 0;
}