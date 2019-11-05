/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.taskinfo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.taskinfo.entity.TblTaskInfo;
import org.springblade.modules.taskinfo.vo.TblTaskInfoVO;
import org.springblade.modules.taskinfo.service.ITblTaskInfoService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 *  控制器
 *
 * @author BladeX
 * @since 2019-11-03
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tbltaskinfo")
@Api(value = "", tags = "接口")
public class TblTaskInfoController extends BladeController {

	private ITblTaskInfoService tblTaskInfoService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入tblTaskInfo")
	public R<TblTaskInfo> detail(TblTaskInfo tblTaskInfo) {
		TblTaskInfo detail = tblTaskInfoService.getOne(Condition.getQueryWrapper(tblTaskInfo));
		return R.data(detail);
	}

	/**
	 * 分页
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入tblTaskInfo")
	public R<IPage<TblTaskInfo>> list(TblTaskInfo tblTaskInfo, Query query) {
		IPage<TblTaskInfo> pages = tblTaskInfoService.page(Condition.getPage(query), Condition.getQueryWrapper(tblTaskInfo));
		return R.data(pages);
	}

	/**
	 * 自定义分页
	 */
	@GetMapping("/get")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入tblTaskInfo")
	public R<IPage<TblTaskInfoVO>> get(TblTaskInfoVO tblTaskInfo, Query query) {
		IPage<TblTaskInfoVO> pages = tblTaskInfoService.selectTblTaskInfoPage(Condition.getPage(query), tblTaskInfo);
		return R.data(pages);
	}

	/**
	 * 自定义分页
	 */
	@PostMapping("/post")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入tblTaskInfo")
	public R<IPage<TblTaskInfoVO>> post(TblTaskInfoVO tblTaskInfo, Query query) {
		IPage<TblTaskInfoVO> pages = tblTaskInfoService.selectTblTaskInfoPage(Condition.getPage(query), tblTaskInfo);
		return R.data(pages);
	}

	/**
	 * 新增
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入tblTaskInfo")
	public R save(@Valid @RequestBody TblTaskInfo tblTaskInfo) {
		return R.status(tblTaskInfoService.save(tblTaskInfo));
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入tblTaskInfo")
	public R update(@Valid @RequestBody TblTaskInfo tblTaskInfo) {
		return R.status(tblTaskInfoService.updateById(tblTaskInfo));
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入tblTaskInfo")
	public R submit(@Valid @RequestBody TblTaskInfo tblTaskInfo) {
		return R.status(tblTaskInfoService.saveOrUpdate(tblTaskInfo));
	}


	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(tblTaskInfoService.deleteLogic(Func.toIntList(ids)));
	}


}