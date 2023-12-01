package com.ruoyi.it.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.it.domain.ItComputer;
import com.ruoyi.it.service.IItComputerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 计算机Controller
 * 
 * @author ruoyi
 * @date 2022-08-28
 */
@RestController
@RequestMapping("/it/computer")
public class ItComputerController extends BaseController
{
    @Autowired
    private IItComputerService itComputerService;

    /**
     * 查询计算机列表
     */
    @PreAuthorize("@ss.hasPermi('it:computer:list')")
    @GetMapping("/list")
    public TableDataInfo list(ItComputer itComputer)
    {
        startPage();
        List<ItComputer> list = itComputerService.selectItComputerList(itComputer);
        return getDataTable(list);
    }


    /**
     * 导出计算机列表
     */
    @PreAuthorize("@ss.hasPermi('it:computer:export')")
    @Log(title = "计算机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ItComputer itComputer)
    {
        List<ItComputer> list = itComputerService.selectItComputerList(itComputer);
        ExcelUtil<ItComputer> util = new ExcelUtil<ItComputer>(ItComputer.class);
        util.exportExcel(response, list, "计算机数据");
    }

    /**
     * 获取计算机详细信息
     */
    @PreAuthorize("@ss.hasPermi('it:computer:query')")
    @GetMapping(value = "/{uid}")
    public AjaxResult getInfo(@PathVariable("uid") Long uid)
    {
        return AjaxResult.success(itComputerService.selectItComputerByUid(uid));
    }

    /**
     * 新增计算机
     */
    @PreAuthorize("@ss.hasPermi('it:computer:add')")
    @Log(title = "计算机", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ItComputer itComputer)
    {
        return toAjax(itComputerService.insertItComputer(itComputer));
    }

    /**
     * 修改计算机
     */
    @PreAuthorize("@ss.hasPermi('it:computer:edit')")
    @Log(title = "计算机", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ItComputer itComputer)
    {
        return toAjax(itComputerService.updateItComputer(itComputer));
    }

    /**
     * 删除计算机
     */
    @PreAuthorize("@ss.hasPermi('it:computer:remove')")
    @Log(title = "计算机", businessType = BusinessType.DELETE)
	@DeleteMapping("/{uids}")
    public AjaxResult remove(@PathVariable Long[] uids)
    {
        return toAjax(itComputerService.deleteItComputerByUids(uids));
    }
}
