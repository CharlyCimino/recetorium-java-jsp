package ar.charlycimino.recetorium;

import ar.charlycimino.recetorium.model.db.IngredienteDAO;
import jakarta.servlet.ServletException;
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
public class IngredienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IngredienteDAO ingredienteDAO = new IngredienteDAO();
        req.setAttribute("listaDeIngredientes", ingredienteDAO.getAll());
        req.getRequestDispatcher("/WEB-INF/jsp/ingredientes/listIngredientes.jsp").forward(req, resp);

    }

}
