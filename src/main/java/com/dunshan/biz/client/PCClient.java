package com.dunshan.biz.client;

import com.dunshan.biz.model.User;
import com.dunshan.common.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xuxinwei
 * @create 2019-10-20
 */
@FeignClient(name = "PC-SERVICE")
@Component
public interface PCClient {

  @PostMapping("/pc/add")
  ResultVO<Boolean> add(@RequestBody User user);

  @PostMapping("/pc/update")
  ResultVO<Boolean> update(@RequestBody User user);

  @PostMapping("/pc/delete/{id}")
  ResultVO<Boolean> delete(@PathVariable("id") String id);

  @GetMapping("/pc/query/{id}")
  ResultVO<User> get(@PathVariable("id") String id);


  @PostMapping("/pcd/add")
  ResultVO<Boolean> add4cd(@RequestBody User user);

  @PostMapping("/pcd/update")
  ResultVO<Boolean> update4cd(@RequestBody User user);

  @PostMapping("/pcd/delete/{id}")
  ResultVO<Boolean> delete4cd(@PathVariable("id") String id);

  @GetMapping("/pcd/query/{id}")
  ResultVO<User> get4cd(@PathVariable("id") String id);
}
