<#include "header.ftl">


    <div id="main">
    

        <div class="container" id="daily">
            <div class="jscroll-inner">
                <div class="daily">
                    <#assign cur_date="" />
                    <#list vos! as vo>
                        <#assign createdDate>${vo.news.createdDate?string('yyyy-MM-dd')}</#assign>
                        <#if (cur_date != createdDate)>
                            <#if vo_index gt 0 >
                             </div> <#-- 上一个要收尾 -->
                            </#if>
                            <#assign cur_date>${createdDate!}</#assign>
                    <h3 class="date">
                        <i class="fa icon-calendar"></i>
                        <span>头条资讯 &nbsp; ${createdDate!}</span>
                    </h3>
                        </#if>
                    <div class="posts">

                        <div class="post">
                            <div class="votebar">
                                <button class="click-like up" aria-pressed="false" title="赞同"><i class="vote-arrow"></i><span class="count">${vo.news.likeCount!}</span></button>
                                <button class="click-dislike down" aria-pressed="true" title="反对"><i class="vote-arrow"></i>
                                </button>
                            </div>
                            <div class="content" data-url="/news/${vo.news.id!}">
                                <div >
                                    <img class="content-img" src="${vo.news.image!}" alt="">
                                </div>
                                <div class="content-main">
                                    <h3 class="title">
                                        <a target="_blank" rel="external nofollow" href="/news/${vo.news.id!}">${vo.news.title!}</a>
                                    </h3>
                                    <div class="meta">
                                        ${vo.news.link!}
                                        <span>
                                            <i class="fa icon-comment"></i> ${vo.news.commentCount!}
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="user-info">
                                <div class="user-avatar">
                                    <a href="/user/${vo.user.id!}/"><img width="32" class="img-circle" src="${vo.user.headUrl!}"></a>
                                </div>

                            </div>

                            <div class="subject-name">来自 <a href="/user/${vo.user.id!}/">${vo.user.name!}</a></div>
                        </div>
                    <#--最后有个元素要收尾 -->
                     <#if vo_has_next> </div> </#if>
                 </#list>

                    </div>
                </div>
            </div>
        </div>

    </div>

<#include "footer.ftl">