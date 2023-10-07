package ManagementDoctor.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import CandidateOfCompany.Model.Candidate;
import ContactManagementLab054.model.Contact;

public class Validation {
     static Scanner in = new Scanner(System.in);

    public String getString() {
        while (true) {
            String res = in.nextLine().trim();

            if (!res.isEmpty()) {
                return res;
            } else {
                System.out.println("you cannot enter empty!");
            }
        }
    }

    public int getInt(String message, int min, int max) {
        boolean flag = true;
        int number = 0;

        while (flag) {
            System.out.println(message);
            try {
                number = Integer.parseInt(getString());
                if (number >= min && number <= max) {
                    flag = false;
                } else {
                    System.out.println("number out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number invalid!");
            }
        }

        return number;
    }

    public boolean chooseYN() {
        while (true) {
            String choose = getString().toLowerCase().substring(0, 1);

            switch (choose) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("enter Y/N only!");
            }
        }
    }

    public String getId(ArrayList<Candidate> candidates) {
        while (true) {
            System.out.println("enter id: ");
            String id = getString();
            if (isCandidateId(candidates, id) == -1) {
                return id;
            } else {
                System.out.println("id existed!");
            }
        }
    }

    public String getphoneNumber(ArrayList<Contact> contacts) {
        while (true) {
            String phoneNumber = getString();

            if (phoneNumber.matches("^\\d{10,11}$")) {
                return phoneNumber;
            } else {
                System.out.println("phone number minimum 10 numbers");
            }
        }

    }

    public String getValidPhoneNumber() {
        String phoneNumber;
        boolean isValid = false;

        do {
            System.out.print("Enter phone number: ");
            phoneNumber = in.nextLine();

            isValid = isValidPhoneNumber(phoneNumber);

            if (!isValid) {
                System.out.println("Phone number is invalid.");
            }
        } while (!isValid);

        return phoneNumber;
    }



    public static boolean isValidPhoneNumber(String phoneNumber){
        String regex = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)-\\d{3}-\\d{4}|\\d{3}\\.\\d{3}\\.\\d{4}|\\d{3} \\d{3} \\d{4}|\\d{3}-\\d{3}-\\d{4} x\\d{1,4}|\\d{3}-\\d{3}-\\d{4} ext\\d{1,4})$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    public String getEmail(ArrayList<Candidate> candidates) {
        while (true) {
            String email = getString();
            if (email.matches("^[a-zA-Z]+[a-zA-Z0-9]*@[a-zA-Z]+(\\.[A-Za-z0-9]+){1,3}$")) {
                return email;
            } else {
                System.out.println("format <account name>@<domain>.");
            }
        }
    }

    public int getYearOfExperience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;

        while (true) {
            int yearExperience = getInt("enter year of experience", 0, 100);
            if (yearExperience > age) {
                System.out.println("year of experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }

    public String getRankOfGraduation() {
        while (true) {
            String rank = getString().toLowerCase();

            switch (rank) {
                case "excellence":
                case "good":
                case "fair":
                case "poor":
                    return rank;
                default:
                    System.out.println("excellence, good, fair or poor only!");
            }
        }

    }

    public int isCandidateId(ArrayList<Candidate> candidates, String id) {
        for (int i = 0; i < candidates.size(); i++) {
            if (id.equalsIgnoreCase(candidates.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    // public String getID(ArrayList<Contact> contacts) {
    //     return String.valueOf(contacts.size() + 1);
    // }

     public int getID(ArrayList<Contact> contacts) {
        return contacts.size()+1;
    }

    public int getIntData(String msg) {
        int data = 0;

        while (true) {
            try {
                System.out.print(msg);
                data = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("The integer number format is invalid\n");
                in.nextLine();
            }
        }
        in.nextLine();
        return data;
    }
}
