package ar.charlycimino.recetorium;

import ar.charlycimino.recetorium.model.db.RecetaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
@WebServlet(urlPatterns = "/recetas")
public class RecetaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RecetaDAO recetaDAO = new RecetaDAO();
        req.setAttribute("listaDeRecetas", recetaDAO.getAll());
        req.getRequestDispatcher("/WEB-INF/jsp/recetas/viewAll.jsp").forward(req, resp);

    }

}
