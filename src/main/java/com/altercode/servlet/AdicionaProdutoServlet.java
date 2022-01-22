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
        String descricaoStr  = req.getParameter("descricao");
        String quantidadeStr  = req.getParameter("quantidade");
        String precoStr  = req.getParameter("preco");
        String validadeStr  = req.getParameter("validade");
        String categoriaStr  = req.getParameter("categoria");
        String unidade_medidaStr  = req.getParameter("unidade-medida");

        int quantidade = Integer.parseInt(quantidadeStr);
        double preco = Double.parseDouble(precoStr);
        LocalDate validade = LocalDate.parse(validadeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Categoria categoria = Categoria.valueOf(categoriaStr);
        UnidadeMedida medida = UnidadeMedida.valueOf(unidade_medidaStr);

        Produto produto = new Produto(descricaoStr, quantidade, preco, validade, categoria, medida);
        Connection connection = ConnectionFactory.getConnection();
        ProdutoDAO dao = new ProdutoDAO(connection);
        dao.save(produto);

        PrintWriter writer = resp.getWriter();
        writer.println("<html><body><p>Produto Adicionado!</p></body></html>");

    }
}
