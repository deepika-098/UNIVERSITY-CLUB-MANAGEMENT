import java.util.*;

class Member {
    int id;
    String name;
    String department;
    String role;

    Member(int id, String name, String department, String role) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + role;
    }
}

public class Main {
    static ArrayList<Member> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- University Club Management ---");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Update Member");
            System.out.println("4. Delete Member");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addMember(); break;
                case 2: viewMembers(); break;
                case 3: updateMember(); break;
                case 4: deleteMember(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void addMember() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Role (e.g., President, Member): ");
        String role = sc.nextLine();

        members.add(new Member(id, name, dept, role));
        System.out.println("✅ Member added successfully!");
    }

    static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found!");
            return;
        }
        System.out.println("\nID | Name | Department | Role");
        for (Member m : members) {
            System.out.println(m);
        }
    }

    static void updateMember() {
        System.out.print("Enter Member ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Member m : members) {
            if (m.id == id) {
                System.out.print("Enter new Name: ");
                m.name = sc.nextLine();
                System.out.print("Enter new Department: ");
                m.department = sc.nextLine();
                System.out.print("Enter new Role: ");
                m.role = sc.nextLine();
                System.out.println("✅ Member updated!");
                return;
            }
        }
        System.out.println("❌ Member not found!");
    }

    static void deleteMember() {
        System.out.print("Enter Member ID to delete: ");
        int id = sc.nextInt();
        Iterator<Member> itr = members.iterator();
        while (itr.hasNext()) {
            if (itr.next().id == id) {
                itr.remove();
                System.out.println("✅ Member deleted!");
                return;
            }
        }
        System.out.println("❌ Member not found!");
    }
}
