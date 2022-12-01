import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.cf.ac.nccteam11.forms.Product;

@Controller
@RequestMapping("admin/recycling")
public class RecyclingAdminController {


    public String ApproveProduct(Product product) {
        if(product.getAvailability() == Boolean.FALSE){

        }
    }
}
