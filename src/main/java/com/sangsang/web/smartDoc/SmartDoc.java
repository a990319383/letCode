package com.sangsang.web.smartDoc;

import com.power.common.util.DateTimeUtil;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.model.ApiConfig;
import com.power.doc.model.CustomRespField;
import com.power.doc.model.SourceCodePath;


public class SmartDoc {


    public static void main(String[] args) {
        ApiConfig config = new ApiConfig();
        config.setServerUrl("http://192.168.200.12:8081");

        //设置为严格模式，Smart-doc将降至要求每个Controller暴露的接口写上标准文档注释
        config.setStrict(false);

        //当把AllInOne设置为true时，Smart-doc将会把所有接口生成到一个Markdown、HHTML或者AsciiDoc中
        config.setAllInOne(true);

        //HTML5文档，建议直接放到src/main/resources/static/doc下，Smart-doc提供一个配置常量HTML_DOC_OUT_PATH
        config.setOutPath("E:\\smartdoc");

        // 设置接口包扫描路径过滤，如果不配置则Smart-doc默认扫描所有的接口类
        // 配置多个报名有英文逗号隔开
        config.setPackageFilters("com.sangsang.web.controller");

       /* config.setSourceCodePaths(
                SourceCodePath.path().setDesc("本项目代码").setPath("src/main/java/com/quanqiuwa/website/openroad/controller/settlement")
//                ,//smart-doc对路径自动会做处理，无论是window合适linux系统路径，直接拷贝贴入即可
//                SourceCodePath.path().setDesc("加载外部项目源码").setPath("D:\\Develop\\Workspace_qqw3\\settlement-service\\settlement-common\\src\\main\\java"),
//                SourceCodePath.path().setDesc("加载外部项目源码").setPath("D:\\Develop\\Workspace_qqw3\\open-road\\open-road-biz\\src\\main\\java\\com\\quanqiuwa\\website\\openroad\\common")
        );*/

        //自定义注释
        config.setCustomResponseFields(
                CustomRespField.field().setName("error").setDesc("错误"),
                CustomRespField.field().setName("errorMessage").setDesc("错误信息"),
                CustomRespField.field().setName("value").setDesc("错误数据"),
                CustomRespField.field().setName("message").setDesc("服务器信息"),
                CustomRespField.field().setName("serverTime").setDesc("服务器时间"),
                CustomRespField.field().setName("code").setDesc("状态值"),
                CustomRespField.field().setName("msg").setDesc("提示信息"),
                CustomRespField.field().setName("data").setDesc("返回值"),
                CustomRespField.field().setName("total").setDesc("总数"),
                CustomRespField.field().setName("object").setDesc("数据"),
                CustomRespField.field().setName("list").setDesc("列表"),
                CustomRespField.field().setName("pageNum").setDesc("当前页"),
                CustomRespField.field().setName("pageSize").setDesc("每页数量"),
                CustomRespField.field().setName("size").setDesc("当前页的数量"),
                CustomRespField.field().setName("startRow").setDesc("当前页面第一个元素在数据库中的行号"),
                CustomRespField.field().setName("endRow").setDesc("当前页面最后一个元素在数据库中的行号"),
                CustomRespField.field().setName("pages").setDesc("总页数"),
                CustomRespField.field().setName("prePage").setDesc("前一页"),
                CustomRespField.field().setName("nextPage").setDesc("下一页"),
                CustomRespField.field().setName("isFirstPage").setDesc("是否为第一页"),
                CustomRespField.field().setName("isLastPage").setDesc("是否为最后一页"),
                CustomRespField.field().setName("hasPreviousPage").setDesc("是否有前一页"),
                CustomRespField.field().setName("hasNextPage").setDesc("是否有下一页"),
                CustomRespField.field().setName("navigatePages").setDesc("导航页码数"),
                CustomRespField.field().setName("navigatepageNums").setDesc("所有导航页号"),
                CustomRespField.field().setName("navigateFirstPage").setDesc("导航条上的第一页"),
                CustomRespField.field().setName("navigateLastPage").setDesc("导航条上的最后一页")

        );

        long start = System.currentTimeMillis();
        HtmlApiDocBuilder.buildApiDoc(config);
        long end = System.currentTimeMillis();

        DateTimeUtil.printRunTime(end, start);
    }

}