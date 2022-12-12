package uk.cf.ac.nccteam11.repairCafe.service;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RepairProductDTO {
    private Integer product_id;
    private String product_name;
    private String condition;
    private String brand;
    private String status;
}
