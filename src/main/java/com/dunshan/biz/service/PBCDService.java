package com.dunshan.biz.service;

import com.dunshan.biz.client.PCClient;
import com.dunshan.biz.model.User;
import com.dunshan.common.ErpConstants;
import com.dunshan.common.exception.BusinessErrorException;
import com.dunshan.common.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuxinwei
 * @create 2019-11-18
 */
@Service
public class PBCDService {

  private static final Logger logger = LoggerFactory.getLogger(PBCDService.class);

  @Autowired
  private PBService pbService;

  @Autowired
  private PCClient pcClient;


  public User getById(String id) {
    User result = pbService.getById(id);
    ResultVO<User> pbUser = pcClient.get4cd(id);
    logger.info("pcClient get4cd result: " + pbUser);
    return result;
  }

  @Transactional
  public Boolean add(User user) {
    Boolean result = pbService.add(user);
    ResultVO<Boolean> pbResult = pcClient.add4cd(user);
    logger.info("pcClient add4cd result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pcClient add error !");
    }
    return result;
  }

  @Transactional
  public Boolean update(User user) {
    Boolean result = pbService.update(user);
    ResultVO<Boolean> pbResult = pcClient.update4cd(user);
    logger.info("pcClient update4cd result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pcClient update error !");
    }
    return result;
  }

  @Transactional
  public Boolean deleteById(String id) {
    Boolean result = pbService.deleteById(id);
    ResultVO<Boolean> pbResult = pcClient.delete4cd(id);
    logger.info("pcClient delete4cd result: " + pbResult);
    if (ErpConstants.ErrorEnum.SUCCESS_200.getIndex() != pbResult.getCode()) {
      throw new BusinessErrorException("pcClient delete error !");
    }
    return result;
  }


}
