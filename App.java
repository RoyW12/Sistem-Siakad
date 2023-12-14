import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in);
    static String[][] admin = { { "admin1", "admin1" }, { "admin2", "admin2" }, { "admin3", "admin3" } };
    static String[][] students = {
            { "1234560001", "Roy wijaya", "1A", "TI", "L" },
            { "1234560002", "Prabowo Subianto", "1B", "TI", "P" },
            { "1234560003", "Joko Widodo", "1C", "TI", "L" },
            { "1234560004", "Ganjar Pranowo", "1D", "TI", "L" },
            { "1234560005", "Megawati", "1E", "TI", "P" }
    };
    static String[][] course = {
            { "RTI231001", "Pancasila", "2" },
            { "RTI231002", "KTI", "2" },
            { "RTI231003", "CTPS", "2" }
    };
    static String CONTINUE = "\u001B[34m";
    static String SUCCESS = "\u001B[32m";
    static String ERROR = "\u001B[31m";
    static String RESETCOLOR = "\u001B[0m";

    static int[][] gradesNumeric = new int[students.length][course.length];
    static String[][] gradesLetter = new String[students.length][course.length];
    static String[][] predicate = new String[students.length][course.length];
    static double[][] equivalentValue = new double[students.length][course.length];
    static double[] ip = new double[students.length];

    public static void main(String[] args) {
        loginView();
    }

    static void loginView() {
        while (true) {
            renderStringWithLn("SISTEM SIAKAD");
            renderStringWithLn("1. admin");
            renderStringWithLn("2. mahasiswa");
            renderStringWithLn("0. exit");
            renderStringWithLn("Choose login as => 1.admin 2.mahasiswa or exit choose 0");
            int choice = getUserChoiceInt();
            switch (choice) {
                case 1:
                    login(choice);
                    clearConsole();
                    break;
                case 2:
                    login(choice);
                    clearConsole();
                    break;
                case 0:
                    clearConsole();
                    System.exit(choice);
                    break;
                default:
                    clearConsole();
                    renderStringWithLn(ERROR + "user can't be found" + RESETCOLOR);
                    renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                    userInput.nextLine().trim();
                    clearConsole();
            }
        }
    }

    static int checkUsernamePassword(String username, String password, String[][] userArray) {
        int userIndex = -1;
        for (int i = 0; i < userArray.length; i++) {
            if (userArray == admin) {
                if (username.equals(userArray[i][0]) && password.equals(userArray[i][1])) {
                    userIndex = i;
                    clearConsole();
                    return userIndex;
                }
            } else if (userArray == students) {
                if (username.equals(userArray[i][0]) && password.equals(userArray[i][0])) {
                    userIndex = i;
                    clearConsole();
                    return userIndex;
                }
            }

        }
        if (userIndex == -1) {
            clearConsole();
            renderStringWithLn(ERROR + "incorrect username and password " + RESETCOLOR);
        }
        return -1;
    }

    static void login(int choice) {
        while (true) {
            int user;
            renderStringWithLn("input username and password");
            String username = getNonEmptyString("Username");
            String password = getNonEmptyString("Password");

            if (choice == 1) {
                user = checkUsernamePassword(username, password, admin);
                if (user >= 0) {
                    adminDashboard(user);
                }
            } else if (choice == 2) {
                user = checkUsernamePassword(username, password, students);
                if (user >= 0) {
                    studentDashboard(user);
                }
            }
        }
    }

    static void adminDashboard(int user) {
        renderStringWithLn("Welcome " + admin[user][0]);
        while (true) {
            renderStringWithLn("=== Dashboard Admin ===");
            renderStringWithLn("1. Input Student Data");
            renderStringWithLn("2. Update Student Data");
            renderStringWithLn("3. Input Course Data into master");
            renderStringWithLn("4. Input Grade");
            renderStringWithLn("5. Search Student");
            renderStringWithLn("6. Students Grade Report");
            renderStringWithLn("7. Logout");
            renderStringWithLn("0. Exit");
            renderString("Select Feature: ");
            int choice = getUserChoiceInt();
            switch (choice) {
                case 1:
                    clearConsole();
                    inputStudentData();
                    break;
                case 2:
                    clearConsole();
                    updateStudentData();
                    break;
                case 3:
                    clearConsole();
                    inputCourseData();
                    break;
                case 4:
                    clearConsole();
                    inputGrade();
                    break;
                case 5:
                    clearConsole();
                    searchStudent();
                    break;
                case 6:
                    clearConsole();
                    studentsGradeReport();
                    break;
                case 7:
                    clearConsole();
                    loginView();
                    break;
                case 0:
                    System.exit(choice);
                default:
                    clearConsole();
                    renderStringWithLn(ERROR + "Feature is not available" + RESETCOLOR);
                    renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                    userInput.nextLine().trim();
                    clearConsole();
            }
        }
    }

    static void inputStudentData() {
        String nim, fullName, classPlacement, studyProgram, sex;
        boolean isFind = false;
        renderStringWithLn("press enter to continue...");
        userInput.nextLine().trim();
        clearConsole();
        renderStudentsTable("Data's Student", students);
        while (!isFind) {
            nim = getStringLimit(10, "NIM", 10);
            fullName = getNonEmptyString("Full Name");
            classPlacement = getStringLimit(2, "Class", 2).toUpperCase();
            studyProgram = getStringLimit(2, "Study Program", 2).toUpperCase();
            sex = specificStringLimit("L", "sex", "P", 1, 1).toUpperCase();
            for (int i = 0; i < students.length; i++) {
                if (nim.equals(students[i][0])) {
                    clearConsole();
                    renderStringWithLn(ERROR + "Student with the NIM of " + nim + " already exists!" + RESETCOLOR);
                    renderStringWithLn(CONTINUE + "Input Data again" + RESETCOLOR);
                    isFind = false;
                    break;
                } else {
                    isFind = true;
                }
                ;
            }
            if (isFind) {
                String[][] newStudents = new String[students.length + 1][5];
                for (int i = 0; i < students.length; i++) {
                    newStudents[i] = students[i];
                }
                newStudents[newStudents.length - 1] = new String[] { nim, fullName, classPlacement, studyProgram, sex };
                students = newStudents;

                int[][] newGradesNumeric = new int[students.length][course.length];
                String[][] newGradesLetter = new String[students.length][course.length];
                String[][] newPredicate = new String[students.length][course.length];
                double[][] newEquivalentValue = new double[students.length][course.length];
                double[] newIp = new double[students.length];
                for (int i = 0; i < students.length - 1; i++) {
                    newIp[i] = ip[i];
                    for (int j = 0; j < course.length; j++) {
                        newGradesNumeric[i][j] = gradesNumeric[i][j];
                        newGradesLetter[i][j] = gradesLetter[i][j];
                        newPredicate[i][j] = predicate[i][j];
                        newEquivalentValue[i][j] = equivalentValue[i][j];
                    }
                }
                ip = newIp;
                gradesNumeric = newGradesNumeric;
                gradesLetter = newGradesLetter;
                predicate = newPredicate;
                equivalentValue = newEquivalentValue;
                renderStudentsTable("Data's Student", students);
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            }
            renderStringWithLn("Do you want to input student again (y/n)?");
            String choice = specificStringLimit("y", "Answer", "n", 1, 1);
            if (choice.equalsIgnoreCase("y")) {
                isFind = false;
            } else {
                isFind = true;
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            }
        }
    }

    static void updateStudentData() {
        String oldNim, fullName, classPlacement, studyProgram;
        boolean isFind = false;
        int studentIndex = -1;
        renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
        userInput.nextLine().trim();
        clearConsole();
        while (!isFind) {
            renderStudentsTable("Data's Student", students);
            renderStringWithLn("Find student by NIM");
            oldNim = getStringLimit(10, "NIM", 10);
            for (int i = 0; i < students.length; i++) {
                if (oldNim.equals(students[i][0])) {
                    clearConsole();
                    studentIndex = i;
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                renderStringWithLn("New Student Data");
                fullName = getNonEmptyString("New Name");
                classPlacement = getStringLimit(2, "New Class", 2).toUpperCase();
                studyProgram = getStringLimit(2, "New Study Program", 2).toUpperCase();
                students[studentIndex][1] = fullName;
                students[studentIndex][2] = classPlacement;
                students[studentIndex][3] = studyProgram;
                clearConsole();
                renderStringWithLn(SUCCESS + "Students have been succesfully updated!" + RESETCOLOR);
                renderStudentsTable("Data's Student", students);
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            } else {
                renderStringWithLn(ERROR + "Student with the NIM of " + oldNim + " doesn't exists!" + RESETCOLOR);
                renderStringWithLn("Input data again");
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            }
        }
    }

    static void inputCourseData() {
        String courseCode, courseName, sks;
        boolean isFind = false;
        renderStringWithLn(CONTINUE + "Press enter to continue..." + RESETCOLOR);
        userInput.nextLine().trim();
        clearConsole();
        renderCourseTable("Course data", course);
        while (!isFind) {
            courseCode = getStringLimit(9, "Course Code", 9).toUpperCase();
            courseName = getNonEmptyString("Course Name");
            sks = getStringLimit(1, "sks", 1);
            for (int i = 0; i < course.length; i++) {
                if (courseCode.equals(course[i][0])) {
                    clearConsole();
                    renderStringWithLn(
                            ERROR + "Course with the Course code of " + courseCode + " already exists!" + RESETCOLOR);
                    renderStringWithLn(CONTINUE + "Input Data again" + RESETCOLOR);
                    isFind = false;
                    break;
                } else if (courseName.equalsIgnoreCase(course[i][1])) {
                    clearConsole();
                    renderStringWithLn(
                            ERROR + "Course with the Course Name of " + courseName + " already exists!" + RESETCOLOR);
                    renderStringWithLn(CONTINUE + "Input Data again" + RESETCOLOR);
                    isFind = false;
                    break;
                } else {
                    isFind = true;
                }
            }

            if (isFind) {
                String[][] newCourse = new String[course.length + 1][3];
                for (int i = 0; i < course.length; i++) {
                    newCourse[i] = course[i];
                }
                newCourse[newCourse.length - 1] = new String[] { courseCode, courseName, sks };
                course = newCourse;
                int[][] newGradesNumeric = new int[students.length][course.length];
                String[][] newGradesLetter = new String[students.length][course.length];
                String[][] newPredicate = new String[students.length][course.length];
                double[][] newEquivalentValue = new double[students.length][course.length];
                for (int i = 0; i < students.length; i++) {
                    for (int j = 0; j < course.length - 1; j++) {
                        newGradesNumeric[i][j] = gradesNumeric[i][j];
                        newGradesLetter[i][j] = gradesLetter[i][j];
                        newPredicate[i][j] = predicate[i][j];
                        newEquivalentValue[i][j] = equivalentValue[i][j];
                    }
                }
                gradesNumeric = newGradesNumeric;
                gradesLetter = newGradesLetter;
                predicate = newPredicate;
                equivalentValue = newEquivalentValue;
                renderCourseTable("Course data", course);
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            }

            renderStringWithLn("Do you want to input course again (y/n)?");
            String choice = specificStringLimit("y", "Answer", "n", 1, 1);
            if (choice.equalsIgnoreCase("y")) {
                isFind = false;
            } else {
                isFind = true;
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            }
        }
    }

    static void inputGrade() {
        renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
        userInput.nextLine().trim();
        String nim = "";
        int indexStudent = -1;
        while (indexStudent == -1) {
            nim = getNonEmptyString("Student NIM");
            for (int i = 0; i < students.length; i++) {
                if (nim.equalsIgnoreCase(students[i][0])) {
                    indexStudent = i;
                    renderStringWithLn(SUCCESS + "Data found" + RESETCOLOR);
                    renderStringWithLn(
                            "+------+------------+----------------------+-------+----------------------+-----+");
                    renderStringWithLn(
                            "| No.  |    NIM     |      Full Name       | Class |     Study Program    | Sex |");
                    renderStringWithLn(
                            "+------+------------+----------------------+-------+----------------------+-----+");
                    System.out.printf("| %-4d | %-10s | %-20s | %-5s | %-20s |  %s  |\n", 1,
                            students[i][0],
                            students[i][1],
                            students[i][2],
                            students[i][3],
                            students[i][4]);
                    renderStringWithLn(
                            "+------+------------+----------------------+-------+----------------------+-----+");
                    renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                    userInput.nextLine().trim();
                    clearConsole();
                    break;
                }
            }
            if (indexStudent == -1) {
                renderStringWithLn(ERROR + "Data is not found. Try again" + RESETCOLOR);
            }
        }
        renderValueTable("Value's Tabel", indexStudent, course, gradesNumeric, equivalentValue, gradesLetter,
                predicate);
        renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
        userInput.nextLine().trim();
        clearConsole();
        for (int i = 0; i < course.length; i++) {
            if ((gradesLetter[indexStudent][i] == "-") && (predicate[indexStudent][i] == "-")) {
                int numericValue;
                while (true) {
                    renderString("Course Grade " + course[i][1] + " : ");
                    numericValue = userInput.nextInt();
                    userInput.nextLine();
                    if (numericValue < 0 || numericValue > 100) {
                        renderStringWithLn(
                                ERROR + "The value must be in the range 1-100. Please try again....." + RESETCOLOR);
                        renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                        userInput.nextLine().trim();
                        clearConsole();
                    } else {
                        break;
                    }
                }
                String letterValue;
                String predicateStatus = "";
                double numericEquivalentValue = 0.0;
                if (numericValue > 80 && numericValue <= 100) {
                    letterValue = "A";
                    predicateStatus = "Exellent";
                    numericEquivalentValue = 4;
                } else if (numericValue > 73 && numericValue <= 80) {
                    letterValue = "B+";
                    predicateStatus = "Very Good";
                    numericEquivalentValue = 3.5;
                } else if (numericValue > 65 && numericValue <= 73) {
                    letterValue = "B";
                    predicateStatus = "Good";
                    numericEquivalentValue = 3;
                } else if (numericValue > 60 && numericValue <= 65) {
                    letterValue = "C+";
                    predicateStatus = "Above Avarage";
                    numericEquivalentValue = 2.5;
                } else if (numericValue > 50 && numericValue <= 60) {
                    letterValue = "C";
                    predicateStatus = "Avarage";
                    numericEquivalentValue = 2;
                } else if (numericValue > 39 && numericValue <= 50) {
                    letterValue = "D";
                    predicateStatus = "Below Avarage";
                    numericEquivalentValue = 1;
                } else if (numericValue > 0 && numericValue <= 39) {
                    letterValue = "E";
                    predicateStatus = "Fail";
                    numericEquivalentValue = 0;
                } else {
                    letterValue = "Not Available";
                }
                gradesNumeric[indexStudent][i] = numericValue;
                gradesLetter[indexStudent][i] = letterValue;
                equivalentValue[indexStudent][i] = numericEquivalentValue;
                predicate[indexStudent][i] = predicateStatus;
            }
        }
        renderString("\n");
        renderStringWithLn("-------------------------------------");
        renderStringWithLn("|          Data mahasiswa           |");
        renderStringWithLn("-------------------------------------");
        renderStringWithLn("| Name        : " + students[indexStudent][1]);
        renderStringWithLn("| NIM         : " + students[indexStudent][0]);
        renderStringWithLn("-------------------------------------");
        renderValueTable("Value's Table", indexStudent, course, gradesNumeric, equivalentValue, gradesLetter,
                predicate);
        renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
        userInput.nextLine().trim();
        clearConsole();
    }

    static void searchStudent() {
        String nimInput;
        boolean isFind = false;
        int studentIndex = -1;
        while (!isFind) {
            renderStudentsTable("Data's Student", students);
            renderStringWithLn("Find student by NIM");
            nimInput = getStringLimit(10, "NIM", 10);
            for (int i = 0; i < students.length; i++) {
                if (nimInput.equals(students[i][0])) {
                    clearConsole();
                    studentIndex = i;
                    isFind = true;
                    break;
                } else {
                    isFind = false;
                }
            }
            if (isFind) {
                renderStringWithLn("+------+------------+----------------------+-------+----------------------+-----+");
                renderStringWithLn("| No.  |    NIM     |      Full Name       | Class |     Study Program    | Sex |");
                renderStringWithLn("+------+------------+----------------------+-------+----------------------+-----+");
                System.out.printf("| %-4d | %-10s | %-20s | %-5s | %-20s |  %s  |\n", 1,
                        students[studentIndex][0],
                        students[studentIndex][1],
                        students[studentIndex][2],
                        students[studentIndex][3],
                        students[studentIndex][4]);
                renderStringWithLn("+------+------------+----------------------+-------+----------------------+-----+");
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            } else {
                renderStringWithLn(ERROR + "Student with the NIM of " + nimInput + " doesn't exists!" + RESETCOLOR);
                renderStringWithLn(CONTINUE + "Input Data again" + RESETCOLOR);
            }
        }
    }

    static void studentsGradeReport() {

        renderStringWithLn("-------------------------------------");
        renderStringWithLn("|       Student Grade Reports       |");
        renderStringWithLn("-------------------------------------");
        renderStringWithLn(
                "\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-10s | %-17s | %-7s | %-21s |", "NIM", "Name", "Class", "Study Program");
        for (int j = 0; j < course.length; j++) {
            System.out.format(" %-10s |", course[j][1]);
        }
        renderStringWithLn(
                "\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.format("| %-10s | %-17s | %-7s | %-21s |",
                    students[i][0], students[i][1], students[i][2], students[i][3], students[i][4]);
            for (int j = 0; j < course.length; j++) {
                int numeric = gradesNumeric[i][j];
                String comment = gradesLetter[i][j];
                if (numeric == 0) {
                    System.out.format(" %-10s |", "-");
                } else {
                    System.out.format(" %-10s |", numeric + " (" + comment + ")");
                }
            }
            renderStringWithLn(
                    "\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        renderStringWithLn("");
        renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
        userInput.nextLine().trim();
        clearConsole();
    }

    static void studentDashboard(int user) {
        renderStringWithLn("Welcome " + students[user][1]);
        while (true) {
            renderStringWithLn("=== Dashboard Mahasiswa ===");
            renderStringWithLn("1. Profile");
            renderStringWithLn("2. Print KHS");
            renderStringWithLn("3. Logout");
            renderStringWithLn("0. Exit");
            renderString("Select Feature: ");
            int choice = getUserChoiceInt();
            switch (choice) {
                case 1:
                    clearConsole();
                    profile(user);
                    break;
                case 2:
                    clearConsole();
                    printKHS(user);
                    break;
                case 3:
                    clearConsole();
                    loginView();
                    break;
                case 0:
                    System.exit(choice);
                default:
                    clearConsole();
                    renderStringWithLn(ERROR + "Feature is not available" + RESETCOLOR);
                    renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                    userInput.nextLine().trim();
                    clearConsole();
            }
        }
    }

    static void profile(int user) {
        renderStringWithLn("+------------------------------------------------------------------------+");
        renderStringWithLn("|                                PROFILE                                 |");
        renderStringWithLn("+------------+----------------------+-------+----------------------+-----+");
        renderStringWithLn("|    NIM     |      Full Name       | Class |     Study Program    | Sex |");
        renderStringWithLn("+------------+----------------------+-------+----------------------+-----+");
        System.out.printf("| %-10s | %-20s | %-5s | %-20s |  %s  |\n",
                students[user][0],
                students[user][1],
                students[user][2],
                students[user][3],
                students[user][4]);
        renderStringWithLn("+------------+----------------------+-------+----------------------+-----+");
        renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
        userInput.nextLine().trim();
        clearConsole();
    }

    static void printKHS(int user) {
        renderStringWithLn("---------------------------------------------");
        renderStringWithLn("|             Study Results Card             |");
        renderStringWithLn("---------------------------------------------");
        renderStringWithLn("| Full Name     : " + students[user][1]);
        renderStringWithLn("| NIM           : " + students[user][0]);
        renderStringWithLn("| Class         : " + students[user][2]);
        renderStringWithLn("| Study Program : " + students[user][3]);
        renderStringWithLn("---------------------------------------------");
        renderKhsTable("Value's Table", user, course, equivalentValue, gradesLetter, ip);
        renderString(CONTINUE + "press enter to continue..." + RESETCOLOR);
        userInput.nextLine().trim();
        clearConsole();
    }

    static void renderKhsTable(String title, int indexStudent, String[][] course,
            double[][] equivalentValue, String[][] gradesLetter, double[] ipData) {

        renderStringWithLn(title);
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
        renderStringWithLn(
                "| No.  |    Course Code     |               Course Name              | Value (equivalent) | Value (Letter) |  SKS |   N X SKS  |");
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
        Double totResult = 0.0, totSks = 0.0, ip = 0.0;
        String status = "";
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            Double result = Double.parseDouble(newCourse[2]) * equivalentValue[indexStudent][i];
            totSks += Double.parseDouble(newCourse[2]);
            totResult += result;

            System.out.printf("| %-4d | %-18s | %-38s | %-18s | %-14s | %-4s | %-10s |\n", (i + 1), newCourse[0],
                    newCourse[1],
                    equivalentValue[indexStudent][i], gradesLetter[indexStudent][i], newCourse[2], result);
        }

        renderStringWithLn(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");

        System.out.printf("| %-104s | %-4s | %-10s |\n", "Sum", totSks, totResult);
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
        ip = totResult / totSks;
        int decimalForm = 2;
        double pembulatanFaktor = Math.pow(10, decimalForm);
        double ipDecimal = Math.round(ip * pembulatanFaktor) / pembulatanFaktor;
        ipData[indexStudent] = ipDecimal;
        System.out.printf("| %-124s |\n", "IP = " + ipDecimal);
        for (int i = 0; i < course.length; i++) {
            if (gradesLetter[indexStudent][i] == null) {
                status = null;
                break;
            }
            if (gradesLetter[indexStudent][i] == "E") {
                status = "Tidak Lulus";
                break;
            } else {
                status = "Lulus";

            }

        }
        System.out.printf("| %-124s |\n", "Status = " + status);
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+--------------------+----------------+------+------------+");
    }

    static void renderStudentsTable(String title, String[][] students) {
        renderStringWithLn(title);
        renderStringWithLn("+------+------------+----------------------+-------+----------------------+-----+");
        renderStringWithLn("| No.  |    NIM     |      Full Name       | Class |     Study Program    | Sex |");
        renderStringWithLn("+------+------------+----------------------+-------+----------------------+-----+");
        for (int i = 0; i < students.length; i++) {
            String[] student = students[i];
            System.out.printf("| %-4d | %-10s | %-20s | %-5s | %-20s |  %s  |\n", (i + 1), student[0], student[1],
                    student[2],
                    student[3], student[4]);
        }
        renderStringWithLn("+------+------------+----------------------+-------+----------------------+-----+");
    }

    static void renderCourseTable(String title, String[][] course) {
        renderStringWithLn(title);
        renderStringWithLn("+------+--------------------+----------------------------------------+-----+");
        renderStringWithLn("| No.  |    Course Code     |               Course Name              | SKS |");
        renderStringWithLn("+------+--------------------+----------------------------------------+-----+");
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), newCourse[0], newCourse[1],
                    newCourse[2]);
        }
        renderStringWithLn("+------+--------------------+----------------------------------------+-----+");
    }

    static void renderValueTable(String title, int indexStudent, String[][] course, int[][] gradesNumeric,
            double[][] equivalentValue, String[][] gradesLetter, String[][] predicate) {
        renderStringWithLn(title);
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+----------------+------------------+");
        renderStringWithLn(
                "| No.  |    Course Code     |               Course Name              | SKS | Value (Number) | Value (Letter) | Value (Weight) |     Predicate    |");
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+----------------+------------------+");
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            if ((gradesLetter[indexStudent][i] == null) && (predicate[indexStudent][i] == null)) {
                gradesLetter[indexStudent][i] = "-";
                predicate[indexStudent][i] = "-";
            }
            System.out.printf("| %-4d | %-18s | %-38s | %-3s | %-14d | %-14s | %-14f | %-16s |\n", (i + 1),
                    newCourse[0],
                    newCourse[1],
                    newCourse[2],
                    gradesNumeric[indexStudent][i],
                    gradesLetter[indexStudent][i],
                    equivalentValue[indexStudent][i],
                    predicate[indexStudent][i]);
        }
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+----------------+------------------+");
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    static void renderStringWithLn(String string) {
        System.out.println(string);
    }

    static void renderString(String string) {
        System.out.print(string);
    }

    static int getUserChoiceInt() {
        int choice;
        choice = userInput.nextInt();
        userInput.nextLine();
        return choice;
    }

    static String getStringLimit(int max, String string, int min) {
        String input;
        while (true) {
            renderString(string + " :");
            input = userInput.nextLine();
            if ((input.length() <= max) && (!(input.length() < min))) {

                return input;
            } else if (input.length() < min) {
                if (input.length() == 0) {
                    clearConsole();
                    renderStringWithLn(ERROR + string + " doesn't have to be empty" + RESETCOLOR);
                }
                renderStringWithLn(string + " has to be " + min + " digit");
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            } else {
                clearConsole();
                renderStringWithLn(ERROR + string + " cannot be more than " + max + " digit" + RESETCOLOR);
            }
        }
    }

    static String getNonEmptyString(String string) {
        String input;
        while (true) {
            renderString(string + " :");
            input = userInput.nextLine();
            if (input.isEmpty()) {
                clearConsole();
                renderStringWithLn(ERROR + string + " doesn't have to be empty" + RESETCOLOR);
            } else {
                return input;
            }
        }
    }

    static String specificStringLimit(String a, String string, String b, int max, int min) {
        String input;
        while (true) {
            renderString(string + " :");
            input = userInput.nextLine();
            if ((input.length() <= max) && (!(input.length() < min))) {

                if ((!input.equalsIgnoreCase(a)) && (!input.equalsIgnoreCase(b))) {
                    clearConsole();
                    renderStringWithLn(ERROR + "Wrong Input. You must input " + a + " / " + b + RESETCOLOR);
                } else {
                    return input;
                }
            } else if (input.length() < min) {
                if (input.length() == 0) {
                    clearConsole();
                    renderStringWithLn(ERROR + string + " doesn't have to be empty" + RESETCOLOR);
                }
                renderStringWithLn(string + " has to be " + min + " digit");
                renderStringWithLn(CONTINUE + "press enter to continue..." + RESETCOLOR);
                userInput.nextLine().trim();
                clearConsole();
            } else {
                clearConsole();
                renderStringWithLn(ERROR + string + " cannot be more than " + max + " digit" + RESETCOLOR);
            }
        }
    }
}