/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.taskinfo.mapper;

import org.apache.ibatis.annotations.Param;
import org.springblade.modules.taskinfo.entity.TblTaskInfo;
import org.springblade.modules.taskinfo.vo.TblTaskInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 *  Mapper 接口
 *
 * @author BladeX
 * @since 2019-11-03
 */
public interface TblTaskInfoMapper extends BaseMapper<TblTaskInfo> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param tblTaskInfo
	 * @return
	 */
	List<TblTaskInfoVO> selectTblTaskInfoPage1(IPage page, @Param("taskType")String taskType);

	List<TblTaskInfoVO> selectTblTaskInfoPage2(IPage page, @Param("taskId")long taskId);

}
