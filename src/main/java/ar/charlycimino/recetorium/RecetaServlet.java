package ar.charlycimino.recetorium;

import ar.charlycimino.recetorium.model.Ingrediente;
import ar.charlycimino.recetorium.model.db.IngredienteDAO;
import ar.charlycimino.recetorium.model.db.RecetaDAO;
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
public class RecetaServlet extends HttpServlet {

    private RecetaDAO recetaDAO;
    private IngredienteDAO ingredienteDAO;

    @Override
    public void init() throws ServletException {
        recetaDAO = new RecetaDAO();
        ingredienteDAO = new IngredienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String destino;
        String accion = req.getParameter("accion");
        accion = accion == null ? "" : accion;
        System.out.println(accion);

        switch (accion) {
            case "create": // Form de alta
                destino = "/WEB-INF/jsp/recetaAddForm.jsp";
                break;
            case "read": // Ver detalle de receta
                String idIngStr = req.getParameter("idIngrediente");
                if (idIngStr != null) {
                    Ingrediente ing = ingredienteDAO.getById(Integer.parseInt(idIngStr));
                    ligarCustomTitle(req, "Recetas con " + ing.getNombre().toLowerCase());
                    req.setAttribute("listaDeRecetas", recetaDAO.getByIngredienteId(Integer.parseInt(idIngStr)));
                    destino = "/WEB-INF/jsp/recetas/listRecetas.jsp";
                } else {
                    ligarIDReceta(req);
                    destino = "/WEB-INF/jsp/recetas/detailReceta.jsp";
                }
                break;
            case "update": // Form de edición
                ligarIDReceta(req);
                destino = "/WEB-INF/jsp/recetaEditForm.jsp";
                break;
            case "delete": // ¿Seguro?
                ligarIDReceta(req);
                destino = "/WEB-INF/jsp/recetaDeleteConf.jsp";
                break;
            default: // Lista de recetas
                ligarCustomTitle(req, "Catálogo de recetas");
                req.setAttribute("listaDeRecetas", recetaDAO.getAll());
                destino = "/WEB-INF/jsp/recetas/listRecetas.jsp";
        }

        req.getRequestDispatcher(destino).forward(req, resp);
    }
    
    private void ligarIDReceta(HttpServletRequest req) {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            req.setAttribute("receta", recetaDAO.getById(Integer.parseInt(idStr)));
        } else {
            throw new RuntimeException("Falta ID de receta");
        }
    }
    
    private void ligarCustomTitle(HttpServletRequest req, String title) {
        req.setAttribute("customTitle", title);
    }
}
