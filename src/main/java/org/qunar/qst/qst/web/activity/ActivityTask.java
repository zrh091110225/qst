package org.qunar.qst.qst.web.activity;

import org.qunar.qst.qst.entity.User;
import org.qunar.qst.qst.service.account.AccountService;
import org.qunar.qst.qst.util.ExcelView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * Created by ronghaizheng on 15/3/6.
 */
@Controller
@RequestMapping(value = "/activity")
public class ActivityTask {
    private static Logger log = LoggerFactory.getLogger(ActivityTask.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "export", method = RequestMethod.GET)
    public ModelAndView list(Model model,
                             ServletRequest request) {
        List<User> userList = accountService.getAllUser();
        log.info("导出用户数={}", userList.size());
        return new ModelAndView(new ExcelView<User>(userList, "用户列表"));
    }
}
