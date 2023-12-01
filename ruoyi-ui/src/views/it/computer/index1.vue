<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="部门" prop="deptId">
        <el-input
          v-model="queryParams.deptId"
          placeholder="请输入部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用人" prop="computerUser">
        <el-input
          v-model="queryParams.computerUser"
          placeholder="请输入使用人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品牌" prop="computerBrand">
        <el-input
          v-model="queryParams.computerBrand"
          placeholder="请输入品牌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="cpu型号" prop="computerCpu">
        <el-input
          v-model="queryParams.computerCpu"
          placeholder="请输入cpu型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="内存" prop="computerMemory">
        <el-input
          v-model="queryParams.computerMemory"
          placeholder="请输入内存"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="硬盘" prop="computerDisk">
        <el-input
          v-model="queryParams.computerDisk"
          placeholder="请输入硬盘"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="显示器" prop="computerMonitor">
        <el-input
          v-model="queryParams.computerMonitor"
          placeholder="请输入显示器"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用时间" prop="computerUsetime">
        <el-date-picker clearable
          v-model="queryParams.computerUsetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择使用时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="计算机编号" prop="computerCode">
        <el-input
          v-model="queryParams.computerCode"
          placeholder="请输入计算机编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['it:computer:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['it:computer:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['it:computer:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['it:computer:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="computerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="uid" />
      <el-table-column label="部门" align="center" prop="deptId" />
      <el-table-column label="计算机类型" align="center" prop="computerType" />
      <el-table-column label="使用人" align="center" prop="computerUser" />
      <el-table-column label="品牌" align="center" prop="computerBrand" />
      <el-table-column label="cpu型号" align="center" prop="computerCpu" />
      <el-table-column label="内存" align="center" prop="computerMemory" />
      <el-table-column label="硬盘" align="center" prop="computerDisk" />
      <el-table-column label="显示器" align="center" prop="computerMonitor" />
      <el-table-column label="使用时间" align="center" prop="computerUsetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.computerUsetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="计算机编号" align="center" prop="computerCode" />
      <el-table-column label="计算机状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['it:computer:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['it:computer:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改计算机对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="部门" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入部门" />
        </el-form-item>
        <el-form-item label="使用人" prop="computerUser">
          <el-input v-model="form.computerUser" placeholder="请输入使用人" />
        </el-form-item>
        <el-form-item label="品牌" prop="computerBrand">
          <el-input v-model="form.computerBrand" placeholder="请输入品牌" />
        </el-form-item>
        <el-form-item label="cpu型号" prop="computerCpu">
          <el-input v-model="form.computerCpu" placeholder="请输入cpu型号" />
        </el-form-item>
        <el-form-item label="内存" prop="computerMemory">
          <el-input v-model="form.computerMemory" placeholder="请输入内存" />
        </el-form-item>
        <el-form-item label="硬盘" prop="computerDisk">
          <el-input v-model="form.computerDisk" placeholder="请输入硬盘" />
        </el-form-item>
        <el-form-item label="显示器" prop="computerMonitor">
          <el-input v-model="form.computerMonitor" placeholder="请输入显示器" />
        </el-form-item>
        <el-form-item label="使用时间" prop="computerUsetime">
          <el-date-picker clearable
            v-model="form.computerUsetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择使用时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="计算机编号" prop="computerCode">
          <el-input v-model="form.computerCode" placeholder="请输入计算机编号" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listComputer, getComputer, delComputer, addComputer, updateComputer } from "@/api/it/computer";

export default {
  name: "Computer",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 计算机表格数据
      computerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deptId: null,
        computerType: null,
        computerUser: null,
        computerBrand: null,
        computerCpu: null,
        computerMemory: null,
        computerDisk: null,
        computerMonitor: null,
        computerUsetime: null,
        computerCode: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        deptId: [
          { required: true, message: "部门不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询计算机列表 */
    getList() {
      this.loading = true;
      listComputer(this.queryParams).then(response => {
        this.computerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        uid: null,
        deptId: null,
        computerType: null,
        computerUser: null,
        computerBrand: null,
        computerCpu: null,
        computerMemory: null,
        computerDisk: null,
        computerMonitor: null,
        computerUsetime: null,
        computerCode: null,
        status: "0",
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.uid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加计算机";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const uid = row.uid || this.ids
      getComputer(uid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改计算机";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.uid != null) {
            updateComputer(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addComputer(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const uids = row.uid || this.ids;
      this.$modal.confirm('是否确认删除计算机编号为"' + uids + '"的数据项？').then(function() {
        return delComputer(uids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('it/computer/export', {
        ...this.queryParams
      }, `computer_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
