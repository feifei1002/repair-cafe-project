package uk.cf.ac.nccteam11.forms;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminApproval {
    public String ApproveLeaves(@RequestParam(required=false , defaultValue="")String aion, @RequestParam(required=false,defaultValue="")String Cancel, HttpServletRequest request, HttpServletResponse response, ModelMap model){
        try{
            //following strings are used for getting the value of button and spiting it to get employee id

            String buttonName=request.getParameter("action");
            String buttonValue=buttonName.substring(0,6);// here we are spliting up the string and button name
            int buttonValue1=Integer.parseInt(buttonName.substring(6));

            if (buttonValue.equalsIgnoreCase("Reject"))
            {

                boolean status=LeaveStatusWorker.Approve(buttonValue1,buttonValue,dtoBean);
                if (status)
                {
                    return "redirect: GlobalConstants.UPCOMING_LEAVES";
                }
            }

            if (buttonValue.equalsIgnoreCase("Cancel"))
            {

                boolean status=LeaveStatusWorker.Approve(buttonValue1,buttonValue,dtoBean);
                if (status)
                {

                    return "redirect: GlobalConstants.UPCOMING_LEAVES";
                }
            }

            if (buttonValue.equalsIgnoreCase("Accept"))
            {


                boolean status=LeaveStatusWorker.Approve(buttonValue1,buttonValue,dtoBean);
                if (status)
                {

                    return "redirect: GlobalConstants.UPCOMING_LEAVES";
                }
            }

            return GlobalConstants.UPCOMING_LEAVES;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return GlobalConstants.ERRORPAGE;

    }
}
