package ar.charlycimino.recetorium;

import ar.charlycimino.recetorium.model.Receta;
import ar.charlycimino.recetorium.model.db.ConnectionPool;
import ar.charlycimino.recetorium.model.db.DAO;
import ar.charlycimino.recetorium.model.db.IngredienteDAO;
import ar.charlycimino.recetorium.model.db.ItemDeRecetaDAO;
import ar.charlycimino.recetorium.model.db.PerfilDAO;
import ar.charlycimino.recetorium.model.db.RecetaDAO;
import ar.charlycimino.recetorium.model.db.UsuarioDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try (PrintWriter out = resp.getWriter()) { // Se obtiene el flujo de salida hacia el browser del cliente
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                PerfilDAO perfilDAO = new PerfilDAO();
                RecetaDAO recetaDAO = new RecetaDAO();
                ItemDeRecetaDAO itemDAO = new ItemDeRecetaDAO();
                IngredienteDAO ingredienteDAO = new IngredienteDAO();
                
                //Receta rec = new Receta("Prueba", "foto", "instrucciones", 2);
                
                testGetDAO(out, usuarioDAO);
                testGetDAO(out, perfilDAO);
                testGetDAO(out, recetaDAO);
                testGetDAO(out, itemDAO);
                testGetDAO(out, ingredienteDAO);
                
                
                //rDAO.add(rec);
                //Receta rec = rDAO.getById(6);
                //rec.setNombre("cambio");
                //rDAO.update(rec);
                //rDAO.delete(6);
                
                System.out.println("ok"); // Se imprimirá en la consola del servidor
                out.println("ok"); // Se imprimirá en el browser del cliente
                resp.setContentType("text/plain"); // Se le aclara al browser que recibirá texto plano
                resp.setStatus(200); // Código de respuesta exitosa
            } catch (Exception ex) {
                ex.printStackTrace(System.out); // Se muestra la traza de la pila en la consola del servidor
                ex.printStackTrace(out); // Se muestra la traza de la pila en el browser del cliente
            } finally {
                out.close(); // Se libera el flujo de salida al browser
            }
        } catch (IOException ex) {
            System.out.println("Error obteniendo flujo de salida al browser: ");
            ex.printStackTrace(System.out);
        }
    }
    
    private static void testGetDAO(PrintWriter out, DAO<?, Integer> dao) throws SQLException {
        out.println(dao.getClass().getSimpleName());
        out.println(dao.getAll());
        out.println();
        out.println(dao.getById(1));
        out.println();
        out.println(dao.getById(500));
        out.println("_________________________________");
    }
}
