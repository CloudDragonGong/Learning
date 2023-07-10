# [Vue](https://v2.cn.vuejs.org/)

## mvvm

![image-20230711000130661](Vue/image-20230711000130661.png)

- 双向数据绑定

## 文件结构

![image-20230711002133880](Vue/image-20230711002133880.png)

~~~html
<!DOCTYPE html>
<html lang='en'>
    <head>
        <meta charset="UTF-8">
        <title>Vue Learning</title>
        <script src = 'js/vue.js'></script>
        <!-- 1.绑定文件 -->
    </head>
    <body>
        <!-- 绑定message对象 -->
        <!-- v-model是指令，v开头的都是 -->
        <div id='app'>
            <input type='text' v-model="message">
            {{message}}
        </div>
    </body>
    <script>
        new Vue({
            el:'#app',  //vue 接管的区域
            data:{
                message:'Hello Vue'
            }
        })
        // 建立对象
    </script>
</html>
~~~

- 效果

  ![image-20230711002349219](Vue/image-20230711002349219.png)

## Vue常用指令

![image-20230711002442108](Vue/image-20230711002442108.png)

~~~html
<!DOCTYPE html>
<html lang='en'>
    <head>
        <meta charset="UTF-8">
        <title>Vue Learning</title>
        <script src = 'js/vue.js'></script>
        <!-- 1.绑定文件 -->
    </head>
    <body>
        <!-- 绑定message对象 -->
        <!-- v-model是指令，v开头的都是 -->
        <div id='app'>
            <!-- 绑定属性 -->
            <a v-bind:href="url">github</a>   
            <a :href="url">github2</a>
            <input type='text' v-model="message">
            {{message}}
        </div>
    </body>
    <script>
        new Vue({
            el:'#app',  //vue 接管的区域
            data:{
                message:"dragongong",
                url : 'https://github.com/CloudDragonGong/'   //属性
            }
        })
        // 建立对象
    </script>
</html>
~~~

![image-20230711010003803](Vue/image-20230711010003803.png)

~~~html
<!DOCTYPE html>
<html lang='en'>
    <head>
        <meta charset="UTF-8">
        <title>Vue Learning</title>
        <script src = 'js/vue.js'></script>
        <!-- 绑定文件 -->
    </head>
    <body>
        <div id='app'>
            <input type="button" value="点我一下" v-on:click = 'handle()'>
            <input type="button" value="再点一次" @click = 'handle()'>
            <!-- v-on:click 是事件，可以有别的种类 -->
            <!-- 第二个是缩写，注意冒号也要省略 -->
        </div>
    </body>
    <script>
        new Vue({
            el:'#app',  //vue 接管的区域
            data:{
               
            },
            // 函数传递
            methods: {
                handle: function(){
                    alert('你点了我一下');
                }
            }
        })
        // 建立对象
    </script>
</html>
~~~

![image-20230711013956933](Vue/image-20230711013956933.png)

~~~html
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset="UTF-8">
    <title>Vue Learning</title>
    <script src='js/vue.js'></script>
    <!-- 绑定文件 -->
</head>

<body>
    <div id='app'>
        <!-- 第一种方式 -->
        <input type='text' v-model="age">
        <span v-if="age > 0 && age < 30">年轻人</span>
        <span v-else-if="age >=30 && age <60">中年人</span>
        <span v-else>老年人</span>
        <!-- 第二种方式 -->
        <br><br>
        <input type='text' v-model="age">
        <span v-show="age > 0 && age < 30">年轻人</span>
        <span v-show="age > 30 && age < 60">中年人</span>
        <span v-show="age >= 60">老年人</span>

    </div>
</body>
<script>
    new Vue({
        el: '#app',  //vue 接管的区域
        data: {
            age: 20
        },
        // 函数传递
        methods: {

        }
    })
        // 建立对象
</script>

</html>
~~~

- 效果

![image-20230711015428264](Vue/image-20230711015428264.png)

- 两者的区别

![image-20230711015433600](Vue/image-20230711015433600.png)

![image-20230711015619646](Vue/image-20230711015619646.png)

~~~html
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset="UTF-8">
    <title>Vue Learning</title>
    <script src='js/vue.js'></script>
    <!-- 绑定文件 -->
</head>

<body>
    <div id='app'>
        <span v-for=" name in city">{{name}}</span>
        <br>
        <span v-for = '(index , name ) in city'>   {{name}}:{{index}}</span>
        <!-- 这里千万别写反了 -->
    </div>
</body>
<script>
    new Vue({
        el: '#app',  //vue 接管的区域
        data: {
            age: 20,
            city:['北京','上海','广州','深圳']
        },
        // 函数传递
        methods: {

        }
    })
        // 建立对象
</script>

</html>
~~~

## 案例

### 需求

![image-20230711021519403](Vue/image-20230711021519403.png)

### 结果

![image-20230711022940905](Vue/image-20230711022940905.png)

### 代码

~~~html
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset="UTF-8">
    <title>Vue Learning</title>
    <script src='js/vue.js'></script>
    <!-- 绑定文件 -->
</head>

<body>
    <div id='app'>
        <table border="1" cellspacing="0" width="60%">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>age</th>
                <th>score</th>
                <th>rank</th>
            </tr>
            <tr v-for="(user,index) in Users" align="center">
                <td>{{index+1}}</td>
                <td>{{user.name}}</td>
                <td>{{user.age}}</td>
                <td>{{user.score}}</td>
                <td v-show="user.score >60">及格</td>
                <td v-show="user.score <=60" style="color:red">不及格</td>
            </tr>
        </table>

    </div>
</body>
<script>
    new Vue({
        el: '#app',  //vue 接管的区域
        data: {
            Users:[
                {
                    name:'yunlong',
                    age:18,
                    score:100,
                },
                {
                    name:'yunpeng',
                    age:22,
                    score:59
                }
            ]
        },
        // 函数传递
        methods: {

        }
    })
        // 建立对象
</script>

</html>
~~~

## 生命周期

- 从创建到销毁的周期

![image-20230711023045640](Vue/image-20230711023045640.png)

![image-20230711023053038](Vue/image-20230711023053038.png)

![image-20230711023150062](Vue/image-20230711023150062.png)

- 掌握mounted就行

~~~html
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset="UTF-8">
    <title>Vue Learning</title>
    <script src='js/vue.js'></script>
    <!-- 绑定文件 -->
</head>

<body>
    <div id='app'>
        <table border="1" cellspacing="0" width="60%">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>age</th>
                <th>score</th>
                <th>rank</th>
            </tr>
            <tr v-for="(user,index) in Users" align="center">
                <td>{{index+1}}</td>
                <td>{{user.name}}</td>
                <td>{{user.age}}</td>
                <td>{{user.score}}</td>
                <td v-show="user.score >60">及格</td>
                <td v-show="user.score <=60" style="color:red">不及格</td>
            </tr>
        </table>

    </div>
</body>
<script>
    new Vue({
        el: '#app',  //vue 接管的区域
        data: {
            Users:[
                {
                    name:'yunlong',
                    age:18,
                    score:100,
                },
                {
                    name:'yunpeng',
                    age:22,
                    score:59
                }
            ]
        },
        // 函数传递
        methods: {

        },
        mounted(){
            alert('ok')
        }
    })
        // 建立对象
</script>

</html>
~~~

### 效果

![image-20230711023418458](Vue/image-20230711023418458.png)

![image-20230711023423980](Vue/image-20230711023423980.png)