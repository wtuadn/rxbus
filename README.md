# rxbus
一个简单的rxbus封装，以任意类型的tag和obj来区分区事件，使用[AutoDispose](https://github.com/uber/AutoDispose)在acitivty销毁时自动解绑

## How to

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency:
```gradle
	dependencies {
	        compile 'com.github.wtuadn.rxbus:rxbus:1.0.2'
	        compile 'com.github.wtuadn.rxbus:rxbus-kotlin:1.0.2'//kotlin support
	}
```