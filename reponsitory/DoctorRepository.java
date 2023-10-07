package ManagementDoctor.reponsitory;

import java.util.HashMap;

import ManagementDoctor.DataAccess.DoctorDAO;
import ManagementDoctor.model.Doctor;

public class DoctorRepository implements IDoctorRepository {

    @Override
    public boolean addOrUpdateDoctor(Doctor doctor) throws Exception {
        try {
            DoctorDAO.getInstance().addOrUpdateDoctor();
            System.out.println("Success");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteDoctor(Doctor doctor) throws Exception {
        try {
            DoctorDAO.getInstance().deleteDoctor();
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Failed");
            return false;
        }
        return true;
    }

    @Override
    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        try {
            return DoctorDAO.getInstance().searchDoctor(input);
            
        } catch (Exception e) {
            System.out.println("Failed");
            return new HashMap<>();
        }
    }

}
