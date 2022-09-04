import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class LunarSystem {
    private static HashMap<String, Student> database = new HashMap<>();

    public static void main(String[] args) {
        FileInputStream file;
        ObjectInputStream inStream;

        try {
            file = new FileInputStream("Lunar.ser");
            inStream = new ObjectInputStream(file);
            database = (HashMap<String, Student>) inStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Lunar.ser file not found. Initializing empty database.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        String x = "REGISTRAR";
        Scanner stdin = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("\n" +
                    "Menu:\n" +
                    "\n" +
                    "    L)Login\n" +
                    "\n" +
                    "    X)Save state and quit\n" +
                    "\n" +
                    "    Q)Quit without saving state.");
            System.out.println();

            System.out.println("Please enter an option: ");
            String a = stdin.nextLine().toUpperCase();
            if (a.equals("L")) {
                System.out.println("Enter WebID: ");

                String c = stdin.nextLine().toUpperCase();
                if (c.equals(x)) {
                    System.out.println("\n" +
                            "Welcome Registrar.\n" +
                            "\n" +
                            "\n" +
                            "Options:\n" +
                            "\n" +
                            "     R) Register a student\n" +
                            "\n" +
                            "     D) De-register a student\n" +
                            "\n" +
                            "     E) View course enrollment\n" +
                            "\n" +
                            "     L) Logout");

                    String d;
                    do {
                        System.out.println("Please select an option: ");
                        d = stdin.nextLine().toUpperCase();
                        switch (d) {
                            case "R":

                                System.out.println("Please enter a webID for the new student: ");
                                String e = stdin.nextLine().toUpperCase();
                                Student student = new Student(e);
                                database.put(e,student);

                                System.out.println(e + " is registered");



                                break;

                            case "D":
                                System.out.println("Please enter student's webID: ");
                                String f = stdin.nextLine().toUpperCase();
                                database.remove(f);
                                System.out.println(f + " has been removed ");
                                break;

                            case "E":
                                System.out.println("Please enter course name");
                                String g = stdin.nextLine();
                                for (Map.Entry mapElement : database.entrySet()) {
                                    Student student1 = (Student) mapElement.getValue();
                                    String finalG = g;
                                    for(Course course: student1.getCourses()) {
                                        if(g.equalsIgnoreCase(course.getDepartment() + " " + course.getNumber())) {
                                            g = (String) mapElement.getKey();
                                            System.out.println("Students in "+ g.toString());

                                            System.out.println(g);
                                            break;
                                        }
                                    }
                                }

                                break;

                            case "L":
                                break;

                        }
                    } while (!d.equals("L"));

                } else if (database.containsKey(c)) {
                    System.out.println("Welcome " + c.toString() + "\n" +
                            "\n" +
                            "\n" +
                            "Options:\n" +
                            "\n" +
                            "    A)Add a class\n" +
                            "\n" +
                            "    D)Drop a class\n" +
                            "\n" +
                            "    C)View your classes sorted by course name/department\n" +
                            "\n" +
                            "    S)View your courses sorted by semester\n" +
                            "\n" +
                            "    Q)Quit");
                    String g;
                    do {
                        System.out.println("Please select an option: ");
                        g = stdin.nextLine().toUpperCase();
                        switch (g) {
                            case "A":
                                System.out.println("Please enter a course name: ");
                                String h = stdin.nextLine();
                                String[] strings = h.split(" ");
                                String index0 = strings[0];
                                int index1 = Integer.parseInt(strings[1]);
                                System.out.println("Please select a semester: ");
                                String i = stdin.nextLine();
                                Course course = new Course(index0, index1, i);
                                if (database.containsKey(c)) {
                                    database.get(c).getCourses().add(course);
                                    System.out.println(h.toString() + " added in " + i.toString());
                                } else {
                                    System.out.println("Invalid student");
                                }


                                break;

                            case "D":
                                System.out.println("Please enter the course name: ");
                                String z = stdin.nextLine();

                                List<Course> courseList = database.get(c).getCourses();

                                database.get(c).setCourses(new ArrayList<>(
                                        courseList.stream()
                                                .filter(course1 -> !z.equalsIgnoreCase(course1.getDepartment()  + " " + course1.getNumber()))
                                                .collect(Collectors.toList()))
                                );

                                break;

                            case "C":
                                System.out.println("Dept. Course Semester " + "\n" + "-------------------------------");
                                database.get(c).printCourses();

                                break;

                            case "S":
                                System.out.println("Dept. Course Semester " + "\n" + "-------------------------------");
                                database.get(c).printSemeseter();

                                break;

                        }
                    } while (!g.equals("Q"));
                }
            }
            if (a.equals("X")) {
                FileOutputStream outFile = null;
                ObjectOutputStream outStream = null;

                try {
                    outFile = new FileOutputStream("Lunar.ser");
                    outStream = new ObjectOutputStream(outFile);
                    outStream.writeObject(database);
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                check = false;
            }
            if (a.equals("Q")) {
                check = false;

            }
        }
    }
}







