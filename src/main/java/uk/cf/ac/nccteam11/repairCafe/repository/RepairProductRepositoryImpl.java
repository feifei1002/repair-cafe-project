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
    public Optional<RepairProduct> getRepairProductsByByLocation(String location) {
        return Optional.empty();
    }

    @Override
    public List<RepairProduct> getRepairProductsBySearch(String search) {
        return repairProductRepoJdbc.findByProductNameContaining(search);
    }

    @Override
    public Optional<RepairProduct> getRepairProductById(Integer id) {
        return repairProductRepoJdbc.findByProductId(id);
    }

    @Override
    public void save(RepairProduct repairProduct) {
        repairProductRepoJdbc.save(repairProduct);
    }

    @Override
    public void deleteRepairProductById(RepairProduct repairProduct) {
        repairProductRepoJdbc.deleteById(repairProduct.getProductId());
    }

    @Override
    public List<RepairProduct> getRepairProductsByCategoryId(Integer repair_Category_category_id) {
        List<RepairProduct> repairProducts = new ArrayList<>();
        repairProductRepoJdbc.findAll().forEach(repairProducts::add);
        return repairProducts;
    }



}
