package com.lwj.house.service.house;

import com.lwj.house.service.ServiceMultiResult;
import com.lwj.house.service.ServiceResult;
import com.lwj.house.web.dto.HouseDTO;
import com.lwj.house.web.form.DatatableSearch;
import com.lwj.house.web.form.HouseForm;
import com.lwj.house.web.form.RentSearch;

/**
 * 房屋管理服务接口
 * @author lwj
 */
public interface IHouseService {

    /**
     * 房屋新增保存接口
     * @param houseForm
     * @return
     */
    ServiceResult<HouseDTO> save(HouseForm houseForm);

    /**
     * 更新房屋信息接口
     * @param houseForm
     * @return
     */
    ServiceResult<HouseDTO> update(HouseForm houseForm);

    /**
     * 管理员房源信息列表查询接口
     * @param datatableSearch
     * @return
     */
    ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch datatableSearch);


    /**
     * 查询完整房源信息
     * @param id
     * @return
     */
    ServiceResult<HouseDTO> findCompleteOne(Integer id);

    /**
     * 移除图片
     * @param id
     * @return
     */
    ServiceResult removePhoto(Integer id);

    /**
     * 修改封面
     * @param coverId
     * @param targetId
     * @return
     */
    ServiceResult updateCover(Integer coverId, Integer targetId);

    /**
     * 增加标签
     * @param houseId
     * @param tag
     * @return
     */
    ServiceResult addTag(Integer houseId, String tag);

    /**
     * 移除标签
     * @param houseId
     * @param tag
     * @return
     */
    ServiceResult removeTag(Integer houseId, String tag);


    /**
     * 更新房源状态
     * @param id
     * @param status
     * @return
     */
    ServiceResult updateStatus(Integer id, Integer status);

    /**
     * 查询房源信息集
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<HouseDTO> query(RentSearch rentSearch);
}
