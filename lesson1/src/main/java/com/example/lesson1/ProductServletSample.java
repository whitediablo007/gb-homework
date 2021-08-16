package com.example.lesson1;

import source.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServletSample", urlPatterns = {"/new_product"})
public class ProductServletSample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String numberOfProducts = req.getParameter("amount");

        if (numberOfProducts == null) {
            resp.sendError(400, "The product quantity is not set...");
            return;
        }
        final int numberInt = Integer.parseInt(numberOfProducts);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        for (int i = 1; i <= numberInt; i++) {
            final Product product = new Product(i, "Product #" + i, 10.0);
            resp.getWriter().println("<H5>" + product.getId() + " - " + product.getTitle() + " - cost: " + product.getCost() + "</H5>");
        }

    }
}
