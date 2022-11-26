package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListResponse;

import java.util.List;

public interface RepairCafeService {

    RepairCafeListResponse getRepairCafes(RepairCafeListRequest repairCafeListRequest);
}
