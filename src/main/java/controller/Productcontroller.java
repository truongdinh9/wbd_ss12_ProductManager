package controller;

import Model.Product;
import Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Productcontroller extends HttpServlet {
    private ProductService productService=new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action") ;
        if(action==null)action="";
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "remove":
                showremoveForm(req, resp);
                break;
            default:
                listproduct(req,resp);


        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action") ;
        if(action==null){action="";}
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            case "remove":
                remove(req, resp);
                break;
            default:
                listproduct(req,resp);

        }
    }
    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher=req.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id= Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product",product);
        RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showremoveForm(HttpServletRequest req, HttpServletResponse resp) {
        int id= Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product",product);
        RequestDispatcher dispatcher=req.getRequestDispatcher("remove.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) {
        int id = (int) Math.floor(Math.random()*1000+5);
        String name=req.getParameter("name");
        String description=req.getParameter("description");
        Double price=Double.parseDouble(req.getParameter("price"));
        Product product=new Product(id,name,description,price);
        productService.save(product);
        RequestDispatcher dispatcher =req.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String description=req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        Product product =productService.findById(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.remove(id);
        try {
            resp.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void listproduct(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<Product> products=productService.findAll();
        req.setAttribute("products",products);
        RequestDispatcher dispatcher=req.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }




}

