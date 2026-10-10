abstract class Employee {
    private String firstName;
    private String lastName;
    private String ssn;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public abstract double earnings();

    public String toString() {
        return String.format("%s %s\nSSN: %s", firstName, lastName, ssn);
    }
}

class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
        super(firstName, lastName, ssn);
        this.weeklySalary = weeklySalary;
    }

    public double earnings() {
        return weeklySalary;
    }

    public String toString() {
        return String.format("Salaried Employee: %s\nWeekly Salary: $%.2f", super.toString(), weeklySalary);
    }
}

class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String ssn, double wage, double hours) {
        super(firstName, lastName, ssn);
        this.wage = wage;
        this.hours = hours;
    }

    public double earnings() {
        if (hours <= 40) {
            return wage * hours;
        } else {
            return (40 * wage) + ((hours - 40) * wage * 1.5);
        }
    }

    public String toString() {
        return String.format("Hourly Employee: %s\nHourly Wage: $%.2f, Hours Worked: %.2f", 
                super.toString(), wage, hours);
    }
}

class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String ssn, double grossSales, double commissionRate) {
        super(firstName, lastName, ssn);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double earnings() {
        return grossSales * commissionRate;
    }

    public String toString() {
        return String.format("Commission Employee: %s\nGross Sales: $%.2f, Commission Rate: %.2f", 
                super.toString(), grossSales, commissionRate);
    }
}

class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String ssn, 
                                      double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, ssn, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double earnings() {
        return baseSalary + super.earnings();
    }

    public String toString() {
        return String.format("Base-Salaried %s\nBase Salary: $%.2f", super.toString(), baseSalary);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        SalariedEmployee salaried = new SalariedEmployee("Amit", "Sharma", "101", 800.00);
        HourlyEmployee hourly = new HourlyEmployee("Pooja", "Verma", "102", 16.75, 42.0);
        CommissionEmployee commission = new CommissionEmployee("Rahul", "Singh", "103", 10000.0, 0.06);
        BasePlusCommissionEmployee basePlusCommission = new BasePlusCommissionEmployee("Neha", "Patel", "104", 5000.0, 0.04, 300.00);

        Employee[] employees = new Employee[4];
        employees[0] = salaried;
        employees[1] = hourly;
        employees[2] = commission;
        employees[3] = basePlusCommission;

        System.out.println(" WEEKLY PAYROLL PROCESSING \n");

        for (Employee currentEmployee : employees) {
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee emp = (BasePlusCommissionEmployee) currentEmployee;
                emp.setBaseSalary(emp.getBaseSalary() * 1.10);
                System.out.println("[Applied 10% bonus to base salary]");
            }

            System.out.println(currentEmployee);
            System.out.printf("Earned: $%.2f\n", currentEmployee.earnings());
            System.out.println(" ");
        }
    }
}