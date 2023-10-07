package ManagementDoctor.reponsitory;

import java.util.HashMap;

import ManagementDoctor.model.Doctor;

public interface IDoctorRepository {
    boolean addOrUpdateDoctor (Doctor Doctor) throws Exception;
    boolean deleteDoctor (Doctor Doctor) throws Exception;
    HashMap <String, Doctor> searchDoctor (String input) throws Exception;

    

}
