package uk.cf.ac.nccteam11.repairCafe.service;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RepairProductDTO {
    private Integer productId;
    private String productName;
    private String condition;
    private String brand;
    private String status;
    private Integer repair_Category_category_id;
    private String isApproved;
}
