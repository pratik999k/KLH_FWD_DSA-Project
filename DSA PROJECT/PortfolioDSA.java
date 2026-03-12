package ProjectDSA;
import java.util.*;

/* Linked List Node */
class Node {
    String skill;
    Node next;

    Node(String skill) {
        this.skill = skill;
        this.next = null;
    }
}

/* Linked List for Skills */
class SkillLinkedList {

    Node head;

    void addSkill(String skill) {
        Node newNode = new Node(skill);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }
    }

    void displaySkills() {
        Node temp = head;

        while (temp != null) {
            System.out.println(" - " + temp.skill);
            temp = temp.next;
        }
    }
}

public class PortfolioDSA {

    /* Bubble Sort */
    static void bubbleSort(String arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j].compareTo(arr[j + 1]) > 0) {

                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /* Stack for checking balanced symbols */
    static boolean isBalanced(String exp) {

        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {

            if (c == '(')
                stack.push(c);

            else if (c == ')') {

                if (stack.isEmpty())
                    return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== PORTFOLIO CREATOR ==========");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();
            System.out.print("Enter About: ");
            String about = sc.nextLine();   

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Education: ");
        String education = sc.nextLine();

        System.out.print("Enter Experience: ");
        String experience = sc.nextLine();

        /* Skills Input */
        System.out.print("How many skills do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        String skills[] = new String[n];
        SkillLinkedList skillList = new SkillLinkedList();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter skill " + (i + 1) + ": ");
            skills[i] = sc.nextLine();

            skillList.addSkill(skills[i]);
        }

        /* Sort skills */
        bubbleSort(skills);

        /* Projects using Queue */
        Queue<String> projects = new LinkedList<>();

        System.out.print("How many projects? ");
        int p = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < p; i++) {

            System.out.print("Enter project " + (i + 1) + ": ");
            projects.add(sc.nextLine());
        }

        /* PORTFOLIO OUTPUT */

        System.out.println("\n\n========== GENERATED PORTFOLIO ==========");

        System.out.println("\nName: " + name);
        System.out.println("Title: " + title);
        System.out.println("Email: " + email);

        System.out.println("\nABOUT");
        System.out.println("--------------------------------");
        System.out.println(about);

        System.out.println("\nEDUCATION");
        System.out.println("--------------------------------");
        System.out.println(education);

        System.out.println("\nEXPERIENCE");
        System.out.println("--------------------------------");
        System.out.println(experience);

        System.out.println("\nSKILLS (Sorted)");
        System.out.println("--------------------------------");

        for (String s : skills)
            System.out.println(" - " + s);

        System.out.println("\nPROJECTS");
        System.out.println("--------------------------------");

        while (!projects.isEmpty())
            System.out.println(" - " + projects.poll());

        /* Stack example */

        sc.nextLine();
        System.out.print("\nEnter expression to check balanced brackets: ");
        String exp = sc.nextLine();

        if (isBalanced(exp))
            System.out.println("Brackets are Balanced");
        else
            System.out.println("Brackets are NOT Balanced");

        System.out.println("\n========== END OF PORTFOLIO ==========");

        sc.close();
    }
}
