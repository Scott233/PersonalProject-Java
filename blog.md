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
            <li><a href="#exception">异常处理说明</a></li>
            <li><a href="#achievement">心路历程与收获</a></li>
        </ol>
    </li>
</ul>

<h2 id="task1">任务一：重新阅读《构建之法》并提问</h2>

<h3 id="question1">问题1：？</h3>
<h3 id="question2">问题2：？</h3>
<h3 id="question3">问题3：？</h3>
<h3 id="question4">问题4：？</h3>
<h3 id="question5">问题5：？</h3>

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
    //不支持生成实例
    private Util() {
        throw new UnsupportedOperationException(/*...*/);
    }

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

<h3 id="improvement">性能改进</h3>

* 文件读写是耗时操作，如果一次只读写一个字符，会产生大量系统调用，效率低下，故全部采用BufferedReader和BufferedWriter包装
* 对出现频率最高的词汇的排序采用Stream类的sort算法而非ArrayList的sort算法，在数据量超过10000的情况下，效率有明显提升

<h3 id="exception">部分异常处理说明</h3>

```java
/*主方法先调用ensureArguments方法检查输入参数*/
ensureArguments(args);

/*ensureArguments方法的实现*/
private static void ensureArguments(String[]args){
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
}

/*Reader、Writer等字符流使用了Java7引进的try-with-resources语句块*/
try(final Reader reader=...; final Writer writer=...){
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