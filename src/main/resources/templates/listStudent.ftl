<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
     <#list userList as item>
     <tr>
         <td>${item.id!}</td>
         <td>${item.name!}</td>
     </tr>
     </#list>
</table>

