package Fitur;

import java.util.Scanner;

public class InputMatkul {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] coursesRti = {
                { "RTI231001", "Pancasila", "2" },
                { "RTI231002", "Konsep Teknologi Informasi", "2" },
                { "RTI231003", "Critical Thinking dan Problem Solving", "2" },
                { "RTI231004", "Matematika Dasar", "2" },
                { "RTI231005", "Dasar Pemrograman", "3" }
        };

        String[][] coursesSib = {
                { "SIB231001", "Agama", "2" },
                { "SIB231002", "Konsep Teknologi Informasi", "2" },
                { "SIB231003", "Critical Thinking dan Problem Solving", "2" },
                { "SIB231004", "Matematika Dasar", "2" },
                { "SIB231005", "Bahasa Indonesia", "3" }
        };

        int pilihProdi;
        String courseCode = null, courseName = null, sks = null;

        boolean isContinue = true;
        boolean isFind = false;

        while (isContinue) {
            System.out.println("=======================================");
            System.out.println("Pilih Program Studi :");
            System.out.println("1. Teknik Informatika");
            System.out.println("2. Sistem Informasi Bisnis");
            System.out.println("=======================================");
            System.out.print("Prodi ke- : ");
            pilihProdi = input.nextInt();
            input.nextLine();

            switch (pilihProdi) {
                case 1:
                    System.out.println("Press enter to continue");
                    input.nextLine().trim();
                    System.out.println("+------+--------------------+----------------------------------------+-----+");
                    System.out.println("| No.  |    Course Code     |               Course Name              | SKS |");
                    System.out.println("+------+--------------------+----------------------------------------+-----+");
                    for (int i = 0; i < coursesRti.length; i++) {
                        String[] CourseRti = coursesRti[i];
                        System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), CourseRti[0], CourseRti[1],
                                CourseRti[2]);
                    }
                    System.out.println("+------+--------------------+----------------------------------------+-----+");
                    if (!isFind) {
                        System.out.print("Course Code       :");
                        courseCode = input.nextLine();
                        if (courseCode.length() == 9) {
                            System.out.print("Course Name       :");
                            courseName = input.nextLine();
                            System.out.print("SKS               :");
                            sks = input.nextLine();
                            for (int i = 0; i < coursesRti.length; i++) {
                                if (courseCode.equals(coursesRti[i][0])) {
                                    System.out.println(
                                            "Course with the Course code of " + courseCode + " already exists!");
                                    System.out.println("Masukkan data kembali");
                                    isFind = false;
                                    break;
                                } else {
                                    isFind = true;
                                }
                                ;
                            }
                        } else {
                            System.out.println("Kode Mata Kuliah harus 9 digit");
                            System.out.println("Masukkan Kode Mata Kuliah lagi");
                            isContinue = true;
                            break;
                        }

                        if (isFind) {
                            String[][] newCourseRti = new String[coursesRti.length + 1][3];
                            for (int i = 0; i < coursesRti.length; i++) {
                                newCourseRti[i] = coursesRti[i];
                            }
                            newCourseRti[newCourseRti.length - 1] = new String[] { courseCode, courseName, sks };
                            coursesRti = newCourseRti;
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                            System.out.println(
                                    "| No.  |    Course Code     |               Course Name              | SKS |");
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                            for (int i = 0; i < coursesRti.length; i++) {
                                String[] CourseRti = coursesRti[i];
                                System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), CourseRti[0],
                                        CourseRti[1],
                                        CourseRti[2]);
                            }
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                        }
                    }
                    isFind = false;
                    break;
                case 2:
                    System.out.println("Press enter to continue");
                    input.nextLine().trim();
                    System.out.println("+------+--------------------+----------------------------------------+-----+");
                    System.out.println("| No.  |    Course Code     |               Course Name              | SKS |");
                    System.out.println("+------+--------------------+----------------------------------------+-----+");
                    for (int i = 0; i < coursesSib.length; i++) {
                        String[] CourseSib = coursesSib[i];
                        System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), CourseSib[0], CourseSib[1],
                                CourseSib[2]);
                    }
                    System.out.println("+------+--------------------+----------------------------------------+-----+");
                    if (!isFind) {
                        System.out.print("Course Code       :");
                        courseCode = input.nextLine();
                        if (courseCode.length() == 9) {
                            System.out.print("Course Name       :");
                            courseName = input.nextLine();
                            System.out.print("SKS               :");
                            sks = input.nextLine();
                            for (int i = 0; i < coursesSib.length; i++) {
                                if (courseCode.equals(coursesSib[i][0])) {
                                    System.out.println(
                                            "Course with the Course code of " + courseCode + " already exists!");
                                    System.out.println("Masukkan data kembali");
                                    isFind = false;
                                    break;
                                } else {
                                    isFind = true;
                                }
                                ;
                            }
                        } else {
                            System.out.println("Kode Mata Kuliah harus 9 digit");
                            System.out.println("Masukkan Kode Mata Kuliah lagi");
                            isContinue = true;
                            break;
                        }
                        if (isFind) {
                            String[][] newCourseSib = new String[coursesSib.length + 1][3];
                            for (int i = 0; i < coursesSib.length; i++) {
                                newCourseSib[i] = coursesSib[i];
                            }
                            newCourseSib[newCourseSib.length - 1] = new String[] { courseCode, courseName, sks };
                            coursesSib = newCourseSib;
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                            System.out.println(
                                    "| No.  |    Course Code     |               Course Name              | SKS |");
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");
                            for (int i = 0; i < coursesSib.length; i++) {
                                String[] CourseSib = coursesSib[i];
                                System.out.printf("| %-4d | %-18s | %-38s | %-3s |\n", (i + 1), CourseSib[0],
                                        CourseSib[1],
                                        CourseSib[2]);
                            }
                            System.out.println(
                                    "+------+--------------------+----------------------------------------+-----+");

                        }
                    }
                    isFind = false;
                    break;
            }
        }

    }
}
