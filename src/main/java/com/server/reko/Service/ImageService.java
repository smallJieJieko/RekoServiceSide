package com.server.reko.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageService {

    @Value("${absoluteImgPath}")
    String absoluteImgPath;

    @Value("${sonImgPath}")
    String sonImgPath;

//    @Value("${server.port}")
//    String port;
//
//    @Value("${host}")
//    String host;

    public Map<String, String> uploadImg(MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        if (file==null) {
            map.put("code", "500");
            map.put("msg", "图片不能为空");
            return map;
        }
        String originalFilename = file.getOriginalFilename();
        //随机生成文件名
        String fileName = generateRandomNumber(10) + originalFilename;
        File dest = new File(absoluteImgPath + fileName);
        String imgUrl = sonImgPath + fileName;
        try {
            file.transferTo(dest);
            map.put("code", "200");
            map.put("msg", "上传成功");
            map.put("imgUrl", imgUrl);
            return map;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    protected long generateRandomNumber(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("随机数位数必须大于0");
        }
        return (long) (Math.random() * 9 * Math.pow(10, n - 1)) + (long) Math.pow(10, n - 1);
    }
}