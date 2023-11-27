
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

    static String[][][] grades = new String[999][course.length][4];

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
                    renderStringWithLn("user can't be found");
                    renderStringWithLn("press enter to continue...");
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
            renderStringWithLn("incorrect username and password ");
        }
        return -1;
    }

    static void login(int choice) {
        while (true) {
            int user;
            renderStringWithLn("input username and password");
            String username = getNonEmptyString("Username"); // trim menghapus spasi di awal dan akhir string
            String password = getNonEmptyString("Password"); // trim menghapus spasi di awal dan akhir string

            if (choice == 1) {
                user = checkUsernamePassword(username, password, admin);
                if (user >= 0) {
                    dashboardAdmin(user);
                }
            } else if (choice == 2) {
                user = checkUsernamePassword(username, password, students);
                if (user >= 0) {
                    dashboardMahasiswa(user);
                }
            }
        }
    }

    static void dashboardAdmin(int user) {
        renderStringWithLn("Welcome " + admin[user][0]);
        while (true) {
            renderStringWithLn("=== Dashboard Admin ===");
            renderStringWithLn("1. Input data mahasiswa ke master");
            renderStringWithLn("2. Update data mahasiswa");
            renderStringWithLn("3. Input data mata kuliah ke master");
            renderStringWithLn("4. Input nilai");
            renderStringWithLn("5. Pencarian Mahasiswa");
            renderStringWithLn("6. Pelaporan Nilai Mahasiswa");
            renderStringWithLn("7. Logout");
            renderStringWithLn("0. Exit");
            renderString("Select Feature: ");
            int choice = getUserChoiceInt();
            switch (choice) {
                case 1:
                    clearConsole();
                    inputDataMahasiswa();
                    break;
                case 2:
                    clearConsole();
                    updateDataMahasiswa();
                    break;
                case 3:
                    clearConsole();
                    inputDataMatkul();
                    break;
                case 4:
                    clearConsole();
                    inputNilai();
                    break;
                case 5:
                    clearConsole();
                    pencarian();
                    break;
                case 6:
                    clearConsole();
                    pelaporanNilai();
                    break;
                case 7:
                    clearConsole();
                    loginView();
                    break;
                case 0:
                    System.exit(choice);
                default:
                    clearConsole();
                    renderStringWithLn("Feature is not available");
                    renderStringWithLn("press enter to continue...");
                    userInput.nextLine().trim();
                    clearConsole();
            }
        }
    }

    static void inputDataMahasiswa() {
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
            sex = getStringLimit(1, "sex", 1).toUpperCase();
            for (int i = 0; i < students.length; i++) {
                if (nim.equals(students[i][0])) {
                    clearConsole();
                    renderStringWithLn("Student with the NIM of " + nim + " already exists!");
                    renderStringWithLn("Input Data again");
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
                renderStudentsTable("Data's Student", students);
                renderStringWithLn("press enter to continue...");
                userInput.nextLine().trim();
                clearConsole();
            }
        }
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

    static void pencarian() {
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
                } else if (nimInput.equals(students[i][0])) {
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
                renderStringWithLn("press enter to continue...");
                userInput.nextLine().trim();
                clearConsole();
            } else {
                renderStringWithLn("Student with the NIM of " + nimInput + " doesn't exists!");
                renderStringWithLn("Input Data again");
            }

        }
    }

    static void inputDataMatkul() {
        String courseCode, courseName, sks;
        boolean isFind = false;
        renderStringWithLn("Press enter to continue...");
        userInput.nextLine().trim();
        clearConsole();
        renderCourseTable("Course data", course);
        while (!isFind) {
            courseCode = getStringLimit(9, "Course Code", 9);
            courseName = getNonEmptyString("Course Name");
            sks = getStringLimit(1, "sks", 1);

            for (int i = 0; i < course.length; i++) {
                if (courseCode.equals(course[i][0])) {
                    clearConsole();
                    renderStringWithLn("Course with the Course code of " + courseCode + " already exists!");
                    renderStringWithLn("Input Data again");
                    isFind = false;
                    break;
                } else {
                    isFind = true;
                }
                ;
            }

            if (isFind) {
                String[][] newCourse = new String[course.length + 1][3];
                for (int i = 0; i < course.length; i++) {
                    newCourse[i] = course[i];
                }
                newCourse[newCourse.length - 1] = new String[] { courseCode, courseName, sks };
                course = newCourse;

                String[][][] newGrades = new String[999][course.length][4];
                for (int i = 0; i < grades.length; i++) {
                    for (int j = 0; j < grades[0].length; j++) {
                        newGrades[i][j] = grades[i][j];
                    }
                }
                grades = newGrades;

                renderCourseTable("Course data", course);
                renderStringWithLn("press enter to continue...");
                userInput.nextLine().trim();
                clearConsole();
            }
        }
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

    static void dashboardMahasiswa(int user) {
        renderStringWithLn("Welcome " + students[user][1]);
        while (true) {
            renderStringWithLn("=== Dashboard Mahasiswa ===");
            renderStringWithLn("1. Profile");
            renderStringWithLn("2. Cetak KHS");
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
                    cetakKHS();
                    break;
                case 3:
                    clearConsole();
                    loginView();
                    break;
                case 0:
                    System.exit(choice);
                default:
                    clearConsole();
                    renderStringWithLn("Feature is not available");
                    renderStringWithLn("press enter to continue...");
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
        renderStringWithLn("press enter to continue...");
        userInput.nextLine().trim();
    }

    static void cetakKHS() {

    }

    static void inputNilai() {
        String nim = "";
        int indexStudent = -1;

        while (indexStudent == -1) {
            nim = getNonEmptyString("Student NIM");
            for (int i = 0; i < students.length; i++) {
                if (nim.equalsIgnoreCase(students[i][0])) {
                    indexStudent = i;
                    renderStringWithLn("Data found");
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
                    renderStringWithLn("press enter to continue...");
                    userInput.nextLine().trim();
                    clearConsole();
                    break;
                }
            }
            if (indexStudent == -1) {
                renderStringWithLn("Data is not found. Try again");
            }
        }

        renderValueTable("Value's Data", indexStudent, course, grades);
        renderStringWithLn("press enter to continue...");
        userInput.nextLine().trim();
        clearConsole();

        for (int i = 0; i < course.length; i++) {
            if (grades[indexStudent][i][0] == "-") {
                while (i < course.length) {
                    int numericValue;
                    while (true) {
                        System.out.print("Nilai matkul " + course[i][1] + " : ");
                        numericValue = userInput.nextInt();
                        userInput.nextLine();
                        if (numericValue < 0 || numericValue > 100) {
                            renderStringWithLn("The value must be in the range 1-100. Please try again.....");
                            renderStringWithLn("press enter to continue...");
                            userInput.nextLine().trim();
                            clearConsole();
                        } else {
                            break;
                        }
                    }
                    String letterValue;
                    String predicate = "";
                    double equivalentValue = 0.0;
                    if (numericValue > 80 && numericValue <= 100) {
                        letterValue = "A";
                        predicate = "Exellent";
                        equivalentValue = 4;
                    } else if (numericValue > 73 && numericValue <= 80) {
                        letterValue = "B+";
                        predicate = "Very Good";
                        equivalentValue = 3.5;
                    } else if (numericValue > 65 && numericValue <= 73) {
                        letterValue = "B";
                        predicate = "Good";
                        equivalentValue = 3;
                    } else if (numericValue > 60 && numericValue <= 65) {
                        letterValue = "C+";
                        predicate = "Above Avarage";
                        equivalentValue = 2.5;
                    } else if (numericValue > 50 && numericValue <= 60) {
                        letterValue = "C";
                        predicate = "Avarage";
                        equivalentValue = 2;
                    } else if (numericValue > 39 && numericValue <= 50) {
                        letterValue = "D";
                        predicate = "Below Avarage";
                        equivalentValue = 1;
                    } else if (numericValue > 0 && numericValue <= 39) {
                        letterValue = "E";
                        predicate = "Fail";
                        equivalentValue = 0;
                    } else {
                        letterValue = "Not Available";
                    }
                    grades[indexStudent][i][0] = String.valueOf(numericValue);
                    grades[indexStudent][i][1] = letterValue;
                    grades[indexStudent][i][2] = Double.toString(equivalentValue);
                    grades[indexStudent][i][3] = predicate;
                    i++;
                }
            }
        }

        renderString("\n");

        renderStringWithLn("-------------------------------------");
        renderStringWithLn("|          Data mahasiswa           |");
        renderStringWithLn("-------------------------------------");
        renderStringWithLn("| Nama        : " + students[indexStudent][1]);
        renderStringWithLn("| NIM         : " + students[indexStudent][0]);
        renderStringWithLn("-------------------------------------");

        renderValueTable("Value's Table", indexStudent, course, grades);
        renderStringWithLn("press enter to continue...");
        userInput.nextLine().trim();
        clearConsole();

    }

    static void renderValueTable(String title, int indexStudent, String[][] course, String[][][] value) {
        renderStringWithLn(title);
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+----------------+------------------+");
        renderStringWithLn(
                "| No.  |    Course Code     |               Course Name              | SKS | Value (Number) | Value (Letter) | Value (Weight) |     Predicate    |");
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+----------------+------------------+");
        for (int i = 0; i < course.length; i++) {
            String[] newCourse = course[i];
            String[] values = value[indexStudent][i];
            for (int j = 0; j < values.length; j++) {
                if (values[j] == null) {
                    values[j] = "-";
                }
            }
            System.out.printf("| %-4d | %-18s | %-38s | %-3s | %-14s | %-14s | %-14s | %-16s |\n", (i + 1), newCourse[0],
                    newCourse[1],
                    newCourse[2], 
                    values[0], 
                    values[1], 
                    values[2],
                    values[3]);
                    
        }
        renderStringWithLn(
                "+------+--------------------+----------------------------------------+-----+----------------+----------------+----------------+------------------+");
    }

    static void updateDataMahasiswa() {
        String oldNim, fullName, classPlacement, studyProgram;
        boolean isFind = false;
        int studentIndex = -1;
        renderStringWithLn("press enter to continue...");
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
                renderStringWithLn("Students have been succesfully added!");
                renderStudentsTable("Data's Student", students);
                renderStringWithLn("press enter to continue...");
                userInput.nextLine().trim();
                clearConsole();
            } else {
                renderStringWithLn("Student with the NIM of " + oldNim + " doesn't exists!");
                renderStringWithLn("Input data again");
                renderStringWithLn("press enter to continue...");
                userInput.nextLine().trim();
                clearConsole();
            }
        }
    }

    static void pelaporanNilai() {

        // pelaporan nilai mahasiswa

        renderStringWithLn("-------------------------------------");
        renderStringWithLn("|      Laporan Nilai Mahasiswa       |");
        renderStringWithLn("-------------------------------------");

        renderStringWithLn(
                "\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-10s | %-17s | %-7s | %-22s |", "NIM", "Nama", "Kelas", "Program Studi");

        // Untuk menampilkan jadwal mata kuliah
        for (int j = 0; j < course.length; j++) {
            System.out.format(" %-10s |", course[j][1]);
        }

        renderStringWithLn(
                "\n-------------------------------------------------------------------------------------------------------------------------------------------------------");

        // untuk menampilkan kolom
        for (int i = 0; i < students.length; i++) {
            System.out.format("| %-10s | %-17s | %-7s | %-22s |",
                    students[i][0], students[i][1], students[i][2], students[i][3], students[i][4]);

            // menampilkan nilai
            for (int j = 0; j < course.length; j++) {
                String grade = grades[i][j][0];
                String comment = grades[i][j][1];

                if (grade == null) {
                    System.out.format(" %-10s |", "-");
                } else {
                    System.out.format(" %-10s |", grade + " (" + comment + ")");
                }
            }
            renderStringWithLn(
                    "\n-------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        renderStringWithLn("");

        renderStringWithLn("press enter to continue...");
        userInput.nextLine().trim();
        clearConsole();

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
                    renderStringWithLn(string + " doesn't have to be empty");
                }
                renderStringWithLn(string + " has to be " + min + " digit");
                renderStringWithLn("press enter to continue...");
                userInput.nextLine().trim();
                clearConsole();
            } else {
                clearConsole();
                renderStringWithLn(string + " cannot be more than " + max + " digit");
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
                renderStringWithLn(string + " doesn't have to be empty");
            } else {
                return input;
            }
        }
    }
}
