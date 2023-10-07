package ManagementDoctor.DataAccess;

import java.util.HashMap;
import java.util.Scanner;

import ManagementDoctor.common.Validation;
import ManagementDoctor.model.Doctor;

public class DoctorDAO {
    private static DoctorDAO instance = null;
    private Validation check = new Validation();
    private Scanner in = new Scanner(System.in);
    private HashMap<String, Doctor> hmDoctor = new HashMap<>();

    public static DoctorDAO getInstance() {
        if (instance == null) {
            synchronized (DoctorDAO.class) {
                if (instance == null) {
                    instance = new DoctorDAO();
                }
            }
        }
        return instance;
    }

    public boolean addOrUpdateDoctor() throws Exception {
        System.out.println("Enter code: ");
        String code = in.nextLine();

        if (hmDoctor.containsKey(code)) {
            updateDoctor(code);
        } else {
            addDoctor(code);
        }
        return true;
    }

    public boolean addDoctor(String code) throws Exception {
        System.out.println("-----Add Doctor-----");

        System.out.print("Enter Name: ");
        String name = in.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = in.nextLine();

        int availability = check.getIntData("Enter Availability: ");

        Doctor newDoctor = new Doctor(code, name, specialization, availability);

        hmDoctor.put(code, newDoctor);

        if (hmDoctor.isEmpty()) {
            throw new Exception("Database does not exist");
        }

        if (name == null || code.isEmpty()) {
            throw new Exception("Data does not exits");
        }

        if (specialization == null || specialization.isEmpty()) {
            throw new Exception("Data does not exits");
        }

        if (availability < 0) {
            throw new Exception("Data does not exits");
        }

        return true;
    }

    public boolean updateDoctor(String code) throws Exception {
        System.out.println("-----Update Doctor-----");

        Doctor existingDoctor = hmDoctor.get(code);

        System.out.print("Enter New Name: ");
        String name = in.nextLine();

        if (name != null && !name.isEmpty()) {
            existingDoctor.setName(name);
        } else {
            throw new Exception("Data does not exits");
        }

        System.out.print("Enter New Specialization: ");
        String specialization = in.nextLine();

        if (specialization != null && !specialization.isEmpty()) {
            existingDoctor.setSpecialization(specialization);
        } else {
            throw new Exception("Data does not exits");
        }

        int newAvailability = check.getInt("Enter New Availability : ", 0, 3);

        if (newAvailability >= 0 && newAvailability <= 3) {
            existingDoctor.setAvailability(newAvailability);
        } else {
            throw new Exception("Availability must be a non-negative integer");
        }

        return true;
    }

    public boolean deleteDoctor() throws Exception {
        System.out.println("-----Delete Doctor-----");
        System.out.print("Enter Code of the Doctor to Delete: ");
        String code = in.nextLine();

        if (code == null || code.isEmpty()) {
            throw new Exception("Doctor code cannot be null or empty");
        }

        if (!hmDoctor.containsKey(code)) {
            throw new Exception("Doctor code [" + code + "] does not exist");
        }

        if (hmDoctor.isEmpty()) {
            throw new Exception("Database does not exits");
        }
        hmDoctor.remove(code);
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        if (hmDoctor.isEmpty()) {
            throw new Exception("Database does not exist");
        }
   

        for (Doctor doctor : hmDoctor.values()) {
            String code = doctor.getCode();
            String name = doctor.getName();
            String specialization = doctor.getSpecialization();

            if (code.contains(input) || name.contains(input) || specialization.contains(input)) {

                hmDoctor.put(doctor.getCode(), doctor);
            }
        }

        return hmDoctor;
    }

}
