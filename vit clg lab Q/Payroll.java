import java.util.Scanner;

class Employee {
    int empId;
    String empname;
    String gender;
    double basicSalary;
    int allowances;
    int deductions;
    double netPay;

    public void Data() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        empId = sc.nextInt();
        System.out.print("Enter Name: ");
        empname = sc.next();
        System.out.print("Enter Gender: ");
        gender = sc.next();
        System.out.print("Enter Basic Salary: ");
        basicSalary = sc.nextDouble();
        System.out.print("Enter Allowances: ");
        allowances = sc.nextInt();
        System.out.print("Enter Deduction: ");
        deductions = sc.nextInt();
    }

    public void Calculate() {
        netPay = basicSalary + allowances - deductions;
    }

    public void Result() {
        
        if (gender.equals("Male")) {
            System.out.println("Mr." + empname + " is drawing Rs." + (int) netPay + "/- as an net pay");
        } else {
            System.out.println("Ms." + empname + " is drawing Rs." + (int) netPay + "/- as an net pay");
        }
    }
}
public class Payroll{
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.Data();
        emp.Calculate();
        System.out.println();
        emp.Result();
    }
}
