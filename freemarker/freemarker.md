Freemarker Tpl
=====================================
Java Web 领先的模板语言

## 一.指令Directs
* <#if>指令
   ``` 
    <#if animals.python.price < animals.elephant.price>
        Pythons are cheaper than elephants today.
    <#elseif animals.python.price > animals.elephant.price>
        Elephants are cheaper than pythons today.
    <#else>
        Elephants and pythons cost the same today.
    </#if>

    <#if usr == "Boss">Hello Boss<#else>Hello Guy</#if>
   ```
      
