package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Livro;
import br.cesjf.lppo.dao.LivroJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author José Flávio
 */
@WebServlet(name = "LivroServlet", urlPatterns = {"/editar.html", "/excluir.html", "listar.html"})
public class LivroServlet extends HttpServlet {

    @PersistenceUnit(unitName = "lppo-2017-1-jpa2PU")
    EntityManagerFactory emf;

    @Resource(name = "java.comp/UserTransaction")
    UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().contains("/editar.html")) {
            doEditarGet(request, response);
        } else if (request.getServletPath().contains("/exclui.html")) {
            doExcluirGet(request, response);
        } else if (request.getServletPath().contains("/criar.html")) {
            doListarGet(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().contains("/editar.html")) {
            doEditarPost(request, response);
        } else if (request.getServletPath().contains("/criar.html")) {
            doCriarPost(request, response);
        }

    }

    private void doEditarGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LivroJpaController dao = new LivroJpaController(ut, emf);

            Long id = dao.findLivro("id");
            Livro livro = dao.findLivro(id);
            request.setAttribute("livro", livro);
            request.getRequestDispatcher("WEB-INF/editar-livro.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("listar.html");
        }
    }

    private void doEditarPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LivroJpaController dao = new LivroJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));

            Livro livro = dao.findLivro(id);
            livro.setTitulo(request.getParameter("titulo"));
            livro.setAutor("autor");
            livro.setAno(Integer.parseInt(request.getParameter("ano")));
            dao.edit(livro);

            response.sendRedirect("listar.html");

        } catch (Exception e) {
            response.sendRedirect("listar.html");
        }
    }

    private void doExcluirGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            LivroJpaController dao = new LivroJpaController(ut, emf);
            Long id = Long.parseLong(request.getParameter("id"));

            dao.destroy(id);
        } catch (Exception e) {
            response.sendRedirect("listar.html");
        }
    }

    private void doListarGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Livro> livros;

        LivroJpaController dao = new LivroJpaController(ut, emf);
        livros = dao.findLivroEntities();

        request.setAttribute("livros", dao);
        request.getRequestDispatcher("WEB-INF/listar-livros.jsp").forward(request, response);
    }

    private void doCriarPost(HttpServletRequest request, HttpServletResponse response) {

        Livro livro1 = new Livro();
        livro1.setTitulo(request.getParameter("titulo"));
        livro1.setAno(Integer.parseInt(request.getParameter("ano")));
        livro1.setAutor(request.getParameter("autor"));

        LivroJpaController dao = new LivroJpaController(ut, emf);

        try {
            dao.create(livro1);
            response.sendRedirect("listar.html");
        } catch (Exception ex) {
            Logger.getLogger(LivroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
