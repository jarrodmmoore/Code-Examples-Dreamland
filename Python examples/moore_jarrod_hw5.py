#variables
raw_input = "Placeholder!"
phase = 1
students = {}
assignment_count = 0
assignment = 1
score = 0
total_score = 0
student_count = 0

#dividing this into phases wasn't neccesary in this case
#but if this were a real program I'd want this to be compartmentalized
#so we can call each phase on command

while (phase != 0):
    #phase 1, enter student ID and name
    if (phase == 1):
        raw_input = input("Enter new a student ID, or say \"done\": ")

        #exit phase 1 when "done" is entered
        if (raw_input[:4].lower() == "done"):
            phase = 2
        #any other string will become a student ID
        else:
            students[raw_input] = {
                "{}".format(input("Enter the name of the student: ")): []
            }
            print("Student registered.\n")
            
    #phase 2, create assignments
    elif (phase == 2):
        print("\n")
        raw_input = "Placeholder."
        while True:
            raw_input = input("How many assignments are there? ")
            if (raw_input.isdigit() == True):
                raw_input = int(raw_input)
                if (raw_input >= 1):
                    assignment_count = raw_input
                    break
        phase = 3
    
    #phase 3, enter scores for every student on every assignment
    elif (phase == 3):
        #get scores for all assignments per each student
        for student_id in students.keys():
            #store the name for later use
            for name, scores in students[student_id].items():
                print("\n\n===== {} =====".format(name))
                #collect all 3 scores in a row and put in the student's score list
                for x in range(0, assignment_count):
                    score = "null"
                    print()
                    #lock into prompt until user provides a digit somewhere from 0 to 100
                    while True:
                        score = input("What score did {} get on assignment {}? ".format(name, x+1))
                        if (score.isdigit()):
                            score = int(score)
                            if (score >= 0 and score <= 100):
                                break
                    #add the score to end of the list
                    scores.append(score)
        phase = 4
        
    #phase 4, show student averages:
    elif (phase == 4):
        print("\n\n===== STUDENT AVERAGES =====")
        for student_id in students:
            total_score = 0
            for name, scores in students[student_id].items():
                #add up all scores
                for x in range(0, assignment_count):
                    total_score += scores[x]
                #...then find the average
                print("{}: {:.1f}%".format(name, (total_score / assignment_count)))
        phase = 5
    
    #phase 5, show assignment averages
    elif (phase == 5):
        print("\n\n===== ASSIGNMENT AVERAGES =====")
        for x in range(0, assignment_count):
            student_count = 0
            total_score = 0
            #get total of all scores on assignment x
            for student_id in students:
                for name, score in students[student_id].items():
                    total_score += students[student_id][name][x]
                    student_count += 1
            #find average
            if (student_count > 0):
                print("Assignment {}: {:.1f}%".format((x + 1), (total_score / student_count)))
        phase = 0

print("\n\n")
if (not(student_count > 0)):
    print("You didn't make any entries!")
input("Press ENTER to exit the program.")