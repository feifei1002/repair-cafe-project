package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairBookingRepository;

import java.util.List;

@Service
public class RepairBookingServiceImpl implements RepairBookingService {
    private final RepairBookingRepository repairBookingRepository;

    public RepairBookingServiceImpl(RepairBookingRepository repairBookingRepo) {
        repairBookingRepository = repairBookingRepo;
    }

    @Override
    public List<RepairBookingDTO> getRepairBookings() {
        List<RepairBooking> repairBookings = repairBookingRepository.getRepairBookings();
        return RepairBookingAssembler.toDTO(repairBookings);
    }

    @Override
    public void addNewRepairBooking(RepairBookingDTO repairBookingDTO) {
        System.out.println("Coming from service: " + repairBookingDTO.toString());
        RepairBooking newRepairBooking = new RepairBooking(repairBookingDTO.getFirstName(), repairBookingDTO.getLastName(), repairBookingDTO.getEmail(), repairBookingDTO.getRepairDate(), repairBookingDTO.getLocation());
        repairBookingRepository.save(newRepairBooking);
    }
}
