package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class RepairCafeDeleteForm {
    private Integer cafeId;
}
