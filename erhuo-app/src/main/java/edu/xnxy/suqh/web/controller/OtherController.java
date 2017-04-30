package edu.xnxy.suqh.web.controller;

import edu.xnxy.suqh.entity.GoodsInfo;
import edu.xnxy.suqh.entity.UserInfo;
import edu.xnxy.suqh.service.IGoodsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author suqh
 * Created by suqh on 2017/4/19.
 */
@Controller
@RequestMapping("/page")
public class OtherController {

    private static final Logger log = Logger.getLogger(OtherController.class);
    @Resource
    private IGoodsService goodsService;


    @RequestMapping("/salePage")
    public String salePage(HttpServletRequest httpServletRequest) {
        //获取session对象
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        //用户没有登录时跳转到登录页面，登录了直接跳转到发布商品界面
        if (userInfo == null) {
            return "login";
        }
        return "sale";
    }

    /*
    * 上传图片
    * */
    @RequestMapping("/sale.do")
    public String upload(HttpServletRequest httpServletRequest, GoodsInfo goodsInfo) throws IOException {
        String fileName = "";
        String path = "";
        try {
            //1.定义解析器,获取request的上下文
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(httpServletRequest.getSession().getServletContext());
            if (multipartResolver.isMultipart(httpServletRequest)) {//判断是否是isMultipart类型数据
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest; //转换成MultipartHttpServletRequest
                //获取所有的文件
                Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
                while (iterator.hasNext()) {//遍历文件
                    //获取其中一个文件
                    MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
                    if (multipartFile != null) {
                         fileName = "imageUpload" + multipartFile.getOriginalFilename();//定义文件名
                         path = "C:\\Users\\QH\\Desktop\\" + fileName; //定义文件输出路径

                        File localFile = new File(path);
                        multipartFile.transferTo(localFile); //将文件写到本地
                    }
                }
            }
            //保存商品信息
            goodsInfo.setFileName(fileName);
            goodsInfo.setFilePath(path);
            goodsService.addGoods(goodsInfo);
            httpServletRequest.setAttribute("goodsInfo",goodsInfo);
        } catch (Exception e) {
            log.error("上传商品失败",e);
        }

        //获取上传的商品列表
        List<GoodsInfo> goodsInfoList = null;
        HttpSession session = httpServletRequest.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        Integer userId = userInfo.getUserId();
        try {
            goodsInfoList = goodsService.queryGoodsInfoByUserId(userId);
            httpServletRequest.setAttribute("goodsInfoList",goodsInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "saleDetails";
    }

    public void showImage(){

    }
}
