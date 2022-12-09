package com.tear.sys.controller;


import com.github.pagehelper.PageInfo;
import com.tear.sys.entity.thing;
import com.tear.sys.service.thingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
public class StoreController {
    @Autowired
    thingService thingService;

    //关于呃呃呃  商品 遍历

    @RequestMapping("/findStoreAll")
    public String  findAllStore(@RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "3")Integer pageSize,
            Model model){
        List<thing> list=thingService.findAll();
        model.addAttribute("stores",list);
        PageInfo pageInfo=new PageInfo(list,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/storeIndex";
    }

    @RequestMapping("/EditStore")
    public String   EditStore(Integer sid,Model model){
        thing t=thingService.findOne(sid);
        model.addAttribute("one",t);
        return  "admin/EditStore";
    }

    @RequestMapping("/EditOneStore")
    public String   EditOnestore(Integer sid,String   sname,String  detail,
        String money,  MultipartFile simg, String  status
                               ){
        //处理数据  前端数据转化为数据库对应类型
        Double newMon=Double.valueOf(money);
        Integer  newStatu=Integer.valueOf(status);//包装类型转换 嘿嘿嘿

  System.out.println("文件名称:"+simg.getName());
  System.out.println("Original"+simg.getOriginalFilename());
  //新建文件所在地:  测试输出路径  E:\毕设\SpringBootCodeForManageWebStore
     // File file=new File("E:/uploads/"+simg.getOriginalFilename());
        System.out.println("输出user.dir路径"+System.getProperty("user.dir"));
  File file=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\"+simg.getOriginalFilename());
        try {
       simg.transferTo(file);
   }catch (Exception r){
       r.printStackTrace();
   }
   //String  path="E:/uploads"+simg.getOriginalFilename();//上传文件传入本地并通过本地显示图片

  String  realPath=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\"+simg.getOriginalFilename();
   System.out.println("输出心文件所在路径:"+realPath);
   //传入数据库的字符串地址参数
        String  SqlPath="/img/"+simg.getOriginalFilename();
   //将数据存入实体类
        thing tTes=new thing(sid,sname,detail,newMon,SqlPath,newStatu);
        thingService.updateThing(tTes);//更新数据
        System.out.println("数据更新成功!");
        return "redirect:/findStoreAll";

    }
    @RequestMapping("/GoAddStore")
    public String   GoAddStore(){
        return  "admin/addStore";
    }
    @RequestMapping("/AddOneStore")
    public String  addOne(String   sname,String  detail,
                          String money,  MultipartFile simg, String  status){
        Double newMon=Double.valueOf(money);
        Integer  newStatu=Integer.valueOf(status);
        System.out.println("文件名称:"+simg.getName());
        System.out.println("Original"+simg.getOriginalFilename());

        System.out.println("输出user.dir路径"+System.getProperty("user.dir"));
        File file=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\add"+simg.getOriginalFilename());
        try {
            simg.transferTo(file);
        }catch (Exception r){
            r.printStackTrace();
        }
        String  realPath=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\add"+simg.getOriginalFilename();
        System.out.println("输出心文件所在路径:"+realPath);
        //添加数据!
        String  SqlPath="/img/add"+simg.getOriginalFilename();
    //数据存入实体当中
        thing  tMy=new thing();
        tMy.setSimg(SqlPath);
        tMy.setDetail(detail);
        tMy.setMoney(newMon);
        tMy.setStatus(newStatu);
        tMy.setSname(sname);
        thingService.addThing(tMy);
        return "redirect:/findStoreAll";
    }

    @RequestMapping("/DeleteStore")
    public String   DeleteStore(Integer sid){
        thingService.deleteThing(sid);
        return "redirect:/findStoreAll";
    }
}
