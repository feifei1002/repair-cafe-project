package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairBookingRepository;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListResponse;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairBookingServiceImpl implements RepairBookingService {
    private final RepairBookingRepository repairBookingRepository;

    public RepairBookingServiceImpl(RepairBookingRepository repairBookingRepo) {
        this.repairBookingRepository = repairBookingRepo;
    }

    @Override
    public RepairBookingListResponse getRepairBookings(RepairBookingListRequest repairBookingListRequest) {
        List<RepairBookingDTO> repairBookings = getRepairBookings();
        return RepairBookingListResponse.of()
                .request(repairBookingListRequest)
                .repairBookings(repairBookings)
                .build();
    }

    @Override
    public SaveRepairBookingResponse addNewRepairBooking(SaveRepairBookingRequest saveRepairBookingRequest) {
        RepairBookingDTO repairBookingDTO = saveRepairBookingRequest.getRepairBookingDTO();
        RepairBooking newRepairBooking = new RepairBooking(
                repairBookingDTO.getBooking_id(),
                repairBookingDTO.getFirstName(),
                repairBookingDTO.getLastName(),
                repairBookingDTO.getEmail(),
                repairBookingDTO.getRepairDate(),
                repairBookingDTO.getLocation());
        repairBookingRepository.addRepairBooking(newRepairBooking);
        return SaveRepairBookingResponse.of().saveRepairBookingRequest(saveRepairBookingRequest).build();
    }

    private List<RepairBookingDTO> getRepairBookings() {

        List<RepairBooking> repairBookings = repairBookingRepository.getRepairBookings();

        return repairBookings.stream().map(c -> RepairBookingAssembler.toDTO(c)).collect(Collectors.toList());

    }
}
