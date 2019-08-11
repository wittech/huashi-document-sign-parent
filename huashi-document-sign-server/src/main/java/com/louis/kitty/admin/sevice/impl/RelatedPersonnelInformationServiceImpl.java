package com.louis.kitty.admin.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;
import com.louis.kitty.admin.model.AssetTypeCar;
import com.louis.kitty.admin.model.AssetTypeHouses;
import com.louis.kitty.admin.model.AssetTypeLand;
import com.louis.kitty.admin.model.AssetTypeOther;
import com.louis.kitty.admin.model.AssetTypeSecurities;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.dao.AssetTypeCarMapper;
import com.louis.kitty.admin.dao.AssetTypeHousesMapper;
import com.louis.kitty.admin.dao.AssetTypeLandMapper;
import com.louis.kitty.admin.dao.AssetTypeOtherMapper;
import com.louis.kitty.admin.dao.AssetTypeSecuritiesMapper;
import com.louis.kitty.admin.dao.HouseholdIncomeMapper;
import com.louis.kitty.admin.dao.RelatedPersonnelInformationMapper;
import com.louis.kitty.admin.sevice.RelatedPersonnelInformationService;

/**
 * ---------------------------
 * 相关人员信息表 (RelatedPersonnelInformationServiceImpl)         
 * ---------------------------
 * 作者： lz
 * 时间：  2019-08-08 11:53:18
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class RelatedPersonnelInformationServiceImpl implements RelatedPersonnelInformationService {

	@Autowired
	private RelatedPersonnelInformationMapper relatedPersonnelInformationMapper;
	@Autowired
	private AssetTypeHousesMapper assetTypeHousesMapper;
	@Autowired
	private AssetTypeLandMapper assetTypeLandMapper;
	@Autowired
	private AssetTypeCarMapper assetTypeCarMapper;
	@Autowired
	private AssetTypeSecuritiesMapper assetTypeSecuritiesMapper;
	@Autowired
	private AssetTypeOtherMapper assetTypeOtherMapper;
	//家庭收支情况
	@Autowired
	private HouseholdIncomeMapper householdIncomeMapper;
	
	@Override
	public int save(RelatedPersonnelInformation record) {
		if(record.getId() == null || record.getId() == 0) {
			int i = relatedPersonnelInformationMapper.add(record);
			//获取相关人id
			Long id = record.getId();
			if(id>0){
				//存储房屋
				if(record.getAssetTypeHouses() !=null){
					for(AssetTypeHouses house : record.getAssetTypeHouses()){
						house.setRpiId(id);
						assetTypeHousesMapper.add(house);
					}
				}
				//存储土地
				if(record.getAssetTypeLand() !=null){
					for(AssetTypeLand land : record.getAssetTypeLand()){
						land.setRpiId(id);
						assetTypeLandMapper.add(land);
					}
				}
				//存储汽车
				if(record.getAssetTypeCar() !=null){
					for(AssetTypeCar car : record.getAssetTypeCar()){
						car.setRpiId(id);
						assetTypeCarMapper.add(car);
					}
				}
				//存储证券
				if(record.getAssetTypeSecurities() !=null){
					for(AssetTypeSecurities aecurities : record.getAssetTypeSecurities()){
						aecurities.setRpiId(id);
						assetTypeSecuritiesMapper.add(aecurities);
					}
				}
				//存储其他
				if(record.getAssetTypeOther() !=null){
					for(AssetTypeOther other : record.getAssetTypeOther()){
						other.setRpiId(id);
						assetTypeOtherMapper.add(other);
					}
				}
				//保存家庭收支情况
				if(record.getHouseholdIncomeForm() !=null){
					record.getHouseholdIncomeForm().setLoanBasisId(record.getLoanBasisId());
					householdIncomeMapper.add(record.getHouseholdIncomeForm());
				}
			}
			//保存配偶数据
			saveSpouseInfo(record,0);
			return i;
		}
		return relatedPersonnelInformationMapper.update(record);
	}
	
	/**
	 * 保存配偶数据
	 * @param record
	 */
	private void saveSpouseInfo(RelatedPersonnelInformation r,int parentId){
		/*if(r.getSpouseInfo() !=null){
			RelatedPersonnelInformation record = r.getSpouseInfo();
			relatedPersonnelInformationMapper.add(record);
			//获取相关人id
			Long id = record.getId();
			if(id>0){
				//存储房屋
				if(record.getAssetTypeHouses() !=null){
					for(AssetTypeHouses house : record.getAssetTypeHouses()){
						house.setRpiId(id);
						assetTypeHousesMapper.add(house);
					}
				}
				//存储土地
				if(record.getAssetTypeLand() !=null){
					for(AssetTypeLand land : record.getAssetTypeLand()){
						land.setRpiId(id);
						assetTypeLandMapper.add(land);
					}
				}
				//存储汽车
				if(record.getAssetTypeCar() !=null){
					for(AssetTypeCar car : record.getAssetTypeCar()){
						car.setRpiId(id);
						assetTypeCarMapper.add(car);
					}
				}
				//存储证券
				if(record.getAssetTypeSecurities() !=null){
					for(AssetTypeSecurities aecurities : record.getAssetTypeSecurities()){
						aecurities.setRpiId(id);
						assetTypeSecuritiesMapper.add(aecurities);
					}
				}
				//存储其他
				if(record.getAssetTypeOther() !=null){
					for(AssetTypeOther other : record.getAssetTypeOther()){
						other.setRpiId(id);
						assetTypeOtherMapper.add(other);
					}
				}
			}
		}*/
	}

	@Override
	public int delete(RelatedPersonnelInformation record) {
		return relatedPersonnelInformationMapper.delete(record.getId());
	}

	@Override
	public int delete(List<RelatedPersonnelInformation> records) {
		for(RelatedPersonnelInformation record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public RelatedPersonnelInformation findById(Long id) {
		return relatedPersonnelInformationMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, relatedPersonnelInformationMapper);
	}
	
}
