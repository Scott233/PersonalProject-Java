<h1>软工实践寒假作业（2/2）</h1>
<table>
    <tr>
        <td>这个作业要求在哪</td>
        <td><a href="https://edu.cnblogs.com/campus/fzu/FZUSESPR21/homework/11672">软工实践寒假作业（2/2）</a></td>
    </tr>
    <tr>
        <td>这个作业的目标</td>
        <td>
            <ul>
                <li>重读阅读之法提出问题</li>
                <li>熟悉github的使用</li>
                <li>编写字符统计程序</li>
                <li>学会单元测试</li>
            </ul>
        </td>
    </tr>
    <tr>
        <td>其它参考文献</td>
        <td>《Effective Java》、《Java设计模式》</td>
    </tr>
</table>
<h2>目录</h2>
<ul>
    <li>
        <a href="#task1">任务一：重新阅读《构建之法》并提问</a>
        <ol>
            <li><a href="#question1">问题1</a></li>
            <li><a href="#question2">问题2</a></li>
            <li><a href="#question3">问题3</a></li>
            <li><a href="#question4">问题4</a></li>
            <li><a href="#question5">问题5</a></li>
        </ol>
    </li>
    <li>
        <a href="#task2">任务二：WordCount字数统计作业</a>
        <ol>
            <li><a href="#projectAddress">Github项目地址</a></li>
            <li><a href="#psp">PSP表格</a></li>
            <li><a href="#idea">解题思路</a></li>
            <li><a href="#codeStyle">代码规范</a></li>
            <li><a href="#design">接口设计和实现</a></li>
            <li><a href="#improvement">性能改进</a></li>
            <li><a href="#unitTest">单元测试</a></li>
            <li><a href="#exception">异常处理说明</a></li>
            <li><a href="#achievement">心路历程与收获</a></li>
        </ol>
    </li>
</ul>

<h2 id="task1">任务一：重新阅读《构建之法》并提问</h2>

<h3 id="question1">问题1：为什么要进行单元测试？</h3>
> 书中第2章第1节：“如何能让自己负责的模块功能定义尽量明确，模块内部的改变不会影响其他模块，而且模块的质量是得到保证的？单元测试就是一个很有效的解决方案。”激发了我对探究在心中已经产生很久的困惑的渴望。(我曾一度以为单元测试是个摆设)

<p>为此，我查阅了以下系列博文：<a href="https://johnnyshieh.me/categories/unit-test/"> https://johnnyshieh.me/categories/unit-test </a> </p>
<p>总结出以下几点：</p>
<ol>
    <li>单元测试，即对程序单元进行测试，在面向过程开发中，一个单元就是一个函数；在面向对象开发中，一个单元就是类的一个方法。</li>
    <li>单元测试的重点是测试类的public方法，private方法是类的内部实现细节，一般不测试。</li>
    <li>单元测试的几点好处：① 促进分离接口和实现，优化代码设计。②节约开发过程中debug的时间。③保证代码工作正确，加强自信心。④便于后期重构或变更时，确保其他模块工作正确。</li>
</ol>

<h3 id="question2">问题2：如何衡量开发者的能力？</h3>
> 书中第17章第4小结提出了一个萝卜与白菜的问题。大致对比了两种开发风格：一种是“萝卜快了不洗泥”，开发速度很快，但bug量惊人的萝卜类型；另一种是“慢工出细活”，速度较慢，但能赶上截止时间且功能稳定，bug量少的白菜类型。究竟哪一种类型的开发者更受青睐？

<h3 id="question3">问题3：如何看待团队协作？</h3>
> 书中关于“代码复审”的章节有提到：鼓励不同职责的成员交叉相互进行代码复审，有利于相互学习。但如今大部分项目开发都奉行前后端分离的模式，各自专注自己精进的部分，甚至存在前端开发者不懂后端语言、后端开发者不懂前端语言的情况。这种团队协作的执行成本和对开发者的要求是否过高？

<h3 id="question4">问题4：如何看待软件开发团队中的官僚模式？</h3>
> 似乎大多数人都对官僚主义嗤之以鼻。而书中第5章第2节列举的十几种软件团队模式中，官僚模式格外显眼。软件开发团队中是否也存在官僚主义？这种官僚主义是否与在行政机关里很常见的官僚主义有本质上的区别？如何避免团队向官僚模式发展？

<h3 id="question5">问题5：除了专业知识、技能以外，软件开发者还需要具备哪些品质以提高竞争力？</h3>
> 书中第3章第1节用足球运动员类比软件开发工程师。除了体能、技术、意识、配合、临场应变等专业领域的品质外，还需要良好的沟通能力。那么软件开发工程师除了必备的专业知识和技能以外，还需要具备哪些良好的品质呢？

<h2 id="task2">任务二：WordCount字数统计作业</h2>

<h3>Github项目地址</h3>
<a id="projectAddress" href="https://github.com/Scott233/PersonalProject-Java"> https://github.com/Scott233/PersonalProject-Java </a>

<h3 id="psp">PSP表格：</h3>
<table>
    <tr>
        <th>Personal Software Process Stages</th>
        <th>预估耗时（分钟）</th>
        <th>实际耗时（分钟）</th>
    </tr>
    <tr>
        <td>计划</td>
        <td>25</td>
        <td>14</td>
    </tr>
    <tr>
        <td>估计这个任务需要多少时间</td>
        <td>5</td>
        <td>11</td>
    </tr>
    <tr>
        <td>开发</td>
        <td>120</td>
        <td>134</td>
    </tr>
    <tr>
        <td>需求分析（包括学习新技术）</td>
        <td>10</td>
        <td>12</td>
    </tr>
    <tr>
        <td>生成设计文档</td>
        <td>20</td>
        <td>30</td>
    </tr>
    <tr>
        <td>设计复审</td>
        <td>10</td>
        <td>14</td>
    </tr>
    <tr>
        <td>代码规范（为目前的开发制定合适的规范）</td>
        <td>10</td>
        <td>19</td>
    </tr>
    <tr>
        <td>具体设计</td>
        <td>30</td>
        <td>41</td>
    </tr>
    <tr>
        <td>具体编码</td>
        <td>480</td>
        <td>620</td>
    </tr>
    <tr>
        <td>代码复审</td>
        <td>120</td>
        <td>93</td>
    </tr>
    <tr>
        <td>测试（自我测试，修改代码，提交修改）</td>
        <td>120</td>
        <td>149</td>
    </tr>
    <tr>
        <td>报告</td>
        <td>60</td>
        <td>98</td>
    </tr>
    <tr>
        <td>测试报告</td>
        <td>40</td>
        <td>55</td>
    </tr>
    <tr>
        <td>计算工作量</td>
        <td>40</td>
        <td>57</td>
    </tr>
    <tr>
        <td>事后总结, 并提出过程改进计划</td>
        <td>30</td>
        <td>22</td>
    </tr>
    <tr>
        <td>合计</td>
        <td>1120</td>
        <td>1467</td>
    </tr>
</table>

<h3 id="idea">解题思路：</h3>
> 读取文件字符流 -> 统计字符数、有效行数等数据并保存 -> 输出被保存的结果

<h3 id="codeStyle">代码规范</h3>
<a href="https://github.com/Scott233/PersonalProject-Java/blob/main/221801101/codeStyle.md"> https://github.com/Scott233/PersonalProject-Java/blob/main/221801101/codeStyle.md </a>

<h3 id="design">接口设计和实现</h3>

<h4>接口设计</h4>

```java
/*Result类，用于保存统计结果*/
public final class Result {
    public final int charCount;
    public final int wordCount;
    public final int lineCount;
    public final Iterable<Map.Entry<String, Integer>> mostFrequent;
    ......
}

/*Counter类，用于读取文件，计数并生成Result*/
public final class Counter {
    public final Result count(String filePath) {
        ......
    }
    ......
}

/*Util类，关键静态方法boolean isWord(Charsequence)用于判断字符序列是否满足作为单词的条件*/
public final class Util {
    public static boolean isWord(Charsequence seq) {
        ......
    }
}

/*Printer类，用于输出Result*/
public final class Printer {
    public void print(Result result, String outputFilePath) {
        ......
    }
}
```

<h4>计数方法实现</h4>
<ul>
    <li>用BufferedReader包装FileReader读取文件字符流。</li>
    <li>用两个int统计字符数和有效行数，用一个StringBuilder保存可能是单词的字符序列，用HashMap保存单词频率。</li>
    <li>一个字符一个字符地读取，遇到字母或数字则append到StringBuilder中，遇到分隔符就用Util判断是否为单词，是的话HashMap中的相应记录就+1,不是就清空StringBuilder。</li>
    <li>用一个bool变量保存当前行是否有非空字符，读取到换行符时根据该布尔值行数+1。</li>
    <li>读取完毕后，根据HashMap生成按出现频率和字母序排序过的可迭代对象，将其连同字符数、行数一同保存到Result中并返回，等待Printer类输出。</li>
</ul>


<h3 id="improvement">性能改进</h3>

* 文件读写是耗时操作，如果一次只读写一个字符，会产生大量系统调用，效率低下，故全部采用BufferedReader和BufferedWriter包装
* 对出现频率最高的词汇的排序采用Stream类的sort算法而非ArrayList的sort算法，在数据量超过10000的情况下，效率有明显提升

<h3 id="unitTest">单元测试</h3>
<ul>
    <li>单元测试类的目录在src/test下，使用了JUnit5，主要测试了Counter的count方法、Util的isWord方法和比较了ArrayList类和Stream类的排序算法的性能。</li>
    <li>UtilTest用预定义的字符串测试isWord方法返回值的正确性。</li>
    <li>CounterTest用samples目录下的系列input文件来让counter方法把结果输入到output文件中，将其与samples目录下的标准output文件进行比较，文件内容完全一致则测试通过。</li>
</ul>


<h3 id="exception">部分异常处理说明</h3>

```java
/*主方法先调用ensureArguments方法检查输入参数*/
ensureArguments(args);

/*ensureArguments方法的实现*/
switch(args.length){
    case 0:
        /*无输入文件，抛出异常*/
        throw new IllegalArgumentException("No input file.");
    case 1:
        /*无输出文件，抛出异常*/
        throw new IllegalArgumentException("No output file");
    default:
        /*有输入文件也有输出文件。通过*/
        break;
}

/*Reader、Writer等字符流使用了Java7引进的try-with-resources语句块*/
try(final Reader reader=...;final Writer writer=...){
    ......
}catch(IOException e){
    /*IO异常均打印StackTrace*/
    e.printStackTrace();
}
```

<h3 id="achievement">心路历程与收获</h3>
> Git和Github以前就有学习，也经常使用，不多说。
>
> 最大的收获应该是在单元测试这方面。
>
> 以前做Android项目的时候，经常会在src文件夹中看到除了main以外多出的test和androidTest目录，知道有JUnit这个东西，知道@Test注解的方法可以像平时写的main方法一样运行，但从来不知道具体应该是怎么使用。
>
> 现在大概明白了，对以后的项目开发很有帮助。