package ie.atu.vehiclemanagement;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class VehicleController {

    private VehicleService vService;

    public VehicleController(VehicleService vService) {
        this.vService = vService;
    }

    @GetMapping("/getVehicle/{regNum}")
    public ResponseEntity<Vehicle> getVehicleByReg(@PathVariable String regNum) {
        return vService.getVehicleByReg(regNum);
    }

    @PostMapping("/addVehicle")
    public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
        return vService.addVehicle(vehicle);
    }

    @PostMapping("/updateVehicle/{regNum}")
    public ResponseEntity<Vehicle> updateVehicle(@Valid @RequestBody Vehicle vehicle, @PathVariable String regNum) {
        return vService.updateVehicle(regNum, vehicle);
    }

}
