package com.servletTest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
//文件上传处理
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先判断上传的数据是否是多段数据
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于上传数据的工具类servletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            //为了防止文件名中的乱码问题,要在开头设置
            servletFileUpload.setHeaderEncoding("UTF-8");
            try {
                //解析上传数据的到每一表达项目FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断，每一表单项是普通各类型还是上传类型
                for (FileItem fileItem:list){
                    if (fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name值" + fileItem.getFieldName());
                        System.out.println("表单项的value值" + fileItem.getString("UTF-8"));
                    }else {
                        //上传的类型文件
                        System.out.println("表单项的name属性值:" + fileItem.getFieldName());
                        System.out.println("上传的文件名" + fileItem.getName());
                        //将文件保存
                        fileItem.write(new File("e:\\"+fileItem.getName()));
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
