<#include "header.ftl">
    <div id="main">
        <div class="container">
            <div class="post detail">

                <div class="votebar">
                    <button class="click-like up" aria-pressed="false" title="赞同"><i class="vote-arrow"></i><span class="count">${news.likeCount!}</span></button>
                    <button class="click-dislike down" aria-pressed="true" title="反对"><i class="vote-arrow"></i>
                    </button>
                </div>

                <div class="content" data-url="#">
                      <div class="content-img">
                          <img src="${news.image!}" alt="">
                      </div>
                      <div class="content-main">
                          <h3 class="title">
                              <a target="_blank" rel="external nofollow" href="#">${news.title!}</a>
                          </h3>
                          <div class="meta">
                              ${news.link!}
                              <span>
                                  <i class="fa icon-comment"></i> ${news.commentCount!}
                              </span>
                          </div>
                      </div>
                  </div>
            <div class="user-info">
                <div class="user-avatar">
                    <a href="/user/${owner.id!}"><img width="32" class="img-circle" src="${owner.headUrl!}"></a>
                </div>

                </div>

                <div class="subject-name">来自 <a href="/user/${owner.id!}">${owner.name!}</a></div>
            </div>


            <div class="post-comment-form">
            <#if user??>
                <span>评论 (${news.commentCount!})</span>
                <form method="post" action="/addComment">
                  <div class="form-group text required comment_content">
                      <label class="text required sr-only">
                          <abbr title="required">*</abbr> 评论
                      </label>
                      <input type="hidden" name="newsId" value="${news.id!}"/>
                      <textarea rows="5" class="text required comment-content form-control" name="content" id="content"></textarea>
                  </div>
                  <div class="text-right">
                    <input type="submit" name="commit" value="提 交" class="btn btn-default btn-info">
                  </div>
                </form>
                <#else>
                <div class="login-actions">
                    <a class="btn btn-success" href="/?pop=1">登录后评论</a>
                </div>
            </#if>
            </div>

            <div id="comments" class="comments">
                <#list commentVOs! as commentvo>
                <div class="media">
                    <a class="media-left" href="/user/${commentvo.user.id!}">
                        <img src="${commentvo.user.headUrl!}">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading"> <small class="date">${commentvo.comment.createdDate?string('yyyy-MM-dd HH:mm:ss')}
                           </small></h4>
                        <div>${commentvo.comment.content!}</div>
                    </div>
                </div>
                </#list>
            </div>

        </div>
        <script type="text/javascript">
          $(function(){

            // If really is weixin
            $(document).on('WeixinJSBridgeReady', function() {

              $('.weixin-qrcode-dropdown').show();

              var options = {
                "img_url": "",
                "link": "http://nowcoder.com/j/wt2rwy",
                "desc": "",
                "title": "读《Web 全栈工程师的自我修养》"
              };

              WeixinJSBridge.on('menu:share:appmessage', function (argv){
                WeixinJSBridge.invoke('sendAppMessage', options, function (res) {
                  // _report('send_msg', res.err_msg)
                });
              });

              WeixinJSBridge.on('menu:share:timeline', function (argv) {
                WeixinJSBridge.invoke('shareTimeline', options, function (res) {
                  // _report('send_msg', res.err_msg)
                });
              });

              // $(window).on('touchmove scroll', function() {
              //   if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
              //     $('div.backdrop').show();
              //     $('div.share-help').show();
              //   } else {
              //     $('div.backdrop').hide();
              //     $('div.share-help').hide();
              //   }
              // });

            });

          })
        </script>
    </div>

<#include "footer.ftl">