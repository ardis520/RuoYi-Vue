package com.ruoyi.it.service;

import java.util.List;
import com.ruoyi.it.domain.ItComputer;

/**
 * 计算机Service接口
 * 
 * @author ruoyi
 * @date 2022-08-28
 */
public interface IItComputerService 
{
    /**
     * 查询计算机
     * 
     * @param uid 计算机主键
     * @return 计算机
     */
    public ItComputer selectItComputerByUid(Long uid);

    /**
     * 查询计算机列表
     * 
     * @param itComputer 计算机
     * @return 计算机集合
     */
    public List<ItComputer> selectItComputerList(ItComputer itComputer);

    /**
     * 新增计算机
     * 
     * @param itComputer 计算机
     * @return 结果
     */
    public int insertItComputer(ItComputer itComputer);

    /**
     * 修改计算机
     * 
     * @param itComputer 计算机
     * @return 结果
     */
    public int updateItComputer(ItComputer itComputer);

    /**
     * 批量删除计算机
     * 
     * @param uids 需要删除的计算机主键集合
     * @return 结果
     */
    public int deleteItComputerByUids(Long[] uids);

    /**
     * 删除计算机信息
     * 
     * @param uid 计算机主键
     * @return 结果
     */
    public int deleteItComputerByUid(Long uid);
}
