package cn.windy.module.wechat.service.impl;

import cn.windy.kernel.service.impl.BaseService;
import cn.windy.module.wechat.model.WeChatSetting;
import cn.windy.module.wechat.repository.WeChatSettingRepository;
import cn.windy.module.wechat.service.IWeChatSettingService;
import cn.windy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeChatSettingService extends BaseService<WeChatSetting,WeChatSettingRepository>
        implements IWeChatSettingService{

    @Autowired
    WeChatSettingRepository weChatSettingRepository;

    @Override
    public Page<WeChatSetting> findBySetting(WeChatSetting setting, Pageable pageable) {
        Specification<WeChatSetting> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if(!StringUtil.isBlank(setting.getCompany())){
                predicate.add(criteriaBuilder.like(root.get("company").as(String.class),"%"+setting.getCompany()+"%"));
            }
            if(!StringUtil.isBlank(setting.getDomain())){
                predicate.add(criteriaBuilder.like(root.get("domain").as(String.class),"%"+setting.getDomain()+"%"));
            }

            Predicate[] pre = new Predicate[predicate.size()];
            return criteriaQuery.where(predicate.toArray(pre)).getRestriction();
        };
        return weChatSettingRepository.findAll(specification,pageable);
    }

    @Transactional
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            weChatSettingRepository.deleteById(id);
        }
    }
}
