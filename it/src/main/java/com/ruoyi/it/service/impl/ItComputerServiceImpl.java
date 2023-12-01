package com.ruoyi.it.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.it.service.IItComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.it.mapper.ItComputerMapper;
import com.ruoyi.it.domain.ItComputer;


/**
 * 计算机Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-28
 */
@Service
public class ItComputerServiceImpl implements IItComputerService
{
    @Autowired
    private ItComputerMapper itComputerMapper;

    /**
     * 查询计算机
     * 
     * @param uid 计算机主键
     * @return 计算机
     */
    @Override
    public ItComputer selectItComputerByUid(Long uid)
    {
        return itComputerMapper.selectItComputerByUid(uid);
    }

    /**
     * 查询计算机列表
     * 
     * @param itComputer 计算机
     * @return 计算机
     */
    @Override
    public List<ItComputer> selectItComputerList(ItComputer itComputer)
    {
        return itComputerMapper.selectItComputerList(itComputer);
    }

    /**
     * 新增计算机
     * 
     * @param itComputer 计算机
     * @return 结果
     */
    @Override
    public int insertItComputer(ItComputer itComputer)
    {
        itComputer.setCreateTime(DateUtils.getNowDate());
        return itComputerMapper.insertItComputer(itComputer);
    }

    /**
     * 修改计算机
     * 
     * @param itComputer 计算机
     * @return 结果
     */
    @Override
    public int updateItComputer(ItComputer itComputer)
    {
        itComputer.setUpdateTime(DateUtils.getNowDate());
        return itComputerMapper.updateItComputer(itComputer);
    }

    /**
     * 批量删除计算机
     * 
     * @param uids 需要删除的计算机主键
     * @return 结果
     */
    @Override
    public int deleteItComputerByUids(Long[] uids)
    {
        return itComputerMapper.deleteItComputerByUids(uids);
    }

    /**
     * 删除计算机信息
     * 
     * @param uid 计算机主键
     * @return 结果
     */
    @Override
    public int deleteItComputerByUid(Long uid)
    {
        return itComputerMapper.deleteItComputerByUid(uid);
    }
}
