# MiraiDIC ——简易mirai词库插件

如你所见，这是一个特别简易的词库插件，只提供变量存取和文件读写功能。

## 使用教程：
1. 安装插件  
2. 启动mirai-console,你会看到在MCL安装文件夹MCL安装路径  config  com.kagg886.miraidic中有dicList文件夹，这就是词库的存放文件夹。这时我们关闭MCL。  
3. 将词库txt文件存入此文件夹后重新启动MCL即可食用  

## 如何编写：
下面的文本为一个标准的词库，我们将以这个词库进行讲解：  
***
作者:kagg886  
版本:1.0  
名称:测试DICwww~  
描述:一个测试DIC罢了，没什么好看的  

  
草  
$存变量 A 1  
数据为%A%!  

存取
$读 file.txt default A  
数据为%A%  
$写 file.txt qwq  
$读 file.txt default A  
数据为%A%  
***

1. 一个词库分为多个功能，它们之间最少需要空缺一行。特殊的，处于文件最开头的功能必须是描述  
2. 一个功能模块由若干指令构成，其中以$开头的为指令，其他的为要发送的消息，**一行一条**  
3. 变量的访问请使用%变量名%，不支持变量套变量的操作，如:%%A%%，也不支持方法套方法，如:$写 file.txt $读 file.txt fky! A，但是支持方法套变量，如$存变量 A %B%

## 预填充变量列表
**它们是bot被执行过程中加载的一些变量**  
%群号%为触发该消息时的群号，下文同理：  
%内容%为文本消息  
%机器人%为bot的qq  
%QQ%为发送者的qq  
%昵称%为发送者的昵称**不是群名片,不是群名片,不是群名片**  

## 函数列表

1. $存变量 变量名 变量值   
顾名思义这是将一个名字为**变量名**的变量赋值为**变量值**  
2. $读 文件名 默认内容 存放变量  
将**文件名**中的文件全部读取并赋给变量**存放变量**，若文件**不存在(不是文件为空)**则赋值**默认内容**  
3. $写 文件名 内容  
在**文件名**的文件内写入文件**内容**  

## 还要什么需要注意的吗？
应该....没了吧x

# 最后，有任何建议什么的，欢迎提出emm。
