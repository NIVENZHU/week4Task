package com.bytedance.week4.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bytedance.week4.common.ApiRestResponse;
import com.bytedance.week4.exception.bdExceptionEnum;
import com.bytedance.week4.model.pojo.Advertisement;
import com.bytedance.week4.service.AdvService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class AdvController {

    @Resource
    private AdvService advService;

    /**
     * 10. 广告上传
     * @param advertisement
     * @return
     */
    @PostMapping("/adv/add")
    public ApiRestResponse insertAdv(@Valid @RequestBody Advertisement advertisement){
        advService.insertAdv(advertisement);
        return ApiRestResponse.success();
    }

    /**
     * 11.特定类型广告的获取
     * @param category
     * @param pageNum
     * @param rowNum
     * @return
     */
    @GetMapping("/adv/{category}")
    public ApiRestResponse selectAdvByCategory(@PathVariable("category") String category,
                                               @RequestParam Integer pageNum,@RequestParam Integer rowNum){
        if(pageNum==null||rowNum==null){
            return ApiRestResponse.error(bdExceptionEnum.NOT_NULL);
        }
        IPage<Advertisement> advertisementIPage = advService.selectAdvByCategory(category,pageNum,rowNum);
        List<Advertisement> advertisementList = advertisementIPage.getRecords();
        int count = advertisementList.size();
        return ApiRestResponse.success(advertisementList,count);
    }

    /**
     * 12. 广告点击反馈
     * @param advId
     * @return
     */
    @GetMapping("/adv/{advId}")
    public ApiRestResponse selectAdvById(@PathVariable("advId") Long advId){
        if(advId==null){
            return ApiRestResponse.error(bdExceptionEnum.NOT_NULL);
        }
        Advertisement adv = advService.selectAdvById(advId);
        return ApiRestResponse.success(adv);
    }

}
