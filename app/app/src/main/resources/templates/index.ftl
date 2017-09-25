<#-- head头文件 -->
<#include "/common/header.ftl" />
<#-- ---------------------------------------------------------------------------- -->

<h3>测试主页</h3>
<form action="/login?logout" method="post">
  <input type="hidden" name="username" value="user1" />
  <input type="submit" value="注销"/>
</form>

<#-- ---------------------------------------------------------------------------- -->
<#-- foot尾文件 -->
<#include "/common/footer.ftl" />