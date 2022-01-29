package com.altercode.servlet;

import com.altercode.dao.ProdutoDAO;
import com.altercode.infra.ConnectionFactory;
import com.altercode.model.Categoria;
import com.altercode.model.Produto;
import com.altercode.model.UnidadeMedida;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/adiciona-produto")
public class AdicionaProdutoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String descricao = req.getParameter("descricao");
        String quantidade = req.getParameter("quantidade");
        String preco = req.getParameter("preco");
        String validade = req.getParameter("validade");
        String categoria = req.getParameter("categoria");
        String unidade_medida = req.getParameter("unidade-medida");

        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);
        produto.setValidade(validade);

        Connection connection = ConnectionFactory.getConnection();
        ProdutoDAO dao = new ProdutoDAO(connection);

/*        int status = dao.save(produto);
        if (status > 0) {

            writer.println("<p>Record saved successfully!</p>");
            req.getRequestDispatcher("index.html").include(req, resp);
        }
        else{
            writer.println("Sorry! unable to save record");
        }
*/
        writer.println("<html><body><p>Produto Adicionado!</p></body></html>");

    }
}
