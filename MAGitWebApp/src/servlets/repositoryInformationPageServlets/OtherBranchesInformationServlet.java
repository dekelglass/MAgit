package servlets.repositoryInformationPageServlets;

import com.google.gson.Gson;
import engine.Branch;
import engine.Commit;
import engine.users.CommitData;
import engine.users.User;
import engine.users.UserManager;
import utils.ServletUtils;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OtherBranchesInformationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        UserManager userManager = ServletUtils.getUserManager(getServletContext());
        String currentUserName = SessionUtils.getUsername(request);
        User currentUser = userManager.getUser(currentUserName);
        List<Object> otherBranchesInformation = new ArrayList<>();
        String headBranchName = currentUser.getMagitManager().GetHeadBranchName();
        Map<String,Branch>allBranches = currentUser.getMagitManager().GetAllBranches();

        for (Map.Entry<String, Branch> entry : allBranches.entrySet()) {
            if (!entry.getKey().equals(headBranchName)) {
                otherBranchesInformation.add(entry.getKey());
                otherBranchesInformation.add(entry.getValue().getLastCommit().getSha1());
                otherBranchesInformation.add(currentUser.getMagitManager().BranchIsRB(entry.getKey()));
            }
        }



        try (PrintWriter out = response.getWriter()) {
            Gson gson = new Gson();
            String json = gson.toJson(otherBranchesInformation);
            out.println(json);
            out.flush();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
