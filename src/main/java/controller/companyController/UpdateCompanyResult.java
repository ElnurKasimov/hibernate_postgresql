package controller.companyController;

import model.config.HibernateProvider;
import model.dto.CompanyDto;
import model.service.CompanyService;
import model.storage.CompanyStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/company/update")
public class UpdateCompanyResult extends HttpServlet {
    private static HibernateProvider connectionProvider;
    private static CompanyStorage companyStorage;
    private static CompanyService companyService;

    @Override
    public void init() throws ServletException {
        connectionProvider = new HibernateProvider();
        try {
            companyStorage = new CompanyStorage(connectionProvider);
            companyService = new CompanyService(companyStorage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyName = req.getParameter("companyName");
        String rating = req.getParameter("rating");
        CompanyDto newCompanyDto = new CompanyDto(companyName, CompanyDto.Rating.valueOf(rating));
        String result = companyService.updateCompany(newCompanyDto);
        req.setAttribute("result", result);
        req.getRequestDispatcher("/WEB-INF/view/company/updateCompany.jsp").forward(req, resp);

    }

}
