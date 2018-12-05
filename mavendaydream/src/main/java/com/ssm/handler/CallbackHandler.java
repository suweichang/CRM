package com.ssm.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Attendance;
import com.ssm.pojo.Callback;
import com.ssm.pojo.Classs;
import com.ssm.service.AttendanceService;
import com.ssm.service.CallbackService;
import com.ssm.service.ClasssService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class CallbackHandler {
    @Autowired
    private CallbackService callbackServiceImpl;
    @Autowired
    private ClasssService classsServiceImpl;
    @RequestMapping("callback")
    public ModelAndView callback(Integer cPage, HttpSession session){
        int page = 1;
        int pageSize = 2;
        if(cPage != null){
            if(cPage == 0){
                page = 1;
            }else{
                page = cPage;
            }
        }
        ModelAndView mv = new ModelAndView("callback");
        PageHelper.startPage(page,pageSize);
        List<Callback> list = callbackServiceImpl.getCbList();
        PageInfo<Callback> pageInfo = new PageInfo<>(list);
        mv.addObject("list",pageInfo);
        List<Classs> classlist = classsServiceImpl.GetAllClasss();
        System.out.println(classlist);
        session.setAttribute("classlist",classlist);
        return mv;
    }
    @RequestMapping("addCb")
    public String addAtt(Integer studentId, String photo, String callbackContent, String callbackDate, HttpServletRequest request){
        Callback callback = new Callback();
        boolean isMultpartForm = ServletFileUpload.isMultipartContent(request);
        if(isMultpartForm){
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //上传文件最大为1000kb
            upload.setFileSizeMax(1024 * 10000);
            String path = request.getSession().getServletContext().getRealPath("upload/");
            List<FileItem> list1;
            try {
                list1 = upload.parseRequest(request);
                for(int i = 0; i < list1.size(); i++){
                    FileItem item = list1.get(i);
                    if(item.isFormField()){
                        String name = item.getFieldName();
                        String value = "";
                        try {
                            value = item.getString("UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }if(name.equals("studentId")){
                            callback.setStudentId(Integer.parseInt(value));
                        }
                        else if(name.equals("callbackDate")){
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = null;
                            try {
                                date = format.parse(value);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            callback.setCallbackDate(date);
                        }
                        else if(name.equals("callbackContent")){
                            callback.setCallbackContent(value);
                        }
                    }
                    else{//获取文件名
                        String fileName = item.getName();
                        if(!fileName.equals("")){
                            //获取文件扩展名
                            String ext = fileName.substring(fileName.indexOf(".")+1);
                            List<String> exts = Arrays.asList("jpg","png","gif","jpeg");
                            if(!exts.contains(ext)){
                                System.out.println("文件类型不符");
                                return null;
                            }
                            //写入文件
//						SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//						String file = format.format(new Date());
//						file += "." + ext;
                            callback.setPhoto(fileName);
                            String file = path + fileName;
                            File f = new File(file);
                            try {
                                item.write(f);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }

                }
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(callbackServiceImpl.addCb(callback) == 1){
            return "redirect:/callback";
        }else {
            return "redirect:/addCb";
        }
    }

    @RequestMapping("updateCb")
    public String updateCb(Integer callbackId,String callbackContent){
        Callback callback = new Callback();
        callback.setCallbackId(callbackId);
        callback.setCallbackContent(callbackContent);
        if(callbackServiceImpl.updateCb(callback) == 1){
            return "redirect:/callback";
        }else {
            return "redirect:/updateCb";
        }
    }
    @RequestMapping("getCbById")
    public ModelAndView getCbById(Integer id){
        ModelAndView mv = new ModelAndView("updateCb");
        Callback callback = callbackServiceImpl.getCbById(id);
        mv.addObject("temp",callback);
        return mv;
    }
}
