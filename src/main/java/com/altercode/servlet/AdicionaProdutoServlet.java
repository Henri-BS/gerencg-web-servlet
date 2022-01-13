package com.altercode.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adiciona-produto")
public class AdicionaProdutoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String descricao  = req.getParameter("descricao");
        String quantidade  = req.getParameter("quantidade");
        String preco  = req.getParameter("preco");
        String validade  = req.getParameter("validade");
        String categoria  = req.getParameter("categoria");
        String unidade_medida  = req.getParameter("unidade-medida");

        System.out.println(descricao);
        System.out.println(quantidade);
        System.out.println(preco);
        System.out.println(validade);
        System.out.println(categoria);
        System.out.println(unidade_medida);

    }
}
