package servlets.repositoryInformationPageServlets;

import com.google.gson.Gson;
import constants.Constants;
import engine.users.User;
import engine.users.UserManager;
import utils.ServletUtils;
import utils.SessionUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class EditFileServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        UserManager userManager = ServletUtils.getUserManager(getServletContext());
        String currentUserName = SessionUtils.getUsername(request);
        String repositoryName = request.getParameter(Constants.CURRENT_WATCHED_REPOSITORY);
        String fileNameFromParameter = request.getParameter(Constants.FileName);
        String fileFulName = ServletUtils.getFixedFileName(fileNameFromParameter,currentUserName,repositoryName);
        String content = request.getParameter(Constants.FileNewContent);
        User currentUser = userManager.getUser(currentUserName);
        int lastSlashIndex = fileFulName.lastIndexOf(File.separator);
        String fileName = fileFulName.substring(lastSlashIndex+1);

        String message = fileName + " was updated";

        try {
            currentUser.getMagitManager().writeToFile(fileFulName,content);
        } catch (IOException e) {
            message = e.getMessage();
        } finally {
            try (PrintWriter out = response.getWriter()) {
                Gson gson = new Gson();
                String json = gson.toJson(message);
                out.println(json);
                out.flush();
            }
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
