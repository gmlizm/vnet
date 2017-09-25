<#-- head头文件 -->
<#include "/common/header.ftl" />
<#-- ---------------------------------------------------------------------------- -->
  
    <h3>Test Login with Username and Password</h3>
    <form name='f' action='/login' method='POST'> 
      <table> 
        <tr>
          <td>User:</td>
          <td><input type='text' name='username' value=''></td>
        </tr> 
        <tr>
          <td>Password:</td>
          <td><input type='password' name='password'/></td>
        </tr> 
        <tr>
        <td colspan='2'>
          <input name="submit" type="submit" value="Login"/></td></tr> 
           </table>
       </form>

<#-- ---------------------------------------------------------------------------- -->
<#-- foot尾文件 -->
<#include "/common/footer.ftl" />