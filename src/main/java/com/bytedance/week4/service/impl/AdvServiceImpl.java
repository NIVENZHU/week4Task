package com.bytedance.week4.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bytedance.week4.exception.bdException;
import com.bytedance.week4.exception.bdExceptionEnum;
import com.bytedance.week4.model.dao.AdvMapper;
import com.bytedance.week4.model.pojo.Advertisement;
import com.bytedance.week4.service.AdvService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service("AdvService")
public class AdvServiceImpl implements AdvService {
    @Resource
    private AdvMapper advMapper;

    /**
     * 添加广告
     * @param advertisement
     */
    @Override
    @Transactional
    public void insertAdv(Advertisement advertisement){
        int count = advMapper.insert(advertisement);
        if(count==0){
            throw new bdException(bdExceptionEnum.INSERT_FAILED);
        }
    }

    /**
     * 获取特定类型的广告
     * @param category
     * @param pageNum
     * @param rowNum
     * @return
     */
    @Override
    @Transactional
    public IPage<Advertisement> selectAdvByCategory(String category, Integer pageNum, Integer rowNum){
        Page<Advertisement> p = new Page<>(pageNum,rowNum);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category",category);
        IPage<Advertisement> advertisementIPage=advMapper.selectPage(p,queryWrapper);
        return advertisementIPage;
    }

    /**
     * 获取特定的广告
     * @param advId
     * @return
     */
    @Override
    public Advertisement selectAdvById(Long advId){
        Advertisement advertisement = advMapper.selectById(advId);
        if(advertisement==null){
            throw new bdException(bdExceptionEnum.ADV_NOT_EXIST);
        }
        return advertisement;
    }

}
