import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private String major;

    public Student(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println("Ma SV: " + id
                + " | Ho ten: " + name
                + " | Nganh hoc: " + major);
    }
}

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== QUAN LY SINH VIEN =====");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem sinh vien");
            System.out.println("4. Xoa sinh vien");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    static void addStudent() {
        System.out.print("Nhap ma sinh vien: ");
        String id = sc.nextLine();

        System.out.print("Nhap ho va ten: ");
        String name = sc.nextLine();

        System.out.print("Nhap nganh dang hoc: ");
        String major = sc.nextLine();

        students.add(new Student(id, name, major));
        System.out.println("Them thanh cong!");
    }

    static void showStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sach sinh vien dang trong!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Nhap ma sinh vien can tim: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.println("Tim thay sinh vien:");
                s.display();
                return;
            }
        }

        System.out.println("Khong tim thay sinh vien!");
    }

    static void deleteStudent() {
        System.out.print("Nhap ma sinh vien can xoa: ");
        String id = sc.nextLine();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.remove(i);
                System.out.println("Xoa sinh vien thanh cong!");
                return;
            }
        }

        System.out.println("Khong tim thay sinh vien!");
    }
}