package ManagementDoctor.controller;

import java.util.HashMap;
import java.util.Scanner;

import ManagementDoctor.model.Doctor;
import ManagementDoctor.reponsitory.DoctorRepository;
import ManagementDoctor.view.Menu;

public class doctorProgramming extends Menu<String>{
    static Scanner in = new Scanner(System.in);

    HashMap <String, Doctor> hm = new HashMap<>();
    private DoctorRepository d = new DoctorRepository();

    public doctorProgramming() {
        super("Doctor Programming", new String[]{"Add Doctor OR Update Doctor", "Delete", "Search", "Exit"});
    }


    @Override
    public void excute(int n) {
        switch (n) {
            case 1:
                try {
                    d.addOrUpdateDoctor(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    d.deleteDoctor(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
            System.out.println("Enter infor you want to search: ");
            String input = in.nextLine();
            System.out.println("----- Result -----");
            
            System.out.printf("%-10s%-16s%-16s%-15s\n","Code","Name","Specialization","Availability");
            try {
                HashMap<String, Doctor> searchResult = d.searchDoctor(input);
                
                for (Doctor doctor : searchResult.values()) {
                    System.out.printf("%-10s%-16s%-16s%-15s\n",doctor.getCode(),doctor.getName(),doctor.getSpecialization(),doctor.getAvailability());
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;

            case 4:
                System.exit(0);
        }
    }
}
