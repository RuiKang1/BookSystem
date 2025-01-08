package cn.lanqiao.booksystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

@RestController
public class codeController {
    @RequestMapping("/CodeImageServlet")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //处理请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //System.out.println("验证码请求过来了");
        //验证图片的宽和高
        int length = 120;
        int width = 50;
        //绘图类
        BufferedImage bufferedImage = new BufferedImage(length,width,TYPE_INT_RGB);
        //通过绘图类生成一个画笔
        Graphics graphics = bufferedImage.getGraphics();
        //设置画笔为白色
        graphics.setColor(Color.white);
        //使用画笔填充矩形边框
        graphics.fillRect(0,0,length,width);
        //颜色数组
        Color[] colors = {Color.red,Color.yellow,Color.green,Color.cyan,Color.pink,Color.orange,Color.blue,Color.darkGray,Color.LIGHT_GRAY};
        //验证码的内容
        String[] codes = {"a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n" , "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "2", "3", "4", "5", "6", "7", "8", "9"};
        //随机数，随机的中文字母和数字中获取4个
        Random random = new Random();
        //用来存储验证码的内容
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(codes.length);
            String str = String.valueOf(codes[index]);
            //随机的画笔颜色
            graphics.setColor(colors[random.nextInt(colors.length)]);
            //设置字体
            graphics.setFont(new Font("宋体",Font.BOLD,30+random.nextInt(10)));
            //绘制字到图片上
            graphics.drawString(str, 1 + (width/2)*i, 30 + random.nextInt(10));
            //将验证码的内容存储到StringBUilder对象中
            stringBuilder.append(str);
        }
        //绘制干扰线条
        for (int i = 0; i < 4; i++) {
            //随机的画笔颜色
            graphics.setColor(colors[random.nextInt(colors.length)]);
            int x0=random.nextInt(length);
            int y0=random.nextInt(width);
            int x1=random.nextInt(length);
            int y1=random.nextInt(width);
            graphics.drawLine(x0,y0,x1,y1);
        }
        //System.out.println(stringBuilder.toString());//验证这个验证码的数据出来没有
        //session需要创建对象
        HttpSession session = request.getSession();
        session.setAttribute("codes",stringBuilder.toString());
        //往前端响应验证码图片
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }
}
