package com.ruoyi.it.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 计算机对象 it_computer
 * 
 * @author ruoyi
 * @date 2022-08-28
 */
public class ItComputer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long uid;

    /** 部门 */
//    @Excel(name = "部门")
    private Long deptId;

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Excel.Type.EXPORT,sort = 0)
    })
    private SysDept dept;

    /** 计算机类型（1表示台式机、2表示笔记本） */
    @Excel(name = "计算机类型", dictType = "it_computer_type")
    private String computerType;



    /** 使用人 */
    @Excel(name = "使用人")
    private String computerUser;

    /** 品牌 */
    @Excel(name = "品牌",dictType = "it_computer_logo")
    private String computerBrand;

    /** cpu型号 */
    @Excel(name = "cpu型号")
    private String computerCpu;

    /** 内存 */
    @Excel(name = "内存", dictType = "it_computer_memory")
    private String computerMemory;

    /** 硬盘 */
    @Excel(name = "硬盘", dictType = "it_computer_disk")
    private String computerDisk;

    /** 显示器 */
    @Excel(name = "显示器")
    private String computerMonitor;

    /** 使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date computerUsetime;

    /** 计算机编号 */
    @Excel(name = "计算机编号")
    private String computerCode;

    /** 计算机状态（0正常 1停用） */
    @Excel(name = "计算机状态",dictType = "it_computer_status")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setComputerType(String computerType) 
    {
        this.computerType = computerType;
    }

    public String getComputerType() 
    {
        return computerType;
    }
    public void setComputerUser(String computerUser) 
    {
        this.computerUser = computerUser;
    }

    public String getComputerUser() 
    {
        return computerUser;
    }
    public void setComputerBrand(String computerBrand) 
    {
        this.computerBrand = computerBrand;
    }

    public String getComputerBrand() 
    {
        return computerBrand;
    }
    public void setComputerCpu(String computerCpu) 
    {
        this.computerCpu = computerCpu;
    }

    public String getComputerCpu() 
    {
        return computerCpu;
    }
    public void setComputerMemory(String computerMemory) 
    {
        this.computerMemory = computerMemory;
    }

    public String getComputerMemory() 
    {
        return computerMemory;
    }
    public void setComputerDisk(String computerDisk) 
    {
        this.computerDisk = computerDisk;
    }

    public String getComputerDisk() 
    {
        return computerDisk;
    }
    public void setComputerMonitor(String computerMonitor) 
    {
        this.computerMonitor = computerMonitor;
    }

    public String getComputerMonitor() 
    {
        return computerMonitor;
    }
    public void setComputerUsetime(Date computerUsetime) 
    {
        this.computerUsetime = computerUsetime;
    }

    public Date getComputerUsetime() 
    {
        return computerUsetime;
    }
    public void setComputerCode(String computerCode) 
    {
        this.computerCode = computerCode;
    }

    public String getComputerCode() 
    {
        return computerCode;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uid", getUid())
            .append("deptId", getDeptId())
            .append("computerType", getComputerType())
            .append("computerUser", getComputerUser())
            .append("computerBrand", getComputerBrand())
            .append("computerCpu", getComputerCpu())
            .append("computerMemory", getComputerMemory())
            .append("computerDisk", getComputerDisk())
            .append("computerMonitor", getComputerMonitor())
            .append("computerUsetime", getComputerUsetime())
            .append("computerCode", getComputerCode())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
