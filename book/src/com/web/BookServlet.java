package com.web;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.sun.deploy.net.HttpResponse;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    //获得BookService业务模块对象
    private BookService bookService = new BookServiceImpl();
    //获取图书列表，并返回请求转发到jsp页面中显示
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过BookService查询Book表中所有数据
        List<Book> books = bookService.queryBooks();
        //将数据保存到request域中
        request.setAttribute("books",books);
        //将请求转发到jsp页面中
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
    //添加新的书本
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //将请求获得的参数注入book中
        Book book = new Book();
        WebUtils.copyParamToBean(request.getParameterMap(),book);
        bookService.addBook(book);
        //获取当前页面
        int pageNo = WebUtils.parseInt(request.getParameter("addPageNo"), 0);
        //为了跳转到最后1页，需要增加1
        pageNo++;
        //请求重定向到book_manager.jsp中（在这里不能使用请求转发，否则可能会导致多次提交单个信息）
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo=" + pageNo);
    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        bookService.deleteBookById(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));

    }
    //负责通过id获取书本信息
    public void getBook(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //在请求中获取id
        int id = Integer.parseInt(request.getParameter("id"));
        //通过id获取书本的具体信息
        Book book = bookService.queryBookById(id);
        //将book中的信息保存到request域中
        request.setAttribute("book",book);
        //请求转发到修改页面中
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }
    //更新操作
    public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.updateBook(book);
        String pageNo = request.getParameter("pageNo");
        System.out.println(pageNo);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }
    //处理分页功能
    public void page(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数pageNo,pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), 2);
        //2.通过BookService调用page(pageNo,pageSize)，去获得当前页面得数据
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3.将分页数据保存到request域中
        request.setAttribute("page",page);
        //4.保存当前页面url，便于分页查询
        page.setUrl("manager/bookServlet?action=page");
        //4.请求转发到book_manager中
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);


    }
    //由于a标签的请求方式默认是doGet，所以我们需要手动将请求经过doPost()
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
