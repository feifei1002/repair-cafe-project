package uk.cf.ac.nccteam11.forms.admin;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import uk.cf.ac.nccteam11.forms.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminApproval {
    public String ApproveProducts(@RequestParam(required=false , defaultValue="")String action, @RequestParam(required=false,defaultValue="")String Cancel, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Product product = new Product();


        return action;
    }

}
