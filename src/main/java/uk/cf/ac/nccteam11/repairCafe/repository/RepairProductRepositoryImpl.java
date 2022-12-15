package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepairProductRepositoryImpl implements RepairProductRepository {
    private final RepairProductRepositoryJdbc repairProductRepoJdbc;

    public RepairProductRepositoryImpl(RepairProductRepositoryJdbc rpRepoJdbc) {
        this.repairProductRepoJdbc = rpRepoJdbc;
    }

    public List<RepairProduct> getRepairProducts() {
        List<RepairProduct> repairProducts = new ArrayList<>();
        repairProductRepoJdbc.findAll().forEach(repairProducts::add);
        return repairProducts;
    }

    @Override
    public List<RepairProduct> getRepairProductsByCategoryId(Integer repair_Category_category_id) {
        List<RepairProduct> repairProducts = new ArrayList<>();
        repairProductRepoJdbc.findAll().forEach(repairProducts::add);
        return repairProducts;
    }

    @Override
    public Optional<RepairProduct> getRepairProductById(Integer product_id) {
        return repairProductRepoJdbc.findById(product_id);
    }

}
