/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Grupos;
import Modelo.GruposDAO;
import Modelo.GruposPer;
import Modelo.GruposPerDAO;
import Modelo.Permisos;
import Modelo.PermisosDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario Local
 */
public class Controlador extends HttpServlet {

    PermisosDAO dao = new PermisosDAO();
    Permisos p = new Permisos();
    GruposDAO gao = new GruposDAO();
    Grupos g = new Grupos();
    GruposPerDAO grao = new GruposPerDAO();
    GruposPer gr = new GruposPer();
    Usuario u = new Usuario();
    UsuarioDAO uao = new UsuarioDAO();
    Cliente c = new Cliente();
    ClienteDAO cao = new ClienteDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");
        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
        if (menu.equals("permisos")) {
            switch (accion) {
                case "Listar":
                    List<Permisos> datos = dao.listar();
                    request.setAttribute("datos", datos);
                    break;
                case "Guardar":
                    String id = request.getParameter("txtid");
                    String permisos = request.getParameter("txtper");
                    p.setId(Integer.parseInt(id));
                    p.setPermiso(permisos);
                    dao.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=permisos&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    String ide = request.getParameter("id");
                    Permisos pe = dao.listarId(ide);
                    request.setAttribute("permisos", pe);
                    request.getRequestDispatcher("Controlador?menu=permisos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String id1 = request.getParameter("txtid");
                    String permisos1 = request.getParameter("txtper");
                    p.setId(Integer.parseInt(id1));
                    p.setPermiso(permisos1);
                    System.out.println(id1);
                    System.out.println(permisos1);
                    dao.actualizar(p);
                    request.getRequestDispatcher("Controlador?menu=permisos&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    String ides = request.getParameter("id");
                    p.setId(Integer.parseInt(ides));
                    dao.eliminar(p);
                    request.getRequestDispatcher("Controlador?menu=permisos&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("permisos.jsp").forward(request, response);
        }
        if (menu.equals("grupos")) {
            switch (accion) {
                case "Listar":
                    List<Grupos> datos = gao.listar();
                    request.setAttribute("datos", datos);
                    break;
                case "Guardar":
                    String id = request.getParameter("txtid");
                    String grupos = request.getParameter("txtgru");
                    g.setId(Integer.parseInt(id));
                    g.setGrupo(grupos);
                    gao.agregar(g);
                    request.getRequestDispatcher("Controlador?menu=grupos&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    String ide = request.getParameter("id");
                    Grupos pe = gao.listarId(ide);
                    request.setAttribute("grupos", pe);
                    request.getRequestDispatcher("Controlador?menu=grupos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String id1 = request.getParameter("txtid");
                    String grupo1 = request.getParameter("txtgru");
                    g.setId(Integer.parseInt(id1));
                    g.setGrupo(grupo1);
                    gao.actualizar(g);
                    request.getRequestDispatcher("Controlador?menu=grupos&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    String ides = request.getParameter("id");
                    g.setId(Integer.parseInt(ides));
                    gao.eliminar(g);
                    request.getRequestDispatcher("Controlador?menu=grupos&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("grupos.jsp").forward(request, response);
        }
        if (menu.equals("gruposPer")) {
            switch (accion) {
                case "Listar":
                    List<GruposPer> datos = grao.listar();
                    request.setAttribute("datos", datos);
                    break;
                case "Guardar":
                    String id = request.getParameter("txtid");
                    String grupos = request.getParameter("txtgru");
                    String permisos = request.getParameter("txtper");
                    gr.setId(Integer.parseInt(id));
                    gr.setIdgrupo(Integer.parseInt(grupos));
                    gr.setIdper(Integer.parseInt(permisos));
                    grao.agregar(gr);
                    request.getRequestDispatcher("Controlador?menu=gruposPer&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    String ide = request.getParameter("id");
                    GruposPer pe = grao.listarId(ide);
                    request.setAttribute("grupos", pe);
                    request.getRequestDispatcher("Controlador?menu=gruposPer&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String id1 = request.getParameter("txtid");
                    String grupo1 = request.getParameter("txtgru");
                    String permisos1 = request.getParameter("txtper");
                    gr.setId(Integer.parseInt(id1));
                    gr.setIdgrupo(Integer.parseInt(grupo1));
                    gr.setIdper(Integer.parseInt(permisos1));
                    grao.actualizar(gr);
                    request.getRequestDispatcher("Controlador?menu=gruposPer&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    String ides = request.getParameter("id");
                    gr.setId(Integer.parseInt(ides));
                    grao.eliminar(gr);
                    request.getRequestDispatcher("Controlador?menu=gruposPer&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("gruposPer.jsp").forward(request, response);
        }
        if (menu.equals("usuarios")) {
            switch (accion) {
                case "Listar":
                    List<Usuario> datos = uao.listar();
                    request.setAttribute("datos", datos);
                    break;
                case "Guardar":
                    String id = request.getParameter("txtid");
                    String nombres = request.getParameter("txtno");
                    String apellidos = request.getParameter("txtap");
                    String usuario = request.getParameter("txtus");
                    String password = request.getParameter("txtpas");
                    String estado = request.getParameter("txtes");
                    String idgrupo = request.getParameter("txtidg");
                    u.setId(Integer.parseInt(id));
                    u.setNombre(nombres);
                    u.setApellido(apellidos);
                    u.setUser(usuario);
                    u.setPass(password);
                    u.setEstado(Boolean.valueOf(estado));
                    u.setIdgrupo(Integer.parseInt(idgrupo));
                    uao.agregar(u);
                    request.getRequestDispatcher("Controlador?menu=usuarios&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    String ide = request.getParameter("id");
                    Usuario pe = uao.listarId(ide);
                    request.setAttribute("grupos", pe);
                    request.getRequestDispatcher("Controlador?menu=usuarios&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String id1 = request.getParameter("txtid");
                    String nombres1 = request.getParameter("txtno");
                    String apellidos1 = request.getParameter("txtap");
                    String usuario1 = request.getParameter("txtus");
                    String password1 = request.getParameter("txtpas");
                    String estado1 = request.getParameter("txtes");
                    String idgrupo1 = request.getParameter("txtidg");
                    u.setId(Integer.parseInt(id1));
                    u.setNombre(nombres1);
                    u.setApellido(apellidos1);
                    u.setUser(usuario1);
                    u.setPass(password1);
                    u.setEstado(Boolean.valueOf(estado1));
                    u.setIdgrupo(Integer.parseInt(idgrupo1));
                    uao.actualizar(u);
                    request.getRequestDispatcher("Controlador?menu=usuarios&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    String ides = request.getParameter("id");
                    u.setId(Integer.parseInt(ides));
                    uao.eliminar(u);
                    request.getRequestDispatcher("Controlador?menu=usuarios&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        }
        if (menu.equals("clientes")) {
            switch (accion) {
                case "Listar":
                    List<Cliente> datos = cao.listar();
                    request.setAttribute("datos", datos);
                    break;
                case "Guardar":
                    String id = request.getParameter("txtid");
                    String nit = request.getParameter("txtnit");
                    String nombres = request.getParameter("txtno");
                    String apellidos = request.getParameter("txtap");
                    String telefono = request.getParameter("txtte");
                    c.setId(Integer.parseInt(id));
                    c.setNit(Integer.parseInt(nit));
                    c.setNombre(nombres);
                    c.setApellido(apellidos);
                    c.setTel(Integer.parseInt(telefono));
                    cao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    String ide = request.getParameter("id");
                    Cliente pe = cao.listarId(ide);
                    request.setAttribute("grupos", pe);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String id1 = request.getParameter("txtid");
                    String nit1 = request.getParameter("txtnit");
                    String nombres1 = request.getParameter("txtno");
                    String apellidos1 = request.getParameter("txtap");
                    String telefono1 = request.getParameter("txtte");
                    c.setId(Integer.parseInt(id1));
                    c.setNit(Integer.parseInt(nit1));
                    c.setNombre(nombres1);
                    c.setApellido(apellidos1);
                    c.setTel(Integer.parseInt(telefono1));
                    cao.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    String ides = request.getParameter("id");
                    c.setId(Integer.parseInt(ides));
                    cao.eliminar(c);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Controlador</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        String accion = request.getParameter("accion");
//        switch (accion) {
//            case "Listar":
//                List<Permisos> datos = dao.listar();
//                request.setAttribute("datos", datos);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//                break;
//            case "Nuevo":
//                request.getRequestDispatcher("add.jsp").forward(request, response);
//                break;
//            case "Guardar":
//                String id = request.getParameter("txtid");
//                String permisos = request.getParameter("txtper");
//                p.setId(Integer.parseInt(id));
//                p.setPermiso(permisos);
//                dao.agregar(p);
//                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
//                break;
//            case "Editar":
//                String ide=request.getParameter("id");
//                Permisos pe = dao.listarId(ide);
//                request.setAttribute("permisos", pe);
//                request.getRequestDispatcher("edit.jsp").forward(request, response);
//                break;
//            case "Actualizar":
//                String id1 = request.getParameter("txtid");
//                String permisos1 = request.getParameter("txtper");
//                p.setId(Integer.parseInt(id1));
//                System.out.println(id1);
//                System.out.println(permisos1);
//                p.setPermiso(permisos1);               
//                dao.actualizar(p);
//                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
//                break;
//            case "Delete":
//                String ides=request.getParameter("id");
//                p.setId(Integer.parseInt(ides));              
//                dao.eliminar(p);
//                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
//                break;
//            default:
//                throw new AssertionError();
//        }
//        String accion = request.getParameter("accion");
//        switch (accion) {
//            case "Listar":
//                List<Permisos> datos = dao.listar();
//                request.setAttribute("datos", datos);
//                request.getRequestDispatcher("permisos.jsp").forward(request, response);
//                break;
//            case "Nuevo":
//                request.getRequestDispatcher("permisos.jsp").forward(request, response);
//                break;
//            case "Guardar":
//                String id = request.getParameter("txtid");
//                String permisos = request.getParameter("txtper");
//                p.setId(Integer.parseInt(id));
//                p.setPermiso(permisos);
//                dao.agregar(p);
//                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
//                break;
//            case "Editar":
//                String ide = request.getParameter("id");
//                Permisos pe = dao.listarId(ide);
//                request.setAttribute("permisos", pe);
//                request.getRequestDispatcher("permisos.jsp").forward(request, response);
//                break;
//            case "Actualizar":
//                String id1 = request.getParameter("txtid");
//                String permisos1 = request.getParameter("txtper");
//                p.setId(Integer.parseInt(id1));
//                System.out.println(id1);
//                System.out.println(permisos1);
//                p.setPermiso(permisos1);
//                dao.actualizar(p);
//                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
//                break;
//            case "Delete":
//                String ides = request.getParameter("id");
//                p.setId(Integer.parseInt(ides));
//                dao.eliminar(p);
//                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
//                break;
//            default:
//                throw new AssertionError();
//        }
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
