package ie.atu.vehiclemanagement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public ResponseEntity<Vehicle> getVehicleByReg(String regNum) {
        if (repo.findById(regNum).isPresent()) {
            return ResponseEntity.ok(repo.findById(regNum).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Vehicle> addVehicle(Vehicle vehicle) {
        return ResponseEntity.ok(repo.save(vehicle));
    }

    public ResponseEntity<Vehicle> updateVehicle(String regNum, Vehicle vehicle) {

        if (repo.findById(regNum).isPresent()) {
            Vehicle oldVehicle = repo.findById(regNum).get();
            oldVehicle.setVehicleName(vehicle.getVehicleName());
            oldVehicle.setVehicleType(vehicle.getVehicleType());
            oldVehicle.setPrice(vehicle.getPrice());
            oldVehicle.setYearOfManufacture(vehicle.getYearOfManufacture());
            oldVehicle.setMileage(vehicle.getMileage());
            repo.save(oldVehicle);
            return ResponseEntity.ok(oldVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
