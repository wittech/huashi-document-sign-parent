package com.louis.kitty.admin.sevice.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.admin.dao.AssetTypeCarMapper;
import com.louis.kitty.admin.dao.AssetTypeHousesMapper;
import com.louis.kitty.admin.dao.AssetTypeLandMapper;
import com.louis.kitty.admin.dao.AssetTypeOtherMapper;
import com.louis.kitty.admin.dao.AssetTypeSecuritiesMapper;
import com.louis.kitty.admin.dao.HouseholdIncomeMapper;
import com.louis.kitty.admin.dao.RelatedPersonnelInformationMapper;
import com.louis.kitty.admin.model.AssetTypeCar;
import com.louis.kitty.admin.model.AssetTypeHouses;
import com.louis.kitty.admin.model.AssetTypeLand;
import com.louis.kitty.admin.model.AssetTypeOther;
import com.louis.kitty.admin.model.AssetTypeSecurities;
import com.louis.kitty.admin.model.RelatedPersonnelInformation;
import com.louis.kitty.admin.sevice.RelatedPersonnelInformationService;
import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

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
			record.setCoupleId(0L);
			record.setCreateTime(new Date());
			int i = relatedPersonnelInformationMapper.add(record);
			//获取相关人id
			Long id = record.getId();
			if(id>0){
				//存储房屋
				if(record.getAssetTypeHouses() !=null){
					for(AssetTypeHouses house : record.getAssetTypeHouses()){
						house.setCreateBy(record.getCreateBy());
						house.setCreateTime(new Date());
						house.setRpiId(id);
						assetTypeHousesMapper.add(house);
					}
				}
				//存储土地
				if(record.getAssetTypeLand() !=null){
					for(AssetTypeLand land : record.getAssetTypeLand()){
						land.setCreateBy(record.getCreateBy());
						land.setCreateTime(new Date());
						land.setRpiId(id);
						assetTypeLandMapper.add(land);
					}
				}
				//存储汽车
				if(record.getAssetTypeCar() !=null){
					for(AssetTypeCar car : record.getAssetTypeCar()){
						car.setCreateBy(record.getCreateBy());
						car.setCreateTime(new Date());
						car.setRpiId(id);
						assetTypeCarMapper.add(car);
					}
				}
				//存储证券
				if(record.getAssetTypeSecurities() !=null){
					for(AssetTypeSecurities aecurities : record.getAssetTypeSecurities()){
						aecurities.setCreateBy(record.getCreateBy());
						aecurities.setCreateTime(new Date());
						aecurities.setRpiId(id);
						assetTypeSecuritiesMapper.add(aecurities);
					}
				}
				//存储其他
				if(record.getAssetTypeOther() !=null){
					for(AssetTypeOther other : record.getAssetTypeOther()){
						other.setCreateBy(record.getCreateBy());
						other.setCreateTime(new Date());
						other.setRpiId(id);
						assetTypeOtherMapper.add(other);
					}
				}
				//保存家庭收支情况
				if(record.getHouseholdIncomeForm() !=null){
					record.getHouseholdIncomeForm().setCreateBy(record.getCreateBy());
					record.getHouseholdIncomeForm().setCreateTime(new Date());
					record.getHouseholdIncomeForm().setLoanBasisId(record.getLoanBasisId());
					record.getHouseholdIncomeForm().setRpiId(id);
					householdIncomeMapper.add(record.getHouseholdIncomeForm());
				}
			}
			//保存配偶数据
			saveSpouseInfo(record,id);
			return i;
		}
		record.setLastUpdateTime(new Date());
		//获取相关人id
		Long id = record.getId();
		if(id>0){
			//存储房屋
			if(record.getAssetTypeHouses() !=null){
				for(AssetTypeHouses house : record.getAssetTypeHouses()){
					house.setLastUpdateBy(record.getLastUpdateBy());
					house.setLastUpdateTime(new Date());
					house.setRpiId(id);
					assetTypeHousesMapper.update(house);
				}
			}
			//存储土地
			if(record.getAssetTypeLand() !=null){
				for(AssetTypeLand land : record.getAssetTypeLand()){
					land.setLastUpdateBy(record.getLastUpdateBy());
					land.setLastUpdateTime(new Date());
					land.setRpiId(id);
					assetTypeLandMapper.update(land);
				}
			}
			//存储汽车
			if(record.getAssetTypeCar() !=null){
				for(AssetTypeCar car : record.getAssetTypeCar()){
					car.setLastUpdateBy(record.getLastUpdateBy());
					car.setLastUpdateTime(new Date());
					car.setRpiId(id);
					assetTypeCarMapper.update(car);
				}
			}
			//存储证券
			if(record.getAssetTypeSecurities() !=null){
				for(AssetTypeSecurities aecurities : record.getAssetTypeSecurities()){
					aecurities.setLastUpdateBy(record.getLastUpdateBy());
					aecurities.setLastUpdateTime(new Date());
					aecurities.setRpiId(id);
					assetTypeSecuritiesMapper.update(aecurities);
				}
			}
			//存储其他
			if(record.getAssetTypeOther() !=null){
				for(AssetTypeOther other : record.getAssetTypeOther()){
					other.setLastUpdateBy(record.getLastUpdateBy());
					other.setLastUpdateTime(new Date());
					other.setRpiId(id);
					assetTypeOtherMapper.update(other);
				}
			}
			//保存家庭收支情况
			if(record.getHouseholdIncomeForm() !=null){
				record.getHouseholdIncomeForm().setLastUpdateBy(record.getLastUpdateBy());
				record.getHouseholdIncomeForm().setLastUpdateTime(new Date());
				record.getHouseholdIncomeForm().setLoanBasisId(record.getLoanBasisId());
				record.getHouseholdIncomeForm().setRpiId(id);
				householdIncomeMapper.update(record.getHouseholdIncomeForm());
			}
		}
		updateSpouseInfo(record,id);
		return relatedPersonnelInformationMapper.update(record);
	}
	
	/**
	 * 保存配偶数据
	 * @param record
	 */
	private void saveSpouseInfo(RelatedPersonnelInformation r,Long parentId){
		if(r.getSpouseInfo() !=null){
			//已婚的时候存储配偶信息
			if(r.getMaritalStatus()>0 && r.getMaritalStatus() !=null){
				if(r.getMaritalStatus()==1){
					RelatedPersonnelInformation record = r.getSpouseInfo();
					record.setCoupleId(parentId);
					record.setCreateTime(new Date());
					record.setCreateBy(r.getCreateBy());
					relatedPersonnelInformationMapper.add(record);
					//获取相关人id
					Long id = record.getId();
					if(id>0){
						//存储房屋
						if(record.getAssetTypeHouses() !=null){
							for(AssetTypeHouses house : record.getAssetTypeHouses()){
								house.setCreateBy(record.getCreateBy());
								house.setCreateTime(new Date());
								house.setRpiId(id);
								assetTypeHousesMapper.add(house);
							}
						}
						//存储土地
						if(record.getAssetTypeLand() !=null){
							for(AssetTypeLand land : record.getAssetTypeLand()){
								land.setCreateBy(record.getCreateBy());
								land.setCreateTime(new Date());
								land.setRpiId(id);
								assetTypeLandMapper.add(land);
							}
						}
						//存储汽车
						if(record.getAssetTypeCar() !=null){
							for(AssetTypeCar car : record.getAssetTypeCar()){
								car.setCreateBy(record.getCreateBy());
								car.setCreateTime(new Date());
								car.setRpiId(id);
								assetTypeCarMapper.add(car);
							}
						}
						//存储证券
						if(record.getAssetTypeSecurities() !=null){
							for(AssetTypeSecurities aecurities : record.getAssetTypeSecurities()){
								aecurities.setCreateBy(record.getCreateBy());
								aecurities.setCreateTime(new Date());
								aecurities.setRpiId(id);
								assetTypeSecuritiesMapper.add(aecurities);
							}
						}
						//存储其他
						if(record.getAssetTypeOther() !=null){
							for(AssetTypeOther other : record.getAssetTypeOther()){
								other.setCreateBy(record.getCreateBy());
								other.setCreateTime(new Date());
								other.setRpiId(id);
								assetTypeOtherMapper.add(other);
							}
						}
					}
				}
			}
			//保存家庭收支情况
			/*if(r.getHouseholdIncomeForm() !=null){
				r.getHouseholdIncomeForm().setLoanBasisId(r.getLoanBasisId());
				r.getHouseholdIncomeForm().setRpiId(r.getId());
				householdIncomeMapper.add(r.getHouseholdIncomeForm());
			}*/
		}
	}
	
	/**
	 * 修改配偶数据
	 * @param record
	 */
	private void updateSpouseInfo(RelatedPersonnelInformation r,Long parentId){
		if(r.getSpouseInfo() !=null){
			//已婚的时候存储配偶信息
			if(r.getMaritalStatus()>0 && r.getMaritalStatus() !=null){
				if(r.getMaritalStatus()==1){
					RelatedPersonnelInformation record = r.getSpouseInfo();
					record.setCoupleId(parentId);
					record.setCreateTime(new Date());
					record.setCreateBy(r.getCreateBy());
					relatedPersonnelInformationMapper.update(record);
					//获取相关人id
					Long id = record.getId();
					if(id>0){
						//存储房屋
						if(record.getAssetTypeHouses() !=null){
							for(AssetTypeHouses house : record.getAssetTypeHouses()){
								house.setCreateBy(record.getCreateBy());
								house.setCreateTime(new Date());
								house.setRpiId(id);
								assetTypeHousesMapper.update(house);
							}
						}
						//存储土地
						if(record.getAssetTypeLand() !=null){
							for(AssetTypeLand land : record.getAssetTypeLand()){
								land.setCreateBy(record.getCreateBy());
								land.setCreateTime(new Date());
								land.setRpiId(id);
								assetTypeLandMapper.update(land);
							}
						}
						//存储汽车
						if(record.getAssetTypeCar() !=null){
							for(AssetTypeCar car : record.getAssetTypeCar()){
								car.setCreateBy(record.getCreateBy());
								car.setCreateTime(new Date());
								car.setRpiId(id);
								assetTypeCarMapper.update(car);
							}
						}
						//存储证券
						if(record.getAssetTypeSecurities() !=null){
							for(AssetTypeSecurities aecurities : record.getAssetTypeSecurities()){
								aecurities.setCreateBy(record.getCreateBy());
								aecurities.setCreateTime(new Date());
								aecurities.setRpiId(id);
								assetTypeSecuritiesMapper.update(aecurities);
							}
						}
						//存储其他
						if(record.getAssetTypeOther() !=null){
							for(AssetTypeOther other : record.getAssetTypeOther()){
								other.setCreateBy(record.getCreateBy());
								other.setCreateTime(new Date());
								other.setRpiId(id);
								assetTypeOtherMapper.update(other);
							}
						}
					}
				}
			}
			//保存家庭收支情况
			/*if(r.getHouseholdIncomeForm() !=null){
				r.getHouseholdIncomeForm().setLoanBasisId(r.getLoanBasisId());
				r.getHouseholdIncomeForm().setRpiId(r.getId());
				householdIncomeMapper.add(r.getHouseholdIncomeForm());
			}*/
		}
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

	@Override
	public List<RelatedPersonnelInformation> findByBaseIdList(Long loanBasisId) {
		return relatedPersonnelInformationMapper.findByBaseIdList(loanBasisId);
	}

	@Override
	public RelatedPersonnelInformation findByBaseIdAndType(RelatedPersonnelInformation record) {
		RelatedPersonnelInformation r = relatedPersonnelInformationMapper.findByBaseIdAndType(record);
		if(r !=null){
			Long id = r.getId();
			RelatedPersonnelInformation rs = new RelatedPersonnelInformation();
			rs.setCoupleId(id);
			rs.setLoanBasisId(r.getLoanBasisId());
			//配偶数据
			RelatedPersonnelInformation rf = relatedPersonnelInformationMapper.findByBaseIdAndType(rs);
			if(rf !=null){
				r.setSpouseInfo(rf);
				Long rid = rf.getId();
				r.getSpouseInfo().setSpouseInfo(relatedPersonnelInformationMapper.findByBaseIdAndType(rs));
				r.getSpouseInfo().setHouseholdIncomeForm(householdIncomeMapper.findByRpiId(rid));
				r.getSpouseInfo().setAssetTypeHouses(assetTypeHousesMapper.findByRpiId(rid));
				r.getSpouseInfo().setAssetTypeCar(assetTypeCarMapper.findByRpiId(rid));
				r.getSpouseInfo().setAssetTypeLand(assetTypeLandMapper.findByRpiId(rid));
				r.getSpouseInfo().setAssetTypeOther(assetTypeOtherMapper.findByRpiId(rid));
				r.getSpouseInfo().setAssetTypeSecurities(assetTypeSecuritiesMapper.findByRpiId(rid));
			}
			r.setSpouseInfo(relatedPersonnelInformationMapper.findByBaseIdAndType(rs));
			r.setHouseholdIncomeForm(householdIncomeMapper.findByRpiId(id));
			r.setAssetTypeHouses(assetTypeHousesMapper.findByRpiId(id));
			r.setAssetTypeCar(assetTypeCarMapper.findByRpiId(id));
			r.setAssetTypeLand(assetTypeLandMapper.findByRpiId(id));
			r.setAssetTypeOther(assetTypeOtherMapper.findByRpiId(id));
			r.setAssetTypeSecurities(assetTypeSecuritiesMapper.findByRpiId(id));
		}
		return r;
	}

}
