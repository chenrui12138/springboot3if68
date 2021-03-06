package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;

import com.entity.UserEntity;
import com.service.UserService;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YonghuEntity;
import com.entity.view.YonghuView;

import com.service.YonghuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 用户
 * 后端接口
 *
 * @author
 * @email
 * @date 2021-11-30 14:36:35
 */
@RestController
@RequestMapping("/yonghu")
public class YonghuController {
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("gonghao", username.toUpperCase()));
        if (user == null || !user.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }

        String token = tokenService.generateToken(user.getId(), username, "yonghu", "用户");
        return R.ok().put("token", token);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YonghuEntity yonghu) {
        //ValidatorUtils.validateEntity(yonghu);
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("gonghao", yonghu.getGonghao()));
        if (user != null) {
            return R.error("工号已存在");
        }
        YonghuEntity user1 = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("xingming", yonghu.getXingming()));
        if (user1 != null) {
            return R.error("姓名已存在");
        }
        Long uId = new Date().getTime();
        yonghu.setId(uId);
        yonghuService.insert(yonghu);
        return R.ok();
    }


    /**
     * 退出
     */
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request) {
        Long id = (Long) request.getSession().getAttribute("userId");
        YonghuEntity user = yonghuService.selectById(id);
        return R.ok().put("data", user);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("gonghao", username));
        if (user == null) {
            return R.error("账号不存在");
        }
        user.setMima("123456");
        yonghuService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YonghuEntity yonghu,
                  HttpServletRequest request) {
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghu), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, YonghuEntity yonghu,
                  HttpServletRequest request) {
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(YonghuEntity yonghu) {
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        ew.allEq(MPUtil.allEQMapPre(yonghu, "yonghu"));
        return R.ok().put("data", yonghuService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YonghuEntity yonghu) {
        EntityWrapper<YonghuEntity> ew = new EntityWrapper<YonghuEntity>();
        ew.allEq(MPUtil.allEQMapPre(yonghu, "yonghu"));
        YonghuView yonghuView = yonghuService.selectView(ew);
        return R.ok("查询用户成功").put("data", yonghuView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        YonghuEntity yonghu = yonghuService.selectById(id);
        return R.ok().put("data", yonghu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        YonghuEntity yonghu = yonghuService.selectById(id);
        return R.ok().put("data", yonghu);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
        yonghu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(yonghu);
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("gonghao", yonghu.getGonghao()));
        if (user != null) {
            return R.error("用户已存在");
        }
//		yonghu.setId(new Date().getTime());
        yonghuService.insert(yonghu);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
        yonghu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(yonghu);
        YonghuEntity user = yonghuService.selectOne(new EntityWrapper<YonghuEntity>().eq("gonghao", yonghu.getGonghao()));
        if (user != null) {
            return R.error("用户已存在");
        }
//		yonghu.setId(new Date().getTime());
        yonghuService.insert(yonghu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YonghuEntity yonghu, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(yonghu);
        if (Objects.equals("管理员", yonghu.getRole())) {
            UserEntity userEntity = new UserEntity();
            userEntity.setGonghao(yonghu.getGonghao());
            userEntity.setPassword(yonghu.getMima());
            userEntity.setRole(yonghu.getRole());
            userEntity.setLianxidianhua(yonghu.getLianxidianhua());
            userEntity.setXingming(yonghu.getXingming());
            userEntity.setXingbie(yonghu.getXingbie());
            //判断user表中是否存在该工号
            UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>()
                    .eq("gonghao", yonghu.getGonghao()));
            if (Objects.isNull(user)) {
                //新增users表
                userEntity.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
                userEntity.setAddtime(new Date());
                userService.insert(userEntity);
            } else {
                userEntity.setId(user.getId());
                userEntity.setAddtime(user.getAddtime());
                userService.updateById(userEntity);
            }

            //全部更新
            yonghuService.updateById(yonghu);
            return R.ok();
        }

        if (Objects.equals("用户", yonghu.getRole())) {

            //判断用户表里是否有该工号
            YonghuEntity yonghuEntity = yonghuService.selectOne(new EntityWrapper<YonghuEntity>()
                    .eq("gonghao", yonghu.getGonghao()));
            if (Objects.isNull(yonghuEntity)){
                return R.error("您没有权限更改此用户的角色");
            }

            //判断user表中是否存在该工号
            UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>()
                    .eq("gonghao", yonghu.getGonghao()));
            if (!Objects.isNull(user)) {
                //删除users信息
                userService.deleteById(user);
                //更新yonghu信息
                yonghuService.updateById(yonghu);
            } else {
                //更新yonghu信息
                yonghuService.updateById(yonghu);
            }

            return R.ok();
        }

        return R.error("没有该角色");
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        yonghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if (type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if (map.get("remindstart") != null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if (map.get("remindend") != null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<YonghuEntity> wrapper = new EntityWrapper<YonghuEntity>();
        if (map.get("remindstart") != null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if (map.get("remindend") != null) {
            wrapper.le(columnName, map.get("remindend"));
        }


        int count = yonghuService.selectCount(wrapper);
        return R.ok().put("count", count);
    }


}
