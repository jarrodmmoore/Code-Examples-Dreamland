/* Person struct, enum, union, malloc demo */
/* Author: Jarrod Moore */

#include <stdio.h>

typedef struct person {
    char name[20];
    int age;
    
    union {
        struct {
            char school[30];
        } child;
        struct {
            char college[30];
            float gpa;
        } student;
        struct {
            char company[30];
            char salary[12];
        } adult;
    };
    
    enum {Child, Student, Adult} kindSetTo;
} Person;

void display(Person* p);

int main()
{
    // non-dynamic student
    Person collegeStudent;
    Person* ptrCollegeStudent = &collegeStudent;
    strcpy(collegeStudent.name, "Willie");
    collegeStudent.age = 20;
    strcpy (collegeStudent.student.college, "K-State");
    collegeStudent.student.gpa = 3.5;
    collegeStudent.kindSetTo = Student;
    
    // dynamic child
    Person *newChild;
    newChild = malloc(sizeof(Person));
    strcpy(newChild->name, "Alison");
    newChild->age = 10;
    strcpy(newChild->child.school, "Amanda Arnold Elementary");
    newChild->kindSetTo = Child;
    
    // dynamic adult
    Person *newAdult;
    newAdult = malloc(sizeof(Person));
    strcpy(newAdult->name, "Bob");
    newAdult->age = 35;
    strcpy(newAdult->adult.company, "BestBuy");
    strcpy(newAdult->adult.salary, "$45,000");
    newAdult->kindSetTo = Adult;
    
    // display them all
    display(ptrCollegeStudent);
    display(newChild);
    display(newAdult);
    
    // now... begone!
    free(newChild);
    free(newAdult);
    
    getchar();
    
    return 0;
}

void display(Person* p)
{
    printf("Name: %s\n", p->name);
    printf("Age: %d\n", p->age);
    switch (p->kindSetTo)
    {
        case Child:
            printf("Is type: Child\n");
            printf("School: %s\n", p->child.school);
            break;
        case Student:
            printf("Is type: Student\n");
            printf("College: %s\n", p->student.college);
            printf("GPA: %.1f\n", p->student.gpa);
            break;
        case Adult:
            printf("Is type: Adult\n");
            printf("Company: %s\n", p->adult.company);
            printf("Salary: %s\n", p->adult.salary);
            break;
    }
    
    printf("\n");
    return 0;
}