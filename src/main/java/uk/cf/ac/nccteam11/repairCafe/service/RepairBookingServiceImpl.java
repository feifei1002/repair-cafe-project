package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairBookingRepository;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairCafeRepository;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairBookingServiceImpl implements RepairBookingService {
    private final RepairBookingRepository repairBookingRepository;
    private final RepairCafeRepository repairCafeRepository;

    public RepairBookingServiceImpl(RepairBookingRepository repairBookingRepo, RepairCafeRepository repairCafeRepo) {
        this.repairBookingRepository = repairBookingRepo;
        this.repairCafeRepository = repairCafeRepo;
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
                repairBookingDTO.getBookingId(),
                repairBookingDTO.getFirstName(),
                repairBookingDTO.getLastName(),
                repairBookingDTO.getEmail(),
                repairBookingDTO.getRepairDate(),
                repairBookingDTO.getCategory(),
                repairBookingDTO.getLocation());
        repairBookingRepository.addRepairBooking(newRepairBooking);
        return SaveRepairBookingResponse.of().saveRepairBookingRequest(saveRepairBookingRequest).build();
    }

    private List<RepairBookingDTO> getRepairBookings() {

        List<RepairBooking> repairBookings = repairBookingRepository.getRepairBookings();

        return repairBookings.stream().map(rb -> RepairBookingAssembler.toDTO(rb)).collect(Collectors.toList());

    }
}
