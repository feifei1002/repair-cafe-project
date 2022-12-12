package uk.cf.ac.nccteam11.data;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.forms.Product;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepoImpl implements ProductRepo {

    private final JdbcTemplate jdbc;
    private RowMapper<Product> productMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public ProductRepoImpl(JdbcTemplate jdbcTemplate) {
        jdbc = jdbcTemplate;
        setProductMapper();
    }

    private void setProductMapper() {
        productMapper = (rs, i) -> new Product(
                rs.getInt("productID"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("category"),
                rs.getString("location"),
                (rs.getString("status").equals("1")) ? Boolean.TRUE : Boolean.FALSE,
                (rs.getString("availability").equals("1")) ? Boolean.TRUE : Boolean.FALSE
        );
    }

    public List<Product> getProducts() {
        String allProductsSQL = "select * from product";
        return jdbc.query(allProductsSQL, productMapper);
    }

    @Override
    public Optional<Product> getProductsByByLocation(String location) {
        return Optional.empty();
    }


    public Optional<Product> getProductsByLocation(String location) {
        String productByLocation = "select * from product where location = ?";
        Optional<Product> theProduct;

        try {
            theProduct = Optional.of(jdbc.queryForObject(productByLocation, productMapper, location));
            return theProduct;
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * @param search
     * @return
     */
    @Override
    public List<Product> getProductsBySearch(String search) {

        String likeTerm = "%" + search + "%";

        String productsSearchSQL = "select * from products where name like ?";
        return jdbc.query(productsSearchSQL, productMapper, likeTerm);
    }

    /**
     * @param description
     * @return
     */
    @Override
    public Optional<Product> getProductsByDescription(String description) {

        String productByDescriptionSql = "select * from product where description like ?";

        try {
            return Optional.of(jdbc.queryForObject(productByDescriptionSql, productMapper, description));
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }

    /**
     * @param category
     * @return
     */
    @Override
    public Optional<Product> getProductByCategory(String category) {
        String productByFurlSql = "select * from product where category = ?";

        try {
            return Optional.of(jdbc.queryForObject(productByFurlSql, productMapper, category));
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        String productByIdSql = "select * from product where id = ?";
        try {
            return Optional.of(jdbc.queryForObject(productByIdSql, productMapper, id));
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }
}

