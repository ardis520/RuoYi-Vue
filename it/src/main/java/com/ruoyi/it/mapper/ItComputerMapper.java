package com.ruoyi.it.mapper;

import java.util.List;
import com.ruoyi.it.domain.ItComputer;
import org.apache.ibatis.annotations.Mapper;

/**
 * 计算机Mapper接口
 * 
 * @author ruoyi
 * @date 2022-08-28
 */
@Mapper
public interface ItComputerMapper 
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
     * 删除计算机
     * 
     * @param uid 计算机主键
     * @return 结果
     */
    public int deleteItComputerByUid(Long uid);

    /**
     * 批量删除计算机
     * 
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteItComputerByUids(Long[] uids);
}
