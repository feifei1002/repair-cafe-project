package uk.cf.ac.nccteam11.forms.admin;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.cf.ac.nccteam11.forms.Product;

import java.util.List;
import java.util.Optional;

public class AdminApproval {
    public String ApproveProducts(@RequestParam(required=false , defaultValue="")String action, @RequestParam(required=false,defaultValue="")String Cancel, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Product product = new Product();


        return action;
    }

}
