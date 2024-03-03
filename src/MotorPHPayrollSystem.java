import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MotorPHPayrollSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static ManagementSystem managementSystem = new ManagementSystem(scanner);
    private static List<Employee> registeredEmployees = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            // Display main menu
            System.out.println("Welcome to the MotorPH");

            System.out.println("1. Login");
            System.out.println("2. Forgot Password");
            System.out.println("3. Create New Account");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    login();
                    break;

                case 2:
                    forgotPassword();
                    break;

                case 3:
                    createNewAccount();
                    break;

                case 4:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }

    private static void login() {
        // User login
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Validate login
        if (validateLogin(email, password)) {
            System.out.println("Login successful");
            // After successful login, redirect to the management system
            managementSystem.runManagement(email);
        } else {
            System.out.println("Invalid credentials");
        }
    }

    private static void createNewAccount() {
        // Create a new employee account
        System.out.print("Enter your Employee ID: ");
        String employeeId = scanner.nextLine();
        System.out.print("Enter your Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your Birthday: ");
        String birthday = scanner.nextLine();
        System.out.print("Enter your Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter your SSS Number: ");
        String sssNumber = scanner.nextLine();
        System.out.print("Enter your Philhealth Number: ");
        String philhealthNumber = scanner.nextLine();
        System.out.print("Enter your TIN Number: ");
        String tinNumber = scanner.nextLine();
        System.out.print("Enter your Pag-ibig Number: ");
        String pagibigNumber = scanner.nextLine();
        System.out.print("Enter your Status: ");
        String status = scanner.nextLine();
        System.out.print("Enter your Position: ");
        String position = scanner.nextLine();
        System.out.print("Enter your Immediate Supervisor: ");
        String immediateSupervisor = scanner.nextLine();
        System.out.print("Enter your Basic Salary: ");
        double basicSalary = scanner.nextDouble();
        System.out.print("Enter your Rice Subsidy: ");
        double riceSubsidy = scanner.nextDouble();
        System.out.print("Enter your Phone Allowance: ");
        double phoneAllowance = scanner.nextDouble();
        System.out.print("Enter your Clothing Allowance: ");
        double clothingAllowance = scanner.nextDouble();
        System.out.print("Enter your Gross Semi-monthly Rate: ");
        double grossSemiMonthlyRate = scanner.nextDouble();
        System.out.print("Enter your Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();

        // Consume the newline character
        scanner.nextLine();

        // Assuming you want to use the email and password for login
        System.out.print("Enter your Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        // Create a new employee account
        Employee newEmployee = new Employee(email, password, employeeId, lastName, firstName, birthday, address, phoneNumber,
                sssNumber, philhealthNumber, tinNumber, pagibigNumber, status, position, immediateSupervisor,
                basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate);

        registeredEmployees.add(newEmployee);

        System.out.println("Account created for " + firstName + " " + lastName);
    }

    private static void forgotPassword() {
        // Forgot password functionality
        System.out.print("Enter your email to reset password: ");
        String resetEmail = scanner.nextLine();

        // Find the user with the provided email using ManagementSystem's findEmployeeByEmail
        Employee user = managementSystem.findEmployeeByEmail(resetEmail);

        if (user != null) {
            // Prompt the user to enter a new password
            System.out.print("Enter a new password: ");
            String newPassword = scanner.nextLine();

            // Set the new password for the user using ManagementSystem's setPassword
            managementSystem.setPassword(user, newPassword);

            System.out.println("Password reset successfully for " + resetEmail);
        } else {
            System.out.println("User not found. Please check your email.");
        }
    }


    private static boolean validateLogin(String email, String password) {
        // Validate user login credentials
        // For demonstration purposes, let's assume a simple check with predefined credentials
        return registeredEmployees.stream()
                .anyMatch(employee -> employee.getEmail().equals(email) && employee.getPassword().equals(password));
    }

    static class Employee {

        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String employeeId;
        private String birthday;
        private String address;
        private String phoneNumber;
        private String sssNumber;
        private String philhealthNumber;
        private String tinNumber;
        private String pagibigNumber;
        private String status;
        private String position;
        private String immediateSupervisor;
        private double basicSalary;
        private double riceSubsidy;
        private double phoneAllowance;
        private double clothingAllowance;
        private double grossSemiMonthlyRate;
        private double hourlyRate;

        public Employee(String email, String password, String employeeId, String lastName, String firstName,
                        String birthday, String address, String phoneNumber, String sssNumber, String philhealthNumber,
                        String tinNumber, String pagibigNumber, String status, String position,
                        String immediateSupervisor, double basicSalary, double riceSubsidy,
                        double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate) {

            this.email = email;
            this.password = password;
            this.employeeId = employeeId;
            this.lastName = lastName;
            this.firstName = firstName;
            this.birthday = birthday;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.sssNumber = sssNumber;
            this.philhealthNumber = philhealthNumber;
            this.tinNumber = tinNumber;
            this.pagibigNumber = pagibigNumber;
            this.status = status;
            this.position = position;
            this.immediateSupervisor = immediateSupervisor;
            this.basicSalary = basicSalary;
            this.riceSubsidy = riceSubsidy;
            this.phoneAllowance = phoneAllowance;
            this.clothingAllowance = clothingAllowance;
            this.grossSemiMonthlyRate = grossSemiMonthlyRate;
            this.hourlyRate = hourlyRate;
        }

        public String getEmail() {
            return email;
        }

        public void setPassword(String newPassword) {
            this.password = newPassword;
        }
        public String getPassword() {
            return password;
        }
        public String getLastName() {
            return lastName;
        }
        public String getFirstName() {
            return firstName;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getAddress() {
            return address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getSssNumber() {
            return sssNumber;
        }

        public String getPhilhealthNumber() {
            return philhealthNumber;
        }

        public String getTinNumber() {
            return tinNumber;
        }

        public String getPagibigNumber() {
            return pagibigNumber;
        }

        public String getStatus() {
            return status;
        }

        public String getPosition() {
            return position;
        }

        public String getImmediateSupervisor() {
            return immediateSupervisor;
        }

        public double getBasicSalary() {
            return basicSalary;
        }

        public double getRiceSubsidy() {
            return riceSubsidy;
        }

        public double getPhoneAllowance() {
            return phoneAllowance;
        }

        public double getClothingAllowance() {
            return clothingAllowance;
        }

        public double getGrossSemiMonthlyRate() {
            return grossSemiMonthlyRate;
        }

        public double getHourlyRate() {
            return hourlyRate;
        }
        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setSssNumber(String sssNumber) {
            this.sssNumber = sssNumber;
        }

        public void setPhilhealthNumber(String philhealthNumber) {
            this.philhealthNumber = philhealthNumber;
        }

        public void setTinNumber(String tinNumber) {
            this.tinNumber = tinNumber;
        }

        public void setPagibigNumber(String pagibigNumber) {
            this.pagibigNumber = pagibigNumber;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setImmediateSupervisor(String immediateSupervisor) {
            this.immediateSupervisor = immediateSupervisor;
        }

        public void setBasicSalary(double basicSalary) {
            this.basicSalary = basicSalary;
        }

        public void setRiceSubsidy(double riceSubsidy) {
            this.riceSubsidy = riceSubsidy;
        }

        public void setPhoneAllowance(double phoneAllowance) {
            this.phoneAllowance = phoneAllowance;
        }

        public void setClothingAllowance(double clothingAllowance) {
            this.clothingAllowance = clothingAllowance;
        }

        public void setGrossSemiMonthlyRate(double grossSemiMonthlyRate) {
            this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        }

        public void setHourlyRate(double hourlyRate) {
            this.hourlyRate = hourlyRate;
        }
    }

    static class ManagementSystem {
        private Scanner scanner;

        public ManagementSystem(Scanner scanner) {
            this.scanner = scanner;
        }

        // Make the setPassword method public
        public void setPassword(Employee user, String newPassword) {
            user.setPassword(newPassword);
        }

        public void runManagement(String loggedInEmail) {
            boolean exit = false;

            while (!exit) {
                // Display management system menu
                System.out.println("HOME");
                System.out.println("1. My Profile");
                System.out.println("2. View Payslip");
                System.out.println("3. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        myProfile(loggedInEmail);
                        break;

                    case 2:
                        // View payslip functionality
                        viewPayslip(loggedInEmail);
                        break;

                    case 3:
                        // Logout
                        exit = true;
                        System.out.println("Logging out...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }
        }

        private void myProfile(String loggedInEmail) {
            // Display extended user's profile information
            Employee loggedInEmployee = findEmployeeByEmail(loggedInEmail);
            if (loggedInEmployee != null) {
                System.out.println("My Profile for " + loggedInEmail);
                System.out.println("Employee ID: " + loggedInEmployee.getEmployeeId());
                System.out.println("Last Name: " + loggedInEmployee.getLastName());
                System.out.println("First Name: " + loggedInEmployee.getFirstName());
                System.out.println("Birthday: " + loggedInEmployee.getBirthday());
                System.out.println("Address: " + loggedInEmployee.getAddress());
                System.out.println("Phone Number: " + loggedInEmployee.getPhoneNumber());
                System.out.println("SSS Number: " + loggedInEmployee.getSssNumber());
                System.out.println("Philhealth Number: " + loggedInEmployee.getPhilhealthNumber());
                System.out.println("TIN Number: " + loggedInEmployee.getTinNumber());
                System.out.println("Pag-ibig Number: " + loggedInEmployee.getPagibigNumber());
                System.out.println("Status: " + loggedInEmployee.getStatus());
                System.out.println("Position: " + loggedInEmployee.getPosition());
                System.out.println("Immediate Supervisor: " + loggedInEmployee.getImmediateSupervisor());
                System.out.println("Basic Salary: " + loggedInEmployee.getBasicSalary());
                System.out.println("Rice Subsidy: " + loggedInEmployee.getRiceSubsidy());
                System.out.println("Phone Allowance: " + loggedInEmployee.getPhoneAllowance());
                System.out.println("Clothing Allowance: " + loggedInEmployee.getClothingAllowance());
                System.out.println("Gross Semi-monthly Rate: " + loggedInEmployee.getGrossSemiMonthlyRate());
                System.out.println("Hourly Rate: " + loggedInEmployee.getHourlyRate());
                System.out.println("\nOptions:");
                System.out.println("1. Edit My Profile");
                System.out.println("2. Go Back");
                System.out.print("Choose an option: ");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        editMyProfile(loggedInEmployee);
                        break;
                    case 2:
                        // Go back (do nothing)
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } else {
                System.out.println("Employee not found.");
            }
        }

        private void editMyProfile(Employee loggedInEmployee) {
            // Allow the user to edit profile information
            System.out.println("Editing My Profile for " + loggedInEmployee.getFirstName() + " " + loggedInEmployee.getLastName());

            // Display edit options
            System.out.println("Options:");
            System.out.println("1. Edit Employee ID");
            System.out.println("2. Edit Last Name");
            System.out.println("3. Edit First Name");
            System.out.println("4. Edit Birthday");
            System.out.println("5. Edit Address");
            System.out.println("6. Edit Phone Number");
            System.out.println("7. Edit SSS Number");
            System.out.println("8. Edit Philhealth Number");
            System.out.println("9. Edit TIN Number");
            System.out.println("10. Edit Pag-ibig Number");
            System.out.println("11. Edit Status");
            System.out.println("12. Edit Position");
            System.out.println("13. Edit Immediate Supervisor");
            System.out.println("14. Edit Basic Salary");
            System.out.println("15. Edit Rice Subsidy");
            System.out.println("16. Edit Phone Allowance");
            System.out.println("17. Edit Clothing Allowance");
            System.out.println("18. Edit Gross Semi-monthly Rate");
            System.out.println("19. Edit Hourly Rate");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter new Employee ID: ");
                    String newEmployeeId = scanner.nextLine();
                    loggedInEmployee.setEmployeeId(newEmployeeId);
                    break;
                case 2:
                    System.out.print("Enter new Last Name: ");
                    String newLastName = scanner.nextLine();
                    loggedInEmployee.setLastName(newLastName);
                    break;
                case 3:
                    System.out.print("Enter new First Name: ");
                    String newFirstName = scanner.nextLine();
                    loggedInEmployee.setFirstName(newFirstName);
                    break;
                case 4:
                    System.out.print("Enter new Birthday: ");
                    String newBirthday = scanner.nextLine();
                    loggedInEmployee.setBirthday(newBirthday);
                    break;
                case 5:
                    System.out.print("Enter new Address: ");
                    String newAddress = scanner.nextLine();
                    loggedInEmployee.setAddress(newAddress);
                    break;
                case 6:
                    System.out.print("Enter new Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    loggedInEmployee.setPhoneNumber(newPhoneNumber);
                    break;
                case 7:
                    System.out.print("Enter new SSS Number: ");
                    String newSssNumber = scanner.nextLine();
                    loggedInEmployee.setSssNumber(newSssNumber);
                    break;
                case 8:
                    System.out.print("Enter new Philhealth Number: ");
                    String newPhilhealthNumber = scanner.nextLine();
                    loggedInEmployee.setPhilhealthNumber(newPhilhealthNumber);
                    break;
                case 9:
                    System.out.print("Enter new TIN Number: ");
                    String newTinNumber = scanner.nextLine();
                    loggedInEmployee.setTinNumber(newTinNumber);
                    break;
                case 10:
                    System.out.print("Enter new Pag-ibig Number: ");
                    String newPagibigNumber = scanner.nextLine();
                    loggedInEmployee.setPagibigNumber(newPagibigNumber);
                    break;
                case 11:
                    System.out.print("Enter new Status: ");
                    String newStatus = scanner.nextLine();
                    loggedInEmployee.setStatus(newStatus);
                    break;
                case 12:
                    System.out.print("Enter new Position: ");
                    String newPosition = scanner.nextLine();
                    loggedInEmployee.setPosition(newPosition);
                    break;
                case 13:
                    System.out.print("Enter new Immediate Supervisor: ");
                    String newImmediateSupervisor = scanner.nextLine();
                    loggedInEmployee.setImmediateSupervisor(newImmediateSupervisor);
                    break;
                case 14:
                    System.out.print("Enter new Basic Salary: ");
                    double newBasicSalary = scanner.nextDouble();
                    loggedInEmployee.setBasicSalary(newBasicSalary);
                    break;
                case 15:
                    System.out.print("Enter new Rice Subsidy: ");
                    double newRiceSubsidy = scanner.nextDouble();
                    loggedInEmployee.setRiceSubsidy(newRiceSubsidy);
                    break;
                case 16:
                    System.out.print("Enter new Phone Allowance: ");
                    double newPhoneAllowance = scanner.nextDouble();
                    loggedInEmployee.setPhoneAllowance(newPhoneAllowance);
                    break;
                case 17:
                    System.out.print("Enter new Clothing Allowance: ");
                    double newClothingAllowance = scanner.nextDouble();
                    loggedInEmployee.setClothingAllowance(newClothingAllowance);
                    break;
                case 18:
                    System.out.print("Enter new Gross Semi-monthly Rate: ");
                    double newGrossSemiMonthlyRate = scanner.nextDouble();
                    loggedInEmployee.setGrossSemiMonthlyRate(newGrossSemiMonthlyRate);
                    break;
                case 19:
                    System.out.print("Enter new Hourly Rate: ");
                    double newHourlyRate = scanner.nextDouble();
                    loggedInEmployee.setHourlyRate(newHourlyRate);
                    break;

                default:
                    System.out.println("Invalid option");
            }

            System.out.println("Profile updated successfully!");
            displayProfile(loggedInEmployee);
            // Go back to the main profile menu
            myProfile(loggedInEmployee.getEmail());
        }

        private void displayProfile(Employee loggedInEmployee) {
            // Display the updated profile information
            System.out.println("\nUpdated Profile Information:");
            System.out.println("Employee ID: " + loggedInEmployee.getEmployeeId());
            System.out.println("Last Name: " + loggedInEmployee.getLastName());
            System.out.println("First Name: " + loggedInEmployee.getFirstName());
            System.out.println("Birthday: " + loggedInEmployee.getBirthday());
            System.out.println("Address: " + loggedInEmployee.getAddress());
            System.out.println("Phone Number: " + loggedInEmployee.getPhoneNumber());
            System.out.println("SSS Number: " + loggedInEmployee.getSssNumber());
            System.out.println("Philhealth Number: " + loggedInEmployee.getPhilhealthNumber());
            System.out.println("TIN Number: " + loggedInEmployee.getTinNumber());
            System.out.println("Pag-ibig Number: " + loggedInEmployee.getPagibigNumber());
            System.out.println("Status: " + loggedInEmployee.getStatus());
            System.out.println("Position: " + loggedInEmployee.getPosition());
            System.out.println("Immediate Supervisor: " + loggedInEmployee.getImmediateSupervisor());
            System.out.println("Basic Salary: " + loggedInEmployee.getBasicSalary());
            System.out.println("Rice Subsidy: " + loggedInEmployee.getRiceSubsidy());
            System.out.println("Phone Allowance: " + loggedInEmployee.getPhoneAllowance());
            System.out.println("Clothing Allowance: " + loggedInEmployee.getClothingAllowance());
            System.out.println("Gross Semi-monthly Rate: " + loggedInEmployee.getGrossSemiMonthlyRate());
            System.out.println("Hourly Rate: " + loggedInEmployee.getHourlyRate());
        }


        private void viewPayslip(String loggedInEmail) {
            boolean exit = false;

            while (!exit) {
                // Display view payslip menu
                System.out.println("VIEW PAYSLIP");
                System.out.println("1. Calculate Hours of Work");
                System.out.println("2. Weekly Salary Based on Hours Worked");
                System.out.println("3. Overall Payslip");
                System.out.println("4. Back");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        calculateHoursOfWork(findEmployeeByEmail(loggedInEmail));
                        break;
                    case 2:
                        weeklySalaryBasedOnHoursWorked(findEmployeeByEmail(loggedInEmail));
                        break;
                    case 3:
                        overallPayslip(findEmployeeByEmail(loggedInEmail));
                        break;
                    case 4:
                        // Back to the main menu
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }

        private void calculateHoursOfWork(Employee loggedInEmployee) {
            Scanner scanner = new Scanner(System.in);

            double totalHoursWorked = 0.0;
            int totalDaysWorked = 0;

            boolean continueInput = true;
            while (continueInput) {
                // Get user input for date, time-in, and time-out
                System.out.print("Enter date (MM/dd/yyyy): ");
                String dateInput = scanner.nextLine();
                System.out.print("Enter time-in (HH:mm): ");
                String timeInInput = scanner.nextLine();
                System.out.print("Enter time-out (HH:mm): ");
                String timeOutInput = scanner.nextLine();

                // Parse date and time
                try {
                    String dateTimeInStr = dateInput + " " + timeInInput + ":00";
                    String dateTimeOutStr = dateInput + " " + timeOutInput + ":00";

                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    Date dateTimeIn = dateFormat.parse(dateTimeInStr);
                    Date dateTimeOut = dateFormat.parse(dateTimeOutStr);

                    // Calculate hours worked for this session
                    double hoursWorked = (dateTimeOut.getTime() - dateTimeIn.getTime()) / (1000.0 * 60.0 * 60.0);

                    // Add to the total hours worked
                    totalHoursWorked += hoursWorked;

                    // Increment the total days worked
                    totalDaysWorked++;

                    // Display the result for this session
                    System.out.println("Hours worked for this session: " + hoursWorked + " hours");

                    // Ask if the user wants to continue inputting data
                    System.out.print("Do you want to continue inputting data? (yes/no): ");
                    String continueInputStr = scanner.nextLine();
                    continueInput = continueInputStr.equalsIgnoreCase("yes");
                } catch (ParseException e) {
                    System.out.println("Invalid date or time format. Please try again.");
                }
            }

            // Display the total hours worked and total days worked
            System.out.println("\nTotal Hours Worked: " + totalHoursWorked + " hours");
            System.out.println("Total Days Worked: " + totalDaysWorked + " days\n");
        }

        private void weeklySalaryBasedOnHoursWorked(Employee loggedInEmployee) {
            Scanner scanner = new Scanner(System.in);

            // Get user input for the number of hours worked in a week
            System.out.print("Enter total hours worked in a week: ");
            double totalHoursWorked = scanner.nextDouble();

            // Get employee information
            double hourlyRate = loggedInEmployee.getHourlyRate();
            double riceSubsidy = loggedInEmployee.getRiceSubsidy();
            double phoneAllowance = loggedInEmployee.getPhoneAllowance();
            double clothingAllowance = loggedInEmployee.getClothingAllowance();

            // Calculate earnings
            double grossIncome = totalHoursWorked * hourlyRate;
            double totalDeductions =  riceSubsidy + phoneAllowance + clothingAllowance;
            double netIncome = grossIncome - totalDeductions;

            // Display the result
            System.out.println("\nWeekly Salary Based on Hours Worked:");
            System.out.println("Gross Income: " + grossIncome);
            System.out.println("Total Deductions: " + totalDeductions);
            System.out.println("Net Income: " + netIncome);

        }

        private void overallPayslip(Employee loggedInEmployee) {
            // Get employee information
            int employeeId = Integer.parseInt(loggedInEmployee.getEmployeeId());
            String employeeName = loggedInEmployee.getFirstName() + " " + loggedInEmployee.getLastName();
            String employeePosition = loggedInEmployee.getPosition();

            // Assuming you have methods to get these values
            double hourlyRate = loggedInEmployee.getHourlyRate();
            double riceSubsidy = loggedInEmployee.getRiceSubsidy();
            double phoneAllowance = loggedInEmployee.getPhoneAllowance();
            double clothingAllowance = loggedInEmployee.getClothingAllowance();

            // User input for days and hours worked
            System.out.print("Enter hours worked: ");
            double hoursWorked = scanner.nextDouble();

            System.out.print("Enter days worked: ");
            int daysWorked = scanner.nextInt();

            // Calculate earnings
            double grossIncome = hoursWorked * hourlyRate;

            // Calculate benefits
            double totalBenefits = riceSubsidy + phoneAllowance + clothingAllowance;

            // Calculate deductions
            double sssDeduction = calculateSSSDeduction(hourlyRate, hoursWorked);
            double philhealthDeduction = calculatePhilhealthDeduction(hourlyRate, hoursWorked);
            double pagIbigDeduction = calculatePagibigDeduction(hourlyRate, hoursWorked);
            double withholdingTax = calculateWithholdingTax(grossIncome, sssDeduction, philhealthDeduction, pagIbigDeduction);

            double totalDeductions = sssDeduction + philhealthDeduction + pagIbigDeduction + withholdingTax;

            // Calculate summary
            double netIncome = grossIncome - totalDeductions - totalBenefits;

            // Display the payslip
            System.out.println("\n-----EMPLOYEE PAYSLIP-------");
            System.out.println("EMPLOYEE ID: " + employeeId);
            System.out.println("EMPLOYEE NAME: " + employeeName);
            System.out.println("EMPLOYEE POSITION: " + employeePosition);
            System.out.println("\n\"EARNINGS\"");
            System.out.println("Days Worked: " + daysWorked);
            System.out.println("Hours Worked: " + hoursWorked);
            System.out.println("GROSS INCOME: " + grossIncome);
            System.out.println("\n\"BENEFITS\"");
            System.out.println("Rice Subsidy: " + riceSubsidy);
            System.out.println("Phone Allowance: " + phoneAllowance);
            System.out.println("Clothing Allowance: " + clothingAllowance);
            System.out.println("TOTAL: " + totalBenefits);
            System.out.println("\n\"DEDUCTIONS\"");
            System.out.println("Social Security System: " + sssDeduction);
            System.out.println("Philhealth: " + philhealthDeduction);
            System.out.println("Pag-Ibig: " + pagIbigDeduction);
            System.out.println("Withholding Tax: " + withholdingTax);
            System.out.println("TOTAL DEDUCTIONS: " + totalDeductions);
            System.out.println("\n\"SUMMARY\"");
            System.out.println("Gross Income: " + grossIncome);
            System.out.println("Benefits: " + totalBenefits);
            System.out.println("Total Deductions: " + totalDeductions);
            System.out.println("TAKE HOME PAY: " + netIncome);
            System.out.println("\n---------------------------");
        }

        private double calculateSSSDeduction(double hourlyRate, double hoursWorked) {
            double totalSalary = hourlyRate * hoursWorked;

            double[][] sssRanges = {
                    {3250, 135.00}, {3750, 157.50}, {4250, 180.00}, {4750, 202.50},
                    {5250, 225.00}, {5750, 247.50}, {6250, 270.00}, {6750, 292.50},
                    {7250, 315.00}, {7750, 337.50}, {8250, 360.00}, {8750, 382.50},
                    {9250, 405.00}, {9750, 427.50}, {10250, 450.00}, {10750, 472.50},
                    {11250, 495.00}, {11750, 517.50}, {12250, 540.00}, {12750, 562.50},
                    {13250, 585.00}, {13750, 607.50}, {14250, 630.00}, {14750, 652.50},
                    {15250, 675.00}, {15750, 697.50}, {16250, 720.00}, {16750, 742.50},
                    {17250, 765.00}, {17750, 787.50}, {18250, 810.00}, {18750, 832.50},
                    {19250, 855.00}, {19750, 877.50}, {20250, 900.00}, {20750, 922.50},
                    {21250, 945.00}, {21750, 967.50}, {22250, 990.00}, {22750, 1012.50},
                    {23250, 1035.00}, {23750, 1057.50}, {24250, 1080.00}, {24750, 1102.50},
                    {25250, 1125.00} // Assuming the maximum value for salaries above 25250
            };

            for (double[] range : sssRanges) {
                if (totalSalary <= range[0]) {
                    return range[1];
                }
            }

            return 1125.00; // Default if salary exceeds the highest range
        }

        private double calculatePhilhealthDeduction(double hourlyRate, double hoursWorked) {
            double totalSalary = hourlyRate * hoursWorked;

            double premiumRate = 0.03;
            double monthlyPremium;

            // Check the salary range and calculate the deduction accordingly
            if (totalSalary <= 10000) {
                // Flat rate for Monthly Basic Salary up to 10,000
                monthlyPremium = totalSalary * premiumRate;
            } else if (totalSalary <= 59999.99) {
                // Monthly Basic Salary from 10,000.01 to 59,999.99
                monthlyPremium = Math.min(totalSalary * premiumRate, 1800);
            } else {
                // Monthly Basic Salary 60,000 and above
                monthlyPremium = 1800;
            }

            // Monthly premium contribution payments are equally shared between the employee and employer
            double totalPhilhealthDeduction = monthlyPremium / 2;

            return totalPhilhealthDeduction;
        }

        private double calculatePagibigDeduction(double hourlyRate, double hoursWorked) {
            double totalSalary = hourlyRate * hoursWorked;
            double employeeContributionRate;
            double employerContributionRate;

            // Check the salary range and set contribution rates accordingly
            if (totalSalary >= 1000 && totalSalary <= 1500) {
                // Monthly Basic Salary between 1,000 and 1,500
                employeeContributionRate = 0.01; // 1%
                employerContributionRate = 0.02; // 2%
            } else {
                // Monthly Basic Salary over 1,500
                employeeContributionRate = 0.02; // 2%
                employerContributionRate = 0.02; // 2%
            }

            double employeeContribution = totalSalary * employeeContributionRate;
            double employerContribution = totalSalary * employerContributionRate;

            double totalContribution = employeeContribution + employerContribution;

            // Check if the total deduction exceeds the maximum contribution amount (100)
            double totalPagibigDeduction = Math.min(totalContribution * 0.5, 100.0);

            return totalPagibigDeduction;
        }

        private double calculateWithholdingTax(double grossIncome, double sssDeduction, double philhealthDeduction, double pagibigDeduction) {
            double taxableIncome = grossIncome - (sssDeduction + philhealthDeduction + pagibigDeduction);
            double withholdingTax = 0.0;

            if (taxableIncome <= 20832) {
                // No withholding tax
                withholdingTax = 0.0;
            } else if (taxableIncome > 20832 && taxableIncome <= 33333) {
                // 20% in excess of 20,833
                withholdingTax = (taxableIncome - 20832) * 0.20;
            } else if (taxableIncome > 33333 && taxableIncome <= 66667) {
                // 2,500 plus 25% in excess of 33,333
                withholdingTax = 2500 + (taxableIncome - 33333) * 0.25;
            } else if (taxableIncome > 66667 && taxableIncome <= 166667) {
                // 10,833 plus 30% in excess of 66,667
                withholdingTax = 10833 + (taxableIncome - 66667) * 0.30;
            } else if (taxableIncome > 166667 && taxableIncome <= 666667) {
                // 40,833.33 plus 32% in excess over 166,667
                withholdingTax = 40833.33 + (taxableIncome - 166667) * 0.32;
            } else if (taxableIncome > 666667) {
                // 200,833.33 plus 35% in excess of 666,667
                withholdingTax = 200833.33 + (taxableIncome - 666667) * 0.35;
            }

            return withholdingTax;
        }


        public Employee findEmployeeByEmail(String email) {
            return registeredEmployees.stream()
                    .filter(employee -> employee.getEmail().equals(email))
                    .findFirst()
                    .orElse(null);
        }
    }
}